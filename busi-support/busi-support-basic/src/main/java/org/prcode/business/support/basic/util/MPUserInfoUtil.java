package org.prcode.business.support.basic.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.prcode.utility.basic.CharsetConstant;
import org.prcode.utility.pay.PayAppType;
import org.prcode.utility.pay.wechat.support.WechatUserInfo;
import org.prcode.utility.pay.wechat.util.AesCbcUtil;
import org.prcode.utility.util.HttpUtil;

/**
 * @ClassName: LPUserInfoUtil
 * @Date: 2017-5-7 16:16
 * @Auther: kangduo
 * @Description: (小程序用户信息工具类)
 */
public class MPUserInfoUtil {
    private static final Logger logger = Logger.getLogger(MPUserInfoUtil.class);

    public static WechatUserInfo validateOpenId(String code, String iv, String encryptedData) throws Exception {
        String validateUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=" + PayAppType.MiniProgramApp.APP_ID +
                "&secret=" + PayAppType.MiniProgramApp.APP_SECRET +  "&js_code="+ code + "&grant_type=authorization_code";
        String result = HttpUtil.get(validateUrl);
        JSONObject json = JSONObject.parseObject(result);
        if (json.get("session_key") == null) {
            return null;
        }
        String sessionKey = json.get("session_key").toString();
        logger.info("验证小程序code及openId，code为" + code + ",返回结果：" + result);
        result = AesCbcUtil.decrypt(encryptedData, sessionKey, iv, CharsetConstant.UTF_8_STR);
        logger.info("获取用户信息，返回数据为：" + result);
        return JSON.parseObject(result, WechatUserInfo.class);
    }
}
