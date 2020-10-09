package com.zhh1011.seckill.enums;

/**
 * 表示秒杀状态数据字典
 */
public enum SeckillState {
    SUCCESS(1,"秒杀成功"),
    END(0,"秒杀结束"),
    REPEAT_KILL(-1,"重复秒杀"),
    INNER_ERROR(-2,"系统异常"),
    DATA_REWRITE(-3,"数据篡改"),
    NONE_SUCH_PRODUCT(-4,"不存在该商品");

    private int state;

    private String stateInfo;

    SeckillState(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
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

    public static SeckillState stateOf(int index){
        for(SeckillState state:values()){
            if(state.getState() == index){
                return state;
            }
        }
        return null;
    }
}
