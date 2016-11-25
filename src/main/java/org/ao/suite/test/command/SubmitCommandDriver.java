package org.ao.suite.test.command;

import org.ao.suite.test.TestContainer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;

public class SubmitCommandDriver extends AbstractCommandDriver {

	public SubmitCommandDriver(TestContainer testContainer, WebDriver webDriver, CommandModel commandModel) throws CommandNotFoundException {
		super(testContainer, webDriver, commandModel);
		logger = LoggerFactory.getLogger(IsSelectedCommandDriver.class);
	}

	@Override
	public void execute() throws ElementNotFoundException {
		
		super.execute();
		
		WebElement webElement = findElement();
		
		webElement.submit();
		
	}

}
