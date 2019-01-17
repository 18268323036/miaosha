package com.yss.mq;

import com.alibaba.fastjson.JSONObject;
import com.yss.domain.PersonInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @auther zhangxy
 * @date 2019/1/16 10:20
 */
@Component
public class MqConsumer {

    private Logger logger = LoggerFactory.getLogger(MqConsumer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitHandler
    @RabbitListener(queues = "myqueue")
    public void onMessage() {
        Message message = rabbitTemplate.receive("myqueue");
        PersonInfo personInfo = null;
        if (message != null && message.getBody() != null && message.getBody().length > 0) {
                personInfo = JSONObject.parseObject(message.getBody(), PersonInfo.class);
                System.out.println("收到消息:" + personInfo);
        }
    }


}
