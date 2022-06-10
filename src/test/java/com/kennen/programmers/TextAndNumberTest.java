package com.kennen.programmers;

import org.junit.jupiter.api.Test;

public class TextAndNumberTest {

    @Test
    void test() {
        String text = "one4seveneight";

        text = text.replaceAll("one", "1");

        for (NumberText value : NumberText.values()) {
            text = text.replaceAll(value.getText(), value.getNumber());
        }

        System.out.println("text = " + text);
    }

    enum NumberText {
        ONE("one", "1"),
        TWO("two", "2"),
        THREE("three", "3"),
        FOUR("four", "4"),
        FIVE("five", "5"),
        SIX("six", "6"),
        SEVEN("seven", "7"),
        EIGHT("eight", "8"),
        NINE("nine", "9"),
        ZERO("zero", "0"),


        ;

        private final String text;
        private final String number;

        public String getText() {
            return text;
        }

        public String getNumber() {
            return number;
        }

        NumberText(String text, String number) {
            this.text = text;
            this.number = number;
        }
    }
}
