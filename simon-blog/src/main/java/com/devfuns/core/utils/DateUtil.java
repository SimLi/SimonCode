package com.devfuns.core.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

    private static final String PATTERN_SDF = "yyyy-MM-dd";

    private static final String PATTERN_SDF_CHINEES = "yyyy年MM月dd日";

    private static final String PATTERN_SDF_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    private static final String PATTERN_SDF_YYYYMMDDHHSSMM = "yyyyMMddHHssmm";

    private static ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<SimpleDateFormat>();

    private static ThreadLocal<SimpleDateFormat> sdf_chiness = new ThreadLocal<SimpleDateFormat>();

    private static ThreadLocal<SimpleDateFormat> sdf_yyyyMMdd_HH_mm_ss = new ThreadLocal<SimpleDateFormat>();

    private static ThreadLocal<SimpleDateFormat> sdf_yyyyMMddHHssmm = new ThreadLocal<SimpleDateFormat>();

    /**
     * 初始化日期格式器
     */
    private static void initObject() {

        if (sdf.get() == null) {
            sdf.set(new SimpleDateFormat(PATTERN_SDF));
        }

        if (sdf_chiness.get() == null) {
            sdf_chiness.set(new SimpleDateFormat(PATTERN_SDF_CHINEES));
        }

        if (sdf_yyyyMMdd_HH_mm_ss.get() == null) {
            sdf_yyyyMMdd_HH_mm_ss.set(new SimpleDateFormat(PATTERN_SDF_HH_MM_SS));
        }

        if (sdf_yyyyMMddHHssmm.get() == null) {
            sdf_yyyyMMddHHssmm.set(new SimpleDateFormat(PATTERN_SDF_YYYYMMDDHHSSMM));
        }

    }

    public static String formatDate(Date date) {
        if (date == null) {
            return null;
        }
        initObject();
        return sdf.get().format(date);
    }

    public static String formatDate(Date date, String pattern) {
        initObject();
        if (date == null) {
            return null;
        } else if (StringUtils.isEmpty(pattern)) {
            return sdf.get().format(date);
        } else if (pattern.equals(PATTERN_SDF)) {
            return sdf.get().format(date);
        } else if (pattern.equals(PATTERN_SDF_HH_MM_SS)) {
            return sdf_yyyyMMdd_HH_mm_ss.get().format(date);
        } else if (pattern.equals(PATTERN_SDF_CHINEES)) {
            return sdf_chiness.get().format(date);
        } else if (pattern.equals(PATTERN_SDF_YYYYMMDDHHSSMM)) {
            return sdf_yyyyMMddHHssmm.get().format(date);
        }
        return null;
    }

    public static Date parseDate(String date) {
        initObject();
        try {
            return sdf.get().parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.error("日期字符[" + date + "]解析错误", e);
        }
        return null;
    }

    public static Date parseDateTime(String date) {
        initObject();
        try {
            return sdf_yyyyMMdd_HH_mm_ss.get().parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.error("日期字符[" + date + "]解析错误", e);
        }
        return null;
    }

    /**
     * 添加天数
     * */
    public static Date addDaysForDate(Date date,int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,days);
        return calendar.getTime();
    }

    public static String getPatternSdf() {
        return PATTERN_SDF;
    }

    public static String getPatternSdfChinees() {
        return PATTERN_SDF_CHINEES;
    }

    public static String getPatternSdfHhMmSs() {
        return PATTERN_SDF_HH_MM_SS;
    }

    public static String getPatternSdfYyyymmddhhssmm() {
        return PATTERN_SDF_YYYYMMDDHHSSMM;
    }

    /**
     * 获得当前月的第一天
     * @return
     */
    public static Date getFirstDayOfCurrentMonth(){
        Calendar calendar  = Calendar.getInstance();
        int firstDay = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH,firstDay);
        return calendar.getTime();
    }

    /**
     * 获得当前月的最后一天
     * @return
     */
    public static Date getLastDayOfCurrentMonth(){
        Calendar calendar  = Calendar.getInstance();
        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH,lastDay);
        calendar.add(Calendar.DATE,1);

        return calendar.getTime();
    }

    public static Date getFirstDayOfCurrentWeek() {
        Calendar cal =Calendar.getInstance();
        int firstDay =  cal.getActualMinimum(Calendar.DAY_OF_WEEK);
        cal.set(Calendar.DAY_OF_WEEK, firstDay);
        cal.add(Calendar.DATE,1);
        return cal.getTime();
    }

    public static Date getLastDayOfCurrentWeek() {
        Calendar cal =Calendar.getInstance();
        int lastDay =  cal.getActualMaximum(Calendar.DAY_OF_WEEK);
        cal.set(Calendar.DAY_OF_WEEK, lastDay);
        cal.add(Calendar.DATE,1);
        return cal.getTime();
    }

}

