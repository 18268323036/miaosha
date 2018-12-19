package com.yss.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.beans.PropertyVetoException;
import java.io.IOException;

@Configurable
//扫描dao(mapper.xml的映射)
@MapperScan("com.yss.mapper")
@EnableTransactionManagement
public class DataSourceConfig {

    @Bean
    public ComboPooledDataSource getComboPooledDataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://39.108.0.94:3306/seckill?useUnicode=true&characterEncoding=utf-8");
            dataSource.setUser("root");
            dataSource.setPassword("root");
            dataSource.setMaxPoolSize(30);
            dataSource.setMinPoolSize(10);
            dataSource.setAutoCommitOnClose(false);
            dataSource.setCheckoutTimeout(1000);
            dataSource.setAcquireRetryAttempts(2);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean getSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(getComboPooledDataSource());
        //扫描mapper.xml的位置,一般放在和java文件平行的resources文件夹下，自己新建
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/*.xml"));
        //放domain包的路径
        factoryBean.setTypeAliasesPackage("com.yss.domain");
        return factoryBean;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(getComboPooledDataSource());
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }



}
