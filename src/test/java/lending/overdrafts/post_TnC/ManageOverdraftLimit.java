package lending.overdrafts.post_TnC;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import lending.common.library.CommonLibrary;
import lending.common.library.CommonStepDefinitions;

import static com.factory.mobile.driver.AppiumDriverManager.*;

public class ManageOverdraftLimit extends CommonLibrary {
	
	public static String overdraftLimitInput;
	public static String overdraftLimitSlider;
	public static String overdraftLimitMax;
	public static String overdraftLimitAIR;
	public static String overdraftLimitValue;
	public static String changeLimitButton;
	public static String removeOverdraftButton;

	@Then("^verify that Manage Overdraft Limit screen is displayed$")
	public void verify_that_Manage_Overdraft_Limit_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot();
		findByAny(CommonStepDefinitions.screenTitle).as("Manage OD Limit Screen Title").isDisplayed();
		findByAny(CommonStepDefinitions.screenQuestion).as("Manage OD Limit Screen Heading").isDisplayed();
	}

	@Given("^that user is on Manage Overdraft Limit screen$")
	public void that_user_is_on_Manage_Overdraft_Limit_screen() throws Throwable {
		setStepName("Given");
		findByAny(CommonStepDefinitions.screenQuestion).as("Manage OD Limit Screen Heading").isDisplayed();
	}

	@Then("^verify that screen title \"([^\"]*)\" is displayed on the screen$")
	public void verify_that_screen_title_is_displayed_on_the_screen(String arg1) throws Throwable {
		setStepName("Then");
		findByAny(CommonStepDefinitions.screenTitle).as("Manage OD Limit Screen Title").verifyEqualsTo(arg1);
	}

	@Then("^verify that existing overdraft limit is displayed on the screen$")
	public void verify_that_existing_overdraft_limit_is_displayed_on_the_screen() throws Throwable {
		setStepName("Then");
		String expected = "ValueNotCalculated";
		findByAny(overdraftLimitInput).as("Manage Overdraft Limit").verifyEqualsTo(expected);
	}

	@Then("^verify that max \"([^\"]*)\" value is displayed on the screen$")
	public void verify_that_max_value_is_displayed_on_the_screen(String arg1) throws Throwable {
		setStepName("Then");
		findByAny(overdraftLimitMax).verifyEqualsTo(arg1);
	}

	@Then("^verify that AIR component \"([^\"]*)\" is displayed on the screen$")
	public void verify_that_AIR_component_is_displayed_on_the_screen(String arg1) throws Throwable {
		setStepName("Then");
		findByAny(overdraftLimitAIR).verifyEqualsTo(arg1);
	}

	@Then("^verify that AIR value \"([^\"]*)\" is displayed on the screen$")
	public void verify_that_AIR_value_is_displayed_on_the_screen(String arg1) throws Throwable {
		setStepName("Then");
		findByAny(overdraftLimitValue).verifyEqualsTo(arg1);
	}

	@Then("^verify that change limit \"([^\"]*)\" button is disabled$")
	public void verify_that_change_limit_button_is_disabled(String arg1) throws Throwable {
		setStepName("Then");
		findByAny(changeLimitButton).verifyEqualsTo(arg1);
		findByAny(changeLimitButton).isDisabled();
	}

	@Then("^verify that remove overdraft \"([^\"]*)\" button is disabled$")
	public void verify_that_remove_overdraft_button_is_disabled(String arg1) throws Throwable {
		setStepName("Then");
		findByAny(removeOverdraftButton).verifyEqualsTo(arg1);
		findByAny(removeOverdraftButton).isDisabled();
	}

	@Then("^verify that slider amount \"([^\"]*)\" is appearing on input box component$")
	public void verify_that_slider_amount_is_appearing_on_input_box_component(String arg1) throws Throwable {
		setStepName("Then");
		findByAny(overdraftLimitInput).verifyEqualsTo(arg1);
	}

	@Then("^user enters existing overdraft limit in precise entry screen$")
	public void user_enters_existing_overdraft_limit_in_precise_entry_screen() throws Throwable {
		setStepName("Then");
		String existingOD = "123456";
		findByAny(overdraftLimitInput).sendKeys(existingOD);
	}

	@Then("^verify that change limit button is disabled on the screen$")
	public void verify_that_change_limit_button_is_disabled_on_the_screen() throws Throwable {
		setStepName("Then");
		findByAny(changeLimitButton).isDisabled();
	}

}
