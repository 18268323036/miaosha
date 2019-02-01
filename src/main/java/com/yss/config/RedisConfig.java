package com.yss.config;

import com.yss.util.RedisUtil;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configurable
public class RedisConfig {

//    @Value("${redis.pool.maxTotal}")
//    private Integer maxTotal;
//    @Value("${redis.pool.maxIdle}")
//    private Integer maxIdle;
//    @Value("${redis.pool.maxWait}")
//    private Integer maxWaitMillis;
//    @Value("${redis.pool.testOnBorrow}")
//    private Boolean testOnBorrow;
//    @Value("${redis.url}")
//    private String host;
//    @Value("${redis.port}")
//    private Integer port;
//    @Value("${redis.auth}")
//    private String redisAuth;


//    @Bean("jedisPoolConfig")
//    public JedisPoolConfig getJedisPoolConfig() {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxTotal(200);
//        jedisPoolConfig.setMaxIdle(20);
//        jedisPoolConfig.setMaxWaitMillis(3000);
//        jedisPoolConfig.setTestOnBorrow(true);
//        return jedisPoolConfig;
//    }

    //redis集群配置
//    @Bean(name = "jedisConnectionFactory")
//    public JedisConnectionFactory jedisConnectionFactory() {
//        Properties prop = new Properties();
//        InputStream in = this.getClass().getResourceAsStream("/redisCluster.properties");
//        try {
//            prop.load(in);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        PropertiesPropertySource propertySource = new PropertiesPropertySource("clusterNodes", prop);
//        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(propertySource);
//        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder
//                jedisPoolConfigBuilder = (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration.builder();
//        jedisPoolConfigBuilder.poolConfig(getJedisPoolConfig());
//        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisClusterConfiguration, jedisPoolConfigBuilder.build());
//        return jedisConnectionFactory;
//    }

    //redis单机配置
    @Bean(name = "jedisConnectionFactory")
    public JedisConnectionFactory getJedisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName("39.108.0.94");
        configuration.setPort(6379);
        JedisConnectionFactory factory = new JedisConnectionFactory(configuration);
        factory.setUsePool(true);
        factory.setHostName("39.108.0.94");
        factory.setPort(6379);
        factory.setPassword("123456");
        return factory;
    }




//    @Bean(name = "redisCacheManager")
//    public RedisCacheManager getRedisCacheManager(){
//        RedisCacheManager manager = RedisCacheManager.create(getJedisConnectionFactory());
//        return manager;
//    }
//
//    @Bean(name = "stringRedisSerializer")
//    public StringRedisSerializer getStringRedisSerializer(){
//        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//        return stringRedisSerializer;
//    }
//
//
    @Bean(name = "redisTemplate")
    public RedisTemplate getRedisTemplate(){
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(getJedisConnectionFactory());
//        redisTemplate.setKeySerializer(getStringRedisSerializer());
//        redisTemplate.setHashKeySerializer(getStringRedisSerializer());
        return redisTemplate;
    }

    @Bean
    public RedisUtil getRedisUtil(){
        return new RedisUtil();
    }







}
