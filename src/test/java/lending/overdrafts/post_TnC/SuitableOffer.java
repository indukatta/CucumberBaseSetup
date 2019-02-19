package lending.overdrafts.post_TnC;

import static com.factory.mobile.driver.AppiumDriverManager.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SuitableOffer {
	public static String suitableOfferLogo;
	public static String suitableOfferHeading;
	public static String suitableOfferMessage;
	public static String suitableOfferContinue;
	
	@Then("^verify that the Suitable Offer screen is displayed$")
	public void verify_that_the_Suitable_Offer_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot();
		findByAny(suitableOfferHeading).isDisplayed();
	}

	@Given("^that user is on the Suitable Offer screen$")
	public void that_user_is_on_the_Suitable_Offer_screen() {
		setStepName("Given");
		findByAny(suitableOfferHeading).isDisplayed();
	}

	@Then("^verify that logo is displayed on Suitable Offer screen$")
	public void verify_that_logo_is_displayed_on_Suitable_Offer_screen() {
		setStepName("Then");
		findByAny(suitableOfferLogo).isDisplayed();
	}

	@Then("^verify that suitable offer heading \"([^\"]*)\" is displayed$")
	public void verify_that_suitable_offer_heading_is_displayed(String expected) {
		setStepName("Then");
		findByAny(suitableOfferHeading).verifyEqualsTo(expected);
	}
	
	@Then("^verify that suitable offer message \"([^\"]*)\" is displayed$")
	public void verify_that_suitable_offer_message_is_displayed(String expected) {
		setStepName("Then");
		findByAny(suitableOfferMessage).verifyEqualsTo(expected);
	}

	@Then("^verify that Continue button on suitable offer is pre selected$")
	public void verify_that_Continue_with_overdraft_button_is_displayed() {
		setStepName("Then");
		findByAny(suitableOfferContinue).isDisplayed();
	}

	@Then("^user clicks on Continue button on Suitable Offer$")
	public void user_clicks_on_Continue_button_on_Suitable_Offer() {
		setStepName("Then");
		findByAny(suitableOfferContinue).click();
	}
}
