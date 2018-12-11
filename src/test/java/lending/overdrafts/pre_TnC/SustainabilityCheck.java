package lending.overdrafts.pre_TnC;

import static com.factory.mobile.driver.MobileDriverManager.captureScreenshot;
import static com.factory.mobile.driver.MobileDriverManager.findByAny;
import static com.factory.mobile.driver.MobileDriverManager.setStepName;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SustainabilityCheck {
	@Then("^verify that SustainabilityCheck screen is displayed$")
	public void verify_that_SustainabilityCheck_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot("SustainabilityCheck");
		findByAny(CommonStepDefinitions.screenTitle).isDisplayed();
		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();
	}

	@Given("^that user is on SustainabilityCheck screen$")
	public void that_user_is_on_SustainabilityCheck_screen() {
		setStepName("Given");
		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();
	}

	@Then("^verify that SustainabilityCheck question \"([^\"]*)\" is displayed$")
	public void verify_that_SustainabilityCheck_question_is_displayed(String expected) {
		setStepName("Then");
		findByAny(CommonStepDefinitions.screenQuestion).verifyEqualsTo(expected);
	}
}
