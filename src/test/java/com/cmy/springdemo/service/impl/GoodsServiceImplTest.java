package com.cmy.springdemo.service.impl;

import com.cmy.springdemo.dataobject.Goods;
import com.cmy.springdemo.service.GoodsService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsServiceImplTest {

    @Autowired
    private GoodsService goodsService;

    @Test
    public void save() {
    }

    @Test
    public void findAll() {
        Pageable pageable = new PageRequest(0, 5);
        Page<Goods> goodsPage = goodsService.findAll(pageable);

        System.out.println("getTotalElements(): "+goodsPage.getTotalElements());

        System.out.println("getTotalPages(): "+goodsPage.getTotalPages());

        Assert.assertEquals(2, goodsPage.getTotalPages());

    }
}