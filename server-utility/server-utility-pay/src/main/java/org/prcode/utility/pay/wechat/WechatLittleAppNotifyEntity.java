package org.prcode.utility.pay.wechat;

import java.io.Serializable;

/**
 * @ClassName: WechatLittleAppNotifyEntity
 * @Date: 2017-04-19 17:29
 * @Auther: kangduo
 * @Description: (微信支付回调返回内容)
 */
public class WechatLittleAppNotifyEntity implements Serializable{
    private static final long serialVersionUID = -4715358106985865748L;

    private String is_subscribe;//Y
    private String appid; // wx681fb1b637c7c74f
    private String fee_type;//CNY
    private String nonce_str;//=d5756748da7d4fc61bb0b1bcba6e6d4d
    private String out_trade_no;//=20150311125950152
    private String transaction_id;//=1010200652201503110030223565
    private String trade_type;//=JSAPI
    private String result_code;//=SUCCESS
    private String sign;//=870A4ACDE06E824FC054A235605C6429
    private String mch_id;//=1226657802
    private String total_fee;//=2
    private String time_end;//=20150311130109
    private String openid;//=o33fQtzx0kf6e3FNvFJXhAF_rcdY
    private String bank_type;//=PAB_CREDIT
    private String return_code;//=SUCCESS
    private String cash_fee;//=2 ;
    private String err_code;
    private String err_code_des;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getIs_subscribe() {
        return is_subscribe;
    }

    public void setIs_subscribe(String is_subscribe) {
        this.is_subscribe = is_subscribe;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getTime_end() {
        return time_end;
    }

    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getBank_type() {
        return bank_type;
    }

    public void setBank_type(String bank_type) {
        this.bank_type = bank_type;
    }

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getCash_fee() {
        return cash_fee;
    }

    public void setCash_fee(String cash_fee) {
        this.cash_fee = cash_fee;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public void setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
    }
}
