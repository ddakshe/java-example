package com.kennen.matcher;

import org.junit.jupiter.api.Test;

public class Regex01Tests {


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
        System.out.println("\"\".matches(\".+\") = " + text.matches(".+"));
        System.out.println("\"\".matches(\".*\") = " + text.matches(".*"));

        text = "강아지";
        System.out.println("강아지.matches(\"강아.\") = " + text.matches("강아."));
        System.out.println("강아지.matches(\"강아지.\") = " + text.matches("강아지."));

        text = "김철수";
        System.out.println("김철수.matches(\"김.수\") = " + text.matches("김.수"));

        text = "김박수";
        System.out.println("김박수.matches(\"김.수\") = " + text.matches("김.수"));
    }

    @Test
    void containsOne() {
        String text = "a";
        System.out.println("a.matches(\"[abc]\") = " + text.matches("[abc]"));
        System.out.println("a.matches(\"[bcd]\") = " + text.matches("[bcd]"));

        text = "abc";
        System.out.println("abc.matches(\"[abc]\") = " + text.matches("[abc]"));
        System.out.println("abc.matches(\"[abcd]\") = " + text.matches("[abcd]"));

        text = "My name is Kennen";
        System.out.println("text.matches(\"My [Nn]ame is Kennen\") = " + text.matches("My [Nn]ame is Kennen"));
    }

    @Test
    void containsCombine() {
        String text = "af";
        System.out.println("af.matches(\"[ab][fg]\") = " + text.matches("[ab][fg]"));
        System.out.println("af.matches(\"[af]\") = " + text.matches("[af]"));

        text = "afyl";
        System.out.println("text.matches(\"[ae][fg][yj][lm]\") = " + text.matches("[ae][fg][yj][lm]"));
    }

    @Test
    void exam() {
        String text = "My Name is Kennen";
        System.out.println("text.matches(\"My [Nn]ame is .[ea][nm][nm]en\") = " + text.matches("My [Nn]ame is .[ea][nm][nm].."));
    }
}
