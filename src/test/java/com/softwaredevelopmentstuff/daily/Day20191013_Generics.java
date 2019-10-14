package com.softwaredevelopmentstuff.daily;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Type erasure: there are no generics in the virtual machine but only ordinary classes and methods. All the type
 * parameters are replaced by their bounds - casts are inserted when necessary to preserve type safety.
 * <p>
 * Generic class. This is a class that have one type parameter.
 */
class Pair<T> {
    private T first;
    private T second;

    Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}

class ArrayUtils {
    public static Pair<String> minMax(String[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        String min = array[0];
        String max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (min.compareTo(array[i]) > 0) min = array[i];
            if (max.compareTo(array[i]) < 0) max = array[i];
        }

        return new Pair<>(min, max);
    }

    /**
     * Generic static method
     */
    public static <T> T getMiddle(T[] array) {
        return array[array.length / 2];
    }

    /**
     * Generic static method
     * Bounded type, this is a lower bound. T should be a subtype of Comparable
     */
    public static <T extends Comparable<T>> T min(T[] array) {
        T min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (min.compareTo(array[i]) > 0) {
                min = array[i];
            }
        }

        return min;
    }

    public static <T extends Comparable<T>> Pair<T> betterMinMax(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        T min = array[0];
        T max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(min) < 0) min = array[i];
            if (array[i].compareTo(max) > 0) max = array[i];
        }

        return new Pair<>(min, max);
    }
}

class Day20191013_Generics {
    @Test
    void testPairMinMax() {
        String[] array = {"abc", "xyz", "def", "fghij", "klmn"};
        Pair<String> minmax = ArrayUtils.minMax(array);
        assertEquals("abc", minmax.getFirst());
        assertEquals("xyz", minmax.getSecond());
    }

    @Test
    void testGetMiddle() {
        String[] array = {"abc", "xyz", "def", "fghij", "klmn"};
        String middle = ArrayUtils.getMiddle(array);
        assertEquals("def", middle);
    }

    @Test
    void testBetterPairMinMax() {
        Pair<String> minmax = ArrayUtils.betterMinMax(new String[]{"abc", "xyz", "def", "fghij", "klmn"});
        assertEquals("abc", minmax.getFirst());
        assertEquals("xyz", minmax.getSecond());

        Pair<Integer> minmax2 = ArrayUtils.betterMinMax(new Integer[]{1, 4, 3, 7, 6, 4, 2, 0, 9});
        assertEquals(0, minmax2.getFirst().intValue());
        assertEquals(9, minmax2.getSecond().intValue());
    }
}
