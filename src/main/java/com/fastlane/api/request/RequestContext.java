package com.fastlane.api.request;

import com.fastlane.helper.UserIdentificationType;
import lombok.Data;

@Data
public class RequestContext {
    /* This captures the user/account making the request, may have phone or email-id */
    private String identificationToken;
    private UserIdentificationType identificationType;
}
