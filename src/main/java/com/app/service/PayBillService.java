package com.app.service;

import com.app.entity.PayBill;
import com.app.mapper.PayBillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PayBillService {

    @Autowired
    PayBillMapper payBillMapper;

    public List<PayBill> getPayBillList(String house_id){
        return payBillMapper.getPayBillList(house_id);
    }

//    public List<PayBill> getPayBillByHouseId(String house_id){
//        return payBillMapper.getPayBillByHouseId(house_id);
//    }

    public boolean insertPayBill(PayBill payBill){
        return payBillMapper.insertPayBill(payBill);
    }

    public boolean updatePayBill(PayBill payBill){
        return payBillMapper.updatePayBill(payBill);
    }

    public boolean deletePayBill(PayBill payBill){
        return payBillMapper.deletePayBill(payBill);
    }

}