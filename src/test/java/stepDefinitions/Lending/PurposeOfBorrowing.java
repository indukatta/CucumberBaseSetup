package stepDefinitions.Lending;

import static com.factory.mobile.driver.MobileDriverManager.*;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PurposeOfBorrowing extends CommonLibrary {

	public static String borrowingTitle;
	public static String purposeOfBorrowing;
	public static String purposeOfBorrowingQuestions;
	public static String continueButton;

	@Then("^verify that screen title \"([^\"]*)\" is displayed\\.$")
	public void verify_that_screen_title_is_displayed(String expected) {
		setStepName("Then");
		findByAny(borrowingTitle).isDisplayed();
		findByAny(borrowingTitle).verifyEqualsTo(expected);
	}

	@Then("^verify that Purpose of Borrowing \"([^\"]*)\" is displayed$")
	public void verify_that_Purpose_of_Borrowing_displayed(String expected) {
		setStepName("Then");
		findByAny(purposeOfBorrowing).verifyEqualsTo(expected);
	}

	@Given("^that user is on Purpose of Borrowing screen$")
	public void that_user_is_on_Purpose_of_Borrowing_screen() throws Throwable {
		setStepName("Given");
		loginAndOpenCreditAndSelectScreen();
		findByAny(ProductSelection.buttonApply).click();
		sleep(3000);
		captureScreenshot("PurposeOfBorrowing");
		findByAny(borrowingTitle).isDisplayed();
		findByAny(purposeOfBorrowing).isDisplayed();
	}

	@Then("^verify that following Purpose of Business questions are displayed on screen$")
	public void verify_that_following_Purpose_of_Borrowing_question_are_displayed_on_screen(DataTable expected)
			throws Throwable {
		setStepName("Then");
		findByAny(purposeOfBorrowingQuestions).verifyAllEqualsTo(expected);
	}

	@Then("^verify that continue button is disabled$")
	public void verify_that_continue_button_is_disabled() {
		setStepName("Then");
		captureScreenshot();
		findByAny(continueButton).isDisabled();
	}

	@Then("^verify that no option is pre-selected$")
	public void verify_that_no_default_option_is_pre_selected() {
		setStepName("Then");
		findByAny(purposeOfBorrowingQuestions).verifyAttributesAllEqualsTo("visible", "false");
	}

	@When("^user selects option (\\d+) from Purpose of Borrowing Question$")
	public void user_selects_an_option_from_Purpose_of_Borrowing_Question(int index) throws Throwable {
		setStepName("When");
		findByAny(purposeOfBorrowingQuestions).click(index);
	}

	@Then("^verify that continue button is enabled$")
	public void verify_that_continue_button_is_enabled() throws Throwable {
		setStepName("Then");
		captureScreenshot();
		findByAny(continueButton).isEnabled();
	}

	@When("^user selects all options from Purpose of Borrowing Question$")
	public void user_selects_all_options_from_Purpose_of_Borrowing_Question() {
		setStepName("When");
		findByAny(purposeOfBorrowingQuestions).clickAll();
	}

	@When("^user clicks on continue button on the screen$")
	public void user_clicks_on_continue_button_on_the_screen() throws Throwable {
		setStepName("When");
		findByAny(continueButton).click();
	}

	@Then("^verify that Residential Status lending question screen is displayed$")
	public void verify_that_Residential_Status_lending_question_screen_is_displayed() throws Throwable {
		functionNotImplemented();
	}

}
