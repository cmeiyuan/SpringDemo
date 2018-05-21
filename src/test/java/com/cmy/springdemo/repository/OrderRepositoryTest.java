package com.cmy.springdemo.repository;

import com.cmy.springdemo.dataobject.GoodsOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void queryGoodsOrderByUserId() {

        Pageable pageable = new PageRequest(0, 3);

        Page<GoodsOrder> goodsOrders = orderRepository.findAllByUserId(1, pageable);

        assertNotNull(goodsOrders);

        System.out.println(goodsOrders.getContent().size());

    }
}