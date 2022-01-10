package com.git.zxxxd.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * JdbcTemplate多数据源配置
 * 依赖于数据源配置
 *
 */
@Configuration
public class JdbcTemplateDataSourceConfig {

    //JdbcTemplate主数据源ds1数据源
    @Primary
    @Bean(name = "OneJdbcTemplate")
    public JdbcTemplate ds1JdbcTemplate(@Qualifier("OneDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    //JdbcTemplate第二个ds2数据源
    @Bean(name = "TwoJdbcTemplate")
    public JdbcTemplate ds2JdbcTemplate(@Qualifier("TwoDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}