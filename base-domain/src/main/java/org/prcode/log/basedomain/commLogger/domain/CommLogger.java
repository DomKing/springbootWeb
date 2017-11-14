package org.prcode.log.basedomain.commLogger.domain;

import java.io.Serializable;
import java.util.Date;
import org.prcode.basedomain.base.BaseDomain;

public class CommLogger extends BaseDomain implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_comm_logger
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static final Boolean DEL_FLAG_ON = false;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_comm_logger
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static final Boolean DEL_FLAG_OFF = true;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_comm_logger
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    @Deprecated
    public static final Boolean DEL_FLAG = DEL_FLAG_OFF;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comm_logger.f_id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comm_logger.f_req_start_time
     *
     * @mbg.generated
     */
    private Date reqStartTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comm_logger.f_user_id
     *
     * @mbg.generated
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comm_logger.f_user_acc_no
     *
     * @mbg.generated
     */
    private String userAccNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comm_logger.f_user_acc_type
     *
     * @mbg.generated
     */
    private Byte userAccType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comm_logger.f_action_url_tail
     *
     * @mbg.generated
     */
    private String actionUrlTail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comm_logger.f_action_url_all
     *
     * @mbg.generated
     */
    private String actionUrlAll;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comm_logger.f_action_res_code
     *
     * @mbg.generated
     */
    private String actionResCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comm_logger.f_is_undefined_exception
     *
     * @mbg.generated
     */
    private Boolean isUndefinedException;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comm_logger.f_ip
     *
     * @mbg.generated
     */
    private String ip;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comm_logger.f_device_id
     *
     * @mbg.generated
     */
    private String deviceId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comm_logger.f_os
     *
     * @mbg.generated
     */
    private String os;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comm_logger.f_os_version
     *
     * @mbg.generated
     */
    private String osVersion;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comm_logger.f_req_deal_time
     *
     * @mbg.generated
     */
    private Integer reqDealTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comm_logger.f_req_end_time
     *
     * @mbg.generated
     */
    private Date reqEndTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comm_logger.f_request_params
     *
     * @mbg.generated
     */
    private String requestParams;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comm_logger.f_excep_stack_info
     *
     * @mbg.generated
     */
    private String excepStackInfo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comm_logger.f_response_data
     *
     * @mbg.generated
     */
    private String responseData;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_comm_logger
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comm_logger.f_id
     *
     * @return the value of t_comm_logger.f_id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comm_logger.f_id
     *
     * @param id the value for t_comm_logger.f_id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comm_logger.f_req_start_time
     *
     * @return the value of t_comm_logger.f_req_start_time
     *
     * @mbg.generated
     */
    public Date getReqStartTime() {
        return reqStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comm_logger.f_req_start_time
     *
     * @param reqStartTime the value for t_comm_logger.f_req_start_time
     *
     * @mbg.generated
     */
    public void setReqStartTime(Date reqStartTime) {
        this.reqStartTime = reqStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comm_logger.f_user_id
     *
     * @return the value of t_comm_logger.f_user_id
     *
     * @mbg.generated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comm_logger.f_user_id
     *
     * @param userId the value for t_comm_logger.f_user_id
     *
     * @mbg.generated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comm_logger.f_user_acc_no
     *
     * @return the value of t_comm_logger.f_user_acc_no
     *
     * @mbg.generated
     */
    public String getUserAccNo() {
        return userAccNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comm_logger.f_user_acc_no
     *
     * @param userAccNo the value for t_comm_logger.f_user_acc_no
     *
     * @mbg.generated
     */
    public void setUserAccNo(String userAccNo) {
        this.userAccNo = userAccNo == null ? null : userAccNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comm_logger.f_user_acc_type
     *
     * @return the value of t_comm_logger.f_user_acc_type
     *
     * @mbg.generated
     */
    public Byte getUserAccType() {
        return userAccType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comm_logger.f_user_acc_type
     *
     * @param userAccType the value for t_comm_logger.f_user_acc_type
     *
     * @mbg.generated
     */
    public void setUserAccType(Byte userAccType) {
        this.userAccType = userAccType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comm_logger.f_action_url_tail
     *
     * @return the value of t_comm_logger.f_action_url_tail
     *
     * @mbg.generated
     */
    public String getActionUrlTail() {
        return actionUrlTail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comm_logger.f_action_url_tail
     *
     * @param actionUrlTail the value for t_comm_logger.f_action_url_tail
     *
     * @mbg.generated
     */
    public void setActionUrlTail(String actionUrlTail) {
        this.actionUrlTail = actionUrlTail == null ? null : actionUrlTail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comm_logger.f_action_url_all
     *
     * @return the value of t_comm_logger.f_action_url_all
     *
     * @mbg.generated
     */
    public String getActionUrlAll() {
        return actionUrlAll;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comm_logger.f_action_url_all
     *
     * @param actionUrlAll the value for t_comm_logger.f_action_url_all
     *
     * @mbg.generated
     */
    public void setActionUrlAll(String actionUrlAll) {
        this.actionUrlAll = actionUrlAll == null ? null : actionUrlAll.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comm_logger.f_action_res_code
     *
     * @return the value of t_comm_logger.f_action_res_code
     *
     * @mbg.generated
     */
    public String getActionResCode() {
        return actionResCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comm_logger.f_action_res_code
     *
     * @param actionResCode the value for t_comm_logger.f_action_res_code
     *
     * @mbg.generated
     */
    public void setActionResCode(String actionResCode) {
        this.actionResCode = actionResCode == null ? null : actionResCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comm_logger.f_is_undefined_exception
     *
     * @return the value of t_comm_logger.f_is_undefined_exception
     *
     * @mbg.generated
     */
    public Boolean getIsUndefinedException() {
        return isUndefinedException;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comm_logger.f_is_undefined_exception
     *
     * @param isUndefinedException the value for t_comm_logger.f_is_undefined_exception
     *
     * @mbg.generated
     */
    public void setIsUndefinedException(Boolean isUndefinedException) {
        this.isUndefinedException = isUndefinedException;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comm_logger.f_ip
     *
     * @return the value of t_comm_logger.f_ip
     *
     * @mbg.generated
     */
    public String getIp() {
        return ip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comm_logger.f_ip
     *
     * @param ip the value for t_comm_logger.f_ip
     *
     * @mbg.generated
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comm_logger.f_device_id
     *
     * @return the value of t_comm_logger.f_device_id
     *
     * @mbg.generated
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comm_logger.f_device_id
     *
     * @param deviceId the value for t_comm_logger.f_device_id
     *
     * @mbg.generated
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comm_logger.f_os
     *
     * @return the value of t_comm_logger.f_os
     *
     * @mbg.generated
     */
    public String getOs() {
        return os;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comm_logger.f_os
     *
     * @param os the value for t_comm_logger.f_os
     *
     * @mbg.generated
     */
    public void setOs(String os) {
        this.os = os == null ? null : os.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comm_logger.f_os_version
     *
     * @return the value of t_comm_logger.f_os_version
     *
     * @mbg.generated
     */
    public String getOsVersion() {
        return osVersion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comm_logger.f_os_version
     *
     * @param osVersion the value for t_comm_logger.f_os_version
     *
     * @mbg.generated
     */
    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion == null ? null : osVersion.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comm_logger.f_req_deal_time
     *
     * @return the value of t_comm_logger.f_req_deal_time
     *
     * @mbg.generated
     */
    public Integer getReqDealTime() {
        return reqDealTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comm_logger.f_req_deal_time
     *
     * @param reqDealTime the value for t_comm_logger.f_req_deal_time
     *
     * @mbg.generated
     */
    public void setReqDealTime(Integer reqDealTime) {
        this.reqDealTime = reqDealTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comm_logger.f_req_end_time
     *
     * @return the value of t_comm_logger.f_req_end_time
     *
     * @mbg.generated
     */
    public Date getReqEndTime() {
        return reqEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comm_logger.f_req_end_time
     *
     * @param reqEndTime the value for t_comm_logger.f_req_end_time
     *
     * @mbg.generated
     */
    public void setReqEndTime(Date reqEndTime) {
        this.reqEndTime = reqEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comm_logger.f_request_params
     *
     * @return the value of t_comm_logger.f_request_params
     *
     * @mbg.generated
     */
    public String getRequestParams() {
        return requestParams;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comm_logger.f_request_params
     *
     * @param requestParams the value for t_comm_logger.f_request_params
     *
     * @mbg.generated
     */
    public void setRequestParams(String requestParams) {
        this.requestParams = requestParams == null ? null : requestParams.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comm_logger.f_excep_stack_info
     *
     * @return the value of t_comm_logger.f_excep_stack_info
     *
     * @mbg.generated
     */
    public String getExcepStackInfo() {
        return excepStackInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comm_logger.f_excep_stack_info
     *
     * @param excepStackInfo the value for t_comm_logger.f_excep_stack_info
     *
     * @mbg.generated
     */
    public void setExcepStackInfo(String excepStackInfo) {
        this.excepStackInfo = excepStackInfo == null ? null : excepStackInfo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comm_logger.f_response_data
     *
     * @return the value of t_comm_logger.f_response_data
     *
     * @mbg.generated
     */
    public String getResponseData() {
        return responseData;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comm_logger.f_response_data
     *
     * @param responseData the value for t_comm_logger.f_response_data
     *
     * @mbg.generated
     */
    public void setResponseData(String responseData) {
        this.responseData = responseData == null ? null : responseData.trim();
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table t_comm_logger
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public enum Column {
        id("f_id"),
        reqStartTime("f_req_start_time"),
        userId("f_user_id"),
        userAccNo("f_user_acc_no"),
        userAccType("f_user_acc_type"),
        actionUrlTail("f_action_url_tail"),
        actionUrlAll("f_action_url_all"),
        actionResCode("f_action_res_code"),
        isUndefinedException("f_is_undefined_exception"),
        ip("f_ip"),
        deviceId("f_device_id"),
        os("f_os"),
        osVersion("f_os_version"),
        reqDealTime("f_req_deal_time"),
        reqEndTime("f_req_end_time"),
        sysAddTime("f_sys_add_time"),
        sysUpdTime("f_sys_upd_time"),
        sysDelTime("f_sys_del_time"),
        sysAddUser("f_sys_add_user"),
        sysUpdUser("f_sys_upd_user"),
        sysDelUser("f_sys_del_user"),
        sysDelState("f_sys_del_state"),
        requestParams("f_request_params"),
        excepStackInfo("f_excep_stack_info"),
        responseData("f_response_data");

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table t_comm_logger
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String column;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_comm_logger
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_comm_logger
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_comm_logger
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        Column(String column) {
            this.column = column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_comm_logger
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String desc() {
            return this.column + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_comm_logger
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String asc() {
            return this.column + " ASC";
        }
    }
}