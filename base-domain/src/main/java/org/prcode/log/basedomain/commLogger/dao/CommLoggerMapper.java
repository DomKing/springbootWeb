package org.prcode.log.basedomain.commLogger.dao;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.prcode.log.basedomain.commLogger.domain.CommLogger;
import org.prcode.log.basedomain.commLogger.domain.CommLoggerExample;
import org.springframework.stereotype.Repository;

@Repository
public interface CommLoggerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comm_logger
     *
     * @mbg.generated
     */
    long countByExample(CommLoggerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comm_logger
     *
     * @mbg.generated
     */
    int insert(CommLogger record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comm_logger
     *
     * @mbg.generated
     */
    int insertSelective(CommLogger record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comm_logger
     *
     * @mbg.generated
     */
    List<CommLogger> selectByExampleWithBLOBs(CommLoggerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comm_logger
     *
     * @mbg.generated
     */
    List<CommLogger> selectByExample(CommLoggerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comm_logger
     *
     * @mbg.generated
     */
    CommLogger selectByPrimaryKey(@Param("id") Long id, @Param("reqStartTime") Date reqStartTime);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comm_logger
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") CommLogger record, @Param("example") CommLoggerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comm_logger
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") CommLogger record, @Param("example") CommLoggerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comm_logger
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") CommLogger record, @Param("example") CommLoggerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comm_logger
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(CommLogger record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comm_logger
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(CommLogger record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comm_logger
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(CommLogger record);
}