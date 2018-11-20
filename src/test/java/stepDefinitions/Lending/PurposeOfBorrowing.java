package stepDefinitions.Lending;

import static com.factory.mobile.driver.MobileDriverManager.*;

import java.util.ArrayList;
import java.util.List;

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
		findByAny(borrowingTitle).verifyEqualsTo(expected);
	}

	@Then("^verify that Purpose of Borrowing \"([^\"]*)\" is displayed$")
	public void verify_that_Purpose_of_Borrowing_displayed(String expected) {
		setStepName("Then");
		findByAny(purposeOfBorrowing).verifyEqualsTo(expected);
	}

	@Given("^that user is on Purpose of Borrowing screen$")
	public void that_user_is_on_Purpose_of_Borrowing_screen() {
		setStepName("Given");
		findByAny(borrowingTitle).isDisplayed();
		findByAny(purposeOfBorrowing).isDisplayed();
	}

	@Then("^verify that following Purpose of Business questions are displayed on screen$")
	public void verify_that_following_Purpose_of_Borrowing_question_are_displayed_on_screen(DataTable expected) throws Throwable {
		List<List<String>> data = expected.raw();
		List<String> pobQuestions = new ArrayList<String>();
		for (int i = 0; i < data.size(); i++) {
			pobQuestions.add(data.get(i).get(0));
		}
		findByAny(purposeOfBorrowingQuestions).verifyAllEqualsTo(pobQuestions);
	}

	@Then("^verify that continue button is disabled$")
	public void verify_that_continue_button_is_disabled() {
		setStepName("Then");
		findByAny(continueButton).isDisabled();
	}

	@Then("^verify that no default option is pre-selected$")
	public void verify_that_no_default_option_is_pre_selected() {
		setStepName("Then");
		findByAny(purposeOfBorrowingQuestions).isDeselectedAll();
	}

	@When("^user selects an option from Purpose of Borrowing Question$")
	public void user_selects_an_option_from_Purpose_of_Borrowing_Question() throws Throwable {
		setStepName("When");
		findByAny(purposeOfBorrowingQuestions).click();
	}

	@Then("^verify that continue button is enabled$")
	public void verify_that_continue_button_is_enabled() throws Throwable {
		setStepName("Then");
		findByAny(continueButton).isEnabled();
	}

	@When("^user selects all options from Purpose of Borrowing Question$")
	public void user_selects_all_options_from_Purpose_of_Borrowing_Question() {
		setStepName("When");
		findByAny(purposeOfBorrowingQuestions).clickAll();
		findByAny(purposeOfBorrowingQuestions).isSelectedAll();
	}

	@When("^user clicks on Continue button on the screen$")
	public void user_clicks_on_Continue_button_on_the_screen() throws Throwable {
		setStepName("When");
		findByAny(continueButton).isEnabled();
	}

	@Then("^verify that Residential Status lending question screen is displayed$")
	public void verify_that_Residential_Status_lending_question_screen_is_displayed() throws Throwable {
		functionNotImplemented();
	}

}
