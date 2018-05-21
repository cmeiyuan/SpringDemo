package com.cmy.springdemo.repository;

import com.cmy.springdemo.dataobject.GoodsOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<GoodsOrder,Integer> {

    Page<GoodsOrder> findAllByUserId(Integer userId, Pageable pageable);

}
