package lending.overdrafts.pre_TnC;

import static com.factory.mobile.driver.AppiumDriverManager.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lending.common.library.CommonLibrary;

public class GrossIncome extends CommonLibrary {
	public static String grossIncomeInputbox = "number_question_selected_value_label";

	@Given("^that user is on Gross Income screen$")
	public void that_user_is_on_Gross_Income_screen() {
		setStepName("Given");
		findByAny(CommonStepDefinitions.screenTitle).isDisplayed();
		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();
	}

	@Then("^verify that Gross Income screen is displayed$")
	public void verify_that_Gross_Income_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot("GrossIncome");
		findByAny(CommonStepDefinitions.screenTitle).isDisplayed();
		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();
	}

	@Then("^verify that Gross Income header is displayed$")
	public void verify_that_Gross_Income_header_is_displayed() {
		setStepName("Then");
		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();
	}
	
	@Then("^verify that Gross Income description \"([^\"]*)\" on screen$")
	public void verify_that_Gross_Income_description_on_screen(String expected) {
		setStepName("Then");
		findByAny(CommonStepDefinitions.screenQuestion).verifyEqualsTo(expected);
	}

	@Then("^verify that Gross Income input box is displayed$")
	public void verify_that_Gross_Income_input_box_is_displayed() {
		setStepName("Then");
		findByAny(grossIncomeInputbox).isDisplayed();
	}

	@Then("^verify that default value of Gross Income is \"([^\"]*)\"$")
	public void verify_that_default_value_of_Gross_Income_is(String expected) {
		setStepName("Then");
		findByAny(grossIncomeInputbox).verifyEqualsTo(expected);
	}

	@When("^user enters less than allowed value \"([^\"]*)\" in Gross Income input box$")
	public void user_enters_less_than_allowed_value_in_Gross_Income_input_box(String expected) {
		setStepName("Then");
		findByAny(grossIncomeInputbox).clear();
		findByAny(grossIncomeInputbox).sendKeys(expected);
	}

	@When("^user enters more than allowed value \"([^\"]*)\" in Gross Income input box$")
	public void user_enters_more_than_allowed_value_in_Gross_Income_input_box(String expected) {
		setStepName("Then");
		findByAny(grossIncomeInputbox).clear();
		findByAny(grossIncomeInputbox).sendKeys(expected);
	}

	@When("^user enters minimum value \"([^\"]*)\" in Gross Income input box$")
	public void user_enters_minimum_value_in_Gross_Income_input_box(String expected) {
		setStepName("Then");
		findByAny(grossIncomeInputbox).clear();
		findByAny(grossIncomeInputbox).sendKeys(expected);
	}

	@When("^user enters maximum value \"([^\"]*)\" in Gross Income input box$")
	public void user_enters_maximum_value_in_Gross_Income_input_box(String expected) {
		setStepName("Then");
		findByAny(grossIncomeInputbox).clear();
		findByAny(grossIncomeInputbox).sendKeys(expected);
	}
	
	@Then("^verify that value of Gross Income is set to \"([^\"]*)\" min limit$")
	public void verify_that_value_of_Gross_Income_is_set_to_min_limit(String expected) {
		setStepName("Then");
		captureScreenshot();
		findByAny(grossIncomeInputbox).verifyEqualsTo(expected);
	}

	@Then("^verify that value of Gross Income is set to \"([^\"]*)\" max limit$")
	public void verify_that_value_of_Gross_Income_is_set_to_max_limit(String expected) {
		setStepName("Then");
		captureScreenshot();
		findByAny(grossIncomeInputbox).verifyEqualsTo(expected);
	}
	
	@Then("^verify that entered value \"([^\"]*)\" is displayed in Gross Income input box$")
	public void verify_that_entered_value_is_displayed_in_Gross_Income_input_box(String expected) {
		setStepName("Then");
		captureScreenshot();
		findByAny(grossIncomeInputbox).verifyEqualsTo(expected);
	}
	
	@When("^user enters alphabetical and special chars \"([^\"]*)\"ZXCVBNM<>\\?\" in Gross Income input box$")
	public void user_enters_alphabetical_and_special_chars_in_Gross_Income_input_box(String expected) {
		setStepName("Then");
		findByAny(grossIncomeInputbox).clear();
		findByAny(grossIncomeInputbox).sendKeys(expected);
	}
}
