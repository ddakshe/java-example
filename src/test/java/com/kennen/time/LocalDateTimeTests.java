package com.kennen.time;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeTests {
    @Test
    void to_get() {
        // 현재 날짜 및 시간
        LocalDateTime now = LocalDateTime.now();
        System.out.println("[now] = " + now);
        System.out.println("now.getYear() = " + now.getYear()); // 년
        System.out.println("now.getMonth() = " + now.getMonth()); // 월
        System.out.println("now.getMonthValue() = " + now.getMonthValue()); // 월(숫자)
        System.out.println("now.getDayOfMonth() = " + now.getDayOfMonth()); // 일
        System.out.println("now.getHour() = " + now.getHour()); // 시
        System.out.println("now.getMinute() = " + now.getMinute()); // 분
        System.out.println("now.getSecond() = " + now.getSecond()); // 초
        // 현재 날짜만 빼오기
        LocalDate date = now.toLocalDate();
        System.out.println("[date] = " + date);
        System.out.println("date.getYear() = " + date.getYear()); // 년
        System.out.println("date.getMonth() = " + date.getMonth()); // 월
        System.out.println("date.getMonthValue() = " + date.getMonthValue()); // 월(숫자)
        System.out.println("date.getDayOfMonth() = " + date.getDayOfMonth()); // 일
        // 현재 시간만 빼오기
        LocalTime time = now.toLocalTime();
        System.out.println("[time] = " + time);
        System.out.println("time.getHour() = " + time.getHour()); // 시
        System.out.println("time.getMinute() = " + time.getMinute()); // 분
        System.out.println("time.getSecond() = " + time.getSecond()); // 초

        Assertions.assertEquals(now.getYear(), date.getYear());
        Assertions.assertEquals(now.getMonth(), date.getMonth());
        Assertions.assertEquals(now.getDayOfMonth(), date.getDayOfMonth());
        Assertions.assertEquals(now.getHour(), time.getHour());
        Assertions.assertEquals(now.getMinute(), time.getMinute());
        Assertions.assertEquals(now.getSecond(), time.getSecond());
    }

    @Test
    void calc() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);
        // PLUS
        System.out.println("now.plusYears(2) = " + now.plusYears(2));
        System.out.println("now.plusMonths(5) = " + now.plusMonths(5));
        System.out.println("now.plusDays(10) = " + now.plusDays(10));
        System.out.println("now.plusHours(5) = " + now.plusHours(5));
        System.out.println("now.plusMinutes(10) = " + now.plusMinutes(10));
        System.out.println("now.plusSeconds(20) = " + now.plusSeconds(20));

        // MINUS
        System.out.println("now.minusYears(2) = " + now.minusYears(2));
        System.out.println("now.minusMonths(5) = " + now.minusMonths(5));
        System.out.println("now.minusDays(10) = " + now.minusDays(10));
        System.out.println("now.minusHours(5) = " + now.minusHours(5));
        System.out.println("now.minusMinutes(10) = " + now.minusMinutes(10));
        System.out.println("now.minusSeconds(20) = " + now.minusSeconds(20));

        System.out.println("now = " + now);
    }

    @Test
    void compare() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);
        LocalDateTime after2Years = now.plusYears(2);
        System.out.println("after2Years = " + after2Years);

        System.out.println("now.isBefore(after2Years) = " + now.isBefore(after2Years));
        System.out.println("now.isAfter(after2Years) = " + now.isAfter(after2Years));
        System.out.println("now.isEqual(after2Years) = " + now.isEqual(after2Years));
    }

    @Test
    void period() {
        LocalDate startDate = LocalDate.now();
        System.out.println("startDate = " + startDate);
        LocalDate endDate = startDate.plusYears(2).plusMonths(3).plusDays(4);
        System.out.println("endDate = " + endDate);
        Period between = Period.between(startDate, endDate);
        System.out.println("between.getYears() = " + between.getYears());
        System.out.println("between.getMonths() = " + between.getMonths());
        System.out.println("between.getDays() = " + between.getDays());
    }

    @Test
    void duration() {
        LocalDateTime startDate = LocalDateTime.now();
        LocalDateTime endDate = startDate.plusMonths(4);
        Duration between = Duration.between(startDate, endDate);
        System.out.println("between = " + between);
        System.out.println("between.toDays() = " + between.toDays());
        System.out.println("between.toHours() = " + between.toHours());
        System.out.println("between.toMinutes() = " + between.toMinutes());
        System.out.println("between.toSeconds() = " + between.toSeconds());
    }

    @Test
    void dateTimeFormatter() {
        // 현재 날짜 및 시간
        LocalDateTime now = LocalDateTime.now();
        // ISO : yyyy-MM-ddTHH:mm:ss
        String isoDateTime = now.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println("isoDateTime = " + isoDateTime);
        // 사용자 입력
        String customFormat1 = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("customFormat1 = " + customFormat1);
        // 오전/오후
        String customFormat2 = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd a HH:mm:ss"));
        System.out.println("customFormat2 = " + customFormat2);

        String formatDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("formatDate = " + formatDate);
        String formatTime = LocalTime.now().format(DateTimeFormatter.ofPattern("a HH:mm:ss"));
        System.out.println("formatTime = " + formatTime);
    }
}
