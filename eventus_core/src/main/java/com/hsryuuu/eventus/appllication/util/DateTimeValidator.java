package com.hsryuuu.eventus.appllication.util;

import com.hsryuuu.eventus.appllication.exception.ErrorCode;
import com.hsryuuu.eventus.appllication.exception.impl.TimeException;

import java.time.LocalDateTime;

public class DateTimeValidator {

    public static void validateTimeRange(LocalDateTime start, LocalDateTime end) {
        validateTimeNull(start, end);
        if (start.isAfter(end)) {
            throw new TimeException(ErrorCode.INVALID_TIME_RANGE);
        }
    }

    private static void validateTimeNull(LocalDateTime time) {
        if (time == null) {
            throw new TimeException(ErrorCode.TIME_IS_NULL);
        }
    }

    private static void validateTimeNull(LocalDateTime start, LocalDateTime end) {
        if (start == null) {
            throw new TimeException(ErrorCode.START_TIME_IS_NULL);
        }
        if (end == null) {
            throw new TimeException(ErrorCode.END_TIME_IS_NULL);
        }
    }


}
