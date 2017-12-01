package com.wowcher;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import static com.wowcher.Error.ILLEGAL_TIME_FORMAT;

public class TimeParser {

    private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    public static LocalTime parse(String time) {
        try {
            return LocalTime.parse(time, timeFormatter);
        } catch (Exception e) {
            throw new ClockServiceException(ILLEGAL_TIME_FORMAT, e);
        }
    }
}
