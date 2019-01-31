package com.yss.mapper;

import com.yss.domain.SecKillInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface SecKillDao {

    int update(SecKillInfo secKillInfo);

    SecKillInfo selectOne(Long secKillId);


}
