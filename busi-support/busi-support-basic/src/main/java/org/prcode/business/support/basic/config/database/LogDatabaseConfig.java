package org.prcode.business.support.basic.config.database;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.prcode.utility.util.exception.DESException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.sql.SQLException;

/**
 * @ClassName: LogDatabaseConfig
 * @Date: 2017-03-30 14:02
 * @Auther: kangduo
 * @Description: (数据库连接配置, 日志数据库)
 */
@Configuration
@MapperScan(value = "org.prcode.log.basedomain.*.dao", sqlSessionFactoryRef = "logSqlSessionFactory")
public class LogDatabaseConfig {

    private final String MAPPERXML_LOCATION = "classpath:mybatis/log/mapper/*.xml";

    @Autowired
    private DbConfigProperties dbConfigProperties;

    @Bean(initMethod = "init", destroyMethod = "close")
    public DruidDataSource logDataSource() throws SQLException, DESException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(dbConfigProperties.getDriveClass());
        druidDataSource.setUrl(dbConfigProperties.getLogUrl());
        druidDataSource.setUsername(dbConfigProperties.getLogUsername());
        druidDataSource.setPassword(dbConfigProperties.getLogPassword());
        druidDataSource.setInitialSize(dbConfigProperties.getInitialSize());
        druidDataSource.setMinIdle(dbConfigProperties.getMinIdle());
        druidDataSource.setMaxActive(dbConfigProperties.getMaxActive());
        druidDataSource.setMaxWait(dbConfigProperties.getMaxWait());
        druidDataSource.setTimeBetweenEvictionRunsMillis(dbConfigProperties.getTimeBetweenEvictionRunsMillis());
        druidDataSource.setMinEvictableIdleTimeMillis(dbConfigProperties.getMinEvictableIdleTimeMillis());
        druidDataSource.setValidationQuery(dbConfigProperties.getValidationQuery());
        druidDataSource.setTestWhileIdle(dbConfigProperties.getTestWhileIdle());
        druidDataSource.setTestOnBorrow(dbConfigProperties.getTestOnBorrow());
        druidDataSource.setTestOnReturn(dbConfigProperties.getTestOnReturn());
        druidDataSource.setPoolPreparedStatements(dbConfigProperties.getPoolPreparedStatements());
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(dbConfigProperties.getMaxPoolPreparedStatementPerConnectionSize());
        druidDataSource.setFilters(dbConfigProperties.getFilters());
        return druidDataSource;
    }

    @Bean
    public SqlSessionFactory logSqlSessionFactory(@Qualifier("logDataSource") DruidDataSource logDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(logDataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(MAPPERXML_LOCATION));
        return sqlSessionFactoryBean.getObject();
    }
}
