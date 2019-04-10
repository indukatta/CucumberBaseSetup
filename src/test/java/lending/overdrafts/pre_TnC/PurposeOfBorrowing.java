package lending.overdrafts.pre_TnC;

import static com.factory.mobile.driver.AppiumDriverManager.*;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lending.common.library.CommonLibrary;

public class PurposeOfBorrowing extends CommonLibrary {
	public static String questionTypes;
	public static String questionTypesChkBox;
	public static String screenQuestion = "lending_question_title";

	@Then("^verify that Purpose of Borrowing screen is displayed$")
	public void verify_that_user_Purpose_of_Borrowing_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot();
		findByAny(CommonStepDefinitions.screenTitle).isDisplayed();
		findByAny(screenQuestion).isDisplayed();
	}
	
	@Given("^that user is on Purpose of Borrowing screen$")
	public void that_user_is_on_Purpose_of_Borrowing_screen() {
		setStepName("Given");
		findByAny(CommonStepDefinitions.screenTitle).isDisplayed();
		findByAny(screenQuestion).isDisplayed();
	}

	@Then("^verify Purpose of Borrowing question \"([^\"]*)\" on screen$")
	public void verify_Purpose_of_Borrowing_question_on_screen(String expected) {
		setStepName("Then");
		findByAny(CommonStepDefinitions.screenTitle).isDisplayed();
		findByAny(screenQuestion).verifyEqualsTo(expected);
	}

	@Then("^verify Purpose of Borrowing title \"([^\"]*)\" on screen$")
	public void verify_Purpose_of_Borrowing_title_on_screen(String expected) {
		setStepName("Then");
		captureScreenshot();
		findByAny(CommonStepDefinitions.screenTitle).isDisplayed();
		findByAny(CommonStepDefinitions.screenTitle).verifyEqualsTo(expected);
	}

	@Then("^verify that following Purpose of Business questions are displayed on screen$")
	public void verify_that_following_Purpose_of_Borrowing_question_are_displayed_on_screen(DataTable expected) {
		setStepName("Then");
		findByAny(questionTypes).verifyAllEqualsTo(expected);
	}

	@Then("^verify that no option is pre-selected$")
	public void verify_that_no_default_option_is_pre_selected() {
		setStepName("Then");
		findByAny(questionTypesChkBox).verifyAttributesAllEqualsTo("value", "0");
	}

	@When("^user selects option (\\d+) from Purpose of Borrowing question screen$")
	public void user_selects_an_option_from_Purpose_of_Borrowing_question(int index) throws Throwable {
		setStepName("When");
		findByAny(questionTypes).click(index);
	}
	
	@Then("^verify that option (\\d+) is selected on Purpose of Borrowing question screen$")
	public void verify_that_option_is_selected_on_Purpose_of_Borrowing_question_screen(int index) {
		setStepName("Then");
		captureScreenshot();
		findByAny(questionTypesChkBox).verifyAttributesEqualsTo("value", "1", index);
	}
}
