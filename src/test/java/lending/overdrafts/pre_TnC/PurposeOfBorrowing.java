package lending.overdrafts.pre_TnC;

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

	@Then("^verify that Purpose of Borrowing screen is displayed$")
	public void verify_that_user_Purpose_of_Borrowing_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot("PurposeOfBorrowing");
		findByAny(screenTitle).isDisplayed();
		findByAny(purposeOfBorrowing).isDisplayed();
	}
	
	@Given("^that user is on Purpose of Borrowing screen$")
	public void that_user_is_on_Purpose_of_Borrowing_screen() {
		setStepName("Given");
		findByAny(screenTitle).isDisplayed();
		findByAny(purposeOfBorrowing).isDisplayed();
	}

	@Then("^verify Purpose of Borrowing question \"([^\"]*)\" on screen$")
	public void verify_Purpose_of_Borrowing_question_on_screen(String expected) {
		setStepName("Then");
		findByAny(screenTitle).isDisplayed();
		findByAny(purposeOfBorrowing).verifyEqualsTo(expected);
	}

	@Then("^verify Purpose of Borrowing title \"([^\"]*)\" on screen$")
	public void verify_Purpose_of_Borrowing_title_on_screen(String expected) {
		setStepName("Then");
		captureScreenshot("PurposeOfBorrowing");
		findByAny(screenTitle).isDisplayed();
		findByAny(screenTitle).verifyEqualsTo(expected);
	}

	@Then("^verify that following Purpose of Business questions are displayed on screen$")
	public void verify_that_following_Purpose_of_Borrowing_question_are_displayed_on_screen(DataTable expected) {
		setStepName("Then");
		findByAny(purposeOfBorrowingQuestions).verifyAllEqualsTo(expected);
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

	@When("^user selects all options from Purpose of Borrowing Question$")
	public void user_selects_all_options_from_Purpose_of_Borrowing_Question() {
		setStepName("When");
		findByAny(purposeOfBorrowingQuestions).clickAll();
	}

}
