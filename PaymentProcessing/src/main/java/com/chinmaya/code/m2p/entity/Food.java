package com.chinmaya.code.m2p.entity;

import lombok.Data;

@Data
public class Food {
    private long id;
    private String foodName;
    private String foodCatagory;
    private String foodPrice;
    private long availableUnit;
}
