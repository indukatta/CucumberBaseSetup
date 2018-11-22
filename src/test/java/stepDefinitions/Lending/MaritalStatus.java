package stepDefinitions.Lending;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.factory.mobile.driver.MobileDriverManager.*;

public class MaritalStatus {
	public static String screenTitle;
	public static String screenHeader;
	public static String questionAnswer;
	public static String questionAnswerCivilPartnership;
	public static String questionAnswerMarried;
	public static String questionAnswerSingle;
	
	@Given("^user is on Marital Status lending question screen$")
	public void user_is_on_Marital_Status_lending_question_screen() {
		findByAccessibilityId(screenTitle).isDisplayed();
		findByAccessibilityId(screenHeader).isDisplayed();
	}

	@Then("^verify that Marital Status description \"([^\"]*)\" on screen$")
	public void verify_that_Marital_Status_description_on_screen(String expect) {
		findByAccessibilityId(screenHeader).isDisplayed();
	}

	@Then("^verify that below Marital Status options are displayed$")
	public void verify_that_below_Marital_Status_options_are_displayed(DataTable expected) {
		findByAccessibilityId(questionAnswer).verifyAllEqualsTo(expected);
	}

	@Then("^verify that none of the options are pre selected$")
	public void verify_that_none_of_the_options_are_pre_selected() {
		findByAccessibilityId(questionAnswer).isAllDeselected();
	}

	@When("^user clicks on Civil partnership option on Marital Status screen$")
	public void user_clicks_on_Civil_partnership_option_on_Marital_Status_screen() {
		findByAccessibilityId(questionAnswerCivilPartnership).click();
	}

	@When("^user clicks on Married option on Marital Status screen$")
	public void user_clicks_on_Married_option_on_Marital_Status_screen() {
		findByAccessibilityId(questionAnswerMarried).click();
	}

	@Then("^verify that Civil partnership option is deselected$")
	public void verify_that_Civil_partnership_option_is_deselected() {
		findByAccessibilityId(questionAnswerCivilPartnership).isDeselected();
	}

	@When("^user clicks on Single option on Marital Status screen$")
	public void user_clicks_on_Single_option_on_Marital_Status_screen() {
		findByAccessibilityId(questionAnswerSingle).click();
	}

}
