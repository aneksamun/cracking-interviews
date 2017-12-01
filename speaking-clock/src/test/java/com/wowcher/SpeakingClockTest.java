package com.wowcher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.time.LocalTime;
import java.util.Collection;

import static java.time.LocalTime.MIDNIGHT;
import static java.time.LocalTime.NOON;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SpeakingClockTest {

    private final LocalTime input;
    private final String expectedOutput;

    public SpeakingClockTest(LocalTime input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameters
    public static Collection<Object[]> testData() {
        return asList(new Object[][] {
                { NOON, "It's Midday" },
                { MIDNIGHT , "It's Midnight" },
                { LocalTime.of(8, 34), "It's eight thirty four" },
                { LocalTime.of(12, 15), "It's twelve fifteen" },
                { LocalTime.of(22, 57), "It's twenty two fifty seven" },
                { LocalTime.of(8, 30), "It's eight thirty" },
                { LocalTime.of(2, 10), "It's two ten" },
                { LocalTime.of(11, 0), "It's eleven" },
                { LocalTime.of(11, 11), "It's eleven eleven" }
        });
    }

    @Test
    public void testSpeak() {
        assertEquals(expectedOutput, SpeakingClock.speak(input));
    }
}
