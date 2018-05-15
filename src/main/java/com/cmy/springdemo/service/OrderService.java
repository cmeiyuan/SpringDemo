package com.cmy.springdemo.service;

import com.cmy.springdemo.dataobject.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {

   Order save(Order order);

   void delete(Integer id);

   Page<Order> findAll(Pageable pageable);

   Order queryOrderByUserId(Integer userId);

}
