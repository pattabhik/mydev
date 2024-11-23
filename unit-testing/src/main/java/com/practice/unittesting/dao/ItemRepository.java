package com.practice.unittesting.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.unittesting.beans.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
