package org.prcode.utility.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @ClassName: PriceUtil
 * @Date: 2017-03-24 15:25
 * @Auther: kangduo
 * @Description: (价格计算工具类)
 */
public class PriceUtil {

    /**
     * Double数据乘100, 舍弃小数位后两位后面的数据
     *
     * @param prize 价格
     * @return 转成分后的价格
     */
    public static Long multiply100(Double prize) {
        if (prize == null) {
            return null;
        }
        //解决精度问题，如75.6实际是75.599999999999
        Double tmpPrize = (prize + 0.0001) * 100;
        return tmpPrize.longValue();
    }

    /**
     * 价格分转元
     *
     * @param srcPrice 分
     * @return 元，进一法保留两位
     */
    public static BigDecimal div100(Long srcPrice) {
        if (srcPrice == null) {
            return null;
        }
        BigDecimal tmpDeci = new BigDecimal(srcPrice);
        return tmpDeci.divide(new BigDecimal("100"), 2, RoundingMode.UP);
    }

    /**
     * 价格分转元
     *
     * @param srcPrice 分
     * @return 元, 进一法保留两位
     */
    public static String div100Str(Long srcPrice) {
        NumberFormat nf = new DecimalFormat("#0.00");
        if (srcPrice == null) {
            return null;
        }
        BigDecimal tmpDeci = new BigDecimal(srcPrice);
        BigDecimal resBig = tmpDeci.divide(new BigDecimal("100"), 2, RoundingMode.UP);
        return nf.format(resBig);
    }

    /**
     * 价格除以整数
     *
     * @param srcPrice 被除数
     * @param num      除数
     * @return 进一法保留两位
     */
    public static BigDecimal divByNum(Long srcPrice, int num) {
        if (srcPrice == null) {
            return null;
        }
        BigDecimal tmpDeci = new BigDecimal(srcPrice);
        return tmpDeci.divide(new BigDecimal(num), 2, RoundingMode.UP);
    }

    /**
     * 去除尾部没必要的0
     *
     * @param price 需要去0的值
     * @return 去0后的数字
     */
    public static BigDecimal removeTailZero(BigDecimal price) {
        if (price == null) {
            return null;
        }
        String s = price.toString();
        BigDecimal bd;
        if (!s.contains(".")) {
            return price;
        }
        int i, len = s.length();
        for (i = 0; i < len; i++) {
            if (s.charAt(len - 1 - i) != '0')
                break;
        }

        if (s.charAt(len - i - 1) == '.') {
            bd = new BigDecimal(s.substring(0, len - i - 1));
        } else {
            bd = new BigDecimal(s.substring(0, len - i));
        }
        return bd;
    }
}
