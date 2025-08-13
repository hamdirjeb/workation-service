package com.example.demo.handler.exception;

import com.example.demo.handler.dto.ErrorCodes;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class BusinessException extends RuntimeException {

    @Getter
    private ErrorCodes errorCode;

    @Getter
    private Integer httpCode;

    @Getter
    private List<String> errors;

    @Getter
    private String customMessage;

    public BusinessException(String customMessage, Throwable cause, ErrorCodes errorCode) {
        super(customMessage, cause);
        this.customMessage = customMessage;
        this.errorCode = errorCode;
    }

    public BusinessException(String customMessage, ErrorCodes errorCode, Integer httpCode) {
        super(customMessage);
        this.customMessage = customMessage;
        this.errorCode = errorCode;
        this.httpCode = httpCode;
    }

    @Builder(toBuilder = true)
    public BusinessException(
            @Builder.ObtainVia(method = "getMessage") String customMessage,
            ErrorCodes errorCode,
            Integer httpCode,
            List<String> errors
    ) {
        super(customMessage);
        this.customMessage = customMessage;
        this.errorCode = errorCode;
        this.httpCode = httpCode;
        this.errors = errors;
    }

}
