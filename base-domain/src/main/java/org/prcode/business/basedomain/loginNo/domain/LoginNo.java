package org.prcode.business.basedomain.loginNo.domain;

import java.io.Serializable;
import org.prcode.basedomain.base.BaseDomain;

public class LoginNo extends BaseDomain implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_login_no.f_id
     *
     * @mbg.generated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_login_no.f_user_id
     *
     * @mbg.generated
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_login_no.f_user_account
     *
     * @mbg.generated
     */
    private String userAccount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_login_no.f_user_pwd
     *
     * @mbg.generated
     */
    private String userPwd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_login_no.f_type
     *
     * @mbg.generated
     */
    private Byte type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_login_no.f_wechat_union_id
     *
     * @mbg.generated
     */
    private String wechatUnionId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_login_no
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_login_no.f_id
     *
     * @return the value of t_login_no.f_id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_login_no.f_id
     *
     * @param id the value for t_login_no.f_id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_login_no.f_user_id
     *
     * @return the value of t_login_no.f_user_id
     *
     * @mbg.generated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_login_no.f_user_id
     *
     * @param userId the value for t_login_no.f_user_id
     *
     * @mbg.generated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_login_no.f_user_account
     *
     * @return the value of t_login_no.f_user_account
     *
     * @mbg.generated
     */
    public String getUserAccount() {
        return userAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_login_no.f_user_account
     *
     * @param userAccount the value for t_login_no.f_user_account
     *
     * @mbg.generated
     */
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_login_no.f_user_pwd
     *
     * @return the value of t_login_no.f_user_pwd
     *
     * @mbg.generated
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_login_no.f_user_pwd
     *
     * @param userPwd the value for t_login_no.f_user_pwd
     *
     * @mbg.generated
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_login_no.f_type
     *
     * @return the value of t_login_no.f_type
     *
     * @mbg.generated
     */
    public Byte getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_login_no.f_type
     *
     * @param type the value for t_login_no.f_type
     *
     * @mbg.generated
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_login_no.f_wechat_union_id
     *
     * @return the value of t_login_no.f_wechat_union_id
     *
     * @mbg.generated
     */
    public String getWechatUnionId() {
        return wechatUnionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_login_no.f_wechat_union_id
     *
     * @param wechatUnionId the value for t_login_no.f_wechat_union_id
     *
     * @mbg.generated
     */
    public void setWechatUnionId(String wechatUnionId) {
        this.wechatUnionId = wechatUnionId == null ? null : wechatUnionId.trim();
    }
}