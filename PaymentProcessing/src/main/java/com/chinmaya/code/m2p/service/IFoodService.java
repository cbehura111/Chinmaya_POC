package com.chinmaya.code.m2p.service;

import com.chinmaya.code.m2p.entity.Food;

import java.util.List;

public interface IFoodService {
    void addFood(Food foodRequest);

    List<Food> getAllFoods();

    Food getFood(long foodId);
}
