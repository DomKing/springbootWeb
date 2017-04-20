package org.prcode.utility.util;


import org.apache.log4j.Logger;
import org.prcode.utility.basic.CharsetConstant;
import org.prcode.utility.util.support.HttpMethod;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * @ClassName: HttpUtil
 * @Date: 2017-3-24 22:41
 * @Auther: kangduo
 * @Description: ()
 */
public class HttpUtil {

    private static final Logger logger = Logger.getLogger(HttpUtil.class);
    private static final int TIMEOUT_IN_MILLIONS = 10000;

    /**
     * httpGet获取数据
     *
     * @param urlPath 请求地址
     * @return 返回数据
     */
    public static String get(String urlPath) {
        InputStream is = null;
        String msg = null;
        try {
            URL url = new URL(urlPath);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod(HttpMethod.GET.name());
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);
            http.setReadTimeout(TIMEOUT_IN_MILLIONS);
            http.setConnectTimeout(TIMEOUT_IN_MILLIONS);
            http.connect();
            is = http.getInputStream();
            int size = is.available();
            byte[] jsonBytes = new byte[size];
            is.read(jsonBytes);
            msg = new String(jsonBytes, CharsetConstant.UTF_8);
        } catch (Exception e) {
            logger.error(ExceptionUtil.parseException(e));
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    logger.error(ExceptionUtil.parseException(e));
                }
            }
        }
        return msg;
    }

    /**
     * httpPost
     *
     * @param urlPath 地址
     * @param content 参数
     * @param charset 编码
     * @return 返回数据
     */
    public static String post(String urlPath, String content, Charset charset) {
        OutputStream os = null;
        InputStream is = null;
        String message = null;
        try {
            URL url = new URL(urlPath);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod(HttpMethod.POST.name());
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);
            http.setConnectTimeout(TIMEOUT_IN_MILLIONS);
            http.setReadTimeout(TIMEOUT_IN_MILLIONS);
            http.connect();
            os = http.getOutputStream();
            os.write(content.getBytes(charset));// 传入参数

            is = http.getInputStream();
            int size = is.available();
            byte[] jsonBytes = new byte[size];
            is.read(jsonBytes);
            message = new String(jsonBytes, charset);
            logger.debug(message);
            os.flush();
        } catch (Exception e) {
            logger.error(ExceptionUtil.parseException(e));
        } finally {
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    logger.error(ExceptionUtil.parseException(e));
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    logger.error(ExceptionUtil.parseException(e));
                }
            }
        }

        return message;
    }
}
