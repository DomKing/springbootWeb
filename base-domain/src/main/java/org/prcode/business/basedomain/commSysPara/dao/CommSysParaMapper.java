package org.prcode.business.basedomain.commSysPara.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.prcode.business.basedomain.commSysPara.domain.CommSysPara;
import org.prcode.business.basedomain.commSysPara.domain.CommSysParaExample;
import org.springframework.stereotype.Repository;

@Repository
public interface CommSysParaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comm_sys_para
     *
     * @mbg.generated
     */
    long countByExample(CommSysParaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comm_sys_para
     *
     * @mbg.generated
     */
    int insert(CommSysPara record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comm_sys_para
     *
     * @mbg.generated
     */
    int insertSelective(CommSysPara record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comm_sys_para
     *
     * @mbg.generated
     */
    List<CommSysPara> selectByExample(CommSysParaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comm_sys_para
     *
     * @mbg.generated
     */
    CommSysPara selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comm_sys_para
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") CommSysPara record, @Param("example") CommSysParaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comm_sys_para
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") CommSysPara record, @Param("example") CommSysParaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comm_sys_para
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(CommSysPara record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comm_sys_para
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(CommSysPara record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comm_sys_para
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int batchInsert(@Param("list") List<CommSysPara> list);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comm_sys_para
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int batchInsertSelective(@Param("list") List<CommSysPara> list, @Param("selective") CommSysPara.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comm_sys_para
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByExample(@Param("example") CommSysParaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comm_sys_para
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByPrimaryKey(Long id);
}