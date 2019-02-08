package lending.overdrafts.post_TnC;

import static com.factory.mobile.driver.AppiumDriverManager.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class FinalOffer {
	public static String finalOfferAmt;
	public static String finalOfferLogo;
	public static String finalOfferSummary;
	public static String finalOfferRateAndFee;
	public static String finalOfferContinue;
	public static String finalOfferNotNow;
	
	@Then("^verify that the Final Offer screen is displayed$")
	public void verify_that_the_Final_Offer_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot("TermsAndConditions");
		findByAny(finalOfferSummary).isDisplayed();
	}

	@Given("^that user is on the Final Offer screen$")
	public void that_user_is_on_the_Final_Offer_screen() {
		setStepName("Given");
		findByAny(finalOfferSummary).isDisplayed();
	}

	@Then("^verify that logo is displayed on Final Offer screen$")
	public void verify_that_logo_is_displayed_on_Final_Offer_screen() {
		setStepName("Then");
		findByAny(finalOfferLogo).isDisplayed();
	}

	@Then("^verify that final offer summary \"([^\"]*)\" is displayed$")
	public void verify_that_final_offer_summary_is_displayed(String expected) {
		setStepName("Then");
		findByAny(finalOfferSummary).verifyEqualsTo(expected);
	}

	@Then("^verify that offered overdraft amount is displayed$")
	public void verify_that_offered_overdraft_amount_is_displayed() {
		setStepName("Then");
		findByAny(finalOfferAmt);
	}

	@Then("^verify that daily and monthly fee \"([^\"]*)\" is displayed$")
	public void verify_that_daily_and_monthly_fee_are_displayed(String expected) {
		setStepName("Then");
		findByAny(finalOfferRateAndFee).verifyContains(expected);
	}

	@Then("^verify that annual rate \"([^\"]*)\" is displayed$")
	public void verify_that_annual_rate_is_displayed(String expected) {
		setStepName("Then");
		findByAny(finalOfferRateAndFee).verifyContains(expected);
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
