package com.cmy.springdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/driver")
public class DriverController {
    @GetMapping("/login")
     public String login(@RequestParam("dirname") String dirname, @RequestParam("password") String password){
        String driverName = "glz";
        String passWord = "alan";
        if (dirname.equals(driverName) && password.equals(passWord)){
            return "登入成功";
        }else{
            return "不存在";
        }

    }

}
