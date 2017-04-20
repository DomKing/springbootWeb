package org.prcode.utility.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName: DateUtil
 * @Date: 2017-03-24 15:47
 * @Auther: kangduo
 * @Description: (日期工具类)
 */
public class DateUtil {

    public static final ThreadLocal<DateFormat> formatDay = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static final ThreadLocal<DateFormat> formatSecond = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    /**
     * 获取当前日期
     *
     * @return yyyy-MM-dd
     */
    public static String getCurrDateDay() {
        Date now = new Date();
        return formatDay.get().format(now);
    }

    /**
     * 获取当天0点时间
     *
     * @return 0点Date
     */
    public static Date getTodayDay() {
        Date now = new Date();
        Date todayDay = null;
        try {
            todayDay = formatDay.get().parse(formatSecond.get().format(now));
        } catch (ParseException e) {
            throw new RuntimeException(DateUtil.class + "Time parse error:" + e.getMessage() + ",time is:" + now);
        }
        return todayDay;
    }

    /**
     * 获取当前时间
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrDateTime() {
        Date now = new Date();
        return formatSecond.get().format(now);
    }

    /**
     * 日期加减
     *
     * @param date   日期
     * @param length 加减天，正则加，负则减
     * @return 计算后的日期
     */
    public static Date getNextDate(Date date, int length) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.DAY_OF_YEAR, length);
        return ca.getTime();
    }
}
