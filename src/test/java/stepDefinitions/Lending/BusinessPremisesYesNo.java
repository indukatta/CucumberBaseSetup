package stepDefinitions.Lending;

import static com.factory.mobile.driver.MobileDriverManager.findByAny;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BusinessPremisesYesNo extends CommonLibrary {
	public static String bpScreenTitle;
	public static String bpScreenHeader;
	public static String bpYes;
	public static String bpNo;

	@Then("^verify that Business Premises YesNo screen is displayed$")
	public void verify_that_Business_Premises_YesNo_screen_is_displayed() {
		findByAny(bpScreenTitle).isDisplayed();
		findByAny(bpScreenHeader).isDisplayed();
	}

	@Given("^that user is on Business Premises YesNo screen$")
	public void that_user_is_on_Business_Premises_YesNo_screen() {
		findByAny(bpScreenTitle).isDisplayed();
		findByAny(bpScreenHeader).isDisplayed();	
	}

	@Then("^verify that Business Premises header \"([^\"]*)\" is displayed$")
	public void verify_that_Business_Premises_header_is_displayed(String expected) {
		findByAny(bpScreenHeader).isDisplayed();
	}

	@Then("^verify that Yes button is displayed on Business Premises screen$")
	public void verify_that_Yes_button_is_displayed_on_Business_Premises_screen() {
		findByAny(bpYes).isDisplayed();
	}

	@Then("^verify that No button is displayed on Business Premises screen$")
	public void verify_that_No_button_is_displayed_on_Business_Premises_screen() {
		findByAny(bpNo).isDisplayed();
	}

	@Then("^verify that Yes button is not selected on Business Premises screen$")
	public void verify_that_Yes_button_is_not_selected_on_Business_Premises_screen() {
		findByAny(bpYes).isDeselected();
	}

	@Then("^verify that No button is not selected on Business Premises screen$")
	public void verify_that_No_button_is_not_selected_on_Business_Premises_screen() {
		findByAny(bpNo).isDeselected();
	}

	@When("^user clicks on No button on Business Premises screen$")
	public void user_clicks_on_No_button_on_Business_Premises_screen() {
		findByAny(bpNo).click();
	}

	@Then("^verify that Question screen is displayed$")
	public void verify_that_Question_screen_is_displayed() {
		functionNotImplemented();
	}

	@When("^user clicks on Yes button on Business Premises screen$")
	public void user_clicks_on_Yes_button_on_Business_Premises_screen() {
		findByAny(bpYes).click();
	}

}
