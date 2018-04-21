package com.cmy.springdemo.repository;

import com.cmy.springdemo.dataobject.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository1 extends JpaRepository<User, String> {

    User queryUserByPhone(String phone);

}
