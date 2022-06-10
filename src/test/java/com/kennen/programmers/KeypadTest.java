package com.kennen.programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;


public class KeypadTest {

    static int lastLeft = 10;
    static int lastRight = 12;

    @Test
    void test() {
        int[] numbers = new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";

        int count = 1;
        Map<Integer, Integer[]> position = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                position.put(count++, new Integer[]{i, j});
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int num : numbers) {
            int input = num == 0 ? 11 : num;
            if (num == 1 || num == 4 || num == 7) {
                appendHand(builder, "left", input);
            } else if (num == 3 || num == 6 || num == 9) {
                appendHand(builder, "right", input);
            } else {
                double left = getDistance(position.get(lastLeft), position.get(input));
                double right = getDistance(position.get(lastRight), position.get(input));
                if (left == right) {
                    appendHand(builder, hand, input);
                } else if (left < right) {
                    appendHand(builder, "left", input);
                } else {
                    appendHand(builder, "right", input);
                }
            }
        }

        Assertions.assertEquals("LRLLRRLLLRR", builder.toString());
    }

    private void appendHand(StringBuilder builder, String hand, int num) {
        int input = num == 0 ? 11 : num;
        if ("right".equals(hand)) {
            builder.append("R");
            lastRight = input;
        } else {
            builder.append("L");
            lastLeft = input;
        }
    }

    private double getDistance(Integer[] a, Integer[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }


}
