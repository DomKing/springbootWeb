package org.prcode.utility.pay.wechat.util;

import java.security.MessageDigest;

/**
 * @ClassName: MD5Util
 * @Date: 2017-04-19 16:47
 * @Auther: kangduo
 * @Description: (MD5工具类)
 */
public class MD5Util {

    private static String byteArrayToHexString(byte b[]) {
        StringBuilder resultSb = new StringBuilder();
        for (byte aB : b) resultSb.append(byteToHexString(aB));

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String MD5Encode(String origin, String charset) {
        String resultString = null;
        try {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charset == null || "".equals(charset))
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            else
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charset)));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return resultString;
    }

    private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
}
