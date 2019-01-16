package com.yss.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @auther zhangxy
 * @date 2019/1/16 10:15
 */
@Component
public class MqProducer implements RabbitTemplate.ConfirmCallback {

    private Logger logger = LoggerFactory.getLogger(MqProducer.class);

    @Resource(name = "rabbitTemplate")
    private RabbitTemplate rabbitTemplate;

    /**
     * 将消息发送到指定的交换器上
     *
     * @param exchange
     * @param msg
     */
    public void publishMsg(String exchange, String routingKey, Object msg) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.convertAndSend(exchange, routingKey, msg, correlationId);
    }

    public Message receiveMeg(String queueName){
        Message msg = rabbitTemplate.receive(queueName);
        return msg;
    }

    public void publishMsg(String topic, String message) {
        this.rabbitTemplate.convertAndSend(topic, message);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("回调id="+correlationData);
        if(ack){
            logger.debug("确认消息发送成功");
        }else{
            logger.debug("确认消息发送失败,失败原因{}",cause);
        }
    }
}
