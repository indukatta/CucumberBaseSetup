package lending.overdrafts.post_TnC;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lending.overdrafts.pre_TnC.AmountOfBorrowing;

import static com.factory.mobile.driver.AppiumDriverManager.*;

public class PreciseInputbox {

	@Then("^verify that precise input box values appears on the screen$")
	public void verify_that_precise_input_box_values_appears_on_the_screen() {
		setStepName("Then");
		captureScreenshot();
		findByAny(AmountOfBorrowing.done);
	}

	@Then("^verify that cancel button is displayed on top corner on the screen$")
	public void verify_that_cancel_button_is_displayed_on_top_corner_on_the_screen() {
		setStepName("Then");
		findByAny(AmountOfBorrowing.cancel).isDisplayed();
	}

	@Then("^verify that min value \"([^\"]*)\" is displayed in input box$")
	public void verify_that_min_value_is_displayed_in_input_box(String expected) {
		setStepName("Then");
		findByAny(AmountOfBorrowing.amtOfBorrowingInput).click();
		findByAny(AmountOfBorrowing.amtOfBorrowingInput).verifyEqualsTo(expected);
	}

	@Then("^verify that hint text is displayed on Tailor Offer screen$")
	public void verify_that_hint_text_is_displayed_on_Tailor_Offer_screen() {
		setStepName("Then");
		findByAny(AmountOfBorrowing.done);
	}

	@Then("^verify that min value \"([^\"]*)\" is displayed in hint text$")
	public void verify_that_min_value_is_displayed_in_hint_text(String expected) {
		setStepName("Then");
		findByAny(AmountOfBorrowing.done);
	}

	@Then("^verify that suitable amount as max value is displayed in hint text$")
	public void verify_that_suitable_amount_as_max_value_is_displayed_in_hint_text() {
		setStepName("Then");
		findByAny(AmountOfBorrowing.done);
	}

	@Then("^verify that Done button is enabled on the screen$")
	public void verify_that_Done_button_is_enabled_on_the_screen() {
		setStepName("Then");
		findByAny(AmountOfBorrowing.done);
	}

	@Given("^that user is on precise input screen$")
	public void that_user_is_on_precise_input_screen_for_tailor_offer() {
		setStepName("Given");
		findByAny(AmountOfBorrowing.done).isDisplayed();
	}

	@When("^user enter \"([^\"]*)\" in precise input box on the screen$")
	public void user_enter_in_precise_input_box_on_the_screen(String keys) {
		setStepName("When");
		findByAny(AmountOfBorrowing.amtOfBorrowingInput).clear();
		findByAny(AmountOfBorrowing.amtOfBorrowingInput).sendKeys(keys);;
	}

	@Then("^verify that Done button is disabled on the screen$")
	public void verify_that_Done_button_is_disabled_on_the_screen() {
		setStepName("Then");
		findByAny(AmountOfBorrowing.done).isDisabled();
	}

	@When("^user enter more than allowed value in precise input box on the screen$")
	public void user_enter_more_than_allowed_value_in_precise_input_box_on_the_screen() {
		setStepName("When");
		findByAny(AmountOfBorrowing.amtOfBorrowingInput);
	}

	@When("^user enter valid allowed value in precise input box on the screen$")
	public void user_enter_valid_allowed_value_in_precise_input_box_on_the_screen() {
		setStepName("Then");
		findByAny(AmountOfBorrowing.done);
	}

	@Then("^user clicks on cancel button on the screen$")
	public void user_clicks_on_cancel_button_on_the_screen() {
		setStepName("Then");
		findByAny(AmountOfBorrowing.cancel).click();
	}

	@Then("^verify that entered values does not displayed in input box$")
	public void verify_that_entered_values_does_not_displayed_in_input_box() {
		setStepName("Then");
		findByAny(AmountOfBorrowing.done);
	}

	@Then("^user tap on input box to bring the keyboard up for precise input$")
	public void user_tap_on_input_box_to_bring_the_keyboard_up_for_precise_input() {
		setStepName("Then");
		findByAny(AmountOfBorrowing.amtOfBorrowingInput).click();
	}

	@Then("^verify that slider value is apparing in the precise input box$")
	public void verify_that_slider_value_is_apparing_in_the_precise_input_box() {
		setStepName("Then");
		findByAny(AmountOfBorrowing.done);
	}

	@Then("^user clicks on Done button on the screen$")
	public void user_clicks_on_Done_button_on_the_screen() {
		setStepName("Then");
		findByAny(AmountOfBorrowing.done).click();
		captureScreenshot();
	}

}
