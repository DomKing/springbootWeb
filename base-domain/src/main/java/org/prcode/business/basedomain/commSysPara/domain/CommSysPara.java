package org.prcode.business.basedomain.commSysPara.domain;

import java.io.Serializable;
import org.prcode.basedomain.base.BaseDomain;

public class CommSysPara extends BaseDomain implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comm_sys_para.f_id
     *
     * @mbg.generated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comm_sys_para.f_sys_para_code
     *
     * @mbg.generated
     */
    private String sysParaCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comm_sys_para.f_sys_para_value
     *
     * @mbg.generated
     */
    private String sysParaValue;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comm_sys_para.f_sys_para_desc
     *
     * @mbg.generated
     */
    private String sysParaDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_comm_sys_para
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comm_sys_para.f_id
     *
     * @return the value of t_comm_sys_para.f_id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comm_sys_para.f_id
     *
     * @param id the value for t_comm_sys_para.f_id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comm_sys_para.f_sys_para_code
     *
     * @return the value of t_comm_sys_para.f_sys_para_code
     *
     * @mbg.generated
     */
    public String getSysParaCode() {
        return sysParaCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comm_sys_para.f_sys_para_code
     *
     * @param sysParaCode the value for t_comm_sys_para.f_sys_para_code
     *
     * @mbg.generated
     */
    public void setSysParaCode(String sysParaCode) {
        this.sysParaCode = sysParaCode == null ? null : sysParaCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comm_sys_para.f_sys_para_value
     *
     * @return the value of t_comm_sys_para.f_sys_para_value
     *
     * @mbg.generated
     */
    public String getSysParaValue() {
        return sysParaValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comm_sys_para.f_sys_para_value
     *
     * @param sysParaValue the value for t_comm_sys_para.f_sys_para_value
     *
     * @mbg.generated
     */
    public void setSysParaValue(String sysParaValue) {
        this.sysParaValue = sysParaValue == null ? null : sysParaValue.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comm_sys_para.f_sys_para_desc
     *
     * @return the value of t_comm_sys_para.f_sys_para_desc
     *
     * @mbg.generated
     */
    public String getSysParaDesc() {
        return sysParaDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comm_sys_para.f_sys_para_desc
     *
     * @param sysParaDesc the value for t_comm_sys_para.f_sys_para_desc
     *
     * @mbg.generated
     */
    public void setSysParaDesc(String sysParaDesc) {
        this.sysParaDesc = sysParaDesc == null ? null : sysParaDesc.trim();
    }
}