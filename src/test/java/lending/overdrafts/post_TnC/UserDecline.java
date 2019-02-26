package lending.overdrafts.post_TnC;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import lending.overdrafts.pre_TnC.CommonLibrary;

import static com.factory.mobile.driver.AppiumDriverManager.*;

public class UserDecline extends CommonLibrary {
	public static String userDeclineTitle;
	public static String userDeclineWhatNext;
	public static String userDeclineOptions;
	public static String userDeclineConsider;
	public static String userDeclineConsiderDesc;
	public static String userDeclineAppeal;
	public static String userDeclineAppealDesc;
	public static String userDeclineNotNow;

	@Then("^verify that User Decline screen is displayed$")
	public void verify_that_User_Decline_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot();
		findByAny(userDeclineTitle).isDisplayed();
	}
	
	@Given("^that user is on User Decline screen$")
	public void that_user_is_on_User_Decline_screen() {
		setStepName("Given");
		findByAny(userDeclineTitle).isDisplayed();
	}

	@Then("^verify that title \"([^\"]*)\" on User Decline screen is displayed$")
	public void verify_that_title_on_User_Decline_screen_is_displayed(String expected) {
		setStepName("Given");
		findByAny(userDeclineTitle).verifyEqualsTo(expected);
	}

	@Then("^verify that what next \"([^\"]*)\" is displayed$")
	public void verify_that_what_next_is_displayed(String expected) {
		setStepName("Given");
		findByAny(userDeclineWhatNext).verifyEqualsTo(expected);
	}

	@Then("^verify that decline options \"([^\"]*)\" is displayed$")
	public void verify_that_decline_options_is_displayed(String expected) {
		setStepName("Given");
		findByAny(userDeclineOptions).verifyEqualsTo(expected);
	}

	@Then("^verify that consider alternative text \"([^\"]*)\" is displayed$")
	public void verify_that_consider_alternative_text_is_displayed(String expected) {
		setStepName("Given");
		findByAny(userDeclineConsider).verifyEqualsTo(expected);
	}

	@Then("^verify that consider alternative desc \"([^\"]*)\" is displayed$")
	public void verify_that_consider_alternative_desc_is_displayed(String expected) {
		setStepName("Given");
		findByAny(userDeclineConsiderDesc).verifyEqualsTo(expected);
	}

	@Then("^verify that appeal decision text \"([^\"]*)\" is displayed$")
	public void verify_that_appeal_decision_text_is_displayed(String expected) {
		setStepName("Given");
		findByAny(userDeclineAppeal).verifyEqualsTo(expected);
	}

	@Then("^verify that appeal decision desc \"([^\"]*)\" is displayed$")
	public void verify_that_appeal_decision_desc_is_displayed(String expected) {
		setStepName("Given");
		findByAny(userDeclineAppealDesc).verifyEqualsTo(expected);
	}

	@Then("^verify that Not Not button is displayed on User Decline screen$")
	public void verify_that_Not_Not_button_is_displayed_on_User_Decline_screen() {
		setStepName("Given");
		findByAny(userDeclineNotNow).isDisplayed();
	}
}
