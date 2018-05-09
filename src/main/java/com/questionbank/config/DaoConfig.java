package com.questionbank.config;
import java.sql.SQLException;

import javax.sql.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@MapperScan(basePackages = "com.questionbank.dao")
@ComponentScan(basePackages = "com.questionbank.dao")
public class DaoConfig {
	@Bean
	public DataSource dataSource() throws SQLException {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUsername("root");
		dataSource.setPassword("MyNewPass1!");
		dataSource.setUrl("jdbc:mysql://localhost:3306/questionbank");

		// 初始化连接大小
		dataSource.setInitialSize(0);
		// 连接池最大连接数量
		dataSource.setMaxActive(20);
		// 连接池最小空闲
		dataSource.setMinIdle(0);
		// 获取连接的最长等待时间
		dataSource.setMaxWait(60000);

		dataSource.setValidationQuery("select 1");
		// 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
		dataSource.setTimeBetweenConnectErrorMillis(60000);
		// 配置一个连接在池中最小生存的时间，单位是毫秒
		dataSource.setMinEvictableIdleTimeMillis(25200000);
		dataSource.setRemoveAbandoned(true);
		dataSource.setRemoveAbandonedTimeout(1800);
		dataSource.setLogAbandoned(true);
		dataSource.addFilters("mergeStat");
		return dataSource;
	}

	@Bean
	public DataSourceTransactionManager transactionManager() throws SQLException {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setTypeAliasesPackage("com.questionbank.domain");
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sessionFactory.setMapperLocations(resolver.getResources("classpath:com/questionbank/mapping/*.xml"));
		return sessionFactory;
	}

}