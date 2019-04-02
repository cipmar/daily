package com.softwaredevelopmentstuff.daily;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.*;

import static java.lang.System.out;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Apache StringUtils tests")
class Day20190320_StringUtils {

    private static final int MAX_LINE_SIZE = 80;
    private static final String PAD_STR = ".";

    @Test
    void testAbbreviate() {
        printStatusLine("abbreviate");

        String[] someTextLines = {
                "Together we can change the world, just one random act of kindness at a time",
                "It's not the color of our skin that divides our nation; it's the condition of our hearts",
                "It always seems impossible until it's done.",
                "Smile, it is the key that fits the lock of everybody's heart.",
                "Because of your smile, you make life more beautiful."
        };

        for (String text : asList(someTextLines)) {
            String abbreviatedText = StringUtils.abbreviate(text, 50);
            out.println(abbreviatedText);
            assertTrue(abbreviatedText.length() <= 50);
        }
    }

    @Test
    void testCenter() {
        printStatusLine("center");

        String[] someTextLines = {
                "123",
                "abcd",
                "ala bala",
                "this is longer",
                "Z"
        };

        for (String text : asList(someTextLines)) {
            String centeredText = StringUtils.center(text, 20, "_");
            out.println(centeredText);
            assertEquals(20, centeredText.length());
        }
    }

    @Test
    void testAppendIfMissing() {
        printStatusLine("appendIfMissing");

        String[] someTextLines = {
                "http://www.google.ro",
                "http://www.google.ro/",
                "/opt/folder1/folder2"
        };

        for (String text : asList(someTextLines)) {
            String newText = StringUtils.appendIfMissing(text, "/");
            out.println(newText);
            assertTrue(newText.endsWith("/"));
        }
    }

    private static void printStatusLine(String line) {
        out.println(StringUtils.center(line, MAX_LINE_SIZE, PAD_STR));
    }

    @BeforeAll
    static void beforeAll() {
        printStatusLine("START");
    }

    @AfterAll
    static void afterAll() {
        out.println();
        printStatusLine("END");
    }

    @BeforeEach
    void initBeforeEach() {
        out.println();
    }
}
