package com.yss.config;


import com.yss.mq.MqConsumer;
import com.yss.mq.MqProducer;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
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
        return factory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory());
        rabbitAdmin.declareBinding(BindingBuilder.bind(new Queue("myqueue",true))
                                                 .to(new DirectExchange("amq.direct",true,false))
                                                 .with("directXXX"));
//        rabbitAdmin.declareExchange(new DirectExchange("amq.direct",true,false));
//        rabbitAdmin.declareQueue(new Queue("myqueue"));
        return rabbitAdmin;
    }

    @Bean("rabbitTemplate")
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setMessageConverter(new Jackson2JsonMessageConverter());
        return template;
    }

    @Bean
    public MqProducer getMqProducer() {
        return new MqProducer();
    }

    @Bean
    public MqConsumer getMqConsumer() {
        return new MqConsumer();
    }


//    @Bean
//    public SimpleMessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory){
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames("myqueue");
//        MessageListenerAdapter adapter = new MessageListenerAdapter();
//        //指定消息转换器
//        adapter.setMessageConverter(new Jackson2JsonMessageConverter());
//        //设置处理器的消费消息的默认方法
//        adapter.setDefaultListenerMethod("onMessage");
//        container.setMessageListener(adapter);
//        return container;
//    }




}
