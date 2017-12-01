package com.wowcher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static java.util.Arrays.asList;

@RunWith(Parameterized.class)
public class TimeParserErrorTest {

    private final String input;

    public TimeParserErrorTest(String input) {
        this.input = input;
    }

    @Parameterized.Parameters
    public static Collection<String> testData() {
        return asList("", null, "78:99", "-1:00", "60:10", "5:55", "05:60");
    }

    @Test(expected = ClockServiceException.class)
    public void testTimeParsing() {
        TimeParser.parse(input);
    }
}
