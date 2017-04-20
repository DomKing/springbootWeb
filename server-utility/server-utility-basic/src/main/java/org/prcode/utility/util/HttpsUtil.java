package org.prcode.utility.util;

import org.apache.log4j.Logger;
import org.prcode.utility.basic.CharsetConstant;
import org.prcode.utility.util.support.DefaultX509TrustManager;
import org.prcode.utility.util.support.HttpMethod;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

/**
 * @ClassName: HttpsUtil
 * @Date: 2017-3-24 23:22
 * @Auther: kangduo
 * @Description: (https工具类)
 */
public class HttpsUtil {
    private static final Logger logger = Logger.getLogger(HttpsUtil.class);
    private static final String USER_AGENT = "Mozilla/5.0";

    /**
     * 以get方式发送https请求，获取响应的JSON字符窜
     *
     * @param url 请求的基于https的url
     * @return 返回url响应的JSON字符窜
     */
    public static String get(String url) {
        HttpsURLConnection https = null;
        try {
            https = (HttpsURLConnection) new URL(url).openConnection();
            https.setRequestMethod(HttpMethod.GET.name());
            https.setRequestProperty("User-Agent", USER_AGENT);
        } catch (IOException e) {
            logger.error(ExceptionUtil.parseException(e));
        }

        return read(https, CharsetConstant.UTF_8);
    }

    /**
     * 通过post提交数据到指定的url，数据默认以UTF-8编码
     *
     * @param url     　请坟的基于https的url
     * @param message 提交的内容
     * @return　返回url响应的message
     */
    public static String post(String url, String message) {
        HttpsURLConnection https;
        String msg = null;
        try {
            https = (HttpsURLConnection) new URL(url).openConnection();
            https.setSSLSocketFactory(createDefaultSSLSocketFactory());
            https.setDoInput(true);
            https.setDoOutput(true);

            https.setRequestMethod(HttpMethod.POST.name());

            write(https, message);

            msg = https.getResponseMessage();
        } catch (IOException e) {
            logger.error(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return msg;
    }

    /**
     * 创建一个默认的，空的信任管理工厂
     *
     * @return 返回创建的信任管理工厂
     */
    private static SSLSocketFactory createDefaultSSLSocketFactory() throws Exception {
        TrustManager[] tm = {new DefaultX509TrustManager()};
        SSLContext sslContext = null;
        SSLSocketFactory factory = null;
        try {
            sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new SecureRandom());

            factory = sslContext.getSocketFactory();
        } catch (NoSuchAlgorithmException | NoSuchProviderException | KeyManagementException e) {
            logger.error(e.getMessage());
        }

        if (null == factory) {
            throw new Exception("SSLSocketFactory is null");
        }

        return factory;
    }

    /**
     * 从流中读取数据
     *
     * @param https
     * @param charset
     * @return
     */
    private static String read(HttpsURLConnection https, Charset charset) {
        charset = charset == null ? CharsetConstant.UTF_8 : charset;
        BufferedReader in = null;
        StringBuilder msg = new StringBuilder();
        try {
            if (HttpsURLConnection.HTTP_OK == https.getResponseCode()) {
                in = new BufferedReader(new InputStreamReader(https.getInputStream(), charset));
                String str;
                while ((str = in.readLine()) != null) {
                    msg.append(str);
                }
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error(e.getMessage());
                }
            }
        }
        return msg.toString();
    }

    /**
     * 通过默认的UTF-8编码，写数据到对应的流
     *
     * @param https
     * @param msg   写出的消息
     */
    private static void write(HttpsURLConnection https, String msg) {
        write(https, msg, null);
    }

    /**
     * 写数据到对应的流
     *
     * @param https
     * @param msg     写出的消息
     * @param charset 写出消息的编码
     */
    private static void write(HttpsURLConnection https, String msg, Charset charset) {
        charset = charset == null ? CharsetConstant.UTF_8 : charset;
        BufferedWriter out = null;

        try {
            out = new BufferedWriter(new OutputStreamWriter(https.getOutputStream(), charset));
            out.write(msg);
        } catch (IOException e) {
            logger.error(e.getMessage());
        } finally {
            if (null != out) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    logger.error(e.getMessage());
                }
            }
        }
    }
}
