package com.codeself.lab.common.result;

import lombok.Getter;

/**
 * Result code enumeration.
 */
@Getter
public enum ResultCode {

    SUCCESS(200, "success"),
    FAIL(500, "internal server error"),
    BAD_REQUEST(400, "bad request"),
    UNAUTHORIZED(401, "unauthorized"),
    FORBIDDEN(403, "forbidden"),
    NOT_FOUND(404, "not found");

    private final int code;
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
