package lending.overdrafts.post_TnC;

import static com.factory.mobile.driver.AppiumDriverManager.captureScreenshot;
import static com.factory.mobile.driver.AppiumDriverManager.*;
import static com.factory.mobile.driver.AppiumDriverManager.setStepName;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lending.overdrafts.pre_TnC.CommonStepDefinitions;

public class ProductTermsAndConditions {
	
	public static String tncHeading = "tandc_summary_label";

	@Then("^verify that products Terms and Conditions screen is visible$")
	public void verify_that_products_Terms_and_Conditions_screen_is_visible() {
		setStepName("Then");
		captureScreenshot();
		findByAny(tncHeading).as("Product T&C Heading").isDisplayed();
	}

	@When("^user clicks on I Consent on product Terms and Conditions screen$")
	public void user_clicks_on_I_Consent_on_product_Terms_and_Conditions_screen() {
		setStepName("Then");
		findByAny(CommonStepDefinitions.lendingPrimaryButton).scrollDownUntilVisible().click();
	}

	@When("^user clicks on Not Now button on products Terms and Conditions screen$")
	public void user_clicks_on_Not_Now_button_on_products_Terms_and_Conditions_screen() {
		setStepName("Then");
		findByAny(CommonStepDefinitions.lendingSecondaryButton).scrollDownUntilVisible().click();
	}
}
