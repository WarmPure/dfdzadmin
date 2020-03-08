package com.app.service;

import com.app.entity.Area;
import com.app.entity.Login;
import com.app.mapper.AreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AreaService {

    @Autowired
    AreaMapper areaMapper;

    public Area getArea(int id){
        return areaMapper.getArea(id);
    }

    public List<Area> getAreaByName(String name){
        return areaMapper.getAreaByName(name);
    }

    public List<Area> getAreaList(){
        return areaMapper.getAreaList();
    }

    public boolean insertArea(Area area){
        return areaMapper.insertArea(area);
    }

    public boolean updateArea(Area area){
        return areaMapper.updateArea(area);
    }

    public boolean deleteArea(Area area){
        return areaMapper.deleteArea(area);
    }

}
