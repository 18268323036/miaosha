package com.yss.test;

import com.yss.config.RedisConfig;
import com.yss.config.SpringConfig;
import com.yss.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther zhangxy
 * @date 2019/1/10 17:37
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RedisConfig.class)
public class RedisTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Resource(name="redisTemplate")
    private ListOperations<String, String> listOps;

    @Test
    public void testRedisTemple() throws Exception {
        // 测试String类型
        // ValueOperations<String, Object> value = redisTemplate.opsForValue();
        // System.err.println(value.get("username"));
        // System.err.println(value.get("age"));

        //测试Hash类型
        //具体调用
        Map<String,String> map = new HashMap<String, String>();
        // map.put("value","code");
        // map.put("key","keyValue");
        // redisTemplate.opsForHash().putAll("hashOps",map);
        Map<Object, Object> entries = redisTemplate.opsForHash().entries("hashOps");
        for (Map.Entry<Object, Object> obj : entries.entrySet()) {
            System.err.println(obj.getKey()+"---"+obj.getValue());
        }
    }


}
