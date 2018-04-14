package com.cmy.springdemo.repository;

import com.cmy.springdemo.dataobject.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;

@Component
public class LoginRepository {
    //List<User> list = new ArrayList<>();
    HashMap<String, String> map = new HashMap<>();

    public String recordLoginStatus(User user) {
        String token = String.valueOf(System.currentTimeMillis());
        map.put(user.getPhone(), token);
        return token;
    }

    public boolean clearLoginStatus(User user) {
        map.remove(user.getPhone());
        return true;
    }

    public String queryPhoneByToken(String token) {
        // 集合->点名册
        Set<String> set = map.keySet();
        for (String key : set) {
            String token1 = map.get(key);
            if (token.equals(token1)) {
                return key;
            }
        }
        return null;
    }
}
