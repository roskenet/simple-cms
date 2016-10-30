package de.roskenet.simplecms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class StaticConfig {

	@Value("${scms.static:}")
	private String staticValues;

	@Bean
	public PropertiesFactoryBean staticValues() {
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		
		if(!staticValues.isEmpty()) {
		    bean.setLocation(new FileSystemResource(staticValues));
		}
		
		return bean;
	}
}
