package com.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


//REPLACEMENT OF -SERVLET.XML FILE

@EnableWebMvc
//REPLACEMENT OF <mvc:annontation-driven> in servlet.xml file
@ComponentScan(basePackages="com.mvc")
//REPLACEMENT OF <context:component-scan> in servlet.xml file
public class SpringConfig implements WebMvcConfigurer{
	
	@Bean
	
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		//IT SPECIFIESTHAT JSTL VIEWS SHOULD BE USED
		//JstlView IS A CLASS provided by the spring FRAMEWORK THAT IS SPECIFICALLY DESIGNED TO HANDLE JSP PAGES USING JSTL
		
		
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/JSP/");
		viewResolver.setSuffix(".jsp");
//		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
		
	}

}
