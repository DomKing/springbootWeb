package org.prcode.security;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.prcode.business.basedomain.loginLog.dao.LoginLogMapper;
import org.prcode.business.basedomain.loginLog.domain.LoginLog;
import org.prcode.business.support.basic.SystemConstant;
import org.prcode.business.support.basic.security.domain.CustomerUserDetail;
import org.prcode.utility.util.DateUtil;
import org.prcode.utility.util.UUIDGenerator;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * @ClassName: LoginSuccessHandler
 * @Date: 2017-4-16 18:10
 * @Auther: kangduo
 * @Description: (登录成功处理器)
 */
@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private static final Logger logger = Logger.getLogger(LoginSuccessHandler.class);

    @Resource
    private LoginLogMapper loginLogMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException,ServletException {
        //记录登录成功日志
        CustomerUserDetail userDetails = (CustomerUserDetail)authentication.getPrincipal();
        LoginLog loginLog = new LoginLog();
        loginLog.setId(UUIDGenerator.getId());
        loginLog.setUserAccount(userDetails.getUsername());
        loginLog.setUserId(userDetails.getId());
        loginLog.setSystemCode(SystemConstant.OOS_SYSTEM);
        loginLog.setSysAddTime(new Date());
        loginLog.setSysAddUser(userDetails.getId());
        loginLogMapper.insertSelective(loginLog);
        logger.debug("用户[ID:" + userDetails.getId() + ", account:" + userDetails.getUsername() + "]于" + DateUtil.getCurrDateTime() + "登录");
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
