package com.app.controller;

import com.app.entity.Area;
import com.app.entity.Login;
import com.app.entity.ResultBean;
import com.app.entity.User;
import com.app.service.AreaService;
import com.app.service.LoginService;
import com.app.service.UserService;
import com.app.tool.TokenProccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

//实现跨域注解
//origin="*"代表所有域名都可访问
//maxAge飞行前响应的缓存持续时间的最大年龄，简单来说就是Cookie的有效期 单位为秒
//若maxAge是负数,则代表为临时Cookie,不会被持久化,Cookie信息保存在浏览器内存中,浏览器关闭Cookie就消失
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "getAreaList")
    public ResultBean<List<Area>> getAreaList(@RequestBody Map<String, Object> reqMap) {

//        String username = reqMap.get("username").toString();
//        String password = reqMap.get("password").toString();

        ResultBean<List<Area>> resultBean = new ResultBean<>();

        List<Area> areaList = areaService.getAreaList();

        if (null != areaList && areaList.size() > 0) {
            resultBean.setStatus(200);
            resultBean.setMsg("success");
            resultBean.setData(areaList);
        } else {
            resultBean.setStatus(200);
            resultBean.setMsg("暂无小区信息");
        }

        return resultBean;
    }

    @RequestMapping(value = "addArea")
    public ResultBean<String> addArea(@RequestBody Area area) {
        String area_name = area.getArea_name();
        ResultBean<String> resultBean = new ResultBean<>();
        List<Area> areaList = areaService.getAreaByName(area_name);
        if (null != areaList && areaList.size() > 0) {
            resultBean.setStatus(500);
            resultBean.setMsg("该小区已存在，请确认后添加");
        } else {
            boolean insertArea = areaService.insertArea(area);
            if (insertArea) {
                resultBean.setStatus(200);
                resultBean.setMsg("添加小区成功");
            } else {
                resultBean.setStatus(500);
                resultBean.setMsg("添加小区失败");
            }
        }
        return resultBean;
    }

    @RequestMapping(value = "updateArea")
    public ResultBean<String> updateArea(@RequestBody Area area) {

        String area_name = area.getArea_name();

        ResultBean<String> resultBean = new ResultBean<>();

        List<Area> areaList = areaService.getAreaByName(area_name);

        if (null != areaList && areaList.size() > 0) {

            boolean resultupdate = areaService.updateArea(area);
            if (resultupdate) {
                resultBean.setStatus(200);
                resultBean.setMsg("小区信息更新成功");
            } else {
                resultBean.setStatus(500);
                resultBean.setMsg("小区信息更新失败");
            }
        } else {
            resultBean.setStatus(500);
            resultBean.setMsg("该小区不存在");
        }
        return resultBean;
    }

    @RequestMapping(value = "deleteArea")
    public ResultBean<String> deleteArea(@RequestBody Area area) {

        String area_name = area.getArea_name();

        ResultBean<String> resultBean = new ResultBean<>();

        List<Area> areaList = areaService.getAreaByName(area_name);

        if (null != areaList && areaList.size() > 0) {

            boolean resultDelete = areaService.deleteArea(area);
            if (resultDelete) {
                resultBean.setStatus(200);
                resultBean.setMsg("删除成功");
            } else {
                resultBean.setStatus(500);
                resultBean.setMsg("删除失败");
            }
        } else {
            resultBean.setStatus(500);
            resultBean.setMsg("该小区不存在");
        }
        return resultBean;
    }

}
