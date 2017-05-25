package org.prcode.utility.pay.wechat.entity;

/**
 * @ClassName: WxCallBackVo
 * @Date: 2017-05-15 13:08
 * @Auther: kangduo
 * @Description: ()
 */
public class WxCallBackVo {

    private String callBackStr;
    private boolean valid;

    private String transId;
    private String outTradeNo;
    private String totalFee;
    private String tradeStatus;
    private String resultCode;

    public String getCallBackStr() {
        return callBackStr;
    }

    public void setCallBackStr(String callBackStr) {
        this.callBackStr = callBackStr;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }
}
