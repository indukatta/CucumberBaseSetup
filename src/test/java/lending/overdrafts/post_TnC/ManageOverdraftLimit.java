package lending.overdrafts.post_TnC;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lending.common.library.CommonLibrary;
import lending.common.library.CommonStepDefinitions;
import lending.overdrafts.pre_TnC.TermsAndConditions;

import static com.factory.mobile.driver.AppiumDriverManager.*;

import org.openqa.selenium.support.FindBy;

public class ManageOverdraftLimit extends CommonLibrary {
	
	@Then("^verify that Manage Overdraft screen is displayed$")
	public void verify_that_Manage_Overdraft_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot();
		findByAny(CommonStepDefinitions.screenTitle).isDisplayed();
		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();
	}

}
