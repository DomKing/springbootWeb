package org.prcode.utility.pay.wechat.support;

/**
 * @ClassName: WechatUserInfo
 * @Date: 2017-5-4 20:04
 * @Auther: kangduo
 * @Description: ()
 */
public class WechatUserInfo {

    private String openId;
    private String nickName;
    private String unionId;
    private String session_key;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }
}
