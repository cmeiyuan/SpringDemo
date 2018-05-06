package com.cmy.springdemo.service;

import com.cmy.springdemo.dataobject.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GoodsService {
    Goods save(Goods goods);

    Page<Goods> findAll(Pageable pageable);

    void delete(Integer id);
}
