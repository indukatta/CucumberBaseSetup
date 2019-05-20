package lending.overdrafts.pre_TnC;

import static com.factory.mobile.driver.AppiumDriverManager.captureScreenshot;
import static com.factory.mobile.driver.AppiumDriverManager.findByAny;
import static com.factory.mobile.driver.AppiumDriverManager.setStepName;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lending.common.library.CommonStepDefinitions;

public class TotalExistingBorrowing {
	public static String totalBorrowingHint;
	public static String totalBorrowingInputbox;
	public static String totalBorrowingCurrencySymbol;
	
	@Then("^verify that Total Existing Borrowings screen is displayed$")
	public void verify_that_Total_Existing_Borrowings_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot("TotalExistingBorrowing");
		findByAny(CommonStepDefinitions.screenTitle).isDisplayed();
		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();
	}

	@Given("^that user is on Total Existing Borrowings screen$")
	public void that_user_is_on_Total_Existing_Borrowings_screen() {
		setStepName("Given");
		findByAny(CommonStepDefinitions.screenTitle).isDisplayed();
		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();
	}

	@Then("^verify that Total Existing Borrowings question \"([^\"]*)\" is displayed$")
	public void verify_that_Total_Existing_Borrowings_question_is_displayed(String expected) {
		setStepName("Then");
		findByAny(CommonStepDefinitions.screenQuestion).verifyEqualsTo(expected);
	}

	@Then("^verify that Total Existing Borrowings input box is displayed$")
	public void verify_that_Total_Existing_Borrowings_input_box_is_displayed() {
		setStepName("Then");
		findByAny(totalBorrowingInputbox).isDisplayed();
	}

	@Then("^verify that default value \"([^\"]*)\" is displayed on Total Existing Borrowings$")
	public void verify_that_default_value_is_displayed_on_Total_Existing_Borrowings(String expected) {
		setStepName("Then");
		findByAny(totalBorrowingInputbox).verifyEqualsTo(expected);
	}

	@When("^user enters minimum value \"([^\"]*)\" in Total Existing Borrowings input box$")
	public void user_enters_minimum_value_in_Total_Existing_Borrowings_input_box(String expected) {
		setStepName("Then");
		findByAny(totalBorrowingInputbox).clear();
		findByAny(totalBorrowingInputbox).sendKeys(expected);
	}

	@When("^user enters maximum value \"([^\"]*)\" in Total Existing Borrowings input box$")
	public void user_enters_maximum_value_in_Total_Existing_Borrowings_input_box(String expected) {
		setStepName("Then");
		findByAny(totalBorrowingInputbox).clear();
		findByAny(totalBorrowingInputbox).sendKeys(expected);
	}

	@Then("^verify that value of Total Existing Borrowings is set to \"([^\"]*)\" min limit$")
	public void verify_that_value_of_Total_Existing_Borrowings_is_set_to_min_limit(String expected) {
		setStepName("Then");
		captureScreenshot();
		findByAny(totalBorrowingInputbox).verifyEqualsTo(expected);
	}

	@Then("^verify that value of Total Existing Borrowings is set to \"([^\"]*)\" max limit$")
	public void verify_that_value_of_Total_Existing_Borrowings_is_set_to_max_limit(String expected) {
		setStepName("Then");
		captureScreenshot();
		findByAny(totalBorrowingInputbox).verifyEqualsTo(expected);
	}
	
	@Then("^verify that Total Existing Borrowings is equals to \"([^\"]*)\" entered value$")
	public void verify_that_Total_Existing_Borrowings_is_equals_to__entered_value(String expected) {
		setStepName("Then");
		captureScreenshot();
		findByAny(totalBorrowingInputbox).verifyEqualsTo(expected);
	}

	@When("^user enters alphabetical and special chars \"([^\"]*)\"ZXCVBNM<>\\?\" in Total Existing Borrowings input box$")
	public void user_enters_alphabetical_and_special_chars_ZXCVBNM_in_Total_Existing_Borrowings_input_box(String expected){
		setStepName("Then");
		findByAny(totalBorrowingInputbox).clear();
		findByAny(totalBorrowingInputbox).sendKeys(expected);
	}

	@Then("^verify that currency symbol \"([^\"]*)\" is displayed on Total Existing Borrowings$")
	public void verify_that_currency_symblol_is_diplayed(String expected) {
		setStepName("Then");
		findByAny(totalBorrowingCurrencySymbol).verifyEqualsTo(expected);
	}

}
