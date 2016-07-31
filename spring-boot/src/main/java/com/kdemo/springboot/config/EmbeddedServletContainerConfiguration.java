package com.kdemo.springboot.config;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.PortInUseException;
import org.springframework.boot.context.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

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
	
	/**
	 * To add application listener
	 * <br/>
	 * If application's successfully started, then browser will launch application default home page
	 * @param context
	 */
	@Autowired(required = true)
	public void configure(ConfigurableApplicationContext context) {
		context.addApplicationListener( event-> {
			if (event instanceof ApplicationFailedEvent) {
				if(((ApplicationFailedEvent) event).getException() instanceof PortInUseException) {
					// System.exit(1);
				}
			}
			else if(event instanceof ContextRefreshedEvent) {
				
				String url = "https://localhost:8443/page";
				
				// check if it can open default browser
				if(Desktop.isDesktopSupported()){
		            Desktop desktop = Desktop.getDesktop();
		            try {
		                desktop.browse(new URI(url));
		            } catch (IOException | URISyntaxException e) {
		                e.printStackTrace();
		            }
		        }else{
		            Runtime runtime = Runtime.getRuntime();
		            try {
		                runtime.exec(new String[]{"cmd", "/c","start chrome " + url});
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
			}
		});
	}
}