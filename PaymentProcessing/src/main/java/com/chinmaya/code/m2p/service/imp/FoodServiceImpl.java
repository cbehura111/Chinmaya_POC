package com.chinmaya.code.m2p.service.imp;

import com.chinmaya.code.m2p.entity.Food;
import com.chinmaya.code.m2p.service.IFoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class FoodServiceImpl implements IFoodService {


    private final Map<Long, Food> foodsMap= new HashMap<>();
    @Override
    public void addFood(Food foodRequest) {
        foodsMap.put(foodRequest.getId(),foodRequest);
    }

    @Override
    public List<Food> getAllFoods() {
        List<Food> foodList = new ArrayList<>();
        foodsMap.entrySet().forEach(es->foodList.add(foodsMap.get(es.getKey())));
        return foodList;
    }

    @Override
    public Food getFood(long foodId) {
        return foodsMap.get(foodId);
    }
}
