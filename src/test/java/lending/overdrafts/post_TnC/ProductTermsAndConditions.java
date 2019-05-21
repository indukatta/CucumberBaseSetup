package lending.overdrafts.post_TnC;

import static com.factory.mobile.driver.AppiumDriverManager.captureScreenshot;
import static com.factory.mobile.driver.AppiumDriverManager.*;
import static com.factory.mobile.driver.AppiumDriverManager.setStepName;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lending.common.library.CommonStepDefinitions;

public class ProductTermsAndConditions {

	public static String tncHeading = "tandc_summary_label";
	public static String tncContentWebView = "tandc_webView";

	@Then("^verify that products Terms and Conditions screen is visible$")
	public void verify_that_products_Terms_and_Conditions_screen_is_visible() {
		setStepName("Then");
		captureScreenshot();
		findByAny(tncHeading).as("Product T&C Heading").isDisplayed();
	}

	@Given("^that user is on products Terms and Conditions screen$")
	public void that_user_is_on_products_Terms_and_Conditions_screen() {
		setStepName("Given");
		findByAny(tncHeading).as("Product T&C Heading").isDisplayed();
	}

	@Then("^verify that product header text \"([^\"]*)\" is visible on the screen$")
	public void verify_that_product_header_text_is_visible_on_the_screen(String arg1) throws Throwable {
		setStepName("Then");
		findByAny(tncHeading).as("Product T&C Heading").verifyEqualsTo(arg1);
	}

	@When("^user clicks on Not Now button on Terms and Conditions screen$")
	public void user_clicks_on_Not_Now_button_on_Terms_and_Conditions_screen() {
		setStepName("Then");
		findByAny(CommonStepDefinitions.lendingSecondaryButton).as("Not Now").scrollDownUntilVisible().click();
	}

	@Then("^verify that Accept display text \"([^\"]*)\" is visible on the screen$")
	public void verify_that_Accept_display_text_is_visible_on_the_screen(String arg1) throws Throwable {
		setStepName("Then");
		findByAny(CommonStepDefinitions.lendingPrimaryButton).as("Accept").verifyEqualsTo(arg1);
	}

	@Then("^verify that Not Now display text \"([^\"]*)\" is visible on the screen$")
	public void verify_that_Not_Now_display_text_is_visible_on_the_screen(String arg1) throws Throwable {
		setStepName("Then");
		findByAny(CommonStepDefinitions.lendingSecondaryButton).as("Not Now").verifyEqualsTo(arg1);
	}

	@Then("^verify that Accept button is enabled on product TnC screen$")
	public void verify_that_Accept_button_is_enabled_on_product_TnC_screen() throws Throwable {
		setStepName("Then");
		findByAny(CommonStepDefinitions.lendingPrimaryButton).as("Accept").isEnabled();
	}

	@Then("^verify that Not Now button is enabled on product TnC screen$")
	public void verify_that_Not_Now_button_is_enabled_on_product_TnC_screen() throws Throwable {
		setStepName("Then");
		findByAny(CommonStepDefinitions.lendingSecondaryButton).as("Not Now").isEnabled();
	}

}
