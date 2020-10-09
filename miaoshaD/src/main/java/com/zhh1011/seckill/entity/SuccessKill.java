package com.zhh1011.seckill.entity;

import java.util.Date;
/**
 * 秒杀商品购买明细
 */
public class SuccessKill {
    /**
     * 秒杀商品id
     */
    private long seckillId;

    /**
     * 秒杀商品购买用户电话（充当用户角色id）
     */
    private long userPhone;

    /**
     * 购买订单创建时间
     */
    private Date createTime;

    /**
     * 秒杀商品 一对多，创建实体携带信息
     */
    private Seckill seckill;

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }

    @Override
    public String toString() {
        return "SuccessKill{" +
                "seckillId=" + seckillId +
                ", userPhone=" + userPhone +
                ", createTime=" + createTime +
                ", seckill=" + seckill +
                '}';
    }
}
