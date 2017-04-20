package org.prcode.utility.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @ClassName: ExceptionUtil
 * @Date: 2017-3-24 22:55
 * @Auther: kangduo
 * @Description: (异常工具类)
 */
public class ExceptionUtil {

    /**
     * 将异常信息转成字符串
     *
     * @param e 异常
     * @return 转换后的字符串
     */
    public static String parseException(Throwable e) {
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            return "\r\n" + sw.toString() + "\r\n";
        } catch (Exception e2) {
            return "cannot parseException";
        }
    }

}
