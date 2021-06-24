package com.douzone.config.app;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfig {

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource, ApplicationContext applicationContext) throws Exception {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:config/app/mybatis/configuration.xml"));
		return sessionFactoryBean.getObject();
	}
	
	@Bean
	public SqlSession sqlSession(SqlSessionFactory sessionFactory) {
		return new SqlSessionTemplate(sessionFactory);
	}
}
