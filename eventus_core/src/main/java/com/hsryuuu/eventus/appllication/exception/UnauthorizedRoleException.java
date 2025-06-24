package com.hsryuuu.eventus.appllication.exception;

public class UnauthorizedRoleException extends GlobalException {

    public UnauthorizedRoleException() {
        super(ErrorCode.UNAUTHORIZED_ROLE);
    }

    public UnauthorizedRoleException(ErrorCode errorCode) {
        super(errorCode);
    }

}
