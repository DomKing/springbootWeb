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

    private Long workerId;
    private Long dataCenterId;
    private SequenceUtil sequenceUtil;
    private static final SecureRandom RAND = new SecureRandom();
    private static final int RAND_AREA = 31;
    private static final String ID_WORKER_CONFIG_PREFIX = "idWorker:config:";

    private static IdWorker ourInstance = new IdWorker();

    public static IdWorker getInstance() {
        if (ourInstance.workerId == null || ourInstance.dataCenterId == null) {
            long workerId = RAND.nextInt(RAND_AREA);
            long centerId = RAND.nextInt(RAND_AREA);
            while (RedisUtil.exists(ID_WORKER_CONFIG_PREFIX + centerId + "_" + workerId)) {
                workerId = RAND.nextInt(RAND_AREA);
                centerId = RAND.nextInt(RAND_AREA);
            }
            ourInstance.workerId = workerId;
            ourInstance.dataCenterId = centerId;
        }
        return ourInstance;
    }

    private IdWorker() {
    }


    @PreDestroy
    public void destroy() {
        String key = ID_WORKER_CONFIG_PREFIX + dataCenterId + "_" + workerId;
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
        IdWorker idWorker = getInstance();
        return new SequenceUtil(idWorker.workerId, idWorker.dataCenterId).nextId();
    }
}
