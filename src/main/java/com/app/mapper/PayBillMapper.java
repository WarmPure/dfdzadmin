package com.app.mapper;

import com.app.entity.PayBill;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PayBillMapper {

    List<PayBill> getPayBillList(@Param("house_id") String house_id);

//    List<PayBill> getPayBillByHouseId(@Param("house_id") String house_id);

    boolean insertPayBill(@Param("paybill") PayBill payBill);

    boolean updatePayBill(@Param("paybill") PayBill payBill);

    boolean deletePayBill(@Param("paybill") PayBill payBill);
}
