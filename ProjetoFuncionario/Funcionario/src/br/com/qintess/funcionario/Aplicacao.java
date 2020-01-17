package br.com.qintess.funcionario;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;


import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.WebApplicationInitializer;


public class Aplicacao implements WebApplicationInitializer {
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
	
		
		
		
		FilterRegistration.Dynamic filter = servletContext.addFilter("openEntityManagerFilter", buildOpenEntityManagerFilter());
		filter.addMappingForUrlPatterns(getDispatcherTypes(), false,"/WEB-INF/views/*");
	}
	
	private OpenEntityManagerInViewFilter buildOpenEntityManagerFilter() {
		OpenEntityManagerInViewFilter openEntityManagerInViewFilter = new OpenEntityManagerInViewFilter();
		openEntityManagerInViewFilter.setEntityManagerFactoryBeanName("sessionFactor");
		return openEntityManagerInViewFilter;
	}
	
	private EnumSet<DispatcherType> getDispatcherTypes() {
		return EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE, DispatcherType.ASYNC);
	}
	
	
}
