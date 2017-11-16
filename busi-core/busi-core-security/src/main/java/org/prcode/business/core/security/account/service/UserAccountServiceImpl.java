package org.prcode.business.core.security.account.service;

import org.prcode.business.basedomain.loginNo.dao.LoginNoMapper;
import org.prcode.business.basedomain.loginNo.domain.LoginNo;
import org.prcode.business.basedomain.loginNo.domain.LoginNoExample;
import org.prcode.business.basedomain.user.dao.UserMapper;
import org.prcode.business.basedomain.user.domain.User;
import org.prcode.business.basedomain.userRole.dao.UserRoleMapper;
import org.prcode.business.basedomain.userRole.domain.UserRole;
import org.prcode.business.basedomain.userRole.domain.UserRoleExample;
import org.prcode.business.core.security.account.dao.UserAccountDao;
import org.prcode.business.core.security.account.entity.UserAccount;
import org.prcode.business.core.security.account.entity.UserHasRole;
import org.prcode.business.support.basic.AccountType;
import org.prcode.business.support.basic.security.util.SecurityUtil;
import org.prcode.business.support.basic.util.IdWorker;
import org.prcode.utility.exception.BusinessException;
import org.prcode.utility.util.StringUtil;
import org.prcode.utility.util.UUIDGenerator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * @className: UserAccountService
 * @date: 2017-4-19 22:09
 * @author: kangduo
 * @description: (账号service)
 */
@Service("userAccountService")
public class UserAccountServiceImpl implements UserAccountService {

    @Resource
    private UserAccountDao userAccountDao;
    @Resource
    private UserMapper userMapper;
    @Resource
    private LoginNoMapper loginNoMapper;
    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<UserAccount> getUserAccountList(UserAccount account, Byte accountType) {
        String systemCode = AccountType.getSystemCode(accountType);
        List<UserAccount> userAccountList = userAccountDao.getUserAccountList(account, systemCode, accountType);
        Set<UserHasRole> resList;
        for (UserAccount userAccount : userAccountList) {
            resList = new HashSet<>(userAccount.getRoleList().size());
            for (UserHasRole userHasRole : userAccount.getRoleList()) {
                if (userHasRole.getHasRole()) {
                    resList.add(userHasRole);
                }
            }
            userAccount.setRoleList(resList);
        }
        return userAccountList;
    }

    @Override
    public UserAccount getUserAccount(String userId, Byte accountType) {
        String systemCode = AccountType.getSystemCode(accountType);
        return userAccountDao.getUserAccount(userId, systemCode, accountType);
    }

    @Override
    @Transactional(timeout = 10)
    public Integer addAccount(UserAccount account, byte accountType) throws BusinessException {
        LoginNoExample example = new LoginNoExample();
        example.createCriteria()
                .andSysDelStateEqualTo(false)
                .andUserAccountEqualTo(account.getUsername())
                .andTypeEqualTo(accountType);
        if (loginNoMapper.countByExample(example) > 0) {
            throw new BusinessException("该账号已存在");
        }

        Date now = new Date();
        Long operId = SecurityUtil.getOperId();
        //插入User表
        User user = addUser(account, now, operId);
        //插入LoginNo表
        addLoginNo(account, user.getId(), accountType, now, operId);
        //插入用户角色表
        addUserRoles(account, user.getId(), now, operId);
        return 1;
    }

    @Override
    @Transactional(timeout = 10)
    public Integer updAccount(UserAccount account) {
        if (!StringUtil.isEmpty(account.getPassword())) {
            LoginNoExample example = new LoginNoExample();
            example.createCriteria().andDeleted(false).andUserIdEqualTo(account.getUserId());
            LoginNo no = new LoginNo();
            no.setUserPwd(bCryptPasswordEncoder.encode(account.getPassword()));
            loginNoMapper.updateByExampleSelective(no, example);
        }
        //删除旧角色
        UserRoleExample example = new UserRoleExample();
        example.createCriteria().andSysDelStateEqualTo(false).andUserIdEqualTo(account.getUserId());
        userRoleMapper.logicalDeleteByExample(example);
        //增加角色
        addUserRoles(account, account.getUserId(), new Date(), SecurityUtil.getOperId());
        return 1;
    }

    private User addUser(UserAccount account, Date now, Long operId) {
        User user = new User();
        user.setId(IdWorker.getLongId());
        user.setNickName(account.getUsername());
        user.setSysAddTime(now);
        user.setSysAddUser(operId);
        userMapper.insertSelective(user);
        return user;
    }

    private void addLoginNo(UserAccount account, Long userId, byte accountType, Date now, Long operId) {
        LoginNo loginNo = new LoginNo();
        loginNo.setId(IdWorker.getLongId());
        loginNo.setType(accountType);
        loginNo.setUserId(userId);
        loginNo.setUserAccount(account.getUsername());
        loginNo.setUserPwd(bCryptPasswordEncoder.encode(account.getPassword()));
        loginNo.setWechatUnionId(account.getUnionId());
        loginNo.setSysAddTime(now);
        loginNo.setSysAddUser(operId);
        loginNoMapper.insertSelective(loginNo);
    }

    private void addUserRoles(UserAccount account, Long userId, Date now, Long operId) {
        UserRole userRole;
        List<Long> roleIds = account.getRoleIds();
        List<UserRole> roles = new ArrayList<>(roleIds.size());
        for (Long roleId : roleIds) {
            userRole = new UserRole();
            userRole.setId(IdWorker.getLongId());
            userRole.setUserId(userId);
            userRole.setRoleId(roleId);
            userRole.setSysAddTime(now);
            userRole.setSysAddUser(operId);
            userRole.setSysDelState(false);
            roles.add(userRole);
        }
        userRoleMapper.batchInsert(roles);
    }
}
