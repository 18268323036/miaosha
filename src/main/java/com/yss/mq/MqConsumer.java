package com.yss.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;


/**
 * @auther zhangxy
 * @date 2019/1/16 10:20
 */
@Component
public class MqConsumer {

    private Logger logger = LoggerFactory.getLogger(MqConsumer.class);

    @RabbitHandler
    @RabbitListener(queues = "")
    public void onMessage(Message message) throws UnsupportedEncodingException {
        logger.debug("收到消息:",new String(message.getBody(), "utf-8"));
    }


}
