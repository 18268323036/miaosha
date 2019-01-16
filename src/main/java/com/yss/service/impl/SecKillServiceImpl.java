package com.yss.service.impl;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.yss.service.SecKillService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Service
public class SecKillServiceImpl implements SecKillService {

    @Override
    public int update() {
        return 0;
    }


}
