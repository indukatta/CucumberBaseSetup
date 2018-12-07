package lending.overdrafts.pre_TnC;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static com.factory.mobile.driver.MobileDriverManager.findByAny;
import static com.factory.mobile.driver.MobileDriverManager.setStepName;
import static com.factory.mobile.driver.MobileDriverManager.captureScreenshot;

public class AmountOfBorrowing extends CommonLibrary {
	public static String screenTitle;
	public static String screenQuestion;

	@Then("^verify that Amount of Borrowing screen is displayed$")
	public void verify_that_Amount_of_Borrowing_YesNo_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot("AmountOfBorrowing");
		findByAny(screenTitle).isDisplayed();
		findByAny(screenQuestion).isDisplayed();
	}
	
	@Given("^that user is on Amount of Borrowing screen$")
	public void that_user_is_on_Amount_of_Borrowing_YesNo_screen() {
		setStepName("Given");
		findByAny(screenQuestion).isDisplayed();
	}

	
	@Then("^verify that Amount of Borrowing title \"([^\"]*)\" on screen$")
	public void verify_that_Amount_of_Borrowing_YesNo_title_on_screen(String expected) {
		setStepName("Then");
		findByAny(screenTitle).verifyEqualsTo(expected);
	}

	@Then("^verify that Amount of Borrowing question \"([^\"]*)\" on screen$")
	public void verify_that_Amount_of_Borrowing_YesNo_header_on_screen(String expected) {
		setStepName("Then");
		findByAny(screenQuestion).verifyEqualsTo(expected);
	}
}
