package com.fastlane.api.response;

import lombok.Data;
import lombok.experimental.Builder;

import java.util.Set;

@Data
@Builder(fluent = false)
public class ResponseData<D> {
    private Set<Error> errors;
    private D data;
    private String successMsg;
}
