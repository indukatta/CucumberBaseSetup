package lending.overdrafts.pre_TnC;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import lending.common.library.CommonLibrary;
import lending.common.library.CommonStepDefinitions;

import static com.factory.mobile.driver.AppiumDriverManager.findByAny;
import static com.factory.mobile.driver.AppiumDriverManager.setStepName;
import static com.factory.mobile.driver.AppiumDriverManager.captureScreenshot;

public class AmountOfBorrowingYesNo extends CommonLibrary {

	@Then("^verify that Amount of Borrowing YesNo screen is displayed$")
	public void verify_that_Amount_of_Borrowing_YesNo_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot();
		findByAny(CommonStepDefinitions.screenTitle).isDisplayed();
		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();
	}
	
	@Given("^that user is on Amount of Borrowing YesNo screen$")
	public void that_user_is_on_Amount_of_Borrowing_YesNo_screen() {
		setStepName("Given");
		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();
	}

	@Then("^verify that Amount of Borrowing title \"([^\"]*)\" on screen$")
	public void verify_that_Amount_of_Borrowing_YesNo_title_on_screen(String expected) {
		setStepName("Then");
		findByAny(CommonStepDefinitions.screenTitle).verifyEqualsTo(expected);
	}

	@Then("^verify that Amount of Borrowing question \"([^\"]*)\" on screen$")
	public void verify_that_Amount_of_Borrowing_YesNo_header_on_screen(String expected) {
		setStepName("Then");
		findByAny(CommonStepDefinitions.screenQuestion).verifyEqualsTo(expected);
	}

	@Then("^verify that disclaimer \"([^\"]*)\" is displayed on the screen$")
	public void verify_that_disclaimer_is_displayed_on_the_screen(String arg1) {
		setStepName("Then");
		findByAny(AmountOfBorrowing.amtOfBorrowingSubTitle).verifyEqualsTo(arg1);
	}
}
