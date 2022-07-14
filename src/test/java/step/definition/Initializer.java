package step.definition;

import core.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Initializer extends Base {
	/*
	 * This class hosts two methods that will run before and after each scenario
	 * Cucumber has Hooks and we have BeforeHooks and AfterHooks
	 * Before Hooks executes a block of code before each scenario
	 * After Hooks executes a block of code after each scenario 
	 */
	
	//below method will run before each scenario
	@Before
	public void beforeHooks(Scenario scenario) {
		logger.info("Scenario " + scenario.getName() + " Started");
		selectBrowser();
		openBrowser();
	
	}

	//this will run after each scenario
	@After
	public void afterHooks(Scenario scenario) {
		driver.quit();
		logger.info("Scenario " + scenario.getName() + scenario.getStatus());
	}
}
