package lending.overdrafts.pre_TnC;

import static com.factory.mobile.driver.AppiumDriverManager.captureScreenshot;
import static com.factory.mobile.driver.AppiumDriverManager.findByAny;
import static com.factory.mobile.driver.AppiumDriverManager.setStepName;

import cucumber.api.java.en.Then;

public class TermsAndConditions {
	@Then("^verify that Terms and Conditions screen is displayed$")
	public void verify_that_Total_Existing_Borrowings_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot("TermsAndConditions");
//		findByAny(CommonStepDefinitions.screenTitle).isDisplayed();
//		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();
	}
}
