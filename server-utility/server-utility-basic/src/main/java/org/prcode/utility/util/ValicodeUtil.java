package org.prcode.utility.util;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @ClassName: ValicodeUtil
 * @Date: 2017-03-24 17:45
 * @Auther: kangduo
 * @Description: (生成验证码工具类)
 */
public class ValicodeUtil {
    /**
     * 创建指定数量的随机字符串
     *
     * @param onlyNumber 是否是数字
     * @param length     生成位数
     * @return 验证码
     */
    public static String createValicode(boolean onlyNumber, int length) {
        if (length < 1) {
            return null;
        }
        StringBuilder retStr = new StringBuilder();
        Random random = new SecureRandom();
        String strTable = onlyNumber ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
        int len = strTable.length();
        for (int i = 0; i < length; i++) {
            int position = Math.abs(random.nextInt() % len);
            retStr.append(strTable.charAt(position));
        }
        return retStr.toString();
    }
}
