package com.douzone.jblog.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.douzone.config.web.FileUploadConfig;
import com.douzone.config.web.MvcConfig;
import com.douzone.config.web.SecurityConfig;

@Configuration
@ComponentScan({"com.douzone.jblog.controller"})
@Import({MvcConfig.class, SecurityConfig.class, FileUploadConfig.class})
public class WebConfig {

}