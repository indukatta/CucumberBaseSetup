package lending.overdrafts.pre_TnC;

import static com.factory.mobile.driver.AppiumDriverManager.captureScreenshot;
import static com.factory.mobile.driver.AppiumDriverManager.findByAny;
import static com.factory.mobile.driver.AppiumDriverManager.setStepName;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lending.common.library.CommonStepDefinitions;

public class YearsOfPersonalAccount {
	
	public static String numberOfYrsText = "number_question_text_field";
	public static String numberOfYrsMax = "number_question_max_label";
	public static String numberOfYrsSlider = "lending_question_slider_accessibility_id";
	
	@Then("^verify that Years of Personal Account screen is displayed$")
	public void verify_that_Years_of_Personal_Account_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot();
		findByAny(CommonStepDefinitions.screenTitle).isDisplayed();
		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();
	}

	@Given("^that user is on Years of Personal Account screen$")
	public void that_user_is_on_Years_of_Personal_Account_screen() {
		setStepName("Given");
		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();
	}

	@Then("^verify that Years of Personal Account question \"([^\"]*)\" is displayed$")
	public void verify_that_Credit_Card_header_is_displayed(String arg1) {
		setStepName("Then");
		findByAny(CommonStepDefinitions.screenQuestion).verifyEqualsTo(arg1);
	}

	@Then("^verify that maximum limit number of years \"([^\"]*)\" is displayed on the screen$")
	public void verify_that_maximum_limit_number_of_years_is_displayed_on_the_screen(String arg1) {
		setStepName("Then");
		findByAny(numberOfYrsMax).verifyEqualsTo(arg1);
	}

	@When("^user selects option (\\d+) on Years of Persoanl Account screen$")
	public void user_selects_option_on_Years_of_Persoanl_Account_screen(float arg1) {
		setStepName("When");
		findByAny(numberOfYrsSlider).setValue(arg1/10);
	}

	@Then("^verify that number of years field is equels to \"([^\"]*)\" on the screen$")
	public void verify_that_number_of_years_field_is_equels_to_on_the_screen(String arg1) {
		setStepName("Then");
		findByAny(numberOfYrsText).verifyEqualsTo(arg1);
	}
}
