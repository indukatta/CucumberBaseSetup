package lending.overdrafts.pre_TnC;

import static com.factory.mobile.driver.MobileDriverManager.captureScreenshot;
import static com.factory.mobile.driver.MobileDriverManager.findByAny;
import static com.factory.mobile.driver.MobileDriverManager.setStepName;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class DeclinedPaymentYesNo {
	public static String hintText = "lending_question_hint";

	@Then("^verify that Declined Payment YesNo screen is displayed$")
	public void verify_that_Declined_Payment_YesNo_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot("DeclinedPaymentYesNo");
		findByAny(CommonStepDefinitions.screenTitle).isDisplayed();
		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();
	}

	@Given("^that user is on Declined Payment YesNo screen$")
	public void that_user_is_on_Declined_Payment_YesNo_screen() {
		setStepName("Given");
		findByAny(CommonStepDefinitions.screenTitle).isDisplayed();
		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();
	}

	@Then("^verify that Declined Payment YesNo question \"([^\"]*)\" is displayed$")
	public void verify_that_Declined_Payment_YesNo_question_is_displayed(String expected) {
		setStepName("Then");
		findByAny(CommonStepDefinitions.screenQuestion).verifyEqualsTo(expected);
	}

	@Then("^verify that hint text \"([^\"]*)\" is displayed$")
	public void verify_that_hint_text_is_displayed(String expected) {
		setStepName("Then");
		findByAny(hintText).verifyEqualsTo(expected);
	}

}
