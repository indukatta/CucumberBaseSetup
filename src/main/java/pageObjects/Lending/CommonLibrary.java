package pageObjects.Lending;

import static com.factory.mobile.driver.MobileDriverManager.*;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import gherkin.formatter.model.Scenario;

public class CommonLibrary {

	@Before
	public void startTestReport(Scenario scenario) {
		startTest(scenario.getName());
	}
	
	@After
	public void endTestReport(Scenario scenario) {
		endTest();
	}
	
}
