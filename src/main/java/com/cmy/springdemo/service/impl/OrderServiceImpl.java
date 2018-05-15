package com.cmy.springdemo.service.impl;

import com.cmy.springdemo.dataobject.Order;
import com.cmy.springdemo.repository.OrderRepository;
import com.cmy.springdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    HashMap<Order,Integer> map = new HashMap<>();

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void delete(Integer orderId) {
         orderRepository.delete(orderId);
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public Order queryOrderByUserId(Integer userId) {
        Set<Order> set = map.keySet();
        for(Order key : set){
            Integer userId1 = map.get(key);
            if (userId1 == userId){
                return key;
            }
        }
        return null;
    }
}
