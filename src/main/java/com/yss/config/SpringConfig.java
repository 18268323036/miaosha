package com.yss.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Configurable
//扫描需要被容器管理的对象
@ComponentScan(basePackages="com.yss")
//@Import引入其他配置文件
@Import(DataSourceConfig.class)
public class SpringConfig {



}
