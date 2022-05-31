package com.kennen.time;

import org.junit.jupiter.api.Test;

import java.time.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZonedDateTimeTests {

    @Test
    void difference() {
        LocalDateTime localDateTime = LocalDateTime.now();
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("America/Sao_Paulo"));

        Period period = Period.between(localDateTime.toLocalDate(), zonedDateTime.toLocalDate());

        Duration duration = Duration.between(localDateTime, zonedDateTime);

        assertEquals(localDateTime.getYear(), zonedDateTime.getYear());
    }

    @Test
    void addZone() {
        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime saoPauloZonedDateTime = now.atZone(ZoneId.of("America/Sao_Paulo"));
        ZonedDateTime seoulZonedDateTime = now.atZone(ZoneId.of("Asia/Seoul"));
        ZonedDateTime londonZonedDateTime = seoulZonedDateTime.withZoneSameInstant(ZoneId.of("Europe/London"));

        LocalDateTime localDateTime = seoulZonedDateTime.toLocalDateTime();
        System.out.println(seoulZonedDateTime);
    }

    @Test
    void withZoneSameInstance() {
        ZonedDateTime now = LocalDateTime.now().atZone(ZoneId.of("Asia/Seoul"));
        ZonedDateTime londonZonedDateTime = now.withZoneSameInstant(ZoneId.of("Europe/London"));

        System.out.println("now = " + now);
        System.out.println("londonZonedDateTime = " + londonZonedDateTime);

        System.out.println(now);

    }
}
