package com.yss.mapper;

import com.yss.domain.SuccessKilledInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface SuccessKilledDao {

    int add(SuccessKilledInfo successKilledInfo);

}
