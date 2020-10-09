package com.zhh1011.seckill.exception;

/**
 * 秒杀关闭异常
 * 超出秒杀时间；商品售卖完毕；
 */
public class SeckillCloseException extends SeckillException {
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
