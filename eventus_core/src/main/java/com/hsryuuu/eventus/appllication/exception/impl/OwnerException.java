package com.hsryuuu.eventus.appllication.exception.impl;

import com.hsryuuu.eventus.appllication.exception.ErrorCode;
import com.hsryuuu.eventus.appllication.exception.GlobalException;

public class OwnerException extends GlobalException {

    public OwnerException() {
        super(ErrorCode.UNAUTHORIZED);
    }

    public OwnerException(ErrorCode errorCode) {
        super(errorCode);
    }

}
