package com.example.demo.handler.dto;

public enum ErrorCodes {

    NULL_OBJECT_TO_SAVE(1),
    NULL_ARGUMENT(2),
    PASSWORD_IS_NULL(3),
    CANDIDATE_ALREADY_EXIST(4),
    PROPERTY_NOT_FOUND(5),
    MISSED_YEAR_OF_DIPLOME(6),

    ;

    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

