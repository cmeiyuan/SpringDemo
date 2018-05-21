package com.cmy.springdemo.service.impl;

import com.cmy.springdemo.dataobject.GoodsOrder;
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

    HashMap<GoodsOrder,Integer> map = new HashMap<>();

    @Override
    public GoodsOrder save(GoodsOrder order) {
        return orderRepository.save(order);
    }

    @Override
    public void delete(Integer orderId) {
         orderRepository.delete(orderId);
    }

    @Override
    public Page<GoodsOrder> findAllByUserId(Integer userId, Pageable pageable) {
        Set<GoodsOrder> set = map.keySet();
        for (GoodsOrder key : set) {
            Integer userId1 = map.get(key);
            if (userId1 == userId) {
                return (Page<GoodsOrder>) key;
            }
        }
        return null;
    }

    @Override
    public Page<GoodsOrder> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

}

