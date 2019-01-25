package com.yss.test;

import com.yss.config.RabbitConfig;
import com.yss.domain.PersonInfo;
import com.yss.mq.MqConsumer;
import com.yss.mq.MqProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @auther zhangxy
 * @date 2019/1/16 13:45
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RabbitConfig.class)
public class MQTest {

    @Autowired
    private MqProducer mqProducer;
    @Autowired
    private MqConsumer mqConsumer;

    @Test
    public void sendMessage(){
        String msg = "xxxxxxxxxxaaaaaa";
        PersonInfo personInfo = new PersonInfo();
        personInfo.setName("张翔耀");
        personInfo.setAge("13");
        personInfo.setSex("fale");
        mqProducer.publishMsg("amq.direct","directXXX",personInfo);
    }


    @Test
    public void receiveMessage() {
        mqConsumer.onMessage();
    }




}
