package org.prcode.business.support.basic.util;

import java.security.SecureRandom;
import java.util.UUID;

import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.prcode.utility.util.SequenceUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @className: IdWorker.
 * @date: 2017-11-14 18:23
 * @author: kangduo
 * @description: ()
 */
@Component
public class IdWorker {

    private static Long workerId;
    private static Long dataCenterId;
    private static SequenceUtil sequenceUtil;
    private static final SecureRandom RAND = new SecureRandom();
    private static final int RAND_AREA = 2 << 4;
    private static final String ID_WORKER_CONFIG_PREFIX = "idWorker:config:";

    /**
     * 注册redis超时时间，避免因未能正确注销导致 workerId 一直不能用
     */
    private static final long EXPIRE_SECONDS = 15 * 60L;

    private static final Logger logger = Logger.getLogger(IdWorker.class);

    private static SequenceUtil getSequenceUtil() {
        if (sequenceUtil == null) {
            long worker = RAND.nextInt(RAND_AREA);
            long center = RAND.nextInt(RAND_AREA);
            while (RedisUtil.exists(ID_WORKER_CONFIG_PREFIX + center + "_" + worker)) {
                worker = RAND.nextInt(RAND_AREA);
                center = RAND.nextInt(RAND_AREA);
            }
            workerId = worker;
            dataCenterId = center;
            sequenceUtil = new SequenceUtil(workerId, dataCenterId);
            RedisUtil.set(ID_WORKER_CONFIG_PREFIX + dataCenterId + "_" + workerId, "1", EXPIRE_SECONDS);
        }
        return sequenceUtil;
    }

    /**
     * 服务终止时，移除注册号
     */
    @PreDestroy
    public void destroy() {
        if (dataCenterId != null && workerId != null) {
            String key = ID_WORKER_CONFIG_PREFIX + dataCenterId + "_" + workerId;
            logger.debug("服务终止，安全移除IdWorker在redis中的注册号：" + key);
            RedisUtil.del(key);
        }
    }

    /**
     * 定时向redis注册
     */
    @Scheduled(cron = "0 0/5 * * * * ")
    public void regWorker() {
        if (dataCenterId != null && workerId != null) {
            String key = ID_WORKER_CONFIG_PREFIX + dataCenterId + "_" + workerId;
            logger.debug("IdWorker服务进行中，向redis续约");
            RedisUtil.set(key, "1", EXPIRE_SECONDS);
        }
    }

    /**
     * 产生uuid
     * @return uuid
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static Long getLongId() {
        return getSequenceUtil().nextId();
    }
}
