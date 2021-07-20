package com.zqk.ronghua.mapper;
import java.util.List;
import com.zqk.ronghua.model.User;

public interface UserExtMapper {

    List<User> selectAll();

    void deleteAll();
}
