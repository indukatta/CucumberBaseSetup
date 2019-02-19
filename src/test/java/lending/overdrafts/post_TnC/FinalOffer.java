package lending.overdrafts.post_TnC;

import static com.factory.mobile.driver.AppiumDriverManager.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class FinalOffer {

	public static String finalOfferLogo;
	public static String finalOfferHeading;
	public static String finalOfferAmt;
	public static String finalOfferFee;
	public static String finalOfferAIR;
	public static String finalOfferContinue;
	public static String finalOfferNotNow;
	
	@Then("^verify that the Final Offer screen is displayed$")
	public void verify_that_the_Final_Offer_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot();
		findByAny(finalOfferHeading).waitUntillVisible().isDisplayed();
	}

	@Given("^that user is on the Final Offer screen$")
	public void that_user_is_on_the_Final_Offer_screen() {
		setStepName("Given");
		findByAny(finalOfferHeading).isDisplayed();
	}

	@Then("^verify that logo is displayed on Final Offer screen$")
	public void verify_that_logo_is_displayed_on_Final_Offer_screen() {
		setStepName("Then");
		findByAny(finalOfferLogo).isDisplayed();
	}

	@Then("^verify that final offer heading \"([^\"]*)\" is displayed$")
	public void verify_that_final_offer_heading_is_displayed(String expected) {
		setStepName("Then");
		findByAny(finalOfferHeading).verifyEqualsTo(expected);
	}

	@Then("^verify that offered overdraft amount is displayed$")
	public void verify_that_offered_overdraft_amount_is_displayed() {
		setStepName("Then");
		findByAny(finalOfferAmt);
	}
	
	@Then("^verify that offered overdraft amount \"([^\"]*)\" is displayed$")
	public void verify_that_offered_overdraft_amount_is_displayed(String expected) throws Throwable {
		setStepName("Then");
		findByAny(finalOfferAmt).verifyEqualsTo(expected);
	}

	@Then("^verify that daily and monthly fee \"([^\"]*)\" is displayed$")
	public void verify_that_daily_and_monthly_fee_are_displayed(String expected) {
		setStepName("Then");
		findByAny(finalOfferFee).verifyEqualsTo(expected);
	}

	@Then("^verify that annual interest rate \"([^\"]*)\" is displayed$")
	public void verify_that_annual_rate_is_displayed(String expected) {
		setStepName("Then");
		findByAny(finalOfferAIR).verifyEqualsTo(expected);
	}

	@Then("^verify that Continue with overdraft button is pre selected$")
	public void verify_that_Continue_with_overdraft_button_is_displayed() {
		setStepName("Then");
		findByAny(finalOfferContinue).isDisplayed();
	}

	@Then("^verify that Not Now button is not pre selected$")
	public void verify_that_Not_Now_button_is_displayed() {
		setStepName("Then");
		findByAny(finalOfferNotNow).isDisplayed();
	}

	@Then("^user clicks on Continue with overdraft button on Final Offer$")
	public void user_clicks_on_Continue_with_overdraft_button_on_Final_Offer() {
		setStepName("Then");
		findByAny(finalOfferContinue).click();
	}

	@Then("^user clicks on Not Now button on Final Offer$")
	public void user_clicks_on_Not_Now_button_on_Final_Offer() {
		setStepName("Then");
		findByAny(finalOfferNotNow).click();
	}
}
