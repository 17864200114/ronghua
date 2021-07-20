package com.zqk.ronghua.service;

import com.zqk.ronghua.mapper.UserExtMapper;
import com.zqk.ronghua.mapper.UserMapper;
import com.zqk.ronghua.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AdminService {
    @Autowired(required = false)
    UserExtMapper userExtMapper;
    @Autowired(required = false)
    UserMapper userMapper;

    public List<User> findAll() {
        List<User> users = userExtMapper.selectAll();
        return users;
    }

    public void deleteAll() {
        userExtMapper.deleteAll();
    }
}
