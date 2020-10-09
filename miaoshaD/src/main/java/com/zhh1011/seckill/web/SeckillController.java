package com.zhh1011.seckill.web;

import com.zhh1011.seckill.dto.Exposer;
import com.zhh1011.seckill.dto.SeckillExecution;
import com.zhh1011.seckill.dto.SeckillResult;
import com.zhh1011.seckill.entity.Seckill;
import com.zhh1011.seckill.enums.SeckillState;
import com.zhh1011.seckill.exception.RepeatKillException;
import com.zhh1011.seckill.exception.SeckillCloseException;
import com.zhh1011.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seckill")
public class SeckillController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @GetMapping(value = "",produces = {"application/json;charset=UTF-8"})
    public List<Seckill> list(){
        return seckillService.getSeckillAll();
    }

    @GetMapping(value = "/{seckillId}",
            produces = {"application/json;charset=UTF-8"})
    public SeckillResult getSeckill(@PathVariable("seckillId")Long seckillId){
        if(seckillId == null){
            return new SeckillResult<SeckillState>(false,SeckillState.NONE_SUCH_PRODUCT);
        }
        Seckill seckill = seckillService.getSeckillById(seckillId);
        return new SeckillResult<Seckill>(true,seckill);
    }

    @PostMapping(value = "/{seckillId}/exposer",
            produces = {"application/json;charset=UTF-8"})
    public SeckillResult<Exposer> exposer(@PathVariable("seckillId") Long seckillId){
        SeckillResult<Exposer> result;
        try {
            Exposer exposer = seckillService.exportSeckillUrl(seckillId);
            result = new SeckillResult<>(true,exposer);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            result = new SeckillResult<>(false,e.getMessage());
        }
        return result;
    }

    @PostMapping(value = "/{seckillId}/{md5}/execution",
            produces = {"application/json;charset=UTF-8"})
    public SeckillResult<SeckillExecution> execute(@PathVariable("seckillId")long seckillId,
                                                   @PathVariable("md5")String md5,
                                                   @CookieValue(value = "userPhone",required = false) Long phone){
        if(phone == null){
            return new SeckillResult<>(false,"用户未登录");
        }
        SeckillResult<SeckillExecution> result;
        try {
            SeckillExecution execution = seckillService.executeSeckill(seckillId,phone,md5);
            result = new SeckillResult<>(true,execution);
            return result;
        }catch (RepeatKillException e){
            SeckillExecution seckillExecution = new SeckillExecution(seckillId,SeckillState.REPEAT_KILL);
            return new SeckillResult<SeckillExecution>(false,seckillExecution);
        }catch (SeckillCloseException e){
            SeckillExecution seckillExecution = new SeckillExecution(seckillId,SeckillState.END);
            return new SeckillResult<SeckillExecution>(false,seckillExecution);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new SeckillResult<>(false,SeckillState.INNER_ERROR.getStateInfo());
        }
    }

    @GetMapping(value = "/time",
            produces = {"application/json;charset=UTF-8"})
    public SeckillResult<Long> time(){
        return new SeckillResult<>(true,System.currentTimeMillis());
    }
}
