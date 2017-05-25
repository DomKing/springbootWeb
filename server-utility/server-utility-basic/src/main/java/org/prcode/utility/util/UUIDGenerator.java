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

    private static final String[] chars = new String[]{"a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};

    /**
     * @return 去除"-"后的uuid字符串
     * @Title: getId
     * @Description: (生成UUID)
     */
    public static String getId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * @return 当前时间毫秒 + orderId
     * @Title: getOrderNumber
     * @Description: (获取订单编号)
     */
    public static String getOrderNo(String orderId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(getUniqueTimestamp()) + orderId;
    }

    /**
     * @return 原子数字当前时间毫秒数
     * @Title: getFileName
     * @Description: (获取文件名)
     */
    public static String getFileName() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(getUniqueTimestamp());
    }

    /**
     * 产生6位的短位UUID(字母 + 数字)
     * 将32位的uuid，四位合一位，并舍弃最后两位
     *
     * @return uuid
     */
    public static String generateShortUuid() {
        StringBuilder stringBuilder = new StringBuilder();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 6; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            stringBuilder.append(chars[x % 0x3E]);
        }
        return stringBuilder.toString();
    }

    /**
     * 产生6位的短位UUID(数字)
     * 将32位的uuid，四位合一位，并舍弃最后两位
     *
     * @return uuid
     */
    public static String generateShortUuidNum() {
        StringBuilder stringBuilder = new StringBuilder();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 6; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            stringBuilder.append(chars[(x % 10) + 26]);
        }
        return stringBuilder.toString();
    }

    /**
     * @return 当前时间戳（原子）
     * @Title: getUniqueTimestamp
     * @Description: (生成时间戳)
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
