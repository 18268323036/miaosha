package com.yss.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configurable
@EnableTransactionManagement
//@EnableAspectJAutoProxy
@EnableScheduling
//@Import引入其他配置文件
@Import({DataSourceConfig.class,RedisConfig.class,RabbitConfig.class,ViewResolverConfig.class})
public class SpringConfig {


}



