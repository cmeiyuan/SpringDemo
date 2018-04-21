package com.cmy.springdemo.service;

import com.cmy.springdemo.dataobject.User;

public interface UserService {

    // 新增一个用户
    User save(User user);

    User queryUserByPhone(String phone);

}
