package com.yss.service.impl;

import com.yss.domain.SuccessKilledInfo;
import com.yss.mapper.SuccessKilledDao;
import com.yss.service.SuccessKilledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuccessKilledServiceImpl implements SuccessKilledService {

    @Autowired
    private SuccessKilledDao successKilledDao;

    @Override
    public int add(SuccessKilledInfo successKilledInfo) {
        return successKilledDao.add(successKilledInfo);
    }



}
