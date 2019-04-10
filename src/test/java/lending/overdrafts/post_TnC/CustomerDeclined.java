package lending.overdrafts.post_TnC;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import lending.common.library.CommonLibrary;

import static com.factory.mobile.driver.AppiumDriverManager.*;
import static com.factory.data.manager.Database.*;

public class CustomerDeclined extends CommonLibrary {
	public static String screenHeading = "custom_title_label";
	public static String textWhatCanYouDo = "lending_screen_custom_text_element_accessibility_id_0_0";
	public static String textAlternativeFinancing = "lending_screen_custom_text_element_accessibility_id_1_0";
	public static String textAppealDecision = "lending_screen_custom_text_element_accessibility_id_1_1";
	public static String nextButton = "lending_primary_button";

	@Then("^verify that Customer Decline screen is displayed$")
	public void verify_that_Customer_Decline_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot();
		findByAny(screenHeading).isDisplayed();
	}

	@Given("^that user is on Customer Decline screen$")
	public void that_user_is_on_Customer_Decline_screen() {
		setStepName("Given");
		findByAny(screenHeading).isDisplayed();
	}

	@Then("^verify that title \"([^\"]*)\" on User Decline screen is displayed$")
	public void verify_that_title_on_User_Decline_screen_is_displayed(String expected) {
		setStepName("Given");
		findByAny(screenHeading).verifyEqualsTo(expected);
	}

	@Then("^verify that decline options \"([^\"]*)\" is displayed$")
	public void verify_that_decline_options_is_displayed(String expected) {
		setStepName("Given");
		findByAny(textWhatCanYouDo).verifyEqualsTo(expected);
	}

	@Then("^verify that consider alternative text \"([^\"]*)\" is displayed$")
	public void verify_that_consider_alternative_text_is_displayed(String expected) {
		setStepName("Given");
		findByAny(textAlternativeFinancing).verifyEqualsTo(expected);
	}

	@Then("^verify that appeal decision text \"([^\"]*)\" is displayed$")
	public void verify_that_appeal_decision_text_is_displayed(String expected) {
		setStepName("Given");
		findByAny(textAppealDecision).verifyEqualsTo(expected);
	}

	@Then("^verify that Next button is displayed on User Decline screen$")
	public void verify_that_Next_button_is_displayed_on_User_Decline_screen() {
		setStepName("Given");
		findByAny(nextButton).isDisplayed();
	}

	@Then("^user clicks on Next button on User decline screen$")
	public void user_clicks_on_Next_button_on_User_decline_screen() {
		setStepName("Given");
		findByAny(nextButton).click();
		sleep(3000);
	}

	@Then("^verify that \"([^\"]*)\" decision is coming in PSE response$")
	public void verify_that_decision_is_comming_in_PSE_response(String decision) {
		setStepName("Then");
		String applicationID = fetchSingleValue("SELECT max(id) from application;");
		System.out.println("applicationID: " + applicationID);
		String pseDecision = fetchSingleValue(
				"select psedecision from application where id = (SELECT max(id) from application);");
		verify(pseDecision).contains(decision);
	}

}
