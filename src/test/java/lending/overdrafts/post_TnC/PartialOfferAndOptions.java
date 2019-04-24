package lending.overdrafts.post_TnC;

import static com.factory.mobile.driver.AppiumDriverManager.captureScreenshot;
import static com.factory.mobile.driver.AppiumDriverManager.findByAny;
import static com.factory.mobile.driver.AppiumDriverManager.setStepName;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lending.overdrafts.pre_TnC.CommonStepDefinitions;

public class PartialOfferAndOptions {
	
	public static String partialOfferExplanation = "offer_explanation_label";
	public static String partialOfferOptionsHeading = "partial_offer_option_heading_label_1";
	public static String partialOfferOptionsDescription = "partial_offer_option_description_label_1_0";
	public static String partialOfferOptionsContactUs = "partial_offer_option_icon_label_1";
	public static String partialOfferOptionsAcceptOD = "partial_offer_option_heading_label_2";
	public static String partialOfferOptionsAIR = "partial_offer_option_description_label_2_1";
	public static String partialOfferOptionsProceed = "partial_offer_option_icon_label_2";
	public static String partialOfferOptionsDeclineOD = "partial_offer_option_heading_label_3";
	public static String partialOfferOptionsDeclineDesc = "partial_offer_option_description_label_3_0";
	public static String partialOfferOptionsDeclineOffer = "partial_offer_option_icon_label_3";
	
	@Then("^verify that the Partial Offer screen is displayed$")
	public void verify_that_the_Partial_Offer_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot();
		findByAny(CommonStepDefinitions.lendingPrimaryButton).as("See my options").isDisplayed();
		findByAny(CommonStepDefinitions.lendingPrimaryButton).as("See my options").verifyEqualsTo("See my options");
	}

	@When("^user clicks on see my options button on the screen$")
	public void user_clicks_on_see_my_options_button_on_the_screen() {
		setStepName("Then");
		findByAny(CommonStepDefinitions.lendingPrimaryButton).as("See my options").click();
	}

	@Then("^verify that Partial Offer Options screen is displayed$")
	public void verify_that_Partial_Offer_Options_screen_is_displayed() {
		setStepName("Then");
		findByAny(partialOfferOptionsHeading).isDisplayed();
		findByAny(partialOfferOptionsHeading).verifyEqualsTo("Refer The Decision");
	}

	@When("^user clicks on Decline Offer CTA on the screen$")
	public void user_clicks_on_Decline_Offer_CTA_on_the_screen() {
		setStepName("Then");
		findByAny(partialOfferOptionsDeclineOffer).click();
	}
	
	@When("^user clicks on Accept Overdraft CTA on the screen$")
	public void user_clicks_on_Accept_Overdraft_CTA_on_the_screen() {
		setStepName("Then");
		findByAny(partialOfferOptionsAcceptOD).click();
	}

}
