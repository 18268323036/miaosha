package com.yss.service.impl;

import com.yss.domain.SecKillInfo;
import com.yss.mapper.SecKillDao;
import com.yss.service.SecKillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecKillServiceImpl implements SecKillService {

    @Autowired
    private SecKillDao secKillDao;

    @Override
    public int update(SecKillInfo secKillInfo) {
        return secKillDao.update(secKillInfo);
    }

    @Override
    public SecKillInfo selectOne(Long secKillId) {
        return secKillDao.selectOne(secKillId);
    }


}
