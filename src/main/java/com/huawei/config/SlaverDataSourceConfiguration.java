package com.huawei.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = "com.huawei.mapper.slave", sqlSessionTemplateRef  = "slaveSqlSessionTemplate")
public class SlaverDataSourceConfiguration {

    @Bean(name = "slaveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.slave")
    public DataSource dataSource() {
        return  new DruidDataSource();
    }

    @Bean(name = "slaveSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("slaveDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "slaveTransactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("slaveDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "slaveSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("slaveSqlSessionFactory") SqlSessionFactory sqlSessionFactory)
            throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
