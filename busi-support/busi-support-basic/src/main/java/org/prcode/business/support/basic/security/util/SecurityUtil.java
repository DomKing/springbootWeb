package org.prcode.business.support.basic.security.util;

import org.apache.log4j.Logger;
import org.prcode.business.support.basic.security.domain.CustomerUserDetail;
import org.prcode.utility.exception.LoginTimeout;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName: SecurityUtil
 * @Date: 2017-4-16 22:32
 * @Auther: kangduo
 * @Description: (项目中任意位置获取用户信息)
 */
public class SecurityUtil {

    private static final Logger logger = Logger.getLogger(SecurityUtil.class);

    public static final String ACCOUNT_TYPE = "accountType";

    /**
     * 是否授权访问
     * @return
     */
    public static boolean isAuthenticated() {
        return SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
    }

    /**
     * 获取当前用户信息
     * @return
     */
    public static CustomerUserDetail getCurrUserDetail() {
        CustomerUserDetail userDetail = null;
        try {
            userDetail = (CustomerUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            userDetail.setPassword(null);
        } catch (Exception e) {
            logger.info("当前用户未登录");
        }
        return userDetail;
    }

    /**
     * 获取当前用户ID
     * @return
     */
    public static String getOperId() {
        CustomerUserDetail userDetail = getCurrUserDetail();
        return userDetail == null ? null : userDetail.getId();
    }

    /**
     * 获取当前用户ID
     * @return
     */
    public static String getOperIdMustExist() throws LoginTimeout {
        CustomerUserDetail userDetail = getCurrUserDetail();
        if (userDetail == null) {
            throw new LoginTimeout("登录信息已过期");
        }
        return userDetail.getId();
    }

    /**
     * 获取session
     * @return session
     */
    public static HttpSession getSession() {
        return getSession(false);
    }

    public static HttpSession getSession(boolean create) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return request.getSession(create);
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attributes.getRequest();
    }

}
