package com.app.service;

import com.app.entity.House;
import com.app.mapper.HouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HouseService {

    @Autowired
    HouseMapper houseMapper;

    public List<House> getHouseList(String areaId, String isarrear){
        return houseMapper.getHouseList(areaId, isarrear);
    }

    public List<House> getHouseById(String house_id){
        return houseMapper.getHouseById(house_id);
    }

    public boolean insertHouse(House house){
        return houseMapper.insertHouse(house);
    }

    public boolean updateHouse(House house){
        return houseMapper.updateHouse(house);
    }

    public boolean deleteHouse(House house){
        return houseMapper.deleteHouse(house);
    }

}