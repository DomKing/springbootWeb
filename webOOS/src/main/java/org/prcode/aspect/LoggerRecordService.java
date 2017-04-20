package org.prcode.aspect;

import org.prcode.log.basedomain.oosLogger.dao.OosLoggerMapper;
import org.prcode.log.basedomain.oosLogger.domain.OosLogger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: LoggerRecordService
 * @Date: 2017-03-30 16:00
 * @Auther: kangduo
 * @Description: ()
 */
@Service
public class LoggerRecordService {
    @Resource
    private OosLoggerMapper oosLoggerMapper;

    /**
     * 异步记录日志，避免日志记录中报错，或者记录过慢
     * 异步方法在同一个类内调用，不会异步的
     * @param oosLogger 日志
     */
    @Async
    void doRecord(OosLogger oosLogger) {
        oosLoggerMapper.insertSelective(oosLogger);
    }
}
