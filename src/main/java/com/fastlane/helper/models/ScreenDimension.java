package com.fastlane.helper.models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by nishantgupta on 4/5/15.
 */
@Data
@AllArgsConstructor
public class ScreenDimension {
    public static ScreenDimension _DEFAULT = new ScreenDimension(-1, -1);
    private int length;
    private int width;
}
