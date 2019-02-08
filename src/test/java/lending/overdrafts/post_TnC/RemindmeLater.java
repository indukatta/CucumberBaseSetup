package lending.overdrafts.post_TnC;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static com.factory.mobile.driver.AppiumDriverManager.*;

public class RemindmeLater {
	public static String remindMeScreen;
	public static String finalOfferLogo;
	public static String finalOfferSummary;
	public static String finalOfferRateAndFee;
	public static String finalOfferContinue;
	public static String finalOfferNotNow;

	@Then("^verify that Remind me Later screen is visible$")
	public void verify_that_Remind_me_Later_screen_is_visible() {
		setStepName("Then");
//		findByAny(element)
	}

	@Given("^that user is on the Remind me Later screen$")
	public void that_user_is_on_the_Remind_me_Later_screen() {

	}

	@Then("^verify that remind me later summay \"([^\"]*)\" is displayed$")
	public void verify_that_remind_me_later_summay_is_displayed(String arg1) {

	}

	@Then("^verify that remind me later description \"([^\"]*)\" is displayed$")
	public void verify_that_remind_me_later_description_is_displayed(String arg1) {

	}

	@Then("^verify that Yes remind me later button is displayed$")
	public void verify_that_Yes_remind_me_later_button_is_displayed() {

	}

	@Then("^verify that NO decline the offer button is displayed$")
	public void verify_that_NO_decline_the_offer_button_is_displayed() {

	}

	@Then("^user clicks on No decline the offer button on screen$")
	public void click_on_No_decline_the_offer_button_on_screen() {

	}

	@Then("^verify that Decline Offer screen is displayed$")
	public void verify_that_Decline_Offer_screen_is_displayed() {

	}

	@Then("^user clicks on Yes remind me later button on screen$")
	public void click_on_Yes_remind_me_later_button_on_screen() {

	}
}
