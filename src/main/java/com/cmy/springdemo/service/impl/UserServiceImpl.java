package com.cmy.springdemo.service.impl;

import com.cmy.springdemo.dataobject.User;
import com.cmy.springdemo.repository.UserRepository1;
import com.cmy.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository1 userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User queryUserByPhone(String phone) {
        return userRepository.queryUserByPhone(phone);
    }
}
