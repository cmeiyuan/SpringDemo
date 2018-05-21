package com.cmy.springdemo.service;

import com.cmy.springdemo.dataobject.GoodsOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {

   GoodsOrder save(GoodsOrder order);

   void delete(Integer id);

   Page<GoodsOrder> findAll(Pageable pageable);

   Page<GoodsOrder> findAllByUserId(Integer userId, Pageable pageable);

}
