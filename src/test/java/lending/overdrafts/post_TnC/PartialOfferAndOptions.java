package lending.overdrafts.post_TnC;

import static com.factory.mobile.driver.AppiumDriverManager.captureScreenshot;
import static com.factory.mobile.driver.AppiumDriverManager.findByAny;
import static com.factory.mobile.driver.AppiumDriverManager.setStepName;

import cucumber.api.java.en.Given;
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

	@Given("^that user is on the Partial Offer screen$")
	public void that_user_is_on_the_Partial_Offer_screen() throws Throwable {
		setStepName("Given");
	}

	@Then("^verify that logo is displayed on Partial Offer screen$")
	public void verify_that_logo_is_displayed_on_Partial_Offer_screen() throws Throwable {
		setStepName("Then");
	}

	@Then("^verify that partial offer heading \"([^\"]*)\" is displayed$")
	public void verify_that_partial_offer_heading_is_displayed(String arg1) throws Throwable {
		setStepName("Then");
	}

	@Then("^verify that partial offer message \"([^\"]*)\" is displayed$")
	public void verify_that_partial_offer_message_is_displayed(String arg1) throws Throwable {
		setStepName("Then");
	}

	@Then("^verify that partial offer explanation \"([^\"]*)\" is displayed$")
	public void verify_that_partial_offer_explanation_is_displayed(String arg1) throws Throwable {
		setStepName("Then");
	}

	@Then("^retrieve and save offered amount from Partial Offer screen$")
	public void retrieve_and_save_offered_amount_from_Partial_Offer_screen() throws Throwable {
		setStepName("Then");
	}

	@Then("^verify that see my options button is enabled on Partial Offer screen$")
	public void verify_that_see_my_options_button_is_enabled_on_Partial_Offer_screen() throws Throwable {
		setStepName("Then");
	}

	@Then("^user clicks on See my options button on Partial Offer screen$")
	public void user_clicks_on_See_my_options_button_on_Partial_Offer_screen() throws Throwable {
		setStepName("Then");
	}

	@Then("^verify that Partial Offer options screen is visible$")
	public void verify_that_Partial_Offer_options_screen_is_visible() throws Throwable {
		setStepName("Then");
	}

	@Then("^verify that refer the decision heading \"([^\"]*)\" is displayed on screen$")
	public void verify_that_refer_the_decision_heading_is_displayed_on_screen(String arg1) throws Throwable {
		setStepName("Then");
	}

	@Then("^verify that refer the decision description \"([^\"]*)\" is displayed on screen$")
	public void verify_that_refer_the_decision_description_is_displayed_on_screen(String arg1) throws Throwable {
		setStepName("Then");
	}

	@Then("^verify that contact us for referral \"([^\"]*)\" is diaplayed on the screen$")
	public void verify_that_contact_us_for_referral_is_diaplayed_on_the_screen(String arg1) throws Throwable {
		setStepName("Then");
	}

	@Then("^verify that accept overdraft heading \"([^\"]*)\" is displayed on screen$")
	public void verify_that_accept_overdraft_heading_is_displayed_on_screen(String arg1) throws Throwable {
		setStepName("Then");
	}

	@Then("^verify that accept overdraft description \"([^\"]*)\" is displayed on screen$")
	public void verify_that_accept_overdraft_description_is_displayed_on_screen(String arg1) throws Throwable {
		setStepName("Then");
	}

	@Then("^verify that proceed with overdraft \"([^\"]*)\" is diaplayed on the screen$")
	public void verify_that_proceed_with_overdraft_is_diaplayed_on_the_screen(String arg1) throws Throwable {
		setStepName("Then");
	}

	@Then("^verify that decline overdraft heading \"([^\"]*)\" is displayed on screen$")
	public void verify_that_decline_overdraft_heading_is_displayed_on_screen(String arg1) throws Throwable {
		setStepName("Then");
	}

	@Then("^verify that decline overdraft description \"([^\"]*)\" is displayed on screen$")
	public void verify_that_decline_overdraft_description_is_displayed_on_screen(String arg1) throws Throwable {
		setStepName("Then");
	}

	@Then("^verify that decline offer \"([^\"]*)\" is diaplayed on the screen$")
	public void verify_that_decline_offer_is_diaplayed_on_the_screen(String arg1) throws Throwable {
		setStepName("Then");
	}

	@Given("^that user is on the Partial Offer options screen$")
	public void that_user_is_on_the_Partial_Offer_options_screen() throws Throwable {
		setStepName("Then");
	}

	@Then("^user clicks on Acept Overdraft CTA on the screen$")
	public void user_clicks_on_Acept_Overdraft_CTA_on_the_screen() throws Throwable {
		setStepName("Then");
	}

	@Then("^user clicks on Decline Overdraft CTA on the screen$")
	public void user_clicks_on_Decline_Overdraft_CTA_on_the_screen() throws Throwable {
		setStepName("Then");
	}

}
