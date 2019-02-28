package lending.overdrafts.post_TnC;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lending.overdrafts.pre_TnC.AmountOfBorrowing;
import lending.overdrafts.pre_TnC.CommonLibrary;

import static com.factory.mobile.driver.AppiumDriverManager.*;

public class PreciseInputbox extends CommonLibrary {

	@Then("^verify that precise input box appears on the screen$")
	public void verify_that_precise_input_box_values_appears_on_the_screen() {
		setStepName("Then");
		captureScreenshot();
		findByAny(AmountOfBorrowing.amtOfBorrowingInput).isDisplayed();
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

	@Then("^verify that hint text \"([^\"]*)\" is displayed on Tailor Offer screen$")
	public void verify_that_hint_text_is_displayed_on_Tailor_Offer_screen(String expected) {
		setStepName("Then");
		findByAny(TailorOffer.hint).isDisplayed();
//		expected = expected.replace("{MaxAmount}", persistentValue.get("sliderAmount"));
		findByAny(TailorOffer.hint).verifyContains(expected);
	}

	@Then("^verify that Done button is enabled on the screen$")
	public void verify_that_Done_button_is_enabled_on_the_screen() {
		setStepName("Then");
		findByAny(AmountOfBorrowing.done).isEnabled();
	}

	@Given("^that user is on precise input screen$")
	public void that_user_is_on_precise_input_screen_for_tailor_offer() {
		setStepName("Given");
		findByAny(AmountOfBorrowing.amtOfBorrowingInput).isDisplayed();
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

	@When("^user enter greater than allowed value in precise input box on the screen$")
	public void user_enter_greater_than_allowed_value_in_precise_input_box_on_the_screen() {
		setStepName("When");
		findByAny(AmountOfBorrowing.amtOfBorrowingInput).clear();
		String greaterThanAllowed = (Integer.parseInt(persistentValue.get("maxAmount"))+10)+"";
		persistentValue.put("valueNotToBeAppear", greaterThanAllowed);
		findByAny(AmountOfBorrowing.amtOfBorrowingInput).sendKeys(greaterThanAllowed);
		
	}

	@When("^user enter valid allowed value in precise input box on the screen$")
	public void user_enter_valid_allowed_value_in_precise_input_box_on_the_screen() {
		setStepName("Then");
		findByAny(AmountOfBorrowing.amtOfBorrowingInput).clear();
		persistentValue.put("valueNotToBeAppear", persistentValue.get("sliderAmount"));
		findByAny(AmountOfBorrowing.amtOfBorrowingInput).sendKeys(persistentValue.get("maxAmount"));
	}

	@Then("^user clicks on cancel button on the screen$")
	public void user_clicks_on_cancel_button_on_the_screen() {
		setStepName("Then");
		findByAny(AmountOfBorrowing.cancel).click();
	}

	@Then("^verify that entered values does not displayed in input box$")
	public void verify_that_entered_values_does_not_displayed_in_input_box() {
		setStepName("Then");
		findByAny(AmountOfBorrowing.amtOfBorrowingInput).verifyNotEqualsTo(persistentValue.get("valueNotToBeAppear"));
	}

	@Then("^user tap on input box to bring the keyboard up for precise input$")
	public void user_tap_on_input_box_to_bring_the_keyboard_up_for_precise_input() {
		setStepName("Then");
		String amount = findByAny(AmountOfBorrowing.amtOfBorrowingInput).getText();
		TailorOffer.setAmountAndFeeinPersistentValue(amount);
		
		findByAny(AmountOfBorrowing.amtOfBorrowingInput).click();
		sleep(1000);
	}

	@Then("^verify that slider value is apparing in the precise input box$")
	public void verify_that_slider_value_is_apparing_in_the_precise_input_box() {
		setStepName("Then");
		findByAny(AmountOfBorrowing.amtOfBorrowingInput).verifyEqualsTo("£"+persistentValue.get("sliderAmount"));
	}

	@Then("^user clicks on Done button on the screen$")
	public void user_clicks_on_Done_button_on_the_screen() {
		setStepName("Then");
		findByAny(AmountOfBorrowing.done).click();
		captureScreenshot();
		String amount = findByAny(AmountOfBorrowing.amtOfBorrowingInput).getText();
		TailorOffer.setAmountAndFeeinPersistentValue(amount);
	}

}
