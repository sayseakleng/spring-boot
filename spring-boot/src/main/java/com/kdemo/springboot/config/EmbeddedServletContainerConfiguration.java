package com.kdemo.springboot.config;

import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.undertow.Undertow.Builder;
import io.undertow.UndertowOptions;

@Configuration
public class EmbeddedServletContainerConfiguration {

	@Bean
	public EmbeddedServletContainerFactory embeddedServletContainerFactory() {
	   
		final UndertowEmbeddedServletContainerFactory undertowEmbeddedServletContainerFactory = new UndertowEmbeddedServletContainerFactory();
	    
	    undertowEmbeddedServletContainerFactory
	            .addBuilderCustomizers(new UndertowBuilderCustomizer() {
	                @Override
	                public void customize(final Builder builder) {
	                    builder.setServerOption(UndertowOptions.ENABLE_HTTP2, true)
	                    	.setServerOption(UndertowOptions.ENABLE_SPDY, true);
	                }
	            });
	    
	    return undertowEmbeddedServletContainerFactory;
	}
}
