package org.prcode.business.support.basic.config.exceptionHandler;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.prcode.utility.basic.CharsetConstant;
import org.prcode.utility.basic.JsonResponse;
import org.prcode.utility.basic.support.ResponseStatus;
import org.prcode.utility.exception.BusinessException;
import org.prcode.utility.exception.LoginTimeout;
import org.prcode.utility.exception.NoPrivilegeException;
import org.prcode.utility.exception.ValidateException;
import org.prcode.utility.util.StringUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * @ClassName: GlobalExceptionHandler
 * @Date: 2017-03-28 10:44
 * @Auther: kangduo
 * @Description: (统一异常处理器, 约定 json 数据格式请求的必须以 .json 为路径结束, 非 json 请求, 不得以 .json 结尾)
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    private final String DEFAULT_EXCEPTION_MESSAGE = "系统异常，请联系客服";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView jsonErrorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {

        //错误数据
        JsonResponse json = new JsonResponse();
        if (e instanceof BusinessException) {
            json.setStatus(ResponseStatus.BUSINESS_FAILED);
            json.setMessage(e.getMessage());
        } else if (e instanceof ValidateException) {
            json.setStatus(ResponseStatus.VALIDATE_ERR);
            json.setMessage(e.getMessage());
        } else if (e instanceof LoginTimeout) {
            json.setStatus(ResponseStatus.LOGIN_TIME_OUT);
            json.setMessage(e.getMessage());
        } else if (e instanceof NoPrivilegeException) {
            json.setStatus(ResponseStatus.NO_PRIVILEGE);
            json.setMessage(e.getMessage());
        } else {
            json.setStatus(ResponseStatus.SYSTEM_ERR);
            json.setMessage(DEFAULT_EXCEPTION_MESSAGE);
        }

        String servletPath = request.getServletPath();
        //约定返回 json 数据的地址必须后缀 .json
        if (!StringUtil.isEmpty(servletPath) && servletPath.endsWith(".json")) {
            returnJsonData(response, json);
            return null;
        }
        ModelAndView resPage = new ModelAndView("error");
        resPage.addObject("status", json.getStatus());
        resPage.addObject("message", json.getMessage());
        return resPage;
    }

    private void returnJsonData(HttpServletResponse response, JsonResponse json) {
        Writer writer = null;
        try {
            response.setCharacterEncoding(CharsetConstant.GBK_STR);
            writer = response.getWriter();
            writer.write(JSON.toJSONString(json));

            writer.flush();
            writer.close();
        } catch (IOException e) {
            logger.error("io close exception", e);
        }finally {
            try {
                if (writer != null) {
                    writer.flush();
                    writer.close();
                }
            } catch (IOException e) {
                logger.error("io close exception", e);
            }
        }

    }
}
