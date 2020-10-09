package com.zhh1011.seckill.dto;

import com.zhh1011.seckill.entity.SuccessKill;
import com.zhh1011.seckill.enums.SeckillState;

/**
 * 秒杀执行结果Dto
 */
public class SeckillExecution {
    /**
     * 秒杀商品id
     */
    private long seckillId;

    /**
     *  执行结果状态码
     *  SUCCESS(1,"秒杀成功"),
     *  END(0,"秒杀结束"),
     *  REPEAT_KILL(-1,"重复秒杀"),
     *  INNER_ERROR(-2,"系统异常"),
     *  DATA_REWRITE(-3,"数据篡改");
     */
    private int state;

    /**
     * 执行结果状态信息
     */
    private String stateInfo;

    /**
     * 秒杀结果信息
     */
    private SuccessKill successKill;

    public SeckillExecution(long seckillId, SeckillState state, SuccessKill successKill) {
        this.seckillId = seckillId;
        this.state = state.getState();
        this.stateInfo = state.getStateInfo();
        this.successKill = successKill;
    }

    public SeckillExecution(long seckillId, SeckillState state) {
        this.seckillId = seckillId;
        this.state = state.getState();
        this.stateInfo = state.getStateInfo();
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessKill getSuccessKill() {
        return successKill;
    }

    public void setSuccessKill(SuccessKill successKill) {
        this.successKill = successKill;
    }

    @Override
    public String toString() {
        return "SeckillExecution{" +
                "seckillId=" + seckillId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", successKill=" + successKill +
                '}';
    }
}
