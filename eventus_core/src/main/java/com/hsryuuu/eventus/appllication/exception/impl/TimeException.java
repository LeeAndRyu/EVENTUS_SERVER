package com.hsryuuu.eventus.appllication.exception.impl;

import com.hsryuuu.eventus.appllication.exception.ErrorCode;
import com.hsryuuu.eventus.appllication.exception.GlobalException;

public class TimeException extends GlobalException {

    public TimeException() {
        super(ErrorCode.INVALID_TIME);
    }

    public TimeException(ErrorCode errorCode) {
        super(errorCode);
    }

}
