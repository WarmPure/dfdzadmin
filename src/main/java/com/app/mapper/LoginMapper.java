package com.app.mapper;

import com.app.entity.Login;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginMapper {


    boolean insertLogin(@Param("login") Login login);

    String selectId(String token);

}
