package com.chinmaya.code.m2p.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class FoodOrder {
    
    private long orderId;
    
    private List<Long> foodId;
    
    private String userId;
    private LocalDateTime orderedAt;
    private BigDecimal billAmount;
    private String status;
}
