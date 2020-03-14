package com.app.controller;

import com.app.entity.Area;
import com.app.entity.House;
import com.app.entity.ResultBean;
import com.app.service.AreaService;
import com.app.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

//实现跨域注解
//origin="*"代表所有域名都可访问
//maxAge飞行前响应的缓存持续时间的最大年龄，简单来说就是Cookie的有效期 单位为秒
//若maxAge是负数,则代表为临时Cookie,不会被持久化,Cookie信息保存在浏览器内存中,浏览器关闭Cookie就消失
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/house")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "getHouseList")
    public ResultBean<List<House>> getHouseList(@RequestBody Map<String, Object> reqMap) {

        String areaId = reqMap.get("areaId").toString();
        String isarrear = reqMap.get("isarrear").toString();

        ResultBean<List<House>> resultBean = new ResultBean<>();

        List<House> houseList = houseService.getHouseList(areaId, isarrear);

        if (null != houseList && houseList.size() > 0) {

            for (int i = 0; i < houseList.size(); i++) {
                Area area = areaService.getAreaById(houseList.get(i).getArea_id());
                houseList.get(i).setArea(area);
            }

            resultBean.setStatus(200);
            resultBean.setMsg("success");
            resultBean.setData(houseList);
        } else {
            resultBean.setStatus(200);
            resultBean.setMsg("暂无房屋信息");
        }
        return resultBean;
    }

    @RequestMapping(value = "addHouse")
    public ResultBean<String> addHouse(@RequestBody House house) {

        ResultBean<String> resultBean = new ResultBean<>();

        String house_id = house.getHouse_id();

        List<House> houseList = houseService.getHouseById(house_id);

        if (null != houseList && houseList.size() > 0) {
            resultBean.setStatus(500);
            resultBean.setMsg("该房屋编号已存在");
        } else {
            boolean insertHouse = houseService.insertHouse(house);
            if (insertHouse) {
                resultBean.setStatus(200);
                resultBean.setMsg("添加房屋信息成功");
            } else {
                resultBean.setStatus(500);
                resultBean.setMsg("添加失败");
            }
        }
        return resultBean;
    }

    @RequestMapping(value = "updateHouse")
    public ResultBean<String> updateHouse(@RequestBody House house) {

        String house_id = house.getHouse_id();

        ResultBean<String> resultBean = new ResultBean<>();

        List<House> houseList = houseService.getHouseById(house_id);

        if (null != houseList && houseList.size() > 0) {
            boolean resultupdate = houseService.updateHouse(house);
            if (resultupdate) {
                resultBean.setStatus(200);
                resultBean.setMsg("房屋信息更新成功");
            } else {
                resultBean.setStatus(500);
                resultBean.setMsg("房屋信息更新失败");
            }
        } else {
            resultBean.setStatus(500);
            resultBean.setMsg("该房屋不存在");
        }
        return resultBean;
    }

    @RequestMapping(value = "deleteHouse")
    public ResultBean<String> deleteHouse(@RequestBody House house) {

        String house_id = house.getHouse_id();

        ResultBean<String> resultBean = new ResultBean<>();

        List<House> houseList = houseService.getHouseById(house_id);

        if (null != houseList && houseList.size() > 0) {

            boolean resultDelete = houseService.deleteHouse(house);
            if (resultDelete) {
                resultBean.setStatus(200);
                resultBean.setMsg("房屋删除成功");
            } else {
                resultBean.setStatus(500);
                resultBean.setMsg("删除失败");
            }
        } else {
            resultBean.setStatus(500);
            resultBean.setMsg("该房屋不存在");
        }
        return resultBean;
    }

}
