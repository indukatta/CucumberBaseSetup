package stepDefinitions.Lending;

import static com.factory.mobile.driver.MobileDriverManager.endTest;
import static com.factory.mobile.driver.MobileDriverManager.startTest;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CommonStepDefinitions extends CommonLibrary {

	@Before
	public void startTestReport(Scenario scenario) throws Exception {
		startTest(scenario.getName());
	}

	@After
	public void endTestReport(Scenario scenario) {
		endTest();
	}

}
