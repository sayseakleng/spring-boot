package com.kdemo.springboot.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		if (!registry.hasMappingForPattern("/resources/**")) {
			registry.addResourceHandler("/resources/**")
				.addResourceLocations("classpath:templates/resources/")
				.setCacheControl(CacheControl.maxAge(4, TimeUnit.HOURS).cachePublic());
		}
	}
}
