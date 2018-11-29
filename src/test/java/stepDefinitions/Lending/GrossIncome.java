package stepDefinitions.Lending;

import static com.factory.mobile.driver.MobileDriverManager.*;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GrossIncome extends CommonLibrary {
	public static String screenTitle;
	public static String backButton;
	public static String screenHeader;
	public static String grossIncomeInfo;
	public static String grossIncomeInputbox;
	public static String grossIncomeCurrencySymbol;

	@Given("^that user is on Gross Income screen$")
	public void that_user_is_on_Gross_Income_screen() {
		setStepName("Given");
		findByAny(screenTitle).isDisplayed();
		findByAny(screenHeader).isDisplayed();
	}

	@Then("^verify that Gross Income screen is displayed$")
	public void verify_that_Gross_Income_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot("GrossIncome_0");
		findByAny(screenTitle).isDisplayed();
		findByAny(screenHeader).isDisplayed();
	}

	@Then("^verify that Gross Income header is displayed$")
	public void verify_that_Gross_Income_header_is_displayed() {
		setStepName("Then");
		findByAny(screenTitle).isDisplayed();
		findByAny(screenHeader).isDisplayed();
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

	@Then("^verify that currency symbol \"([^\"]*)\" is displayed$")
	public void verify_that_currency_symblol_is_diplayed(String expected) {
		setStepName("Then");
		findByAny(grossIncomeCurrencySymbol).verifyEqualsTo(expected);
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

	@When("^user enters alphabetical and special chars \"([^\"]*)\"ZXCVBNM<>\\?\" in Gross Income input box$")
	public void user_enters_alphabetical_and_special_chars_in_Gross_Income_input_box(String expected) {
		setStepName("Then");
		findByAny(grossIncomeInputbox).clear();
		findByAny(grossIncomeInputbox).sendKeys(expected);
	}
	
	@And("^user clicks on back button on the screen$")
	public void user_clicks_on_back_button_on_the_screen() {
		setStepName("Then");
		findByAny(backButton).click();
		sleep(3000);
	}

}
