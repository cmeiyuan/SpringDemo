package com.cmy.springdemo.controller;

import com.cmy.springdemo.dataobject.Goods;
import com.cmy.springdemo.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/demo")
public class DemoController {

    private final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/test1")
    public ModelAndView test1(Map<String, Object> map){
        map.put("name", "iphone");
        map.put("price", "12000");
        map.put("description", "手机便宜了");
        return new ModelAndView("test1",  map);
    }

    @GetMapping("/goods/list")
    public ModelAndView query(@RequestParam(value = "page", defaultValue = "0") int page,
                             @RequestParam(value = "size", defaultValue = "10") int size, Map<String, Object> map){


        logger.info("page:" + page);
        logger.info("size:" + size);

        Pageable pageable = new PageRequest(page, size);
        Page<Goods> goodsPage = goodsService.findAll(pageable);

        logger.info("查询数据成功，总共有" + goodsPage.getContent().size() +"条数据");

        System.out.println("查询数据成功，总共有" + goodsPage.getContent().size() +"条数据");

        map.put("goodsPage", goodsPage);

        return new ModelAndView("goods", map);
    }

}
