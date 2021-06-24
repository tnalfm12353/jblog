package com.douzone.jblog.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.douzone.config.app.DBConfig;
import com.douzone.config.app.MybatisConfig;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.douzone.jblog.repository","com.douzone.jblog.service"})
@Import({DBConfig.class, MybatisConfig.class})
public class AppConfig {

}
