package lending.overdrafts.post_TnC;

import static com.factory.mobile.driver.AppiumDriverManager.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import lending.common.library.CommonLibrary;
import lending.overdrafts.pre_TnC.CommonStepDefinitions;

public class FinalOffer extends CommonLibrary {

	public static String finalOfferLogo;
	public static String finalOfferHeading;
	public static String finalOfferAmt;
	public static String finalOfferFee;
	public static String finalOfferAIR;

	@Then("^verify that Final Offer screen is displayed$")
	public void verify_that_Final_Offer_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot();
		findByAny(finalOfferHeading).waitUntillVisible().isDisplayed();
	}

	@Given("^that user is on Final Offer screen$")
	public void that_user_is_on_Final_Offer_screen() {
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
		findByAny(finalOfferAmt).isDisplayed();
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
		findByAny(finalOfferAIR).verifyContains(expected);
	}
	
	@Then("^user clicks Annual Interest Rate icon on Final Offer$")
	public void user_clicks_Annual_Interest_Rate_icon_on_Final_Offer() {
		setStepName("Then");
		findByAny(finalOfferAIR).click();
	}

	@Then("^verify that Continue with overdraft button is pre selected$")
	public void verify_that_Continue_with_overdraft_button_is_displayed() {
		setStepName("Then");
		findByAny(CommonStepDefinitions.lendingPrimaryButton).as("Continue with overdraft").isDisplayed();
	}

	@Then("^verify that Not Now button is not pre selected$")
	public void verify_that_Not_Now_button_is_displayed() {
		setStepName("Then");
		findByAny(CommonStepDefinitions.lendingSecondaryButton).as("Final Offer's Not Now").isDisplayed();
	}

	@Then("^user clicks on Continue with overdraft button on Final Offer$")
	public void user_clicks_on_Continue_with_overdraft_button_on_Final_Offer() {
		setStepName("Then");
		findByAny(CommonStepDefinitions.lendingPrimaryButton).as("Continue with overdraft").click();
	}

	@Then("^user clicks on Not Now button on Final Offer$")
	public void user_clicks_on_Not_Now_button_on_Final_Offer() {
		setStepName("Then");
		findByAny(CommonStepDefinitions.lendingSecondaryButton).as("Final Offer's Not Now").click();
		sleep(2000);
	}

	@Then("^verify that selected suitable offer amount is displayed on Final Offer screen$")
	public void verify_that_selected_suitable_offer_amount_is_displayed_on_Final_Offer_screen() {
		setStepName("Then");
		captureScreenshot();
		findByAny(finalOfferAmt).verifyEqualsTo("£"+commaSeparatedNumber(persistentValue.get("sliderAmount"))+".00");
	}

	@Then("^verify that correct rate has been calculated on Final Offer screen$")
	public void verify_that_correct_rate_has_been_calculated_on_Final_Offer_screen() {
		setStepName("Then");
		findByAny(finalOfferFee).verifyContains(persistentValue.get("dailyFee"));
		findByAny(finalOfferFee).verifyContains(persistentValue.get("monthlyFee"));
	}

}
