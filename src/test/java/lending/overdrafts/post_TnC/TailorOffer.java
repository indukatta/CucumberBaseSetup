package lending.overdrafts.post_TnC;

import static com.factory.mobile.driver.AppiumDriverManager.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lending.overdrafts.pre_TnC.AmountOfBorrowing;
import lending.overdrafts.pre_TnC.CommonLibrary;
import lending.overdrafts.pre_TnC.CommonStepDefinitions;

public class TailorOffer extends CommonLibrary {

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

	@Then("^verify that max default value is displayed on Trailor Offer screen$")
	public void verify_that_max_default_value_is_displayed_on_Trailor_Offer_screen() {
		setStepName("Then");
		findByAny(AmountOfBorrowing.amtOfBorrowingMax).as("Suitable Offer Max Amount").verifyEqualsTo("£"+persistentValue.get("SuitableOfferAmt"));
	}

	@Then("^verify that \"([^\"]*)\" is displayed in rate and feed section$")
	public void verify_that_is_displayed_in_rate_and_feed_section(String arg1) {
		setStepName("Then");
		findByAny(AmountOfBorrowing.monthyFee).as("Suitable Offer Fee").verifyContains(arg1);
	}

	@When("^user selects the suitable offer amount on Tailor Offer screen$")
	public void user_selects_an_amount_on_Tailor_Offer_screen() {
		setStepName("Then");
		findByAny(AmountOfBorrowing.amtOfBorrowingSlider).setValue("0.8");
		sleep(1000);
		setAmountAndFeeinPersistentValue();
	}

	@Given("^user moves slider to \"([^\"]*)\" percent of maximum value on Tailor Offer screen$")
	public void user_moves_slider_to_percent_of_maximum_value_on_Tailor_Offer_screen(String arg1) {
		setStepName("Then");
		findByAny(AmountOfBorrowing.amtOfBorrowingSlider).setValue(Integer.parseInt(arg1.replace("%", ""))/100);
		sleep(1000);
		setAmountAndFeeinPersistentValue();
	}

	@Then("^verify that fee has calculated correctly on Tailor Offer screen$")
	public void verify_that_fee_has_calculated_correctly_on_Tailor_Offer_screen() {
		setStepName("Then");
		findByAny(AmountOfBorrowing.monthyFee).as("Daily Fee").verifyContains(persistentValue.get("DailyFee"));
		findByAny(AmountOfBorrowing.monthyFee).as("Monthly Fee").verifyContains(persistentValue.get("MonthlyFee"));
	}

	@When("^user clicks on Suitable Amount input box to open keyboard on Tailor Offer screen$")
	public void user_change_the_offer_amount_with_keyboard_on_Tailor_Offer_screen() {
		setStepName("Then");
		findByAny(AmountOfBorrowing.amtOfBorrowingInput).click();
		findByAny(AmountOfBorrowing.done).isDisplayed();
		findByAny(AmountOfBorrowing.amtOfBorrowingInput).sendKeys((Integer.parseInt(persistentValue.get("SuitableOfferAmt"))-50)+"");
	}
	
	@Then("^user clicks on Done button on Input keypad screen$")
	public void user_clicks_on_Done_button_on_Input_keypad_screen() {
		setStepName("Then");
		findByAny(AmountOfBorrowing.done).isEnabled();
		findByAny(AmountOfBorrowing.done).click();
		setAmountAndFeeinPersistentValue();
	}
	
	private void setAmountAndFeeinPersistentValue() {
		captureScreenshot();
		
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.DOWN);
		String amount = findByAny(AmountOfBorrowing.amtOfBorrowingInput).getText();
		amount = amount.replace(",", "").replace("£", "");
		double amountInt = Integer.parseInt(amount);
		double dailyRate = 1.5/36500;
		String dailyFee = df.format(amountInt * dailyRate);
		String monthlyFee = df.format(Double.parseDouble(dailyFee)*31);
		System.out.println("SuitableOfferAmt: "+ amount+"DailyFee: "+dailyFee+", MonthlyFee: "+monthlyFee);
		persistentValue.put("SuitableOfferAmt", amount);
		persistentValue.put("DailyFee", dailyFee);
		persistentValue.put("MonthlyFee", monthlyFee);
	}
	
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.DOWN);
		String amount = "3400";
		amount = amount.replace(",", "").replace("£", "");
		double amountInt = Integer.parseInt(amount);
		double dailyRate = 1.5/36500;
		String dailyFee = df.format(amountInt * dailyRate);
		String monthlyFee = Double.parseDouble(dailyFee)*31+"";
		System.out.println("SuitableOfferAmt: "+ amount+"DailyFee: "+dailyFee+", MonthlyFee: "+monthlyFee);
	}

}
