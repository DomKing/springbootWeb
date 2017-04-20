package org.prcode.utility.util;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;

/**
 * @ClassName: IPUtil
 * @Date: 2017-3-24 21:54
 * @Auther: kangduo
 * @Description: (ip相关工具类)
 */
public class IPUtil {

    private static final Logger logger = Logger.getLogger(IPUtil.class);

    /**
     * 获取请求的ip地址
     *
     * @param request http请求
     * @return ip地址
     */
    public static String getRealIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (StringUtil.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtil.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtil.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (StringUtil.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("http_client_ip");
        }
        if (StringUtil.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        // 如果是多级代理，那么取第一个ip为客户ip
        if (ip != null && ip.contains(",")) {
            ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
        }
        return ip;
    }

    /**
     * ip地址是否可以ping通
     *
     * @param ipAddress ip地址
     * @param timeout   超时，单位毫秒
     * @return true | false
     */
    public static boolean ipCanPing(String ipAddress, int timeout) {

        if (StringUtil.isEmpty(ipAddress)) {
            return false;
        }

        boolean canPing = false;
        try {
            canPing = InetAddress.getByName(ipAddress).isReachable(timeout);
        } catch (IOException e) {
            logger.error(ExceptionUtil.parseException(e));
        }
        return canPing;
    }

    /**
     * 链接是否可以被请求
     *
     * @param url     地址
     * @param timeout 超时，单位毫秒
     * @return true | false
     */
    public static boolean AddrCanConnect(String url, int timeout) {

        if (StringUtil.isEmpty(url)) {
            return false;
        }

        boolean canConnect = false;
        try {
            URL urlStr = new URL(url);

            HttpURLConnection connection = (HttpURLConnection) urlStr.openConnection();
            connection.setUseCaches(false);
            connection.setConnectTimeout(timeout);
            int state = connection.getResponseCode();
            if (state == HttpURLConnection.HTTP_OK) {
                canConnect = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return canConnect;
    }
}
