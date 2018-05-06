package com.cmy.springdemo.controller;

import com.cmy.springdemo.dataobject.Goods;
import com.cmy.springdemo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/list")
    public List<Goods> query(@RequestParam("page") int page, @RequestParam("size") int size){
        Pageable pageable = new PageRequest(page, size);
        Page<Goods> goodsPage = goodsService.findAll(pageable);
        return goodsPage.getContent();
    }

    @PostMapping("/update")
    public Goods update(@RequestParam("id") Integer id,
                        @RequestParam("name") String name,
                        @RequestParam("title") String title,
                        @RequestParam("price") Float price,
                        @RequestParam("description") String description,
                        @RequestParam("images") String images){
        Goods goods = new Goods();
        goods.setId(id);
        goods.setName(name);
        goods.setTitle(title);
        goods.setPrice(price);
        goods.setImages(images);
        goods.setDescription(description);
        return goodsService.save(goods);
    }

    @PostMapping("/delete")
    public void delete(@RequestParam("id") Integer id){
        goodsService.delete(id);
    }
}
