package lending.overdrafts.pre_TnC;

import static com.factory.mobile.driver.AppiumDriverManager.captureScreenshot;
import static com.factory.mobile.driver.AppiumDriverManager.findByAny;
import static com.factory.mobile.driver.AppiumDriverManager.setStepName;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class BusinessBorrowingYesNo {
	public static String hintText = "accessibility id==lending_question_hint";

	@Then("^verify that Business Borrowing YesNo screen is displayed$")
	public void verify_that_Amount_of_Borrowing_YesNo_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot("BusinessBorrowingYesNo");
		findByAny(CommonStepDefinitions.screenTitle).isDisplayed();
		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();
	}

	@Given("^that user is on Business Borrowing YesNo screen$")
	public void that_user_is_on_Amount_of_Borrowing_YesNo_screen() {
		setStepName("Given");
		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();
	}

	@Then("^verify Business Borrowingg YesNo title \"([^\"]*)\" on screen$")
	public void verify_that_Amount_of_Borrowing_YesNo_title_on_screen(String expected) {
		setStepName("Then");
		findByAny(CommonStepDefinitions.screenTitle).verifyEqualsTo(expected);
	}

	@Then("^verify that Business Borrowing YesNo question \"([^\"]*)\" is displayed$")
	public void verify_that_Amount_of_Borrowing_YesNo_header_on_screen(String expected) {
		setStepName("Then");
		findByAny(CommonStepDefinitions.screenQuestion).verifyEqualsTo(expected);
	}

	@Then("^verify that hint text \"([^\"]*)\" is displayed on Business Borrowing$")
	public void verify_that_hint_text_is_displayed(String expected) {
		setStepName("Then");
		findByAny(hintText).verifyEqualsTo(expected);
	}
}
