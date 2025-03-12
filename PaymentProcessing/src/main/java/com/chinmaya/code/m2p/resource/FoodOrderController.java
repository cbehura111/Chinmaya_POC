package com.chinmaya.code.m2p.resource;

import com.chinmaya.code.m2p.entity.Food;
import com.chinmaya.code.m2p.entity.FoodOrder;
import com.chinmaya.code.m2p.service.IOrderService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@Slf4j
@OpenAPIDefinition
@RequestMapping("/api/order/v1.0.0/")
public class FoodOrderController {
    private final IOrderService orderService;

    public FoodOrderController(IOrderService orderService) {
        this.orderService = orderService;
    }
    
    @PostMapping("order")
    public ResponseEntity<FoodOrder> placeOrder(@RequestBody FoodOrder oderRequest){
        Callable task= ()->orderService.placeOrder(oderRequest);

        return new ResponseEntity(orderService.placeOrder(oderRequest), HttpStatus.OK);
    }
    @PostMapping("cancel/{orderId}")
    public ResponseEntity<FoodOrder> cancelOrder(@PathVariable long orderId){
        return new ResponseEntity(orderService.cancelOrder(orderId), HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<List<Food>> getAllOrders(){
        return new ResponseEntity(orderService.getAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Food> getFood(@PathVariable long orderId){
        return new ResponseEntity(orderService.getOrderDetails(orderId), HttpStatus.OK);
    }
}
