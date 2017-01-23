package org.ao.suite.aspect;

import org.ao.suite.SuiteDriver;
import org.ao.suite.test.command.AbstractCommandDriver;
import org.ao.suite.test.command.model.CommandModel;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CommandDriverAspect {
        
        @Pointcut("execution(* org.ao.suite.test.command.*.execute(..))")
        public void commandExecute() {}

	@Around("commandExecute() && args(commandModel, suiteDriver)")
	@Order(0)
	public Object replaceCommandModelObject(ProceedingJoinPoint jp, CommandModel commandModel, 
	                SuiteDriver suiteDriver) 
	                throws Throwable {
		
		AbstractCommandDriver acd = (AbstractCommandDriver)jp.getTarget();
		
		acd.getLogger().debug("AROUND-ASPECT: executing {}", commandModel);
		
		CommandModel repCommandModel = new CommandModel(){
			{ 
				setCommand(commandModel.getCommand());
				setArgs(commandModel.getArgs());
				setValue(commandModel.getValue());
				}
			};
		if (commandModel.getArgs() != null)
			repCommandModel.setArgs(acd.getArgs(commandModel));
		if (commandModel.getValue() != null)
			repCommandModel.setValue(acd.getValue(commandModel));
		
		acd.getLogger().debug("AROUND-ASPECT: command-parameter replaced {}", repCommandModel);
		
		Object returnObject = jp.proceed(new Object[]{repCommandModel, suiteDriver});
		
		acd.getLogger().debug("AROUND-ASPECT: command-parameter returned {}", repCommandModel);
		
		if (commandModel.getValue() != null) {
			String value = commandModel.getValue().toString();
			if (suiteDriver.getObjectContainer().containsVariable(value)) {
				String varName = suiteDriver.getObjectContainer().getVariableName(value);
				// value can only a variable name if we want to save the returned value
				if (value.equals("${" + varName + "}")) { 
					suiteDriver.getObjectContainer().putVariable(varName, repCommandModel.getValue());	
				}
			}
		}
		
		acd.getLogger().debug("AROUND-ASPECT: executed {}", commandModel);
		
		return returnObject;
		
	}
	
	@Around("commandExecute() && args(commandModel, suiteDriver)")
        @Order(1)
        public Object reportCommandExecute(ProceedingJoinPoint jp, CommandModel commandModel, SuiteDriver suiteDriver) 
                        throws Throwable {
                
                Object retVal = null;
                
                try {
                        retVal = jp.proceed();
                        
                        return retVal;
                }
                catch(Exception ex) {
                        
                        throw ex;
                }
                
                
        }

}
