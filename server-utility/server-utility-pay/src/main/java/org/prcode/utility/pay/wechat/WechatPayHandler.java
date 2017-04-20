package org.prcode.utility.pay.wechat;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.jdom.JDOMException;
import org.prcode.utility.pay.wechat.util.MD5Util;
import org.prcode.utility.pay.wechat.util.XmlUtil;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @ClassName: WechatPayHandler
 * @Date: 2017-04-19 16:17
 * @Auther: kangduo
 * @Description: (微信支付处理类)
 */
public class WechatPayHandler {

    private static final Logger logger = Logger.getLogger(WechatPayHandler.class);

    public Map<String, String> prePay(WechatPayParam payParam) throws IOException, JDOMException {
        //准备参数
        String postData = "https://api.mch.weixin.qq.com/pay/unifiedorder";//微信统一下单地址
        SortedMap<String, Object> parameters = new TreeMap<>();
        parameters.put("appid", payParam.getAppId());
        parameters.put("mch_id", payParam.getMchId());
        parameters.put("nonce_str", payParam.getNotifyUrl());
        parameters.put("body", payParam.getBody());
        parameters.put("out_trade_no", payParam.getOutTradeNo());
        parameters.put("total_fee", payParam.getTotalFee());
        parameters.put("spbill_create_ip", payParam.getSpBillCreateIp());
        parameters.put("notify_url", payParam.getNotifyUrl());
        parameters.put("trade_type", payParam.getTradeType());
        parameters.put("openid", payParam.getOpenId());
        parameters.put("sign", createMD5Sign(parameters, payParam.getPartnerKey()));
        String reqXml = getRequestXml(parameters);
        logger.info("reqXml: " + reqXml);
        logger.info("Charset.defaultCharset().name(): " + Charset.defaultCharset().name());
        logger.info("ISO8859-1 string: " + new String(reqXml.getBytes(), "ISO8859-1"));

        String packageData = new String(reqXml.getBytes(), "ISO8859-1");
        HttpPost httpPost = new HttpPost(postData);
        HttpEntity entity = new StringEntity(packageData);
        httpPost.setEntity(entity);

        CookieStore cookieStore = new BasicCookieStore();
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        CloseableHttpResponse chResponse = client.execute(httpPost);

        entity = chResponse.getEntity();
        String res = "";
        if (entity != null) {
            if (chResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                res = EntityUtils.toString(entity, "UTF-8");
                logger.info("prepay response's content: " + res);
                logger.info("prepay response's xml: " + XmlUtil.turn2Map(res));
            }
        }
        return XmlUtil.turn2Map(res);
    }

    public boolean validateNotify(String partnerKey, String encoding, SortedMap<String, Object> parameters) {
        StringBuilder sb = new StringBuilder();
        Set es = parameters.entrySet();
        for (Object e : es) {
            Map.Entry entry = (Map.Entry) e;
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (!"sign".equals(k) && null != v && !"".equals(v)) {
                sb.append(k).append("=").append(v).append("&");
            }
        }
        sb.append("key=").append(partnerKey);

        //算出摘要
        String sign = MD5Util.MD5Encode(sb.toString(), encoding).toLowerCase();
        String tenpaySign = ((String)parameters.get("sign")).toLowerCase();
        logger.info(sb.toString() + " => sign:" + sign + " tenpaySign:" + tenpaySign);

        return tenpaySign.equals(sign);
    }

    private String createMD5Sign(SortedMap<String, Object> parameters, String partnerKey) {
        StringBuilder sb = new StringBuilder();
        Set es = parameters.entrySet();
        for (Object e : es) {
            Map.Entry entry = (Map.Entry) e;
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k).append("=").append(v).append("&");
            }
        }
        sb.append("key=").append(partnerKey);
        return MD5Util.MD5Encode(sb.toString(), "UTF-8").toUpperCase();
    }

    private static String getRequestXml(SortedMap<String, Object> parameters) {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        Set es = parameters.entrySet();
        for (Object e : es) {
            Map.Entry entry = (Map.Entry) e;
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if ("attach".equalsIgnoreCase(k) || "body".equalsIgnoreCase(k) || "sign".equalsIgnoreCase(k)) {
                sb.append("<").append(k).append(">").append("<![CDATA[").append(v).append("]]></").append(k).append(">");
            } else {
                sb.append("<").append(k).append(">").append(v).append("</").append(k).append(">");
            }
        }
        sb.append("</xml>");
        return sb.toString();
    }
}
