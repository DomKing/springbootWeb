package org.prcode.log.basedomain.oosLogger.dao;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.prcode.log.basedomain.oosLogger.domain.OosLogger;
import org.prcode.log.basedomain.oosLogger.domain.OosLoggerExample;
import org.springframework.stereotype.Repository;

@Repository
public interface OosLoggerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_oos_logger
     *
     * @mbg.generated
     */
    long countByExample(OosLoggerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_oos_logger
     *
     * @mbg.generated
     */
    int insert(OosLogger record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_oos_logger
     *
     * @mbg.generated
     */
    int insertSelective(OosLogger record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_oos_logger
     *
     * @mbg.generated
     */
    List<OosLogger> selectByExampleWithBLOBs(OosLoggerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_oos_logger
     *
     * @mbg.generated
     */
    List<OosLogger> selectByExample(OosLoggerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_oos_logger
     *
     * @mbg.generated
     */
    OosLogger selectByPrimaryKey(@Param("id") Long id, @Param("reqStartTime") Date reqStartTime);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_oos_logger
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") OosLogger record, @Param("example") OosLoggerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_oos_logger
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") OosLogger record, @Param("example") OosLoggerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_oos_logger
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") OosLogger record, @Param("example") OosLoggerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_oos_logger
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(OosLogger record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_oos_logger
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(OosLogger record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_oos_logger
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(OosLogger record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_oos_logger
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int batchInsert(@Param("list") List<OosLogger> list);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_oos_logger
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int batchInsertSelective(@Param("list") List<OosLogger> list, @Param("selective") OosLogger.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_oos_logger
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByExample(@Param("example") OosLoggerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_oos_logger
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByPrimaryKey(@Param("id") Long id, @Param("reqStartTime") Date reqStartTime);
}