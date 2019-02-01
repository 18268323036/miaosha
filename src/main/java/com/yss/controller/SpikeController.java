package com.yss.controller;

import com.yss.domain.SecKillInfo;
import com.yss.domain.SuccessKilledInfo;
import com.yss.service.SecKillService;
import com.yss.service.SuccessKilledService;
import com.yss.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther zhangxy
 * @date 2019/1/30 16:35
 */
@RestController
@RequestMapping(value = "/spike/")
public class SpikeController {

    @Autowired
    private SecKillService secKillService;

    @Autowired
    private SuccessKilledService successKilledService;

    @Autowired
    private RedisUtil redisUtil;


    @RequestMapping(value = "/do")
    @Transactional
    public Object spike(Long secKillId,String userPhone){
        if(secKillId==null){
            return null;
        }
        SecKillInfo secKillInfo = null;
        if(redisUtil.getCacheObject(String.valueOf(secKillId))==null){
            secKillInfo = secKillService.selectOne(secKillId);
        }else{
            secKillInfo = (SecKillInfo)redisUtil.getCacheObject(String.valueOf(secKillId));
        }
        if(secKillId!=null){
            secKillInfo.setNum(secKillInfo.getNum()-1);
            int updateCount = secKillService.update(secKillInfo);
            redisUtil.setCacheObject(String.valueOf(secKillId),secKillInfo);
            if(updateCount>0){
                SuccessKilledInfo killedInfo = new SuccessKilledInfo();
                killedInfo.setUserPhone(userPhone);
                killedInfo.setState(0);
                successKilledService.add(killedInfo);
            }
        }
        return "success";
    }


}
