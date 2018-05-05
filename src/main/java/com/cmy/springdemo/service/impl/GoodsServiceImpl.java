package com.cmy.springdemo.service.impl;

import com.cmy.springdemo.dataobject.Goods;
import com.cmy.springdemo.repository.GoodsRepository;
import com.cmy.springdemo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService{

    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public Goods save(Goods goods) {
        return goodsRepository.save(goods);
    }
}
