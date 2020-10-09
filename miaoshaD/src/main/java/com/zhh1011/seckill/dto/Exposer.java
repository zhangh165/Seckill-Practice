package com.zhh1011.seckill.dto;

/**
 *获取秒杀接口url Dto
 */
public class Exposer {
    //是否开启秒杀
    private boolean isExposer;

    //md5
    private String md5;

    //seckill id
    private long seckillId;

    //系统当前时间
    private long now;

    //秒杀开启时间
    private long start;

    //秒杀结束时间
    private long end;

    public Exposer(boolean isExposer, String md5, long seckillId) {
        this.isExposer = isExposer;
        this.md5 = md5;
        this.seckillId = seckillId;
    }

    public Exposer(boolean isExposer, long seckillId, long now, long start, long end) {
        this.isExposer = isExposer;
        this.seckillId = seckillId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public Exposer(boolean isExposer, long seckillId) {
        this.isExposer = isExposer;
        this.seckillId = seckillId;
    }

    public boolean isExposer() {
        return isExposer;
    }

    public void setExposer(boolean exposer) {
        isExposer = exposer;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Exposer{" +
                "isExposer=" + isExposer +
                ", md5='" + md5 + '\'' +
                ", seckillId=" + seckillId +
                ", now=" + now +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
