package com.app.entity;

import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.Serializable;

public class ResultBean<T> implements Serializable {

    private String status;

    private String msg;

    private T data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResultBean(T data, ResultEnum resultEnum) {
        this.status = resultEnum.getStatus();
        this.msg = resultEnum.getMsg();
        this.data = data;
    }

    public ResultBean(ResultEnum resultEnum) {
        this.status = resultEnum.getStatus();
        this.msg = resultEnum.getMsg();
    }

    public ResultBean(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ResultBean setResultEnum(ResultEnum result){
        this.status = result.getStatus();
        this.msg = result.getMsg();
        return this;
    }

    public ResultBean() {
    }

    public ResultBean setData(T data, ResultEnum resultEnum){
        setData(data);
        return setResultEnum(resultEnum);
    }

    public ResultBean setResultEnum(String status, String msg){
        this.status = status;
        this.msg = msg;
        return this;
    }


    /**
     * 回滚
     * @return
     */
    public ResultBean rollback(){
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return this;
    }

}
