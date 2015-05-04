package com.fastlane.api.response;

import com.fastlane.helper.models.TaxType;

import java.util.Map;

/**
 * Created by nishantgupta on 4/5/15.
 */
public class OrderResponse {
    private long orderId;
    private double billAmount;
    private Map<TaxType, Double> texes;
    private double totalBillAmount;
}
