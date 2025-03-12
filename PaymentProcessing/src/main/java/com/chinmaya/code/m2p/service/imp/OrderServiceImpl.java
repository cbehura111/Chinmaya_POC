package com.chinmaya.code.m2p.service.imp;

import com.chinmaya.code.m2p.entity.Food;
import com.chinmaya.code.m2p.entity.FoodOrder;
import com.chinmaya.code.m2p.service.IFoodService;
import com.chinmaya.code.m2p.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {
    private final Map<Long, FoodOrder> orderMap= new HashMap<>();

    private final IFoodService foodService;

    public OrderServiceImpl(IFoodService foodService) {
        this.foodService = foodService;
    }

    @Override
    public FoodOrder placeOrder(FoodOrder oderRequest) {
        orderMap.put(oderRequest.getOrderId(),oderRequest);

        oderRequest.getFoodId().forEach(id->{
            Food food = foodService.getFood(id);
            food.setAvailableUnit(food.getAvailableUnit()-1);
            foodService.addFood(food);
        });
        return oderRequest;
    }

    @Override
    public FoodOrder cancelOrder(long orderId) {
        LocalDateTime cancelTime = LocalDateTime.now().plusMinutes(5);
        if(orderMap.get(orderId).getOrderedAt().isBefore(cancelTime)){
            orderMap.get(orderId).setStatus("Cancelled");
        }
        return orderMap.get(orderId);
    }

    @Override
    public List<FoodOrder> getAllOrders() {
        List<FoodOrder> foodList = new ArrayList<>();
        orderMap.entrySet().forEach(es->foodList.add(orderMap.get(es.getKey())));
        return foodList;
    }

    @Override
    public FoodOrder getOrderDetails(long orderId) {
        return orderMap.get(orderId);
    }
}
