package com.yss.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

@Configurable
public class RedisConfig {

    @Value("${redis.pool.maxTotal}")
    private Integer maxTotal;
    @Value("${redis.pool.maxIdle}")
    private Integer maxIdle;
    @Value("${redis.pool.maxWait}")
    private Integer maxWaitMillis;
    @Value("${redis.pool.testOnBorrow}")
    private Boolean testOnBorrow;
    @Value("${redis.url}")
    private String host;
    @Value("${redis.port}")
    private Integer port;
    @Value("${redis.auth}")
    private String redisAuth;



    @Bean("jedisPoolConfig")
    public JedisPoolConfig getJedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);;
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        return jedisPoolConfig;
    }



    @Bean(name="jedisConnectionFactory")
    public RedisPassword getRedisPassword(){
        RedisPassword redisPassword = new RedisPassword(redisAuth);

        return null;
    }





}
