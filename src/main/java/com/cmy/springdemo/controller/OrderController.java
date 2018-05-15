package com.cmy.springdemo.controller;

import com.cmy.springdemo.dataobject.Order;
import com.cmy.springdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public Order add(@RequestParam("userId") Integer userId,
                     @RequestParam("goodsId") Integer goodsId,
                     @RequestParam("name") String name,
                     @RequestParam("phone") String phone,
                     @RequestParam("details") String details){
        Order order = new Order();
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
    public Order update(@RequestParam("id") Integer id,
                        @RequestParam("name") String name,
                        @RequestParam("phone") String phone,
                        @RequestParam("details") String details){
        Order order = new Order();
        order.setId(id);
        order.setName(name);
        order.setPhone(phone);
        order.setDetails(details);
        return orderService.save(order);
    }

    @PostMapping("/list")
    public List<Order> query(@RequestParam("userId") Integer userId,
                             @RequestParam("page") int page,
                             @RequestParam("size") int size){
       return (List<Order>) orderService.queryOrderByUserId(userId);
    }

}
