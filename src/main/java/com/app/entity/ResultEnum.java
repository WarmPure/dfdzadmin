package com.app.entity;

public enum ResultEnum {

    success(200,"操作成功！"),
    error(500,"服务器异常！"),
//    server_error("-500","服务异常"),
//    unlogin("-4","未登录"),
//    denine("403","没有权限"),
//    misPassword("-5","用户名密码不正确"),
//    unknown("-1","用户不存在"),
//    data_existent("-504","数据不存在"),
//    result_empty("-000","查询内容为空"),
//    deleteError("-001","删除数据不存在"),
//    param_isnull("-400","参数为空"),
//    NOT_SYSTEM_API("404","不是系统指定api"),
//    REPEAT("666","数据已存在"),
//    HTTP_ERROR("-405","请求异常"),
//    API_ERROR("1001","")
            ;
    private int status;
    private String msg;

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    ResultEnum(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
