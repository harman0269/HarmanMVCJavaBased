package com.mvc.config;
import org.springframework.web.servlet.DispatcherServlet;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
//REPLACEMENT OF WEB.XML FILE

public class WebServletConfiguration implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext ctx) throws ServletException {
		AnnotationConfigWebApplicationContext annWebConfig=new AnnotationConfigWebApplicationContext();
		annWebConfig.register(SpringConfig.class);
		annWebConfig.setServletContext(ctx);
		ServletRegistration.Dynamic servlet=ctx.addServlet("dispatcher",new DispatcherServlet(annWebConfig));
		//REPLACEMENT OF <servlet-class>(<servlet>) in web.xml file
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		
		//REPLACEMENT OF <url-pattern>/ (<servlet-mapping>)in web.xml		
		
	}

}
