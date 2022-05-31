package com.kennen.matcher;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegexTests {


    @Test
    void character1() {
        String text = "a";
        System.out.println("a.matches(\".\") = " + text.matches("."));
        System.out.println("a.matches(\"..\") = " + text.matches(".."));

        text = "aa";
        System.out.println("aa.matches(\".\") = " + text.matches("."));
        System.out.println("aa.matches(\"..\") = " + text.matches(".."));

        text = "*1";
        System.out.println("*1.matches(\".\") = " + text.matches("."));
        System.out.println("*1.matches(\"..\") = " + text.matches(".."));

        text = "한글";
        System.out.println("한글.matches(\".\") = " + text.matches("."));
        System.out.println("한글.matches(\"..\") = " + text.matches(".."));
        System.out.println("한글.matches(\".+\") = " + text.matches(".+"));
        System.out.println("한글.matches(\".*\") = " + text.matches(".*"));

        text = "";
        System.out.println("\"\".matches(\".*\") = " + text.matches(".*"));
    }

    @Test
    void contains() {
        String text = "a";
        System.out.println("a.matches(\"[abc]\") = " + text.matches("[abc]"));
        System.out.println("a.matches(\"[bcd]\") = " + text.matches("[bcd]"));


    }
}
