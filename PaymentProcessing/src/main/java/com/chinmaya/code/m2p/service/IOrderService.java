package com.chinmaya.code.m2p.service;

import com.chinmaya.code.m2p.entity.FoodOrder;

import java.util.List;

public interface IOrderService {
    FoodOrder placeOrder(FoodOrder oderRequest);
    FoodOrder cancelOrder(long orderId);
    List<FoodOrder> getAllOrders();
    FoodOrder getOrderDetails(long orderId);
}
