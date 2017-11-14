package org.prcode.business.support.basic.util;

import java.security.SecureRandom;
import java.util.UUID;

import javax.annotation.PreDestroy;

import org.prcode.utility.util.SequenceUtil;
import org.springframework.stereotype.Component;

/**
 * @className: IdWorker.
 * @date: 2017-11-14 18:23
 * @author: kangduo
 * @description: ()
 */
@Component
public class IdWorker {

    private static final long WORKER_ID;
    private static final long DATA_CENTER_ID;
    private static final SequenceUtil SEQUENCE_UTIL;
    private static final SecureRandom RAND = new SecureRandom();
    private static final int RAND_AREA = 31;
    private static final String ID_WORKER_CONFIG_PREFIX = "idWorker:config:";
    static {
        long workerId = RAND.nextInt(RAND_AREA);
        long centerId = RAND.nextInt(RAND_AREA);
        while (RedisUtil.exists(ID_WORKER_CONFIG_PREFIX + centerId + "_" + workerId)) {
            workerId = RAND.nextInt(RAND_AREA);
            centerId = RAND.nextInt(RAND_AREA);
        }
        WORKER_ID = workerId;
        DATA_CENTER_ID = centerId;
        SEQUENCE_UTIL = new SequenceUtil(WORKER_ID, DATA_CENTER_ID);
    }

    @PreDestroy
    public void destroy() {
        String key = ID_WORKER_CONFIG_PREFIX + DATA_CENTER_ID + "_" + WORKER_ID;
        RedisUtil.del(key);
    }

    /**
     * 产生uuid
     * @return uuid
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static Long getLongId() {
        return SEQUENCE_UTIL.nextId();
    }
}
