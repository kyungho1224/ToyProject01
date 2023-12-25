package com.fastcampus.BE7.group2.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by KimKyungHo on 2023-12-21(021)
 */
public class Utils {

    // String -> LocalDateTime
    // 변환 시 주의사항 : 시간 필수!
    private static final DateTimeFormatter formatterLong = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter formatterShort = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private Utils() {
    }

    private static String checkLocalDateTimeFormat(String date) {
        // 년월일만 입력했을 때
        if (!date.contains(" ")) {
            return date.concat(" 00:00:00").trim();
        }
        // HH 만 입력
        int maxLength = 3;
        int length = date.split(":").length;
        String endWith = ":00";
        return date.concat(endWith.repeat(maxLength - length)).trim();
    }

    public static LocalDateTime stringToLocalDateTime(String date) {
        String checkDate = checkLocalDateTimeFormat(date);
        System.out.println("checkDate = " + checkDate);
        String yearMonthDay = checkDate.split(" ")[0].trim();
        String hourMinuteSec = checkDate.split(" ")[1].trim();

        int year = Integer.parseInt(yearMonthDay.split("-")[0].trim());
        int month = Integer.parseInt(yearMonthDay.split("-")[1].trim());
        int day = Integer.parseInt(yearMonthDay.split("-")[2].trim());

        String reDate;
        if (hourMinuteSec.equals("00:00:00")) {
            reDate = String.format("%02d-%02d-%02d 00:00:00", year, month, day);
        } else {
            int hour = Integer.parseInt(hourMinuteSec.split(":")[0].trim());
            int minute = Integer.parseInt(hourMinuteSec.split(":")[1].trim());
            int sec = Integer.parseInt(hourMinuteSec.split(":")[2].trim());
            reDate = String.format("%02d-%02d-%02d %02d:%02d:%02d", year, month, day, hour, minute, sec);
        }

        return LocalDateTime.parse(reDate, formatterLong);
    }

    public static String localDateTimeToString(LocalDateTime localDateTime, boolean isLong) {
        if (isLong) {
            // 년월일 시분초
            return localDateTime.format(formatterLong);
        }
        // 년월일
        return localDateTime.format(formatterShort);
    }

}
