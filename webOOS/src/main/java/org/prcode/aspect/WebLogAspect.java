package org.prcode.aspect;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.prcode.business.support.basic.security.domain.CustomerUserDetail;
import org.prcode.business.support.basic.security.util.SecurityUtil;
import org.prcode.log.basedomain.oosLogger.domain.OosLogger;
import org.prcode.utility.basic.support.ResponseStatus;
import org.prcode.utility.exception.BusinessException;
import org.prcode.utility.exception.LoginTimeout;
import org.prcode.utility.exception.NoPrivilegeException;
import org.prcode.utility.exception.ValidateException;
import org.prcode.utility.util.ExceptionUtil;
import org.prcode.utility.util.IPUtil;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

/**
 * @ClassName: WebLogAspect
 * @Date: 2017-03-28 13:16
 * @Auther: kangduo
 * @Description: (日志请求AOP记录)
 */
@Aspect
@Order(5)//多个切面根据order依次执行，小的先行
@Component
public class WebLogAspect {

    @Resource
    private LoggerRecordService loggerRecordService;

    private Logger logger = Logger.getLogger(getClass());

    private ThreadLocal<OosLogger> commLoggerThreadLocal = new ThreadLocal<>();

    @Pointcut("execution(public * org.prcode.web..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        logger.debug("***************请求开始***************");
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        OosLogger commLogger = new OosLogger();
        commLogger.setActionUrlAll(request.getRequestURL().toString());
        commLogger.setActionUrlTail(request.getServletPath());
        commLogger.setRequestParams(JSON.toJSONString(request.getParameterMap()));
        commLogger.setIp(IPUtil.getRealIP(request));
        commLogger.setReqStartTime(new Date());

        CustomerUserDetail userDetail = SecurityUtil.getCurrUserDetail();
        if (userDetail != null) {
            commLogger.setUserId(userDetail.getId());
            commLogger.setUserAccNo(userDetail.getUsername());
            commLogger.setUserAccType(userDetail.getAccountType());
        }
        commLoggerThreadLocal.set(commLogger);

        // 记录下请求内容
        logger.debug("URL : " + request.getRequestURL().toString());
        logger.debug("HTTP_METHOD : " + request.getMethod());
        logger.debug("IP : " + IPUtil.getRealIP(request));
        logger.debug("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.debug("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        logger.debug("params : " + JSON.toJSONString(request.getParameterMap()));

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        OosLogger commLogger = commLoggerThreadLocal.get();
        commLogger.setActionResCode(ResponseStatus.SUCCESS);
        commLogger.setReqEndTime(new Date());
        commLogger.setReqDealTime((int) (commLogger.getReqEndTime().getTime() - commLogger.getReqStartTime().getTime()));
        commLogger.setResponseData(JSON.toJSONString(ret));
        commLogger.setIsUndefinedException(false);

        loggerRecordService.doRecord(commLogger);

        logger.debug("RESPONSE : " + JSON.toJSONString(ret));
        logger.debug("SPEND TIME : " + commLogger.getReqDealTime() + "ms");
        logger.debug("***************请求结束***************");
    }

    @AfterThrowing(throwing="ex", pointcut = "webLog()")
    public void doAfterThrowing(Throwable ex) {
        //有异常
        OosLogger commLogger = commLoggerThreadLocal.get();
        if (ex instanceof BusinessException) {
            commLogger.setActionResCode(ResponseStatus.BUSINESS_FAILED);
        } else if (ex instanceof ValidateException) {
            commLogger.setActionResCode(ResponseStatus.VALIDATE_ERR);
        } else if (ex instanceof LoginTimeout) {
            commLogger.setActionResCode(ResponseStatus.LOGIN_TIME_OUT);
        } else if (ex instanceof NoPrivilegeException) {
            commLogger.setActionResCode(ResponseStatus.NO_PRIVILEGE);
        } else {
            commLogger.setActionResCode(ResponseStatus.SYSTEM_ERR);
        }
        commLogger.setReqEndTime(new Date());
        commLogger.setReqDealTime((int) (commLogger.getReqEndTime().getTime() - commLogger.getReqStartTime().getTime()));
        commLogger.setIsUndefinedException(true);
        commLogger.setExcepStackInfo(ExceptionUtil.parseException(ex));

        loggerRecordService.doRecord(commLogger);

        logger.debug("EXCEPTION : " + ExceptionUtil.parseException(ex));
        logger.debug("SPEND TIME : " + commLogger.getReqDealTime() + "ms");
        logger.debug("***************请求结束***************");
    }

}
