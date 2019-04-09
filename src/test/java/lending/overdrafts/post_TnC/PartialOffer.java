package lending.overdrafts.post_TnC;

import static com.factory.mobile.driver.AppiumDriverManager.captureScreenshot;
import static com.factory.mobile.driver.AppiumDriverManager.findByAccessibilityId;
import static com.factory.mobile.driver.AppiumDriverManager.setStepName;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lending.overdrafts.pre_TnC.CommonStepDefinitions;

public class PartialOffer {
	@Then("^verify that the Partial Offer screen is displayed$")
	public void verify_that_the_Partial_Offer_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot();
		findByAccessibilityId(CommonStepDefinitions.lendingPrimaryButton).as("Continue").isDisplayed();
		findByAccessibilityId(CommonStepDefinitions.lendingPrimaryButton).as("Continue").verifyEqualsTo("See my options");	
	}
	
}
