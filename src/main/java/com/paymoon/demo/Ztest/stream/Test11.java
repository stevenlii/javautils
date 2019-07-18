package com.paymoon.demo.Ztest.stream;

import org.apache.http.util.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

public class Test11 {
    public static void main(String[] args) throws ParseException {
//        System.out.println(getMorning(System.currentTimeMillis(),null));
        String sDate1="19980321";
//        Date date=new SimpleDateFormat("yyyyMMdd").parse(sDate1);
//        System.out.println(getStartOfDay(date));
//        System.out.println(getEndOfDay(date));
        System.out.println(getMorning(sDate1));

    }

    //获取当天（按当前传入的时区）00:00:00所对应时刻的long型值
    private static int getMorning(String dateStr) throws ParseException {
        Date date=new SimpleDateFormat("yyyyMMdd").parse(dateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return (int)(calendar.getTimeInMillis() / 1000L);
    }
//    private static int getMorning2(String now, String timeZone) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
//        LocalDateTime ldt = LocalDateTime.parse(now, formatter);
//        LocalDateTime today_start = LocalDateTime.of(ldt., LocalTime.MIN);//当天零点
//
//        return (int)(calendar.getTimeInMillis() / 1000L);
//    }
    public static int getLastDayMorning() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(11, 0);
        cal.set(13, 0);
        cal.set(12, 0);
        cal.set(14, 0);
        cal.add(5, -1);
        return (int)(cal.getTimeInMillis() / 1000L);
    }
    // 获得某天最大时间 2017-10-15 23:59:59
    public static Date getEndOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());;
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    // 获得某天最小时间 2017-10-15 00:00:00
    public static Date getStartOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

}