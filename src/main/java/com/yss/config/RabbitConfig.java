package com.yss.config;


import com.yss.mq.MqProducer;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * @auther zhangxy
 * @date 2019/1/15 11:20
 */
@Configurable
public class RabbitConfig {


    @Bean("connectionFactory")
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setHost("39.108.0.94");
        factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setChannelCacheSize(50);
        factory.setPublisherConfirms(true);
        factory.setVirtualHost("/");
//        factory.setCacheMode(CachingConnectionFactory.CacheMode.CONNECTION);
        return factory;
    }


//    @Bean("mqConnection")
//    public Connection getConnection(){
//        return connectionFactory().createConnection();
//    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean("rabbitTemplate")
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    public MqProducer getMqProducer(){
        return new MqProducer();
    }

//    @Bean
//    public Queue myQueue() {
//        return new Queue("myqueue");
//    }

}
