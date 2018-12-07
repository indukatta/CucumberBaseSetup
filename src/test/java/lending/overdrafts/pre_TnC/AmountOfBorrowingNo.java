package lending.overdrafts.pre_TnC;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.factory.mobile.driver.MobileDriverManager.*;

public class AmountOfBorrowingNo {
	public static String screenTitle;
	public static String screenMessage;
	public static String okayGotItButton;

	@Then("^verify that Amount of Borrowing No screen is displayed$")
	public void verify_that_Amount_of_Borrowing_No_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot("AmountOfBorrowingNo");
		findByAny(screenTitle).isDisplayed();
		findByAny(screenMessage).isDisplayed();
	}

	@Given("^that user is on Amount of Borrowing No screen$")
	public void that_user_is_on_Amount_of_Borrowing_No_screen() {
		setStepName("Given");
		findByAny(screenMessage).isDisplayed();
	}

	@Then("^verify Amount of Borrowing No title \"([^\"]*)\" on screen$")
	public void verify_Amount_of_Borrowing_No_title_on_screen(String expected) {
		setStepName("Then");
		findByAny(screenTitle).verifyEqualsTo(expected);
	}

	@Then("^verify Amount of Borrowing No message \"([^\"]*)\" on screen$")
	public void verify_Amount_of_Borrowing_No_message_on_screen(String expected) {
		setStepName("Then");
		findByAny(screenMessage).verifyEqualsTo(expected);
	}

	@Then("^verify that Okay Got it button is displayed on screen$")
	public void verify_that_Okay_Got_it_button_is_displayed_on_screen() {
		setStepName("Then");
		findByAny(okayGotItButton).isDisplayed();
	}

	@Then("^verify that Okay Got it button is enabled on screen$")
	public void verify_that_Okay_Got_it_button_is_enabled_on_screen() {
		setStepName("Then");
		findByAny(okayGotItButton).isEnabled();
	}

	@When("^user clicks on Okay Got it button on Amount of Borrowing No screen$")
	public void user_clicks_on_Okay_Got_it_button_on_Amount_of_Borrowing_No_screen() {
		setStepName("When");
		findByAny(okayGotItButton).click();
	}

}