package lending.overdrafts.post_TnC;

import static com.factory.mobile.driver.AppiumDriverManager.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lending.common.library.CommonLibrary;
import lending.common.library.CommonStepDefinitions;
import lending.overdrafts.pre_TnC.AmountOfBorrowing;

public class TailorOffer extends CommonLibrary {
	public static String hint;
	public static String dailyFee;
	public static String monthlyFee;
	public static String feeAndAIR;

	@Then("^verify that Tailor Offer screen is visible$")
	public void verify_that_Tailor_Offer_screen_is_visible() {
		setStepName("Then");
		captureScreenshot();
		findByAny(CommonStepDefinitions.screenTitle).isDisplayed();
		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();
	}

	@Given("^that user is on the Tailor Offer screen$")
	public void that_user_is_on_the_Tailor_Offer_screen() {
		setStepName("Then");
		findByAny(CommonStepDefinitions.screenTitle).isDisplayed();
		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();
	}

	@Then("^verify that header \"([^\"]*)\" is displayed on Tailor Offer screen$")
	public void verify_that_header_is_displayed_on_Tailor_Offer_screen(String arg1) {
		setStepName("Then");
		findByAny(CommonStepDefinitions.screenQuestion).verifyEqualsTo(arg1);
	}

	@Then("^verify that min default value \"([^\"]*)\" is displayed on Tailor Offer screen$")
	public void verify_that_min_default_value_is_displayed_on_Tailor_Offer_screen(String arg1) {
		setStepName("Then");
		findByAny(AmountOfBorrowing.amtOfBorrowingInput).as("Tailor Offer Input").verifyEqualsTo(arg1);
	}

	@Then("^verify that max \"([^\"]*)\" suitable amount is displayed on Trailor Offer screen$")
	public void verify_that_max_suitable_amount_is_displayed_on_Trailor_Offer_screen(String arg1) {
		setStepName("Then");
		findByAny(AmountOfBorrowing.amtOfBorrowingMax).as("Suitable Offer Max Amount")
				.verifyEqualsTo(arg1 + persistentValue.get("maxAmount").replace(".00", ""));
	}

	@Then("^verify that daily, monthly and AIR fee and rate are displayed correctly$")
	public void verify_that_daily_monthly_and_AIR_fee_and_rate_are_displayed_correctly(DataTable expected) {
		setStepName("Then");
		findByAny(feeAndAIR).verifyAllEqualsTo(expected);
	}

	@Then("^user clicks Annual Interest Rate icon on the screen$")
	public void user_clicks_Annual_Interest_Rate_icon_on_the_screen() {
		setStepName("Then");
		findByAny(feeAndAIR).click();
		sleep(1000);
	}
	
	@When("^user moves slider to (\\d+) percent of maximum value on Tailor Offer screen$")
	public void user_moves_slider_to_percent_of_maximum_value_on_Tailor_Offer_screen(float arg1) {
		setStepName("Then");
		findByAny(AmountOfBorrowing.amtOfBorrowingSlider).setValue(arg1 / 100);
		sleep(1000);
		captureScreenshot();
		String amount = findByAny(AmountOfBorrowing.amtOfBorrowingInput).getText();
		setAmountAndFeeinPersistentValue(amount);
	}

	@Then("^verify that fee has calculated correctly on Tailor Offer screen$")
	public void verify_that_fee_has_calculated_correctly_on_Tailor_Offer_screen() {
		setStepName("Then");
		findByAny(dailyFee).as("Daily Fee")
				.verifyContains("Daily fee £" + persistentValue.get("dailyFee"));
		findByAny(monthlyFee).as("Monthly Fee")
				.verifyContains("Monthly fee max £" + persistentValue.get("monthlyFee"));
	}

	@When("^user clicks on Suitable Amount input box to open keyboard on Tailor Offer screen$")
	public void user_change_the_offer_amount_with_keyboard_on_Tailor_Offer_screen() {
		setStepName("Then");
		findByAny(AmountOfBorrowing.amtOfBorrowingInput).click();
		findByAny(AmountOfBorrowing.done).isDisplayed();
	}

	@Then("^user clicks on Done button on Input keypad screen$")
	public void user_clicks_on_Done_button_on_Input_keypad_screen() {
		setStepName("Then");
		findByAny(AmountOfBorrowing.done).click();
		sleep(1000);
		captureScreenshot();
		String amount = findByAny(AmountOfBorrowing.amtOfBorrowingInput).getText();
		setAmountAndFeeinPersistentValue(amount);
	}

	public static void setAmountAndFeeinPersistentValue(String amount) {
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.DOWN);
		amount = amount.replace(",", "").replace("£", "");
		double amountInt = Integer.parseInt(amount);
		double dailyRate = 1.5 / 36500;
		String dailyFee = df.format(amountInt * dailyRate);
		String monthlyFee = df.format(Float.parseFloat(dailyFee) * 31);
		System.out.println("sliderAmount: " + amount + ", DailyFee: " + dailyFee + ", MonthlyFee: " + monthlyFee);
		persistentValue.put("sliderAmount", amount);
		persistentValue.put("dailyFee", dailyFee);
		persistentValue.put("monthlyFee", monthlyFee);
	}
	
	public static void setMaximumAmount(String amount) {
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.DOWN);
		amount = amount.replace(",", "").replace("£", "");
		persistentValue.put("maxAmount", amount);
	}

}
