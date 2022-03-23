package com.chinmay.mapping.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Item {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int iId;
		private String itemName;
		private float price;
	}
