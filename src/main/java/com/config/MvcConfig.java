package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry welcome) {
		welcome.addViewController("/").setViewName("welcome");
	}
	public void addViewControllers1(ViewControllerRegistry login) {
		login.addViewController("/login").setViewName("login");
	}
	
	public void addViewControllers2(ViewControllerRegistry register) {
		register.addViewController("/register").setViewName("register");
	}

}
