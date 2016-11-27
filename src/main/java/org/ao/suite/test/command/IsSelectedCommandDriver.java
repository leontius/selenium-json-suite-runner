package org.ao.suite.test.command;

import org.ao.suite.ObjectContainer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;

public class IsSelectedCommandDriver extends AbstractCommandDriver {

	public IsSelectedCommandDriver(ObjectContainer objectContainer, WebDriver webDriver, CommandModel commandModel) throws CommandNotFoundException {
		super(objectContainer, webDriver, commandModel);
		logger = LoggerFactory.getLogger(IsSelectedCommandDriver.class);
	}

	@Override
	public void execute() throws ElementNotFoundException {
		super.execute();
		logger.debug("executing {} - {}", getCommand(), getArgs());
		WebElement webElement = findElement();
		//commandModel.setValue(String.valueOf(webElement.isSelected()));
		logger.debug("executed {} - {} - {}", getCommand(), getArgs(), getValue());
	}

}
