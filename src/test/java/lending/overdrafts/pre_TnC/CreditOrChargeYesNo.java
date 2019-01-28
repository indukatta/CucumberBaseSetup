package lending.overdrafts.pre_TnC;

import static com.factory.mobile.driver.AppiumDriverManager.captureScreenshot;
import static com.factory.mobile.driver.AppiumDriverManager.findByAny;
import static com.factory.mobile.driver.AppiumDriverManager.setStepName;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CreditOrChargeYesNo {
	@Then("^verify that Credit or Charge Card YesNo screen is displayed$")
	public void verify_that_Credit_or_Charge_Card_YesNo_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot("CreditOrChargeYesNo");
		findByAny(CommonStepDefinitions.screenTitle).isDisplayed();
		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();
	}

	@Given("^that user is on Credit or Charge Card YesNo screen$")
	public void that_user_is_on_Credit_or_Charge_Card_YesNo_screen() {
		setStepName("Given");
		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();
	}

	@Then("^verify that Credit or Charge Card YesNo question \"([^\"]*)\" is displayed$")
	public void verify_that_Credit_or_Charge_Card_YesNo_question_is_displayed(String expected) {
		setStepName("Then");
		findByAny(CommonStepDefinitions.screenQuestion).verifyEqualsTo(expected);
	}
}
