package com.chinmaya.code.m2p.resource;

import com.chinmaya.code.m2p.entity.Food;
import com.chinmaya.code.m2p.service.IFoodService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@OpenAPIDefinition
@RequestMapping("/api/food/v1.0.0/")
public class FoodMaintenanceController {
    private final IFoodService foodService;

    public FoodMaintenanceController(IFoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("")
    public ResponseEntity<Food> addNewFood(@RequestBody Food foodRequest){
        foodService.addFood(foodRequest);
        return new ResponseEntity(foodRequest, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Food>> getAllFoods(){
        return new ResponseEntity(foodService.getAllFoods(), HttpStatus.OK);
    }


    @GetMapping("/{foodId}")
    public ResponseEntity<Food> getFood(@PathVariable long foodId){
        return new ResponseEntity(foodService.getFood(foodId), HttpStatus.OK);
    }
}
