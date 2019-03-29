package lending.overdrafts.post_TnC;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import lending.overdrafts.pre_TnC.CommonLibrary;

import static com.factory.mobile.driver.AppiumDriverManager.*;
import static com.factory.data.manager.Database.*;
public class CustomerDecline extends CommonLibrary {
	public static String userDeclineTitle;
	public static String userDeclineBody;
	public static String userDeclineWhatNext;
	public static String userDeclineOptions;
	public static String userDeclineConsider;
	public static String userDeclineConsiderDesc;
	public static String userDeclineAppeal;
	public static String userDeclineAppealDesc;
	public static String userDeclineNext;

	@Then("^verify that Customer Decline screen is displayed$")
	public void verify_that_Customer_Decline_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot();
		findByAny(userDeclineTitle).isDisplayed();
	}
	
	@Then("^verify that the Iceberg Decline screen is displayed$")
	public void verify_that_the_Iceberg_Decline_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot();
		findByAny(userDeclineBody).isDisplayed();
	}
	
	@Then("^verify that \"([^\"]*)\" decision is coming in PSE response$")
	public void verify_that_decision_is_comming_in_PSE_response(String decision) {
		setStepName("Then");
		String applicationID = fetchSingleValue("SELECT max(id) from application;");
		System.out.println("applicationID: "+applicationID);
		String pseDecision = fetchSingleValue("select psedecision from application where id = (SELECT max(id) from application);");
		verify(pseDecision).contains(decision);
	}
	@Given("^that user is on Customer Decline screen$")
	public void that_user_is_on_Customer_Decline_screen() {
		setStepName("Given");
		findByAny(userDeclineTitle).isDisplayed();
	}

	@Then("^verify that title \"([^\"]*)\" on User Decline screen is displayed$")
	public void verify_that_title_on_User_Decline_screen_is_displayed(String expected) {
		setStepName("Given");
		findByAny(userDeclineTitle).verifyEqualsTo(expected);
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

	@Then("^verify that Next button is displayed on User Decline screen$")
	public void verify_that_Next_button_is_displayed_on_User_Decline_screen() {
		setStepName("Given");
		findByAny(userDeclineNext).isDisplayed();
	}

	@Then("^user clicks on Next button on User decline screen$")
	public void user_clicks_on_Next_button_on_User_decline_screen() {
		reportFail("CustomerDecline");
	}
}
