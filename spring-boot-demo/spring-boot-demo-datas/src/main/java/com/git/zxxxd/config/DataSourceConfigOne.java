package com.git.zxxxd.config;

import com.baomidou.mybatisplus.MybatisConfiguration;
import com.baomidou.mybatisplus.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 mybatis多数据源的原理是根据不同包，调用不同的数据源，你只需要把你的dao和xml写在某个package中，springboot自动帮你实现数据源切换
 核心代码就这句
 @MapperScan(basePackages ="com.web.ds2.**.dao", sqlSessionTemplateRef = "ds2SqlSessionTemplate")
 用来指定包扫描指定sqlSessionTemplateRef
 和sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources()
 */

@Configuration
@MapperScan(basePackages = "com.git.zxxxd.mapper.one", sqlSessionFactoryRef = "OneSqlSessionFactory")
public class DataSourceConfigOne {

    @Primary
    @Bean("OneSqlSessionFactory")
    public SqlSessionFactory OneSqlSessionFactory(@Qualifier("OneDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // mapper的xml形式文件位置必须要配置，不然将报错：no statement （这种错误也可能是mapper的xml中，namespace与项目的路径不一致导致）
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:com/git/zxxxd/mapper/one/*.xml"));
        return bean.getObject();

        /**
            mybatis-plus是mybatis的增强版，只增加，不影响。
         也就是说使用mybatis-plus兼容原来所有的mybatis代码和配置。
         然后又做了很多增加和简化使用，具体看官网教程 https://mybatis.plus/

            相对于mybatis的多数据源配置就是改了下 SqlSessionFactory
            核心代码就是修改mybatis为mybatis-plus，如下
         */
//        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
//        sqlSessionFactory.setDataSource(dataSource);
//        MybatisConfiguration configuration = new MybatisConfiguration();
//        configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
//        configuration.setJdbcTypeForNull(JdbcType.NULL);
//        sqlSessionFactory.setConfiguration(configuration);
//        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().
//                getResources("classpath*:com/git/zxxxd/mapper/one/*.xml"));
//        sqlSessionFactory.setPlugins(new Interceptor[]{
//                new PaginationInterceptor(),
//                new PerformanceInterceptor()
//        });
//        return sqlSessionFactory.getObject();
    }

    /**
     expected single matching bean but found 2: OneTransactionManager,TwoTransactionManager

     如果不添加Primary就会有上边报错 容器有两个事物管理器不知使用那个，添加Primary需要关注使用那个事物类
     */
    @Primary
    @Bean("OneTransactionManager")
    public DataSourceTransactionManager TwoTransactionManager(@Qualifier("OneDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean("OneSqlSessionTemplate")
    public SqlSessionTemplate OneSqlSessionTemplate(@Qualifier("OneSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
