package org.prcode.utility.util;

/**
 * @ClassName: StringUtil
 * @Date: 2017-03-24 16:22
 * @Auther: kangduo
 * @Description: (字符串工具类)
 */
public class StringUtil {

    /**
     * 是否为null或空串
     * @param source 原文
     * @return true | false
     */
    public static boolean isEmpty(String source) {
        return source == null || source.isEmpty();
    }

    /**
     * 字符串不是null且不是空串
     * @param source 原文
     * @return 是否不空 true | false
     */
    public static boolean isNotEmpty(String source) {
        return source != null && source.length() > 0;
    }
    /**
     * 指定位置替换为*
     * @param source 原文
     * @param from 开始位，计数从1开始
     * @param to 结束位，计数从1开始
     * @return 如：abc12******0d
     */
    public static String replaceWithStar(String source, int from, int to) {
        if (isEmpty(source) || from > to) {
            return source;
        }
        from = from < 1 ? 1 : from;
        to = to > source.length() ? source.length() : to;
        StringBuilder sb = new StringBuilder();
        sb.append(source.substring(0, from - 1));
        for (int i = 0; i < to - from + 1; i++) {
            sb.append("*");
        }
        sb.append(source.substring(to));
        return sb.toString();
    }

    /**
     * 两边加%，用于sql中like
     * @param str 原文
     * @return trim后两边加%
     */
    public static String turn2LikeStr(String str) {
        if (isEmpty(str)) {
            return "%%";
        }
        return "%" + str.trim() + "%";
    }
}
