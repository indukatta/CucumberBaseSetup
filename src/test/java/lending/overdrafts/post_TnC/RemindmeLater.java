package lending.overdrafts.post_TnC;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static com.factory.mobile.driver.AppiumDriverManager.*;

public class RemindmeLater {
	public static String remindMeTitle;
	public static String remindMeHeading;
	public static String remindMeSubHeading;
	public static String yesRemindMeLater;
	public static String noDeclineTheOffer;

	@Then("^verify that Remind me Later screen is visible$")
	public void verify_that_Remind_me_Later_screen_is_visible() {
		setStepName("Then");
		captureScreenshot();
		findByAny(remindMeTitle).isDisplayed();
	}

	@Given("^that user is on the Remind me Later screen$")
	public void that_user_is_on_the_Remind_me_Later_screen() {
		setStepName("Then");
		findByAny(remindMeTitle).isDisplayed();
	}

	@Then("^verify that remind me later title \"([^\"]*)\" is displayed$")
	public void verify_that_remind_me_later_title_is_displayed(String expected) {
		setStepName("Then");
		findByAny(remindMeTitle).verifyEqualsTo(expected);
	}
	
	@Then("^verify that remind me later heading \"([^\"]*)\" is displayed$")
	public void verify_that_remind_me_later_heading_is_displayed(String expected) {
		setStepName("Then");
		findByAny(remindMeHeading).verifyEqualsTo(expected);
	}

	@Then("^verify that remind me later sub heading \"([^\"]*)\" is displayed$")
	public void verify_that_remind_me_later_sub_heading_is_displayed(String expected) {
		setStepName("Then");
		findByAny(remindMeSubHeading).verifyEqualsTo(expected);
	}

	@Then("^verify that Yes remind me later button is displayed$")
	public void verify_that_Yes_remind_me_later_button_is_displayed() {
		setStepName("Then");
		findByAny(yesRemindMeLater).isDisplayed();
	}

	@Then("^verify that No decline the offer button is displayed$")
	public void verify_that_No_decline_the_offer_button_is_displayed() {
		setStepName("Then");
		findByAny(noDeclineTheOffer).isDisplayed();
	}

	@Then("^user clicks on No decline the offer button on screen$")
	public void click_on_No_decline_the_offer_button_on_screen() {
		setStepName("Then");
		findByAny(noDeclineTheOffer).as("No, decline the offer").click();
	}

	@Then("^user clicks on Yes remind me later button on screen$")
	public void click_on_Yes_remind_me_later_button_on_screen() {
		setStepName("Then");
		findByAny(yesRemindMeLater).isDisplayed();
	}
}
