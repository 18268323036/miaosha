package com.yss.service;

import com.yss.domain.SecKillInfo;

public interface SecKillService {

    int update(SecKillInfo secKillInfo);

    SecKillInfo selectOne(Long secKillId);
}
