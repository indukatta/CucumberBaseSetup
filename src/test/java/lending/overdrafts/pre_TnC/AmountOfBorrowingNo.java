package lending.overdrafts.pre_TnC;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static com.factory.mobile.driver.MobileDriverManager.*;

public class AmountOfBorrowingNo {
	public static String screenTitle;
	public static String screenMessage;

	@Then("^verify that Amount of Borrowing No screen is displayed$")
	public void verify_that_Amount_of_Borrowing_No_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot("AmountOfBorrowingNo");
		findByAny(screenTitle).isDisplayed();
//		findByAny(screenMessage).isDisplayed();
	}

	@Given("^that user is on Amount of Borrowing No screen$")
	public void that_user_is_on_Amount_of_Borrowing_No_screen() {
		setStepName("Given");
//		findByAny(screenMessage).isDisplayed();
	}

	@Then("^verify Amount of Borrowing No title \"([^\"]*)\" on screen$")
	public void verify_Amount_of_Borrowing_No_title_on_screen(String expected) {
		setStepName("Then");
		findByAny(screenTitle).verifyEqualsTo(expected);
	}

	@Then("^verify Amount of Borrowing No message \"([^\"]*)\" on screen$")
	public void verify_Amount_of_Borrowing_No_message_on_screen(String expected) {
		setStepName("Then");
//		findByAny(screenMessage).verifyEqualsTo(expected);
	}

}
