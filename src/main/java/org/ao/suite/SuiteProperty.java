package org.ao.suite;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SuiteProperty {

	@Value("${suite.parallel}")
	public boolean isParallel;
	
	@Value("${suite.startup}")
	public String startUp;
	
	@Value("${suite.home}")
	public String home;
	
	@Value("${suite.test.home}")
	public String testHome;
	
	@Value("${suite.objects.home}")
	public String objectsHome;
	
	@Value("${suite.screenshot.home}")
	public String screenshotsHome;
	
	@Value("${suite.webdriver}")
	public String webDriver;
	
	@Value("${suite.webdriver.timeout}")
	public long timeOut;
	
	@Value("${suite.remote.url}")
	public String remoteUrl;
	
}
