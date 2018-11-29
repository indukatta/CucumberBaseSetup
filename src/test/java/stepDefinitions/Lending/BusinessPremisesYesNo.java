package stepDefinitions.Lending;

import static com.factory.mobile.driver.MobileDriverManager.captureScreenshot;
import static com.factory.mobile.driver.MobileDriverManager.findByAny;
import static com.factory.mobile.driver.MobileDriverManager.setStepName;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BusinessPremisesYesNo extends CommonLibrary {
	public static String screenTitle;
	public static String bpScreenHeader;
	public static String bpYes;
	public static String bpNo;

	@Then("^verify that Business Premises YesNo screen is displayed$")
	public void verify_that_Business_Premises_YesNo_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot("BusinessPremisesYesNo_0");
		findByAny(screenTitle).isDisplayed();
		findByAny(bpScreenHeader).isDisplayed();
	}

	@Given("^that user is on Business Premises YesNo screen$")
	public void that_user_is_on_Business_Premises_YesNo_screen() {
		setStepName("Given");
		findByAny(screenTitle).isDisplayed();
		findByAny(bpScreenHeader).isDisplayed();	
	}

	@Then("^verify that Business Premises header \"([^\"]*)\" is displayed$")
	public void verify_that_Business_Premises_header_is_displayed(String expected) {
		setStepName("Then");
		findByAny(bpScreenHeader).isDisplayed();
	}

	@Then("^verify that Yes button is displayed on Business Premises screen$")
	public void verify_that_Yes_button_is_displayed_on_Business_Premises_screen() {
		setStepName("Then");
		findByAny(bpYes).isDisplayed();
	}

	@Then("^verify that No button is displayed on Business Premises screen$")
	public void verify_that_No_button_is_displayed_on_Business_Premises_screen() {
		setStepName("Then");
		findByAny(bpNo).isDisplayed();
	}

	@Then("^verify that Yes button is not selected on Business Premises screen$")
	public void verify_that_Yes_button_is_not_selected_on_Business_Premises_screen() {
		setStepName("Then");
		findByAny(bpYes).verifyAttributesEqualsTo("value", "0");
	}

	@Then("^verify that No button is not selected on Business Premises screen$")
	public void verify_that_No_button_is_not_selected_on_Business_Premises_screen() {
		setStepName("Then");
		findByAny(bpNo).verifyAttributesEqualsTo("value", "0");
	}

	@When("^user clicks on No button on Business Premises screen$")
	public void user_clicks_on_No_button_on_Business_Premises_screen() {
		setStepName("Then");
		findByAny(bpNo).click();
		sleep(2000);
	}

	@When("^user clicks on Yes button on Business Premises screen$")
	public void user_clicks_on_Yes_button_on_Business_Premises_screen() {
		setStepName("Then");
		findByAny(bpYes).click();
		sleep(2000);
	}

}
