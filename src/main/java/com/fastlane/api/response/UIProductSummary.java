package com.fastlane.api.response;

import lombok.Data;
import lombok.experimental.Builder;

import java.util.List;

/**
 * Created by nishantgupta on 4/5/15.
 */
@Data
@Builder(fluent = false)
public class UIProductSummary {
    private long bardCodeId;
    private long productId;
    private String name;
    private String imageUrl;
    private String desc;
    private List<String> categories;
    private List<String> tags;
}
