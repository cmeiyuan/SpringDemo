package com.cmy.springdemo.controller;

import com.cmy.springdemo.dataobject.User;
import com.cmy.springdemo.repository.LoginRepository;
import com.cmy.springdemo.repository.UserRepository;
import com.cmy.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final String SMS_CODE = "123456";

    // @Autowired
    // private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private LoginRepository loginRepository;

    @PostMapping("/add")
    public String add(@RequestParam("phone") String phone, @RequestParam("code") String code, @RequestParam("nickname") String nickName) {
        // 检查用户手机号是否为空
        if (phone == null || phone.length() == 0) {
            return "用户手机号不能为空";
        }

        // 检查短信验证码是否为空
        if (code == null || code.length() == 0) {
            return "验证码不能为空";
        }

        // 校验短信验证码
        if (!SMS_CODE.equals(code)) {
            return "验证码不正确";
        }

        //判断昵称是否为空
        if (nickName == null || nickName.length() == 0) {
            return "昵称不能为空";
        }

        User user = userService.queryUserByPhone(phone);

        if (user != null) {
            return "该用户已注册";
        }

        user = new User();
        user.setPhone(phone);
        user.setNickName(nickName);

        // userRepository.save(user);
        userService.save(user);

        return "注册成功：id:" + user.getId() + "phone:" + user.getPhone() + "nickName:" + user.getNickName();
    }

    @PostMapping("/login")
    public String login(@RequestParam("phone") String phone, @RequestParam("code") String code) {
        //
        if (phone == null || phone.length() == 0) {
            return "用户手机号不能为空";
        }

        // 查询用户
        User user = userService.queryUserByPhone(phone);

        if (user == null) {
            return "用户不存在";
        }

        if (code == null || code.length() == 0) {
            return "验证码不能为空";
        }

        if (!SMS_CODE.equals(code)) {
            return "验证码错误";
        }

        // 记录用户登入状态
        String token = loginRepository.recordLoginStatus(user);


        return "登录成功:" + token;
    }

    @PostMapping("/logout")
    public String logout(@RequestParam("token") String token) {
        // 通过token查询手机号
        String phone = loginRepository.queryPhoneByToken(token);
        if (phone == null || phone.length() == 0) {
            return "登出失败，该token无效";
        }
        User user = userService.queryUserByPhone(phone);
        if (user == null) {
            return "登出失败，该用户不存在";
        }
        // 清除用户状态
        loginRepository.clearLoginStatus(user);
        return "登出成功";
    }

    @PostMapping("/query")
    public String query(@RequestParam("token") String token) {
        String phone = loginRepository.queryPhoneByToken(token);
        if (phone == null || phone.length() == 0) {
            return "查询用户信息失败，该token无效";
        }
        User user = userService.queryUserByPhone(phone);
        if (user == null) {
            return "查询用户信息失败，该用户不存在";
        }
        return "nickName:" + user.getNickName() + "</br>phone:" + user.getPhone() + "</br>realName:" + user.getRealName() + "</br>cardId" + user.getCardId();
    }



    @PostMapping("/update")
    public String update(@RequestParam("token") String token, @RequestParam("nickname") String nickName, @RequestParam("realname") String realName, @RequestParam("cardid") String cardId) {
        String phone = loginRepository.queryPhoneByToken(token);
        if (phone == null || phone.length() == 0) {
            return "修改用户信息失败，该token无效";
        }
        User user = userService.queryUserByPhone(phone);
        if (user == null) {
            return "修改用户信息失败，该用户不存在";
        }
        user.setNickName(nickName);
        user.setRealName(realName);
        user.setCardId(cardId);
        userService.save(user);
        return "nickName:" + user.getNickName() + "</br>phone:" + user.getPhone() + "</br>realName:" + user.getRealName() + "</br>cardId" + user.getCardId();
    }

}
