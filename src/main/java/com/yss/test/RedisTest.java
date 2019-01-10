package com.yss.test;

import com.yss.config.SpringConfig;
import com.yss.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @auther zhangxy
 * @date 2019/1/10 17:37
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class RedisTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void test1(){
        redisUtil.setCacheObject("1","zhangxinagyao");
        System.out.println(redisUtil.getCacheObject("1"));
    }

}
