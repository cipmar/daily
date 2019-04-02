package com.softwaredevelopmentstuff.daily;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static java.lang.Math.PI;
import static java.lang.Math.pow;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day20190402_Series {
    @Test
    void testSeries1() {
        // 1 + 1/2 + 1/4 + 1/8 + 1/16.... = 2
        // this is a convergent series
        int n = 30;
        double epsilon = 0.000000000000000001;

        double result = IntStream
                .range(1, n)
                .mapToDouble(i -> 1.0 / pow(2, i))
                .reduce(1.0, (s, i) -> s + i);

        System.out.println(result);

        assertTrue(result < 2 - epsilon);
    }

    @Test
    void testHarmonicSeries() {
        // 1 + 1/2 + 1/3 + 1/4 + 1/5.... = Infinity
        // this is a divergent series
        int n = 900000;

        double result = IntStream
                .range(1, n)
                .mapToDouble(i -> 1.0 / i)
                .reduce(0.0, (s, i) -> s + i);

        System.out.println(result);
    }

    @Test
    void testSeries3() {
        // 1 + (1/2)^2 + (1/3)^2 + (1/4)^2 + (1/5)^2.... = ?
        // this is a convergent series, it converges to (PI^2)/6, unsolved problem...
        int n = 10000;
        double epsilon = 0.000000000000000001;

        double result = IntStream
                .range(1, n)
                .mapToDouble(i -> pow(1.0 / i, 2))
                .reduce(0.0, (s, i) -> s + i);

        System.out.println(result);

        assertTrue(result < pow(PI, 2) / 6 - epsilon);
    }
}
