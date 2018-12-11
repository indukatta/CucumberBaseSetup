package lending.overdrafts.pre_TnC;

import static com.factory.mobile.driver.MobileDriverManager.captureScreenshot;
import static com.factory.mobile.driver.MobileDriverManager.findByAny;
import static com.factory.mobile.driver.MobileDriverManager.setStepName;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BusinessPremisesYesNo extends CommonLibrary {
	public static String screenTitle;
	public static String screenQuestion;
	public static String bpYes;
	public static String bpNo;

	@Then("^verify that Business Premises YesNo screen is displayed$")
	public void verify_that_Business_Premises_YesNo_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot("BusinessPremisesYesNo_0");
		findByAny(screenTitle).isDisplayed();
		findByAny(screenQuestion).isDisplayed();
	}

	@Given("^that user is on Business Premises YesNo screen$")
	public void that_user_is_on_Business_Premises_YesNo_screen() {
		setStepName("Given");
		findByAny(screenTitle).isDisplayed();
		findByAny(screenQuestion).isDisplayed();	
	}

	@Then("^verify that Business Premises header \"([^\"]*)\" is displayed$")
	public void verify_that_Business_Premises_header_is_displayed(String expected) {
		setStepName("Then");
		findByAny(screenQuestion).isDisplayed();
	}

}
