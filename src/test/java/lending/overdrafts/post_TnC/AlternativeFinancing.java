package lending.overdrafts.post_TnC;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import lending.common.library.CommonLibrary;
import lending.common.library.CommonStepDefinitions;

import static com.factory.mobile.driver.AppiumDriverManager.*;

public class AlternativeFinancing extends CommonLibrary {

	public static String findOutMore = "//XCUIElementTypeLink[@name=\"Find out more\"]";

	@Then("^verify that Alternative Financing screen is visible$")
	public void verify_that_Alternative_Financing_screen_is_visible() {
		setStepName("Then");
		captureScreenshot();
		findByAny(CommonStepDefinitions.lendingPrimaryButton).as("I consent").scrollDownUntilVisible().isDisplayed();
	}

	@Then("^user clicks on I Consent on Financial Alternative screen$")
	public void user_clicks_on_I_Consent_on_Financial_Alternative_screen() {
		setStepName("Then");
		findByAny(CommonStepDefinitions.lendingPrimaryButton).as("I consent on Alternative Financing")
				.scrollDownUntilVisible().click();
	}

	@Then("^user clicks on Not Now on Financial Alternative screen$")
	public void user_clicks_on_Not_Now_on_Financial_Alternative_screen() {
		setStepName("Then");
		findByAny(CommonStepDefinitions.lendingSecondaryButton).as("Not Now on Alternative Financing")
				.scrollDownUntilVisible().click();
	}

	@Then("^verify that alert button Ok got it is displayed on the screen$")
	public void verify_that_alert_button_Ok_got_it_is_displayed_on_the_screen() {
		setStepName("Then");
		captureScreenshot();
		findByAny(DeclineOffer.alertPrimaryButton).as("Ok, got it").isDisplayed();
	}

	@Then("^verify that alert image is displayed on the screen$")
	public void verify_that_alert_image_is_displayed_on_the_screen() throws Throwable {
		setStepName("Then");
		findByAny(DeclineOffer.alertImageView).isDisplayed();

	}

	@Then("^verify that alert title \"([^\"]*)\" is displayed on the screen$")
	public void verify_that_alert_title_is_displayed_on_the_screen(String arg1) throws Throwable {
		setStepName("Then");
		findByAny(DeclineOffer.alertTitleLabel).verifyEqualsTo(arg1);
	}

	@Then("^verify that alert body \"([^\"]*)\" is displayed on the screen$")
	public void verify_that_alert_body_is_displayed_on_the_screen(String arg1) throws Throwable {
		setStepName("Then");
		findByAny(DeclineOffer.alertBodyLabel).verifyEqualsTo(arg1);
	}

	@Then("^user clicks on Ok got it button on alert screen$")
	public void user_clicks_on_Ok_got_it_button_on_alert_screen() throws Throwable {
		setStepName("Then");
		findByAny(DeclineOffer.alertPrimaryButton).as("Ok, got it").click();
		sleep(2500);
	}
	
	@Given("^that user is on Alternative financing screen$")
	public void that_user_is_on_Alternative_financing_screen() throws Throwable {
		setStepName("Then");
		findByAny(CommonStepDefinitions.lendingPrimaryButton).as("I consent").isDisplayed();
	}

	@Then("^verify that the heading label \"([^\"]*)\" is displayed on screen$")
	public void verify_that_the_heading_label_is_displayed_on_screen(String arg1) throws Throwable {
		setStepName("Then");
		findByAny(ProductTermsAndConditions.tncHeading).as("Alternative Financing Heading").verifyEqualsTo(arg1);
	}

	@Then("^verify that the web view component is displayed on the screen$")
	public void verify_that_the_alternative_financing_content_web_view_displayed_on_the_screen() throws Throwable {
		setStepName("Then");
		findByAny(ProductTermsAndConditions.tncContentWebView).as("Alternative Financing Web View").isDisplayed();
	}

	@Then("^verify that find out more hyperlink is displayed on the screen$")
	public void verify_that_find_out_more_hyperlink_is_displayed_on_the_screen() throws Throwable {
		setStepName("Then");
		findByXpath(findOutMore).isDisplayed();
	}

	@Then("^user clicks on find out more link on Alternative Financing screen$")
	public void user_clicks_on_find_out_more_link_on_Alternative_Financing_screen() throws Throwable {
		setStepName("Then");
		application().scrollUp();
		findByXpath(findOutMore).click();
		sleep(4000);
		captureScreenshot();
	}

	@Then("^verify that web view with done button is opened on the screen$")
	public void verify_that_web_view_with_done_button_is_opened_on_the_screen() throws Throwable {
		setStepName("Then");
		findByAny(CommonStepDefinitions.webViewDone).isDisplayed();
	}

	@Then("^verify that I consent button is disabled on the Alternative financing screen$")
	public void verify_that_I_consent_button_is_disabled_on_the_Alternative_financing_screen() throws Throwable {
		setStepName("Then");
		findByAny(CommonStepDefinitions.lendingPrimaryButton).as("I consent").isDisabled();
	}

	@Then("^verify that I consent button is enabled on the Alternative financing screen$")
	public void verify_that_I_consent_button_is_enabled_on_the_Alternative_financing_screen() throws Throwable {
		setStepName("Then");
		findByAny(CommonStepDefinitions.lendingPrimaryButton).scrollDownUntilVisible().as("I consent").isEnabled();
	}

	@Then("^verify that Not now button is enabled on the Alternative finanging  screen$")
	public void verify_that_Not_now_button_is_enabled_on_the_Alternative_finanging_screen() throws Throwable {
		setStepName("Then");
		findByAny(CommonStepDefinitions.lendingSecondaryButton).scrollDownUntilVisible().as("Not now").isEnabled();
	}

}
