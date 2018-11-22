package stepDefinitions.Lending;

import static com.factory.mobile.driver.MobileDriverManager.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GrossIncome extends CommonLibrary {
	public static String grossIncomeScreenTitle;
	public static String grossIncomeScreenHeader;
	public static String grossIncomeInputbox;
	public static String grossIncomeCurrencySymbol;
	public static String grossIncomeWarning;

	@Then("^verify that Gross Income screen is displayed$")
	public void verify_that_Gross_Income_screen_is_displayed() {
		findByAny(grossIncomeScreenTitle).isDisabled();
	}

	@Given("^that user is on Gross Income screen$")
	public void that_user_is_on_Gross_Income_screen() {
		findByAny(grossIncomeScreenHeader).isDisplayed();
	}

	@Then("^verify that Gross Income header is displayed$")
	public void verify_that_Gross_Income_header_is_displayed() {
		findByAny(grossIncomeScreenHeader).isDisplayed();
	}

	@Then("^verify that Gross Income inputbox is displayed$")
	public void verify_that_Gross_Income_inputbox_is_displayed() {
		findByAny(grossIncomeInputbox).isDisplayed();
	}

	@Then("^verify that default value of Gross Income is \"([^\"]*)\"$")
	public void verify_that_default_value_of_Gross_Income_is(String expected) {
		findByAny(grossIncomeInputbox).verifyEqualsTo(expected);
	}

	@Then("^verify that currency symblol \"([^\"]*)\" is diplayed$")
	public void verify_that_currency_symblol_is_diplayed(String expected) {
		findByAny(grossIncomeCurrencySymbol).verifyEqualsTo(expected);
	}

	@When("^user enters minimum value \"([^\"]*)\" in Gross Income input box$")
	public void user_enters_minimum_value_in_Gross_Income_input_box(String expected) {
		findByAny(grossIncomeInputbox).sendKeys(expected);
	}

	@When("^vefify that warning message is not displayed$")
	public void vefify_that_warning_message_is_not_displayed() {
		functionNotImplemented();
//		findByAny(grossIncomeWarning).isHidden();
	}

	@When("^user enters maximum value \"([^\"]*)\" in Gross Income input box$")
	public void user_enters_maximum_value_in_Gross_Income_input_box(String expected) {
		findByAny(grossIncomeInputbox).sendKeys(expected);
	}

	@Then("^verify that value of Gross Income is set to \"([^\"]*)\" min limit$")
	public void verify_that_value_of_Gross_Income_is_set_to_min_limit(String expected) {
		findByAny(grossIncomeInputbox).verifyEqualsTo(expected);
	}

	@Then("^verify that value of Gross Income is set to \"([^\"]*)\" max limit$")
	public void verify_that_value_of_Gross_Income_is_set_to_max_limit(String expected) {
		findByAny(grossIncomeInputbox).verifyEqualsTo(expected);
	}

	@When("^user enters alphabetical and special chars \"([^\"]*)\"ZXCVBNM<>\\?\" in Gross Income input box$")
	public void user_enters_alphabetical_and_special_chars_in_Gross_Income_input_box(String expected) {
		findByAny(grossIncomeInputbox).sendKeys(expected);
	}

}
