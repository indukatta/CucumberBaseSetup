package lending.overdrafts.post_TnC;

import static com.factory.mobile.driver.AppiumDriverManager.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import lending.common.library.CommonLibrary;

public class SuitableOffer extends CommonLibrary {
	
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
		findByAny(suitableOfferMessage).verifyContains(expected);
	}

	@Then("^verify that continue button is enabled on Suitable Offer screen$")
	public void verify_that_continue_button_is_enabled_on_Suitable_Offer_screen() {
		setStepName("Then");
		findByAny(suitableOfferContinue).isEnabled();
	}

	@Then("^verify that Continue button on suitable offer is pre selected$")
	public void verify_that_Continue_with_overdraft_button_is_displayed() {
		setStepName("Then");
		findByAny(suitableOfferContinue).isDisplayed();
	}
	
	@Then("^user clicks on continue button on Suitable Offer screen$")
	public void user_clicks_on_Continue_button_on_Suitable_Offer_screen() {
		setStepName("Then");
		findByAny(suitableOfferContinue).click();
		sleep(2000);
	}

	@Then("^retrieve and save offered amount from Suitable Offer screen$")
	public void retrieve_and_save_offered_amount_from_Suitable_Offer_screen() {
		String suitableOfferMsg = findByAny(suitableOfferMessage).getText().split("£")[1];
		System.out.println("Stored value for 'maxAmount' is "+ suitableOfferMsg);
		persistentValue.put("maxAmount", suitableOfferMsg);
	}
	
}
