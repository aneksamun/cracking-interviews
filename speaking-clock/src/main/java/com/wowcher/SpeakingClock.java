package com.wowcher;

import io.vavr.collection.HashMap;
import io.vavr.collection.Map;
import io.vavr.control.Option;

import java.time.LocalTime;

import static com.wowcher.Error.UNRECOGNIZED_NUMBER;
import static io.vavr.API.*;
import static io.vavr.Predicates.is;
import static java.time.LocalTime.MIDNIGHT;
import static java.time.LocalTime.NOON;

public class SpeakingClock {

    private static final Map<Integer, String> FIRST_NINETEEN_DIGIT_NAMES = HashMap.<Integer, String>empty()
            .put(0, "")
            .put(1, "one")
            .put(2, "two")
            .put(3, "three")
            .put(4, "four")
            .put(5, "five")
            .put(6, "six")
            .put(7, "seven")
            .put(8, "eight")
            .put(9, "nine")
            .put(10, "ten")
            .put(11, "eleven")
            .put(12, "twelve")
            .put(13, "thirteen")
            .put(14, "fourteen")
            .put(15, "fifteen")
            .put(16, "sixteen")
            .put(17, "seventeen")
            .put(18, "eighteen")
            .put(19, "nineteen");

    private static final Map<Integer, String> TENS_DIGIT_NAMES = HashMap.of(
            2, "twenty",
            3, "thirty",
            4, "forty",
            5, "fifty"
    );

    public static String speak(LocalTime localTime) {
        return "It's " + Match(localTime).of(
                Case($(is(MIDNIGHT)), "Midnight"),
                Case($(is(NOON)), "Midday"),
                Case($(), asTimeString(nameOf(localTime.getHour()), nameOf(localTime.getMinute())))
        );
    }

    private static String nameOf(int number) {
        Option<String> option = FIRST_NINETEEN_DIGIT_NAMES.get(number);
        return option.getOrElse(() -> divideTens(number));
    }

    private static String divideTens(int number) {
        return asTimeString(matchTens(number), matchOnes(number));
    }

    private static String matchTens(int number) {
        int tens = number / 10;
        Option<String> option = TENS_DIGIT_NAMES.get(tens);
        return option.getOrElseThrow(() -> new ClockServiceException(UNRECOGNIZED_NUMBER, number));
    }

    private static String matchOnes(int number) {
        int ones = number % 10;
        Option<String> option = FIRST_NINETEEN_DIGIT_NAMES.get(ones);
        return option.getOrElseThrow(() -> new ClockServiceException(UNRECOGNIZED_NUMBER, number));
    }

    private static String asTimeString(String major, String minor) {
        return minor.isEmpty() ? major : major + " " + minor;
    }
}
