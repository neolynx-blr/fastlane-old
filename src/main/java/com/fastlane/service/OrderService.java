package com.fastlane.service;

import com.fastlane.api.request.CartProduct;
import com.fastlane.api.response.OrderResponse;

import java.util.List;

/**
 * Created by nishantgupta on 4/5/15.
 */
public interface OrderService {

    public OrderResponse createOrder(List<CartProduct> products);

}
