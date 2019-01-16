package com.yss.test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.yss.config.RabbitConfig;
import com.yss.config.RedisConfig;
import com.yss.mq.MqProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @auther zhangxy
 * @date 2019/1/16 13:45
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RabbitConfig.class)
public class MQTest {

    @Autowired
    private MqProducer mqProducer;

    @Test
    public void sendMessage(){
        String msg = "这是我的第一条消息";
        mqProducer.publishMsg("xxxExchange","666666",msg);
    }


    @Test
    public void receiveMessage(){
        Message msg = mqProducer.receiveMeg("zxy");
        System.out.println(msg);
    }




}
