package org.prcode.utility.util;

import java.text.SimpleDateFormat;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName: UUIDGenerator
 * @Date: 2017-03-24 14:17
 * @Auther: kangduo
 * @Description: (生成UUID字符串)
 */
public class UUIDGenerator {
    private static final AtomicLong LAST_TIME_MS = new AtomicLong();

    /**
     *
     * @Title: getId
     * @Description: (生成UUID)
     * @return 去除"-"后的uuid字符串
     */
    public static String getId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     *
     * @Title: getOrderNumber
     * @Description: (获取订单编号)
     * @return 当前时间毫秒 + orderId
     */
    public static String getOrderNo(String orderId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(getUniqueTimestamp()) + orderId;
    }

    /**
     *
     * @Title: getFileName
     * @Description: (获取文件名)
     * @return 原子数字当前时间毫秒数
     */
    public static String getFileName() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(getUniqueTimestamp());
    }

    /**
     * @Title: getUniqueTimestamp
     * @Description: (生成时间戳)
     * @return 当前时间戳（原子）
     */
    private static long getUniqueTimestamp() {
        long now = System.currentTimeMillis();
        while (true) {
            long lastTime = LAST_TIME_MS.get();
            if (lastTime >= now)
                now = lastTime + 1;
            if (LAST_TIME_MS.compareAndSet(lastTime, now))
                return now;
        }
    }
}
