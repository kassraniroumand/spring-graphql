package com.stockTracker.exception;

import org.springframework.graphql.execution.ErrorType;

import java.util.Map;
import java.util.Objects;

public class ApplicationException extends  RuntimeException{

    private final ErrorType errorType;
    private final String message;
    private final Map<String, Objects> extenstions;

    public ApplicationException(ErrorType errorType, String message, Map<String, Objects> extenstions) {
        super(message);
        this.errorType = errorType;
        this.message = message;
        this.extenstions = extenstions;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Map<String, Objects> getExtenstions() {
        return extenstions;
    }
}
