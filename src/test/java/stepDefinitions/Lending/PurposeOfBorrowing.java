package stepDefinitions.Lending;

import static com.factory.mobile.driver.MobileDriverManager.*;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PurposeOfBorrowing extends CommonLibrary {

	public static String screenTitle;
	public static String purposeOfBorrowing;
	public static String purposeOfBorrowingQuestions;
	public static String purposeOfBorrowingQuestionsChkBox;
	public static String continueButton;

	@Given("^that user is on Purpose of Borrowing screen$")
	public void that_user_is_on_Purpose_of_Borrowing_screen() throws Throwable {
		setStepName("Given");
		captureScreenshot("PurposeOfBorrowing");
		findByAny(screenTitle).isDisplayed();
		findByAny(purposeOfBorrowing).isDisplayed();
	}

	@Then("^verify that Purpose of Borrowing \"([^\"]*)\" is displayed$")
	public void verify_that_Purpose_of_Borrowing_displayed(String expected) {
		setStepName("Then");
		findByAny(purposeOfBorrowing).verifyEqualsTo(expected);
	}

	@Then("^verify that screen title \"([^\"]*)\" is displayed$")
	public void verify_that_screen_title_is_displayed(String expected) {
		setStepName("Then");
		captureScreenshot("PurposeOfBorrowing");
		findByAny(screenTitle).isDisplayed();
		findByAny(screenTitle).verifyEqualsTo(expected);
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
		findByAny(purposeOfBorrowingQuestionsChkBox).verifyAttributesAllEqualsTo("value", "0");
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
		sleep(3000);
	}

}
