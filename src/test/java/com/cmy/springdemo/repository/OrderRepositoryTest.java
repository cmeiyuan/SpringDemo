package com.cmy.springdemo.repository;

import com.cmy.springdemo.dataobject.GoodsOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(OrderRepositoryTest.class);

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void queryGoodsOrderByUserId() {



        Pageable pageable = new PageRequest(0, 3);


        logger.info("开始从数据库查询数据");

        Page<GoodsOrder> goodsOrders = orderRepository.findAllByUserId(1, pageable);

        logger.info("查询到数据:" + goodsOrders.getContent());

        assertNotNull(goodsOrders);

        System.out.println(goodsOrders.getContent().size());

    }

}