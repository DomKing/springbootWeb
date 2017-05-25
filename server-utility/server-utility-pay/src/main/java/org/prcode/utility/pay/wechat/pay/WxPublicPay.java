package org.prcode.utility.pay.wechat.pay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.jdom.JDOMException;
import org.prcode.utility.pay.wechat.entity.JsAPIConfigVO;
import org.prcode.utility.pay.wechat.entity.WxCallBackVo;
import org.prcode.utility.pay.wechat.entity.WxPublicPayDTO;
import org.prcode.utility.pay.wechat.util.*;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

/**
 * 微信公众号支付
 * created on 2017-04-18 14:33
 *
 * @author nextyu
 */
public class WxPublicPay {

    private static final Logger logger = Logger.getLogger(WxPublicPay.class);

    private WxPublicPay() {
    }

    /**
     * 获取微信用户openId
     *
     * @param appId
     * @param secret
     * @param code
     * @return
     */
    public static String getOpenId(String appId, String secret, String code) {
        String requestURL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appId + "&secret=" + secret + "&code="
                + code + "&grant_type=authorization_code";

        // 创建httpClient
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建httpGet
        HttpGet httpGet = new HttpGet(requestURL);
        // 执行get请求
        HttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpGet);
            // 获得相应实体
            HttpEntity entity = httpResponse.getEntity();

            String result = EntityUtils.toString(entity);
            JSONObject jsonObject = JSON.parseObject(result);
            String openId = (String) jsonObject.get("openid");
            return openId;
        } catch (Exception e) {
            logger.error("获取微信用户openId失败", e);
        }

        return null;

    }

    /**
     * 构建支付信息
     * 前端解析获取js需要传入的参数信息
     *
     * @param wxPublicPayDTO
     * @return 支付信息
     */
    public static JsAPIConfigVO buildPayInfo(WxPublicPayDTO wxPublicPayDTO) {
        String randomString = UUID.randomUUID().toString().replaceAll("-", "");
        JsAPIConfigVO vo = new JsAPIConfigVO();
        try {
            Map<String, String> map = unifiedOrder(wxPublicPayDTO, randomString);
            vo.setPrepayBackMap(map);
            String prepayId = map.get("prepay_id");
            String timestamp = String.valueOf(System.currentTimeMillis() / 1000);

            String sb = "appId=" + wxPublicPayDTO.getAppId() +
                    "&nonceStr=" + randomString +
                    "&package=" + "prepay_id=" + prepayId +
                    "&signType=" + "MD5" +
                    "&timeStamp=" + timestamp +
                    "&key=" + wxPublicPayDTO.getApiKey();


            String newSign = MD5Util.MD5Encode(sb, "UTF-8").toUpperCase();
            vo.setAppId(wxPublicPayDTO.getAppId());
            vo.setTimeStamp(timestamp);
            vo.setNonceStr(randomString);
            vo.setPackageName("prepay_id=" + prepayId);
            vo.setSignType("MD5");
            vo.setPaySign(newSign);

        } catch (Exception e) {
            logger.error("WxPublicPay buildPayInfo error", e);
        }
        return vo;
    }

    public static WxCallBackVo validCallBack(HttpServletRequest request, String appId, String mchId, String apiKey) throws IOException, JDOMException {
        WxCallBackVo vo = new WxCallBackVo();
        String responseStr = parseWeixinCallback(request);
        vo.setCallBackStr(responseStr);
        SortedMap<String, String> map = XMLUtil.parseXML(responseStr);
        if (map == null) {
            vo.setValid(false);
            return vo;
        }
        String signFromAPIResponse = map.get("sign");
        map.remove("sign");
        String sign = WxPayCommonUtil.createSign("UTF-8", map, apiKey);
        if (!signFromAPIResponse.equals(sign)) {
            vo.setValid(false);
        }
        String transactionId = map.get("transaction_id");
        String tradeStatus = getTradeState(appId, mchId, transactionId, apiKey);

        vo.setValid("SUCCESS".equals(tradeStatus));
        vo.setResultCode(map.get("result_code"));
        vo.setTradeStatus(tradeStatus);
        vo.setTransId(transactionId);
        vo.setOutTradeNo(map.get("out_trade_no"));
        vo.setTotalFee(map.get("total_fee"));
        return vo;
    }

    private static Map<String, String> unifiedOrder(WxPublicPayDTO wxPublicPayDTO, String randomString) throws Exception {
        SortedMap<String, String> packageParams = new TreeMap<String, String>();
        packageParams.put("appid", wxPublicPayDTO.getAppId());
        packageParams.put("mch_id", wxPublicPayDTO.getMchId());
        packageParams.put("nonce_str", randomString);
        packageParams.put("body", wxPublicPayDTO.getBody());
        packageParams.put("out_trade_no", wxPublicPayDTO.getOutTradeNo());
        packageParams.put("total_fee", wxPublicPayDTO.getTotalFee());
        packageParams.put("spbill_create_ip", wxPublicPayDTO.getSpCreateBillIp());
        packageParams.put("notify_url", wxPublicPayDTO.getNotifyUrl());
        packageParams.put("trade_type", "JSAPI");
//        packageParams.put("attach", wxPublicPayDTO.getAttach());
        packageParams.put("openid", wxPublicPayDTO.getOpenId());

        String sign = WxPayCommonUtil.createSign("UTF-8", packageParams, wxPublicPayDTO.getApiKey());
        packageParams.put("sign", sign);

        String requestXML = WxPayCommonUtil.getRequestXml(packageParams);
        String resultXml = HttpUtil.postData(WxPayCommonConfigUtil.UNIFIED_ORDER_URL, requestXML);
        return XMLUtil.parseXML(resultXml);
    }

    /**
     * 解析微信回调参数
     *
     * @param request
     * @return
     * @throws IOException
     */
    private static String parseWeixinCallback(HttpServletRequest request) throws IOException {
        // 获取微信调用我们notify_url的返回信息
        String result = "";
        InputStream inStream = request.getInputStream();
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        try {
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inStream.read(buffer)) != -1) {
                outSteam.write(buffer, 0, len);
            }
            result = new String(outSteam.toByteArray(), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                outSteam.close();
                if(inStream != null){
                    inStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * SUCCESS—支付成功
     * REFUND—转入退款
     * NOTPAY—未支付
     * CLOSED—已关闭
     * REVOKED—已撤销（刷卡支付）
     * USERPAYING--用户支付中
     * PAYERROR--支付失败(其他原因，如银行返回失败)
     * @param appId
     * @param mchId
     * @param transId
     * @param apiKey
     * @return
     */
    private static String getTradeState(String appId, String mchId, String transId, String apiKey) {
        String randomString = UUID.randomUUID().toString().replaceAll("-", "");
        try {
            SortedMap<String, String> packageParams = new TreeMap<String, String>();
            packageParams.put("appid", appId);
            packageParams.put("mch_id", mchId);
            packageParams.put("nonce_str", randomString);
            packageParams.put("transaction_id", transId);
            String sign = WxPayCommonUtil.createSign("UTF-8", packageParams, apiKey);
            packageParams.put("sign", sign);

            String requestXML = WxPayCommonUtil.getRequestXml(packageParams);
            String resultXml = HttpUtil.postData(WxPayCommonConfigUtil.QUERY_ORDER_URL, requestXML);
            Map<String, String> map = XMLUtil.parseXML(resultXml);
            logger.info("查询微信支付在微信详情");
            return map.get("trade_state");
        } catch (Exception e) {
            logger.error("WxPCPay getTradeState error", e);
        }
        return null;
    }

}
