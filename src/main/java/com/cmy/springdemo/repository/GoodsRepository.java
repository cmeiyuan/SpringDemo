package com.cmy.springdemo.repository;

import com.cmy.springdemo.dataobject.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods,Integer> {

}
