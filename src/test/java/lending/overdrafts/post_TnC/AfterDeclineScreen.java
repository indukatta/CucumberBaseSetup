package lending.overdrafts.post_TnC;

import cucumber.api.java.en.Then;
import lending.common.library.CommonLibrary;
import lending.overdrafts.pre_TnC.CommonStepDefinitions;

import static com.factory.mobile.driver.AppiumDriverManager.*;

public class AfterDeclineScreen extends CommonLibrary {

	@Then("^verify that Alternative Financing screen is visible$")
	public void verify_that_Alternative_Financing_screen_is_visible() {
		setStepName("Then");
		captureScreenshot();
		findByAny(ProductTermsAndConditions.tncHeading).as("Alternative Financing Heading").verifyEqualsTo("Borrowing");
		findByAny(CommonStepDefinitions.lendingPrimaryButton).as("I consent").scrollDownUntilVisible().isDisplayed();
	}

	@Then("^user clicks on I Consent on Financial Alternative screen$")
	public void user_clicks_on_I_Consent_on_Financial_Alternative_screen() {
		setStepName("Then");
		findByAny(CommonStepDefinitions.lendingPrimaryButton).as("I consent on Alternative Financing").scrollDownUntilVisible().click();
	}

	@Then("^user clicks on Not Now on Financial Alternative screen$")
	public void user_clicks_on_Not_Now_on_Financial_Alternative_screen() {
		setStepName("Then");
		findByAny(CommonStepDefinitions.lendingSecondaryButton).as("Not Now on Alternative Financing").scrollDownUntilVisible().click();
	}

	@Then("^verify that Ok got it for I Consent option is displayed$")
	public void verify_that_Ok_got_it_for_I_Consent_option_is_displayed() {
		setStepName("Then");
		captureScreenshot();
		findByAny(DeclineOffer.alertPrimaryButton).as("Ok got it for I consent").isDisplayed();
	}
	
	@Then("^verify that Ok got it for Not Not option is displayed$")
	public void verify_that_Ok_got_it_for_Not_Not_option_is_displayed() {
		setStepName("Then");
		captureScreenshot();
		findByAny(DeclineOffer.alertPrimaryButton).as("Ok got it for I consent").isDisplayed();
	}

	@Then("^user clicks on Ok got it on Alternative Financing screen$")
	public void user_clicks_on_Ok_got_it_on_Alternative_Financing_screen() {
		setStepName("Then");
		findByAny(DeclineOffer.alertPrimaryButton).as("Ok got it After Alternative Financing").click();
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
		findByAny(CommonStepDefinitions.lendingPrimaryButton).as("Ok got it on Appeal").click();
	}

}
