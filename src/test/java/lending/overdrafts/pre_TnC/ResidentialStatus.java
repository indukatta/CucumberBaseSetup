package lending.overdrafts.pre_TnC;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.factory.mobile.driver.AppiumDriverManager.*;

public class ResidentialStatus {
	public static String screenTitle;
	public static String screenHeader;
	public static String questionAnswer;
	public static String questionAnswerRadioBtn;

	@Given("^user is on Residential Status lending question screen$")
	public void user_is_on_Residential_Status_lending_question_screen() {
		setStepName("Given");
		findByAny(screenTitle).isDisplayed();
		findByAny(screenHeader).isDisplayed();
	}

	@Then("^verify that Residential Status screen is displayed$")
	public void verify_that_Residential_Status_is_displayed() {
		setStepName("Given");
		captureScreenshot("ResidentialStatus_0");
		findByAny(screenTitle).isDisplayed();
		findByAny(screenHeader).isDisplayed();
	}

	@Then("^verify that Residential Status description \"([^\"]*)\" on screen$")
	public void verify_that_Residential_Status_description_on_screen(String expected) {
		setStepName("Then");
		findByAny(screenHeader).verifyEqualsTo(expected);
	}

	@Then("^verify that below Residential Status options are displayed$")
	public void verify_that_below_Residential_Status_options_are_displayed(DataTable expected) {
		setStepName("Then");
		captureScreenshot();
		findByAny(questionAnswer).verifyAllEqualsTo(expected);
	}

	@Then("^verify that none of the Residential Status is pre selected$")
	public void verify_that_none_of_the_Residential_Status_is_pre_selected() {
		setStepName("Then");
		captureScreenshot();
		findByAny(questionAnswerRadioBtn).verifyAttributesAllEqualsTo("value", "0");
	}

	@When("^user selects option (\\d+) on Residential Status screen$")
	public void user_selects_option_on_Residential_Status_screen(int index) {
		setStepName("When");
		findByAny(questionAnswer).click(index);
	}

	@Then("^verify that option (\\d+) on Residential Status screen is deselected$")
	public void verify_that_option_on_Residential_Status_screen_is_deselected(int index) {
		setStepName("Then");
		captureScreenshot();
		findByAny(questionAnswerRadioBtn).verifyAttributesEqualsTo("value", "0", index);
	}
	
	@Then("^verify that option (\\d+) on Residential Status screen is selected$")
	public void verify_that_option_on_Residential_Status_screen_is_selected(int index) {
		setStepName("Then");
		captureScreenshot();
		findByAny(questionAnswerRadioBtn).verifyAttributesEqualsTo("value", "1", index);
	}

}
