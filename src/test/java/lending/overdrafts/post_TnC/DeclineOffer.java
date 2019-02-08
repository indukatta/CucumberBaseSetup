package lending.overdrafts.post_TnC;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static com.factory.mobile.driver.AppiumDriverManager.*;

public class DeclineOffer {
	public static String screenHeader;
	
	@Then("^verify that Decline Offer screen is visible$")
	public void verify_that_Decline_Offer_screen_is_visible() {
		setStepName("Then");
		captureScreenshot("DeclineOffer");
		findByAny(screenHeader).isAlertPresent();
	}

	@Given("^that user is on the Decline Offer screen$")
	public void that_user_is_on_the_Decline_Offer_screen() {
		setStepName("Given");
		findByAny(screenHeader).isAlertPresent();
	}

	@Then("^verify that Decline Offer summay \"([^\"]*)\" is displayed$")
	public void verify_that_Decline_Offer_summay_is_displayed(String expected) {
		setStepName("Then");
		verify(alertGetText()).equalsTo(expected);
	}

	@Then("^click on No button on Decline Offer screen$")
	public void click_on_No_button_on_Decline_Offer_screen() {
		setStepName("Then");
		alertDismiss();
	}

	@Then("^click on Yes button on Decline Offer screen$")
	public void click_on_Yes_button_on_Decline_Offer_screen() {
		setStepName("Then");
		alertAccept();
	}

	@Then("^verify that User Decline screen is displayed$")
	public void verify_that_User_Decline_screen_is_displayed() {
		setStepName("Then");
	}
	
}
