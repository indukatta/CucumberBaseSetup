package lending.overdrafts.pre_TnC;

import static com.factory.mobile.driver.AppiumDriverManager.captureScreenshot;
import static com.factory.mobile.driver.AppiumDriverManager.findByAny;
import static com.factory.mobile.driver.AppiumDriverManager.setStepName;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class YearsOfPersonalAccount {
	@Then("^verify that Years of Personal Account screen is displayed$")
	public void verify_that_Years_of_Personal_Account_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot("YearsOfPersonalAccount");
		findByAny(CommonStepDefinitions.screenTitle).isDisplayed();
		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();
	}
}
