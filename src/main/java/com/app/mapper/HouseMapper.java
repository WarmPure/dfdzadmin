package com.app.mapper;

import com.app.entity.House;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseMapper {

    List<House> getHouseList(@Param("area_id") String area_id, @Param("isarrear") String isarrear);

    List<House> getHouseById(@Param("house_id") String house_id);

    boolean insertHouse(@Param("house") House house);

    boolean updateHouse(@Param("house") House house);

    boolean deleteHouse(@Param("house") House house);
}
