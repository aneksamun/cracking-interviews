package com.wowcher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.LocalTime;
import java.util.Collection;

import static java.time.LocalTime.MIDNIGHT;
import static java.time.LocalTime.NOON;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TimeParserTest {

    private final String input;
    private final LocalTime expectedTime;

    public TimeParserTest(String input, LocalTime expectedTime) {
        this.input = input;
        this.expectedTime = expectedTime;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return asList(new Object[][] {
                { "08:34", LocalTime.of(8, 34) },
                { "00:00", MIDNIGHT },
                { "12:00", NOON }
        });
    }

    @Test
    public void testTimeParsing() {
        assertEquals(expectedTime, TimeParser.parse(input));
    }
}