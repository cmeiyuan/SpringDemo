package com.cmy.springdemo.repository;

import com.cmy.springdemo.dataobject.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    Order queryOrderByUserId(Integer userId);
}
