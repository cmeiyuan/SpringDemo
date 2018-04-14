package com.cmy.springdemo.repository;

import com.cmy.springdemo.dataobject.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {

    private List<User> users = new ArrayList<>();

    // 新增用户
    public User save(User user) {
        user.setId(users.size() + 1);
        users.add(user);
        return user;
    }

    // 删除用户
    public User delete(User user) {
        return user;
    }

    // 修改用户
    public User update(User user) {
        int index = -1;
        for(int i = 0 ; i < users.size(); i++){
            User user1 = users.get(i);
            if (user.getId() == user1.getId()){
                index = i;
                break;
            }
        }
        users.set(index, user);
        return user;
    }

    public User query(String phone) {
        for(int i = 0 ; i < users.size(); i++){
             User user = users.get(i);
             if(user.getPhone().equals(phone)){
                 return user;
             }
        }
       return null;
    }

}
