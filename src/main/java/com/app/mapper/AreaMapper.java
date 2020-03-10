package com.app.mapper;

import com.app.entity.Area;
import com.app.entity.Login;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AreaMapper {

    Area getArea(@Param("id") int id);

    List<Area> getAreaByName(@Param("name") String name);

    Area getAreaById(@Param("id") int id);

    List<Area> getAreaList();

    boolean insertArea(@Param("area") Area area);

    boolean updateArea(@Param("area") Area area);

    boolean deleteArea(@Param("area") Area area);
}
