package lending.overdrafts.post_TnC;

import cucumber.api.java.en.Then;
import lending.overdrafts.pre_TnC.CommonLibrary;
import lending.overdrafts.pre_TnC.CommonStepDefinitions;

import static com.factory.mobile.driver.AppiumDriverManager.*;

public class AfterDeclineScreen extends CommonLibrary {
	public static String lendingPrimaryButton = "lending_primary_button";
	public static String lendingSecondaryButton = "lending_secondary_button";
	
	public static String alertImageView = "alertImageView";
	public static String alertTitleLabel = "alertTitleLabel";
	public static String alertBodyLabel = "alertBodyLabel";
	public static String okGotIt = "alertPrimaryButton";
	
	
	@Then("^verify that Alternative Financing screen is visible$")
	public void verify_that_Alternative_Financing_screen_is_visible() {
		setStepName("Then");
		captureScreenshot();
		findByAccessibilityId(CommonStepDefinitions.lendingPrimaryButton).as("I consent").scrollDownUntilVisible().isDisplayed();
		findByAccessibilityId(CommonStepDefinitions.lendingPrimaryButton).as("I consent").verifyEqualsTo("I consent");
	}

	@Then("^user clicks on I Consent on Financial Alternative screen$")
	public void user_clicks_on_I_Consent_on_Financial_Alternative_screen() {
		setStepName("Then");
		findByAccessibilityId(CommonStepDefinitions.lendingPrimaryButton).as("I consent").click();
	}


}
