package stepDefinitions.Lending;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.factory.mobile.driver.MobileDriverManager.*;

public class ResidentialStatus {
	public static String screenTitle;
	public static String screenHeader;
	public static String questionAnswer;
	public static String questionAnswerTenant;
	public static String questionAnswerHallOfResidence;
	public static String questionAnswerOwnerOccupier;
	
	@Given("^user is on Residential Status lending question screen$")
	public void user_is_on_Residential_Status_lending_question_screen() {
		setStepName("Given");
		findByAny(screenTitle).isDisabled();
		findByAny(screenHeader).isDisabled();
	}

	@Then("^verify that Residential Status description \"([^\"]*)\" on screen$")
	public void verify_that_Residential_Status_description_on_screen(String expected) {
		setStepName("Then");
		findByAny(screenHeader).verifyEqualsTo(expected);
	}

	@Then("^verify that below Residential Status options are displayed$")
	public void verify_that_below_Residential_Status_options_are_displayed(DataTable expected) {
		setStepName("Then");
		findByAny(questionAnswer).verifyAllEqualsTo(expected);
	}

	@When("^user clicks on Halls of residence option on Residential Status screen$")
	public void user_clicks_on_Halls_of_residence_option_on_Residential_Status_screen() {
		setStepName("When");
		findByAny(questionAnswerHallOfResidence).click();
	}

	@When("^user clicks on Owner occupier option on Residential Status screen$")
	public void user_clicks_on_Owner_occupier_option_on_Residential_Status_screen() {
		setStepName("When");
		findByAny(questionAnswerOwnerOccupier).click();
	}

	@Then("^verify that Halls of residence option is deselected$")
	public void verify_that_Halls_of_residence_option_is_deselected() {
		setStepName("Then");
		findByAny(questionAnswerHallOfResidence).isDeselected();
	}

	@When("^user clicks on Tenant option on Residential Status screen$")
	public void user_clicks_on_Tenant_option_on_Residential_Status_screen() {
		setStepName("When");
		findByAny(questionAnswerTenant).click();
	}

}
