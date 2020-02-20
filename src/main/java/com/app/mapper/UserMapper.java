package com.app.mapper;

import com.app.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User getUser(@Param("phone")String phone, @Param("password")String password);


    User getUserById(int id);
}
