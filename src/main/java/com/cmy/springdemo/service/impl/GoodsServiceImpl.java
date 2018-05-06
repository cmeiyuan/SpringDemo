package com.cmy.springdemo.service.impl;

import com.cmy.springdemo.dataobject.Goods;
import com.cmy.springdemo.repository.GoodsRepository;
import com.cmy.springdemo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService{

    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public Goods save(Goods goods) {
        return goodsRepository.save(goods);
    }

    @Override
    public Page<Goods> findAll(Pageable pageable) {
        return goodsRepository.findAll(pageable);
    }

    @Override
    public void delete(Integer id) {
         goodsRepository.delete(id);
    }


}
