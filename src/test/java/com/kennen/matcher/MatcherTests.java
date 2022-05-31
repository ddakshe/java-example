package com.kennen.matcher;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class MatcherTests {
    @Test
    void matchers() {
        Pattern stringPattern = Pattern.compile("\\d\\d\\d\\d"); // 숫자문자숫자문자 조합
        String input = "나는 986년도에 태어났고 너는 012년도에 태어났다.";
        Matcher m = stringPattern.matcher(input);

        assertTrue(m.find());

        assertEquals(3, m.start());
        assertEquals("1986",m.group());
        assertEquals(7, m.end());

        assertTrue(m.find());
        assertEquals(19, m.start());
        assertEquals("2012", m.group());
        assertEquals(23, m.end());

        assertFalse(m.find());
    }

    @Test
    void findIndex() {
        Pattern stringPattern = Pattern.compile("\\d\\d\\d\\d");
        String input = "goodbye 2021 and welcome 2022";
        Matcher m = stringPattern.matcher(input);

        assertTrue(m.find(20));
        assertEquals(25, m.start());
        assertEquals("2022", m.group());
        assertEquals(29, m.end());
    }

    @Test
    void matches() {
        Pattern stringPattern = Pattern.compile("\\d\\d\\d\\d");
        Matcher m = stringPattern.matcher("2019");

        assertTrue(m.find());
        assertEquals(0, m.start());
        assertEquals("2019", m.group());
        assertEquals(4, m.end());
        assertTrue(m.matches());

    }

    @Test
    void matches2() {
        System.out.println("Pattern.matches(\"\\\\d\\\\d\\\\d\\\\d\", \"2019\") = " + Pattern.matches("\\d\\d\\d\\d", "2019"));
        Matcher m = Pattern.compile("\\d\\d\\d\\d").matcher("aaa2019");
        if (m.find()) {
            System.out.println("m.start() = " + m.start());
            System.out.println("m.group() = " + m.group());
        }
    }
}
