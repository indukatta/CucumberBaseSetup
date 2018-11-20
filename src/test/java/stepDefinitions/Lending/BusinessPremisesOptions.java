package stepDefinitions.Lending;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.factory.mobile.driver.MobileDriverManager.*;

public class BusinessPremisesOptions {
	public static String bpScreenTitle;
	public static String bpTypeScreenHeader;
	public static String bpTypes;
	public static String bpTypeLeasehold;
	public static String bpTypeFreehold;

	@Then("^verify that Business Premises options screen is displayed$")
	public void verify_that_Business_Premises_options_screen_is_displayed() {
		findByAny(bpScreenTitle).isDisplayed();
	}

	@Then("^verify that Premises Business options header \"([^\"]*)\" is displayed$")
	public void verify_that_Premises_Business_options_header_is_displayed(String expected) {
		findByAny(bpTypeScreenHeader).isDisplayed();
	}

	@Given("^that user is on Business Premises options screen$")
	public void that_user_is_on_Business_Premises_options_screen() {
		findByAny(bpTypeScreenHeader).isDisplayed();
	}

	@Then("^verify that Freehold Business Premises type is displayed$")
	public void verify_that_Freehold_Business_Premises_type_is_displayed() {
		findByAny(bpTypeFreehold).isDisplayed();
	}

	@Then("^verify that Leasehold Business Premises type is displayed$")
	public void verify_that_Leasehold_Business_Premises_type_is_displayed() {
		findByAny(bpTypeLeasehold).isDisplayed();
	}

	@Then("^verify that Freehold Business Premises type is not selected$")
	public void verify_that_Freehold_Business_Premises_type_is_not_selected() {
		findByAny(bpTypeFreehold).isDeselected();
	}

	@Then("^verify that Leasehold Business Premises type is not selected$")
	public void verify_that_Leasehold_Business_Premises_type_is_not_selected() {
		findByAny(bpTypeLeasehold).isDeselected();
	}

	@When("^user clicks on Freehold Business Premises type$")
	public void user_clicks_on_Freehold_Business_Premises_type() {
		findByAny(bpTypeFreehold).click();
	}

	@When("^user clicks on Leasehold Business Premises type$")
	public void user_clicks_on_Leasehold_Business_Premises_type() {
		findByAny(bpTypeLeasehold).click();
	}

}
