package com.zhh1011.seckill.dto;

/**
 * 封装JSON结果
 * @param <T>
 */
public class SeckillResult<T> {
    private boolean isSuccess;

    private T data;

    private String message;

    public SeckillResult(boolean isSuccess, T data) {
        this.isSuccess = isSuccess;
        this.data = data;
    }

    public SeckillResult(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
