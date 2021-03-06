package org.ao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@ComponentScan(basePackages="org.ao.suite")
@PropertySources(
		@PropertySource("classpath:application.properties")
		)
public class JSONRunnerConfig {

	
}
