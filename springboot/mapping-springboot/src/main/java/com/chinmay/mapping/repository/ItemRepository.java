package com.chinmay.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chinmay.mapping.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}
