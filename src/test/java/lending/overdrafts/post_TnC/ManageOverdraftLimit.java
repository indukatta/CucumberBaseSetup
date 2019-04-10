package lending.overdrafts.post_TnC;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lending.common.library.CommonLibrary;
import lending.overdrafts.pre_TnC.CommonStepDefinitions;
import lending.overdrafts.pre_TnC.TermsAndConditions;

import static com.factory.mobile.driver.AppiumDriverManager.*;

import org.openqa.selenium.support.FindBy;

public class ManageOverdraftLimit extends CommonLibrary {
	public static String tncHeading = "tandc_summary_label";
	

	@Then("^verify that products Terms and Conditions screen is visible$")
	public void verify_that_products_Terms_and_Conditions_screen_is_visible() {
		setStepName("Then");
		captureScreenshot();
		findByAccessibilityId(tncHeading).isDisplayed();
	}

	@When("^user clicks on I Consent on product Terms and Conditions screen$")
	public void user_clicks_on_I_Consent_on_product_Terms_and_Conditions_screen() {
		setStepName("Then");
		findByAccessibilityId(TermsAndConditions.tncAccept).click();
	}

	@Then("^verify that Manage Overdraft screen is displayed$")
	public void verify_that_Manage_Overdraft_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot();
		findByAny(CommonStepDefinitions.screenTitle).isDisplayed();
		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();
	}

}
