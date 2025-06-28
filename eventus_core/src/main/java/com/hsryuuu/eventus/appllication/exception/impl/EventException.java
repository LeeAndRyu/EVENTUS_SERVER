package com.hsryuuu.eventus.appllication.exception.impl;

import com.hsryuuu.eventus.appllication.exception.ErrorCode;
import com.hsryuuu.eventus.appllication.exception.GlobalException;

public class EventException extends GlobalException {

    public EventException() {
        super(ErrorCode.UNAUTHORIZED);
    }

    public EventException(ErrorCode errorCode) {
        super(errorCode);
    }

}
