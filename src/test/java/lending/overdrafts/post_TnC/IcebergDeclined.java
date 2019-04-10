package lending.overdrafts.post_TnC;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import lending.common.library.CommonLibrary;

import static com.factory.mobile.driver.AppiumDriverManager.*;
import static com.factory.data.manager.Database.*;

public class IcebergDeclined extends CommonLibrary {
	public static String screenHeading = "custom_title_label";
	public static String firstLine = "lending_screen_custom_text_element_accessibility_id_0_0";
	public static String secondLine = "lending_screen_custom_text_element_accessibility_id_0_1";
	public static String thirdLine = "lending_screen_custom_text_element_accessibility_id_0_2";
	public static String textWhatCanYouDo = "lending_screen_custom_text_element_accessibility_id_0_3";
	public static String textAlternativeFinancing = "lending_screen_custom_text_element_accessibility_id_1_0";
	public static String textAppealDecision = "lending_screen_custom_text_element_accessibility_id_1_1";
	
	public static String nextButton;

	@Then("^verify that Iceberg Decline screen is displayed$")
	public void verify_that_Customer_Decline_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot();
		findByAny(screenHeading).isDisplayed();
	}

	@Given("^that user is on Iceberg Decline screen$")
	public void that_user_is_on_Customer_Decline_screen() {
		setStepName("Given");
		findByAny(screenHeading).isDisplayed();
	}

	@Then("^verify that first line of description \"([^\"]*)\" is displayed on screen$")
	public void verify_that_first_line_of_description_is_displayed_on_screen(String expected) {
		setStepName("Then");
		findByAccessibilityId(firstLine).verifyEqualsTo(expected);
	}

	@Then("^verify that second line of description \"([^\"]*)\" is displayed on screen$")
	public void verify_that_second_line_of_description_is_displayed_on_screen(String expected) {
		setStepName("Then");
		findByAccessibilityId(secondLine).verifyEqualsTo(expected);
	}

	@Then("^verify that Experian info \"([^\"]*)\" is displayed on screen$")
	public void verify_that_Experian_info_is_displayed_on_screen(String expected) {
		setStepName("Then");
		findByAccessibilityId(thirdLine).verifyEqualsTo(expected);
	}
	

	@Then("^verify that decline options \"([^\"]*)\" on Iceberg declined screen$")
	public void verify_that_decline_options_on_Iceberg_declined_screen(String expected) {
		setStepName("Given");
		findByAny(textWhatCanYouDo).verifyEqualsTo(expected);
	}

	@Then("^verify that consider alternative text \"([^\"]*)\" on Iceberg declined screen$")
	public void verify_that_consider_alternative_text_on_Iceberg_declined_screen(String expected) {
		setStepName("Given");
		findByAny(textAlternativeFinancing).verifyEqualsTo(expected);
	}

	@Then("^verify that appeal decision text \"([^\"]*)\" on Iceberg declined screen$")
	public void verify_that_appeal_decision_text_on_Iceberg_declined_screen(String expected) {
		setStepName("Given");
		findByAny(textAppealDecision).verifyEqualsTo(expected);
	}

	@Then("^verify that Next button is displayed on Iceberg Decline screen$")
	public void verify_that_Next_button_is_displayed_on_Iceberg_Decline_screen() {
		setStepName("Then");
		findByAccessibilityId(CustomerDeclined.nextButton).isDisplayed();
	}

	@Then("^user clicks on Next button on Iceberg decline screen$")
	public void user_clicks_on_Next_button_on_Iceberg_decline_screen() {
		setStepName("Then");
		findByAccessibilityId(CustomerDeclined.nextButton).click();
		sleep(2000);
	}
	
}
