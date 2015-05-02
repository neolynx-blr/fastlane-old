package com.fastlane.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "code")
public class Error {
    private final String code;
    private String locale;
    private String message;
    private String field;

    public Error(final String code, final String field) {
        this.code = code;
        this.field = field;
    }
}