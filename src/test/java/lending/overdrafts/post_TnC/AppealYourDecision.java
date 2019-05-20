package lending.overdrafts.post_TnC;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import lending.common.library.CommonLibrary;
import lending.common.library.CommonStepDefinitions;

import static com.factory.mobile.driver.AppiumDriverManager.*;

public class AppealYourDecision extends CommonLibrary {
	public static String findOutMore1 = "(//XCUIElementTypeLink[@name=\"Find out more\"])[1]";
	public static String findOutMore2 = "(//XCUIElementTypeLink[@name=\"Find out more\"])[2]";
	public static String referenceNumber = "//XCUIElementTypeStaticText[contains(@name, \"ICEBERG\")]";
	

	@Given("^that user is on Appeal your decision screen$")
	public void that_user_is_on_Appeal_your_decision_screen() throws Throwable {
		setStepName("Then");
		findByAny(ProductTermsAndConditions.tncHeading).as("Appeal Decision Heading")
		.verifyEqualsTo("Appeal your decision");
	}

	@Then("^verify that the correnct reference number is displayed on the screen$")
	public void verify_that_the_correnct_reference_number_is_displayed_on_the_screen() throws Throwable {
		setStepName("Then");
		findByXpath(referenceNumber).verifyContains("ICEBERG"+applicationID);
	}

	@Then("^verify that the Ok got it button is enabled on the screen$")
	public void verify_that_the_Ok_got_it_button_is_enabled_on_the_screen() throws Throwable {
		setStepName("Then");
		application().scrollDown();
		findByAny(CommonStepDefinitions.lendingPrimaryButton).as("OK, got it").isEnabled();
	}

	@Then("^user clicks on first find out more link on Appeal your decision screen$")
	public void user_clicks_on_first_find_out_more_link_on_Appeal_your_decision_screen() throws Throwable {
		setStepName("Then");
		application().scrollUp();
		findByXpath(findOutMore1).click();
		sleep(4000);
		captureScreenshot();
	}

	@Then("^user clicks on second find out more link on Appeal your decision screen$")
	public void user_clicks_on_second_find_out_more_link_on_Appeal_your_decision_screen() throws Throwable {
		setStepName("Then");
		application().scrollDown();
		findByXpath(findOutMore2).click();
		sleep(4000);
		captureScreenshot();
	}

	@Then("^verify that Appeal your Decision screen is visible$")
	public void verify_that_Appeal_your_Decision_screen_is_visible() {
		setStepName("Then");
		captureScreenshot();
		findByAny(ProductTermsAndConditions.tncHeading).as("Appeal Decision Heading")
				.verifyEqualsTo("Appeal your decision");
	}

	@Then("^user clicks on Ok got it on Appleal your Decision screen$")
	public void user_clicks_on_Ok_got_it_on_Appleal_your_Decision_screen() {
		setStepName("Then");
		findByAny(CommonStepDefinitions.lendingPrimaryButton).scrollDownUntilVisible().as("Ok got it on Appeal")
				.click();
		sleep(1000);
	}

	@Then("^user navigate from decline screen to homescreen with Consent on Alternative Financing$")
	public void user_navigate_from_decline_screen_to_homescreen_with_Consent_on_Alternative_Financing()
			throws Throwable {
		setStepName("Then");
		findByAny(CommonStepDefinitions.lendingPrimaryButton).as("Next on Iceberg Decline").click();
		sleep(2000);
		application().scrollDown();
		findByAny(CommonStepDefinitions.lendingPrimaryButton).as("I consent").scrollDownUntilVisible().click();
		findByAny(DeclineOffer.alertPrimaryButton).as("Ok got it for I consent").click();
		sleep(2000);
		application().scrollDown();
		findByAny(CommonStepDefinitions.lendingPrimaryButton).as("Ok got it on Appeal").click();
	}

	@Then("^user navigate from decline screen to homescreen without Consent on Alternative Financing$")
	public void user_navigate_from_decline_screen_to_homescreen_without_Consent_on_Alternative_Financing()
			throws Throwable {
		setStepName("Then");
		findByAny(CommonStepDefinitions.lendingPrimaryButton).as("Next on Iceberg Decline").click();
		sleep(2000);
		application().scrollDown();
		findByAny(CommonStepDefinitions.lendingSecondaryButton).as("Not now").scrollDownUntilVisible().click();
		findByAny(DeclineOffer.alertPrimaryButton).as("Ok got it for Not now").click();
		sleep(2000);
		application().scrollDown();
		findByAny(CommonStepDefinitions.lendingPrimaryButton).as("Ok got it on Appeal").click();
	}

}
