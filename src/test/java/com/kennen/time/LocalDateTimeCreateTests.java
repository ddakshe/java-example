package com.kennen.time;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class LocalDateTimeCreateTests {

    @Test
    void localDateTime() {
        // 현재 날짜 및 시간
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);
        // chicago 날짜 및 시간
        LocalDateTime chicagoDateTime = LocalDateTime.now(ZoneId.of("America/Chicago"));
        System.out.println("chicagoDateTime = " + chicagoDateTime);
        // cuba 날짜 및 시간
        LocalDateTime cubaDateTime = LocalDateTime.now(ZoneId.of("Cuba"));
        System.out.println("cubaDateTime = " + cubaDateTime);

        // LocalDate, LocalTime 으로 현재 날짜 및 시간 가져오기
        LocalDate dateNow = LocalDate.now(); // 현재 날짜
        LocalTime timeNow = LocalTime.now(); // 현재 시간
        LocalDateTime fromLocalDateAndTime = LocalDateTime.of(dateNow, timeNow);
        System.out.println("fromLocalDateAndTime = " + fromLocalDateAndTime);
    }



    @Test
    void of() {
        // of custom
        int year = 2020, month = 5, dayOfMonth = 16, hour = 6, minute = 24, second = 44;
        LocalDateTime of = LocalDateTime.of(year, month, dayOfMonth, hour, minute, second);
        System.out.println("of = " + of);

        // of LocalDate, LocalTime
        LocalDate dateNow = LocalDate.of(year, month, dayOfMonth);
        LocalTime timeNow = LocalTime.of(hour, minute, second); // second is Optional
        LocalDateTime ofLocalDateAndTime = LocalDateTime.of(dateNow, timeNow);
        System.out.println("ofLocalDateAndTime = " + ofLocalDateAndTime);
    }

    @Test
    void stringToLocalDateTime() {
        String input = "2022-05-16 21:07:12";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(input, formatter);
        System.out.println("localDateTime = " + localDateTime);
    }

    @Test
    void fromLegacy() {
        // from Date
        Date date = new Date();
        System.out.println("date = " + date);
        LocalDateTime fromDate = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        System.out.println("fromDate = " + fromDate);

        // from Calendar
        Calendar calendar = Calendar.getInstance();
        System.out.println("calendar = " + calendar);
        LocalDateTime fromCalendar = LocalDateTime.ofInstant(calendar.toInstant(), calendar.getTimeZone().toZoneId());
        System.out.println("fromCalendar = " + fromCalendar);
    }
}
