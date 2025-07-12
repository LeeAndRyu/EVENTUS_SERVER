package com.hsryuuu.eventus.appllication.exception.impl;

import com.hsryuuu.eventus.appllication.exception.ErrorCode;
import com.hsryuuu.eventus.appllication.exception.GlobalException;

public class SecurityException extends GlobalException {

    public SecurityException() {
        super(ErrorCode.FORBIDDEN);
    }

    public SecurityException(ErrorCode errorCode) {
        super(errorCode);
    }

}
