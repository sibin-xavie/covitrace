package com.jea.medico;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
/**
*
* @author sibin
* @since 13 sep 2020 1.45 PM
*/
public class Initializer implements WebApplicationInitializer {
	private static final String DISPATCHER_SERVLET_NAME = "MEDICAL_SEVLET";

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		  AnnotationConfigWebApplicationContext registerApplication = new AnnotationConfigWebApplicationContext();
	        registerApplication.register(WebAppConfig.class);
	        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(registerApplication));
	        dispatcher.setLoadOnStartup(1);
	        dispatcher.addMapping("/");
		
	}
}
