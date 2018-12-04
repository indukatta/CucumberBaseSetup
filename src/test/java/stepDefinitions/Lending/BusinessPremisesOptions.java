package stepDefinitions.Lending;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.factory.mobile.driver.MobileDriverManager.*;

public class BusinessPremisesOptions {
	public static String screenTitle;
	public static String bpTypeScreenHeader;
	public static String bpTypes;
	public static String bpTypeLeaseholdCkb;
	public static String bpTypeFreeholdCkb;
	public static String bpTypeLeasehold;
	public static String bpTypeFreehold;

	@Given("^that user is on Business Premises options screen$")
	public void that_user_is_on_Business_Premises_options_screen() {
		setStepName("Given");
		findByAny(bpTypeScreenHeader).isDisplayed();
	}

	@Then("^verify that Business Premises options screen is displayed$")
	public void verify_that_Business_Premises_options_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot("BusinessPremises");
		findByAny(screenTitle).isDisplayed();
		findByAny(bpTypeScreenHeader).isDisplayed();
	}

	@Then("^verify that Premises Business options header \"([^\"]*)\" is displayed$")
	public void verify_that_Premises_Business_options_header_is_displayed(String expected) {
		setStepName("Then");
		findByAny(bpTypeScreenHeader).verifyEqualsTo(expected);
	}

	@When("^user clicks on Freehold Business Premises type$")
	public void user_clicks_on_Freehold_Business_Premises_type() {
		setStepName("Then");
		findByAny(bpTypeFreehold).click();
	}

	@When("^user clicks on Leasehold Business Premises type$")
	public void user_clicks_on_Leasehold_Business_Premises_type() {
		setStepName("Then");
		findByAny(bpTypeLeasehold).click();
	}
	
	@Then("^verify that Freehold Business Premises type \"([^\"]*)\" is displayed$")
	public void verify_that_Freehold_Business_Premises_type_is_displayed(String expected) {
		setStepName("Then");
		findByAny(bpTypeFreehold).isDisplayed();
		findByAny(bpTypeFreehold).verifyEqualsTo(expected);
	}

	@Then("^verify that Leasehold Business Premises type \"([^\"]*)\" is displayed$")
	public void verify_that_Leasehold_Business_Premises_type_is_displayed(String expected) {
		setStepName("Then");
		findByAny(bpTypeLeasehold).isDisplayed();
		findByAny(bpTypeLeasehold).verifyEqualsTo(expected);
	}

	@Then("^verify that non of the Business Premises type is pre selected$")
	public void verify_that_non_of_the_Business_Premises_type_is_pre_selected() {
		setStepName("Then");
		findByAny(bpTypes).verifyAttributesAllEqualsTo("value", "0");
	}
	@Then("^verify that Leasehold Business Premises type is not selected$")
	public void verify_that_Leasehold_Business_Premises_type_is_not_selected() {
		setStepName("Then");
		captureScreenshot();
		findByAny(bpTypeLeaseholdCkb).verifyAttributesEqualsTo("value", "0");
	}

	@Then("^verify that Freehold Business Premises type is not selected$")
	public void verify_that_Freehold_Business_Premises_type_is_not_selected() {
		setStepName("Then");
		captureScreenshot();
		findByAny(bpTypeFreeholdCkb).verifyAttributesEqualsTo("value", "0");
	}
}
