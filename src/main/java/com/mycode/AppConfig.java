package com.mycode;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.server.i18n.AcceptHeaderLocaleContextResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class AppConfig {

	private static final ApiInfo MY_API_INFO = new ApiInfo("My Rest microservice project's Api Documentation", 
			"My Rest microservice project's Api Documentation", "1.0", "urn:tos",
	          new Contact("sabya", "https://github.com/sabya-gupta", "sabya_gupta@outlook.com"), 
	          "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");//copy from swagger and then change

	@Bean
	public LocaleResolver localeResolver() {
		//SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource() {//or set it in application props file
		ResourceBundleMessageSource resourcebundlemessagesource = new ResourceBundleMessageSource();
		resourcebundlemessagesource.setBasename("messages");
		return resourcebundlemessagesource;
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(MY_API_INFO)
				;
	}
	
}
