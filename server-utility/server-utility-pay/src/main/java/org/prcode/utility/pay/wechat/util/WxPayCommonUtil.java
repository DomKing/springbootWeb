package org.prcode.utility.pay.wechat.util;

import org.prcode.utility.pay.wechat.util.MD5Util;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/**
 * created on 2017-04-18 14:07
 *
 * @author nextyu
 */
public class WxPayCommonUtil {
    private WxPayCommonUtil() {
    }


    /**
     * sign签名
     *
     * @param characterEncoding
     * @param packageParams
     * @param apiKey
     * @return
     */
    public static String createSign(String characterEncoding, SortedMap<String, String> packageParams, String apiKey) {
        StringBuilder sb = new StringBuilder();
        Set es = packageParams.entrySet();
        for (Object e : es) {
            Map.Entry entry = (Map.Entry) e;
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k).append("=").append(v).append("&");
            }
        }
        sb.append("key=").append(apiKey);
        return MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
    }

    /**
     * 将请求参数转换为xml格式的string
     *
     * @param packageParams
     * @return
     */
    public static String getRequestXml(SortedMap<String, String> packageParams) {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        Set es = packageParams.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if ("attach".equalsIgnoreCase(k) || "body".equalsIgnoreCase(k) || "sign".equalsIgnoreCase(k)) {
                sb.append("<" + k + ">" + "<![CDATA[" + v + "]]></" + k + ">");
            } else {
                sb.append("<" + k + ">" + v + "</" + k + ">");
            }
        }
        sb.append("</xml>");
        return sb.toString();
    }
}
