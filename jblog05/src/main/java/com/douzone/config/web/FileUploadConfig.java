package com.douzone.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class FileUploadConfig extends WebMvcConfigurerAdapter{

	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(52428800);
		multipartResolver.setMaxInMemorySize(4096);
		multipartResolver.setDefaultEncoding("utf-8");
		
		return multipartResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/images/logo/**")
				.addResourceLocations("file:/uploads-jblog/");
	}
	
	
}
