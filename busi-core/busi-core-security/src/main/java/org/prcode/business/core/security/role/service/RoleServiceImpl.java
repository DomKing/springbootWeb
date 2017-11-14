package org.prcode.business.core.security.role.service;

import org.prcode.business.basedomain.role.dao.RoleMapper;
import org.prcode.business.basedomain.role.domain.Role;
import org.prcode.business.basedomain.role.domain.RoleExample;
import org.prcode.business.basedomain.roleResource.dao.RoleResourceMapper;
import org.prcode.business.basedomain.roleResource.domain.RoleResource;
import org.prcode.business.basedomain.roleResource.domain.RoleResourceExample;
import org.prcode.business.core.security.role.dao.RoleDao;
import org.prcode.business.core.security.role.entity.RoleEntity;
import org.prcode.business.support.basic.SystemConstant;
import org.prcode.business.support.basic.security.util.SecurityUtil;
import org.prcode.utility.exception.BusinessException;
import org.prcode.utility.util.UUIDGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @className: RoleService
 * @date: 2017-4-22 15:12
 * @author: kangduo
 * @description: ()
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RoleResourceMapper roleResourceMapper;
    @Resource
    private RoleDao roleDao;

    @Override
    @Transactional(timeout = 10)
    public Integer addRole(RoleEntity entity) throws BusinessException {
        RoleExample example = new RoleExample();
        example.createCriteria().andSysDelStateEqualTo(false).andRoleCodeEqualTo(entity.getRoleCode());
        if (roleMapper.countByExample(example) > 0) {
            throw new BusinessException("角色code已存在");
        }
        //添加角色
        entity.setRoleCode("ROLE_" + entity.getRoleCode());
        Role role = addRoleBasic(entity);
        //添加角色权限
        addRoleResource(entity, role.getId());
        return 1;
    }

    @Override
    public RoleEntity getRoleEntity(String roleId, String systemCode) {
        return roleDao.getRoleEntity(roleId, systemCode);
    }

    private Role addRoleBasic(RoleEntity entity) {
        Role role = new Role();
        role.setId(UUIDGenerator.getId());
        role.setRoleName(entity.getRoleName());
        role.setRoleCode(entity.getRoleCode());
        role.setRoleDesc(entity.getRoleDesc());
        role.setSystemCode(SystemConstant.OOS_SYSTEM);
        role.setSysAddTime(new Date());
        role.setSysAddUser(SecurityUtil.getOperId());
        roleMapper.insertSelective(role);
        return role;
    }

    @Override
    @Transactional(timeout = 10)
    public Integer updRole(RoleEntity entity) {
        //修改角色信息
        Role role = new Role();
        role.setId(entity.getId());
        role.setRoleDesc(entity.getRoleDesc());
        role.setRoleName(entity.getRoleName());
        roleMapper.updateByPrimaryKeySelective(role);
        //删除旧权限
        RoleResourceExample example = new RoleResourceExample();
        example.createCriteria().andSysDelStateEqualTo(false).andRoleIdEqualTo(role.getId());
        roleResourceMapper.logicalDeleteByExample(example);
        //添加角色权限
        addRoleResource(entity, role.getId());
        return 1;
    }

    private void addRoleResource(RoleEntity entity, String roleId) {
        List<String> resourceIds = entity.getResourceUrlIds();
        List<RoleResource> roleResourceList = new ArrayList<>(resourceIds.size());
        RoleResource roleResource;
        Date now = new Date();
        String operId = SecurityUtil.getOperId();
        for (String resourceId : resourceIds) {
            roleResource = new RoleResource();
            roleResource.setId(UUIDGenerator.getId());
            roleResource.setRoleId(roleId);
            roleResource.setResourceUrlId(resourceId);
            roleResource.setSysAddTime(now);
            roleResource.setSysAddUser(operId);
            roleResource.setSysDelState(false);
            roleResourceList.add(roleResource);
        }
        roleResourceMapper.batchInsert(roleResourceList);
    }
}
