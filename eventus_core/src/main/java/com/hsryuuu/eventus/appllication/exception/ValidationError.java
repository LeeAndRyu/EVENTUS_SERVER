package com.hsryuuu.eventus.appllication.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ValidationError {
    private final String field;
    private final String message;
}
