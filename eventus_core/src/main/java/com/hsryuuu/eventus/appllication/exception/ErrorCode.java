package com.hsryuuu.eventus.appllication.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorCode {
    // # 공통
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "BAD_REQUEST 잘못된 요청입니다."),
    NOT_FOUND(HttpStatus.NOT_FOUND, "NOT_FOUND 존재하지 않는 데이터입니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR 서버측 알수 없는 에러입니다."),
    BAD_REQUEST_ENUM(HttpStatus.BAD_REQUEST, "잘못된 enum 값 요청입니다."),
    DATA_INVALID_EMPTY_VALUE(HttpStatus.BAD_REQUEST, "필수값이 빠져있습니다."),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "로그인이 필요한 기능입니다."),

    // 권한 관련
    FORBIDDEN(HttpStatus.UNAUTHORIZED, "권한이 없습니다."),
    FORBIDDEN_CREATE(HttpStatus.UNAUTHORIZED, "생성 권한이 없습니다."),
    // 유저 관련
    LOGIN_REQUIRED(HttpStatus.UNAUTHORIZED, "로그인이 필요한 기능입니다."),
    // 작업 관련
    TASK_PARENT_DOESNT_EXISTS(HttpStatus.BAD_REQUEST, "작업의 상위 작업이 존재하지않습니다."),

    // 시간 관련
    INVALID_TIME(HttpStatus.BAD_REQUEST, "시간(기간) 설정에 문제가 있습니다."),
    TIME_IS_NULL(HttpStatus.BAD_REQUEST, "시간이 누락되었습니다."),
    START_TIME_IS_NULL(HttpStatus.BAD_REQUEST, "시작 시간이 누락되었습니다."),
    END_TIME_IS_NULL(HttpStatus.BAD_REQUEST, "죵료 시간이 누락되었습니다."),
    INVALID_TIME_RANGE(HttpStatus.BAD_REQUEST, "시작시간은 종료시간보다 빠르게 설정해야 합니다."),
    // # Redis 관련
    REDIS_KEY_NOT_FOUND(HttpStatus.INTERNAL_SERVER_ERROR, "Redis Key Not Found.");


    private final HttpStatus status;
    private final String message;
}
