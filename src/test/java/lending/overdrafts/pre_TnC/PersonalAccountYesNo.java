package lending.overdrafts.pre_TnC;

import static com.factory.mobile.driver.AppiumDriverManager.captureScreenshot;
import static com.factory.mobile.driver.AppiumDriverManager.findByAny;
import static com.factory.mobile.driver.AppiumDriverManager.setStepName;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class PersonalAccountYesNo {

	@Then("^verify that Personal Account YesNo screen is displayed$")
	public void verify_that_Personal_Account_YesNo_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot("PersonalAccountYesNo");
		findByAny(CommonStepDefinitions.screenTitle).isDisplayed();
		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();
	}

	@Given("^that user is on Current Account YesNo screen$")
	public void that_user_is_on_Current_Account_YesNo_screen() {
		setStepName("Given");
		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();
	}

	@Then("^verify that Credit Card question \"([^\"]*)\" is displayed$")
	public void verify_that_Credit_Card_header_is_displayed(String expected) {
		setStepName("Then");
		findByAny(CommonStepDefinitions.screenQuestion).verifyEqualsTo(expected);
	}
	
	@Then("^verify that Personal Account question \"([^\"]*)\" is displayed$")
	public void verify_that_Personal_Account_question_is_displayed(String arg1) throws Throwable {
		setStepName("Then");
		findByAny(CommonStepDefinitions.screenQuestion).verifyEqualsTo(arg1);
	}
}
