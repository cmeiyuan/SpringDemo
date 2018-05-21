package com.cmy.springdemo.controller;

import com.cmy.springdemo.dataobject.GoodsOrder;
import com.cmy.springdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public GoodsOrder add(@RequestParam("userId") Integer userId,
                          @RequestParam("goodsId") Integer goodsId,
                          @RequestParam("name") String name,
                          @RequestParam("phone") String phone,
                          @RequestParam("details") String details){
        GoodsOrder order = new GoodsOrder();
        order.setUserId(userId);
        order.setGoodsId(goodsId);
        order.setName(name);
        order.setPhone(phone);
        order.setDetails(details);
        return orderService.save(order);
    }


    @PostMapping("/delete")
    public void delete(@RequestParam("id") Integer id){
         orderService.delete(id);
    }

    @PostMapping("/update")
    public GoodsOrder update(@RequestParam("id") Integer id,
                             @RequestParam("userId") Integer userId,
                             @RequestParam("goodsId") Integer goodsId,
                             @RequestParam("name") String name,
                             @RequestParam("phone") String phone,
                             @RequestParam("details") String details){
        GoodsOrder order = new GoodsOrder();
        order.setId(id);
        order.setUserId(userId);
        order.setGoodsId(goodsId);
        order.setName(name);
        order.setPhone(phone);
        order.setDetails(details);
        return orderService.save(order);
    }

    @PostMapping("/list")
    public List<GoodsOrder> query(@RequestParam("userId") Integer userId,
                                  @RequestParam("page") Integer page,
                                  @RequestParam("size") Integer size){
       Pageable pageable = new PageRequest(page,size);
       Page<GoodsOrder> goodsOrdersPage = orderService.findAllByUserId(userId,pageable);
       return goodsOrdersPage.getContent();
       }
    }


