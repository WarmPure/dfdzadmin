package com.app.controller;

import com.app.entity.PayBill;
import com.app.entity.ResultBean;
import com.app.service.PayBillService;
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
@RequestMapping("/paybill")
public class PayBillController {

    @Autowired
    private PayBillService payBillService;

    @RequestMapping(value = "getPayBillList")
    public ResultBean<List<PayBill>> getPayBillList(@RequestBody Map<String, Object> reqMap) {
        String house_id = reqMap.get("house_id").toString();
        ResultBean<List<PayBill>> resultBean = new ResultBean<>();
        List<PayBill> payBillList = payBillService.getPayBillList(house_id);
        if (null != payBillList && payBillList.size() > 0) {
            resultBean.setStatus(200);
            resultBean.setMsg("success");
            resultBean.setData(payBillList);
        } else {
            resultBean.setStatus(200);
            resultBean.setMsg("暂无账单信息");
        }
        return resultBean;
    }

    @RequestMapping(value = "addPayBill")
    public ResultBean<String> addPayBill(@RequestBody PayBill payBill) {
        ResultBean<String> resultBean = new ResultBean<>();
        boolean insertPayBill = payBillService.insertPayBill(payBill);
        if (insertPayBill) {
            resultBean.setStatus(200);
            resultBean.setMsg("success");
            resultBean.setData("添加账单成功");
        } else {
            resultBean.setStatus(200);
            resultBean.setMsg("添加失败");
        }
        return resultBean;
    }

    @RequestMapping(value = "updatePayBill")
    public ResultBean<String> updatePayBill(@RequestBody PayBill payBill) {
        ResultBean<String> resultBean = new ResultBean<>();
        boolean resultupdate = payBillService.updatePayBill(payBill);
        if (resultupdate) {
            resultBean.setStatus(200);
            resultBean.setMsg("success");
            resultBean.setData("账单更新成功");
        } else {
            resultBean.setStatus(200);
            resultBean.setMsg("账单更新失败");
        }
        return resultBean;
    }

    @RequestMapping(value = "deletePayBill")
    public ResultBean<String> deletePayBill(@RequestBody PayBill payBill) {
        ResultBean<String> resultBean = new ResultBean<>();
        boolean resultDelete = payBillService.deletePayBill(payBill);
        if (resultDelete) {
            resultBean.setStatus(200);
            resultBean.setMsg("success");
            resultBean.setData("账单删除成功");
        } else {
            resultBean.setStatus(200);
            resultBean.setMsg("账单删除失败");
        }
        return resultBean;
    }

}
