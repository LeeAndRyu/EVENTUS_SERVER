package com.hsryuuu.eventus.appllication.exception.impl;

import com.hsryuuu.eventus.appllication.exception.ErrorCode;
import com.hsryuuu.eventus.appllication.exception.GlobalException;

public class TaskException extends GlobalException {

    public TaskException() {
        super(ErrorCode.UNAUTHORIZED);
    }

    public TaskException(ErrorCode errorCode) {
        super(errorCode);
    }

}
