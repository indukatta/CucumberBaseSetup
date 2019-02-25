package lending.overdrafts.pre_TnC;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.factory.mobile.driver.AppiumDriverManager.*;

public class MaritalStatus {
	public static String questionAnswer;
	public static String questionAnswerRadioBtn;
	public static String screenQuestion = "accessibility id==lending_question_title";
	
	@Given("^user is on Marital Status lending question screen$")
	public void user_is_on_Marital_Status_lending_question_screen() {
		setStepName("Then");
		findByAny(CommonStepDefinitions.screenTitle).isDisplayed();
		findByAny(screenQuestion).isDisplayed();
	}

	@Then("^verify that Marital Status screen is displayed$")
	public void verify_that_Marital_Status_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot("MaritalStatus_0");
		findByAny(CommonStepDefinitions.screenTitle).isDisplayed();
		findByAny(screenQuestion).isDisplayed();
	}

	@Then("^verify that Marital Status description \"([^\"]*)\" on screen$")
	public void verify_that_Marital_Status_description_on_screen(String expect) {
		setStepName("Then");
		findByAny(screenQuestion).verifyEqualsTo(expect);
	}

	@Then("^verify that below Marital Status options are displayed$")
	public void verify_that_below_Marital_Status_options_are_displayed(DataTable expected) {
		setStepName("Then");
		findByAny(questionAnswer).verifyAllEqualsTo(expected);
	}

	@Then("^verify that none of the Marital Status is pre selected$")
	public void verify_that_none_of_the_Marital_Status_is_pre_selected() {
		setStepName("Then");
		captureScreenshot();
		findByAny(questionAnswerRadioBtn).verifyAttributesAllEqualsTo("value", "0");
	}

	@When("^user selects option (\\d+) on Marital Status screen$")
	public void user_selects_option_on_Marital_Status_screen(int index) {
		setStepName("When");
		findByAny(questionAnswer).click(index);
	}

	@Then("^verify that option (\\d+) on Marital Status is deselected$")
	public void verify_that_option_on_Marital_Status_is_deselected(int index) {
		setStepName("Then");
		captureScreenshot();
		findByAny(questionAnswerRadioBtn).verifyAttributesEqualsTo("value", "0", index);
	}
	@Then("^verify that option (\\d+) on Marital Status is selected$")
	public void verify_that_option_on_Marital_Status_is_selected(int index) {
		setStepName("Then");
		captureScreenshot();
		findByAny(questionAnswerRadioBtn).verifyAttributesEqualsTo("value", "1", index);
	}
	
}
