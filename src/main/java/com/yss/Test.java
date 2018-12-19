package com.yss;

import com.yss.config.SpringConfig;
import com.yss.mapper.SecKillDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        SecKillDao secKillDao = (SecKillDao)context.getBean(SecKillDao.class);
        System.out.println(secKillDao.selectOne(1000));
        System.out.println(1);
    }

}
