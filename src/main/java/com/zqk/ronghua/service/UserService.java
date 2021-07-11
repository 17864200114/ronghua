package com.zqk.ronghua.service;

import com.zqk.ronghua.mapper.UserMapper;
import com.zqk.ronghua.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {
    @Autowired(required = false)
    UserMapper userMapper;
    public void create(String name,String phonenumber,String email,String text){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPhonenumber(phonenumber);
        user.setText(text);
        user.setGmtCreate(System.currentTimeMillis());
        userMapper.insert(user);
    }
}
