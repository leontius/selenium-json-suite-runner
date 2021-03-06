package org.ao.suite.test.command.webelement;

import org.ao.suite.SuiteDriver;
import org.ao.suite.test.command.AbstractCommandDriver;
import org.ao.suite.test.command.exception.CommandInvalidArgumentException;
import org.ao.suite.test.command.model.CommandModel;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("getAttribute")
public class GetAttributeCommandDriver extends AbstractCommandDriver {
	
	public GetAttributeCommandDriver() {
		super(LoggerFactory.getLogger(GetAttributeCommandDriver.class));
	}
	
	@Override
	public void execute(CommandModel commandModel, SuiteDriver suiteDriver) 
			throws RuntimeException {
		
		if (commandModel.getArgs() == null || commandModel.getArgs().length < 2)
			throw new CommandInvalidArgumentException(commandModel.getCommand());
		
		WebElement webElement = findElement(commandModel.getArgs()[0], suiteDriver);
		commandModel.setValue(webElement.getAttribute(commandModel.getArgs()[1]));
	}

}
