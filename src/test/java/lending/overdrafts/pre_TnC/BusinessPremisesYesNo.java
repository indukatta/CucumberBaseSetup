package lending.overdrafts.pre_TnC;

import static com.factory.mobile.driver.AppiumDriverManager.captureScreenshot;
import static com.factory.mobile.driver.AppiumDriverManager.findByAny;
import static com.factory.mobile.driver.AppiumDriverManager.setStepName;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import lending.common.library.CommonLibrary;
import lending.common.library.CommonStepDefinitions;

public class BusinessPremisesYesNo extends CommonLibrary {

	@Then("^verify that Business Premises YesNo screen is displayed$")
	public void verify_that_Business_Premises_YesNo_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot("BusinessPremisesYesNo");
		findByAny(CommonStepDefinitions.screenTitle).isDisplayed();
		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();
	}

	@Given("^that user is on Business Premises YesNo screen$")
	public void that_user_is_on_Business_Premises_YesNo_screen() {
		setStepName("Given");
		findByAny(CommonStepDefinitions.screenTitle).isDisplayed();
		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();	
	}

	@Then("^verify that Business Premises header \"([^\"]*)\" is displayed$")
	public void verify_that_Business_Premises_header_is_displayed(String expected) {
		setStepName("Then");
		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();
	}

}
