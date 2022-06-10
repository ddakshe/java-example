package com.kennen.programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LottosTest {
    @Test
    void test() {
        int[] lottos = new int[] {44,1,0,0,31,25};

        int[] win_nums = new int[]{31, 10, 45, 1, 6, 19};

        long worst = IntStream.of(lottos)
                .filter(value -> Arrays.stream(win_nums).anyMatch(lottoNum -> value == lottoNum)).count();

        long best = IntStream.of(lottos)
                .filter(value ->
                    Arrays.stream(win_nums).anyMatch(lottoNum -> value == lottoNum) || value == 0
                ).count();

        Assertions.assertEquals(worst, 2);
        Assertions.assertEquals(best, 4);
    }
}
