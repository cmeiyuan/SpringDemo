package com.cmy.springdemo.controller;

import com.cmy.springdemo.dataobject.Goods;
import com.cmy.springdemo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/add")
    public Goods add(@RequestParam("name") String name,
                     @RequestParam("title") String title,
                     @RequestParam("price") Float price,
                     @RequestParam("description") String description,
                     @RequestParam("images") String images) {
        Goods goods = new Goods();
        goods.setDescription(description);
        goods.setImages(images);
        goods.setName(name);
        goods.setPrice(price);
        goods.setTitle(title);
        return goodsService.save(goods);
    }
}
