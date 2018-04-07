package com.cmy.springdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public String login(@RequestParam("username") String a, @RequestParam("password") String b) {
        String useName = "glz";
        String passWord = "123456";
        if(a.equals(useName) && b.equals(passWord)){
            return "登录成功";
        }else {
            return "登录失败，用户名或密码不正确";
        }
    }

    @GetMapping("/logout")
    public String logout(@RequestParam("username") String username, @RequestParam("password") String password){
        return "登出成功";
    }

}
