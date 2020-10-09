package com.zhh1011.seckill.service.impl;

import com.zhh1011.seckill.dao.SeckillDao;
import com.zhh1011.seckill.dao.SuccsessKillDao;
import com.zhh1011.seckill.dao.cache.SeckillRedisDao;
import com.zhh1011.seckill.dto.Exposer;
import com.zhh1011.seckill.dto.SeckillExecution;
import com.zhh1011.seckill.entity.Seckill;
import com.zhh1011.seckill.entity.SuccessKill;
import com.zhh1011.seckill.enums.SeckillState;
import com.zhh1011.seckill.exception.RepeatKillException;
import com.zhh1011.seckill.exception.SeckillCloseException;
import com.zhh1011.seckill.exception.SeckillException;
import com.zhh1011.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * 秒杀业务实现类
 */
@Service
public class SeckillServiceImpl implements SeckillService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillDao seckillDao;
    @Autowired
    private SuccsessKillDao succsessKillDao;
    @Autowired
    private SeckillRedisDao seckillRedisDao;

    //md5盐值
    private final String slat = "sagag&^TUxyg87atuhga8ox7taoi86ftr(&^R(";

    @Override
    public List<Seckill> getSeckillAll() {
        return seckillDao.queryAll(0, 100);
    }

    @Override
    public Seckill getSeckillById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    @Override
    public Exposer exportSeckillUrl(long seckillId) {

        Seckill seckill = seckillRedisDao.getSeckillFromCache(seckillId);
        if(seckill==null){
            seckill = seckillDao.queryById(seckillId);
            //判断是否含有该商品
            if (seckill == null) {
                return new Exposer(false, seckillId);
            }else {
                seckillRedisDao.putSeckill(seckill);
            }
        }


        //获取开始时间，结束时间以及当前时间
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        Date now = new Date();
        //判断是否处于秒杀时间段
        if (now.getTime() < startTime.getTime()
                || now.getTime() > endTime.getTime()) {
            return new Exposer(false, seckillId, now.getTime(), startTime.getTime(), endTime.getTime());
        }
        //获取md5加密，暴露秒杀接口
        String md5 = getMD5(seckillId);
        return new Exposer(true,md5,seckillId);
    }

    /**
     * 进行md5加密
     * @param seckillId
     * @return
     */
    private String getMD5(long seckillId){
        String base = seckillId+"/"+slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    @Transactional
    @Override
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws RepeatKillException, SeckillCloseException, SeckillException {
        //判断用户是否为正常访问行为
        if (md5 == null || !md5.equals(getMD5(seckillId))) {
            throw new SeckillException("seckill data rewrite");
        }
        try {
            //记录购买明细，同时判断是否重复购买
            int insertCount = succsessKillDao.insertSuccessKill(userPhone,seckillId );
            if (insertCount <= 0) {
                //重复购买则进行Rollback
                throw new RepeatKillException("seckill repeat");
            } else {
                //进行秒杀操作
                int upateCount = seckillDao.reduceNumber(seckillId, new Date());
                //判断是否秒杀成功
                if (upateCount <= 0) {
                    throw new SeckillCloseException("seckill is close");
                } else {
                    //获取购买明细，并返回相应信息
                    SuccessKill successKill = succsessKillDao.queryById(seckillId, userPhone);
                    return new SeckillExecution(seckillId, SeckillState.SUCCESS, successKill);
                }
            }

        }catch (RepeatKillException e1){
            throw e1;
        }catch(SeckillCloseException e2){
            throw e2;
        }catch(Exception e){
            logger.error(e.getMessage(),e);
            throw new SeckillException("seckill inner error"+e.getMessage());
        }
    }
}
