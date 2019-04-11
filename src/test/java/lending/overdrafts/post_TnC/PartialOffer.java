package lending.overdrafts.post_TnC;

import static com.factory.mobile.driver.AppiumDriverManager.captureScreenshot;
import static com.factory.mobile.driver.AppiumDriverManager.findByAny;
import static com.factory.mobile.driver.AppiumDriverManager.setStepName;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lending.overdrafts.pre_TnC.CommonStepDefinitions;

public class PartialOffer {
	
	public static String partialOfferHeading = "partial_offer_option_heading_label_1";
	public static String partialOfferDescription = "partial_offer_option_description_label_1_0";
	public static String partialOfferContactUs = "partial_offer_option_icon_label_1";
	public static String partialOfferAcceptOD = "partial_offer_option_heading_label_2";
	public static String partialOfferAIR = "partial_offer_option_description_label_2_1";
	public static String partialOfferProceed = "partial_offer_option_icon_label_2";
	public static String partialOfferDeclineOD = "partial_offer_option_heading_label_3";
	public static String partialOfferDeclineDesc = "partial_offer_option_description_label_3_0";
	public static String partialOfferDeclineOffer = "partial_offer_option_icon_label_3";
	
	
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
		findByAny(partialOfferHeading).isDisplayed();
		findByAny(partialOfferHeading).verifyEqualsTo("Refer The Decision");
	}

	@When("^user clicks on Decline Offer CTA on the screen$")
	public void user_clicks_on_Decline_Offer_CTA_on_the_screen() {
		setStepName("Then");
		findByAny(partialOfferDeclineOffer).click();
	}

}
