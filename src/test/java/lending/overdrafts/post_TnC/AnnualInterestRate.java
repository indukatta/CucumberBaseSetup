package lending.overdrafts.post_TnC;

import static com.factory.mobile.driver.AppiumDriverManager.*;

import cucumber.api.java.en.Then;
import lending.common.library.CommonLibrary;

public class AnnualInterestRate extends CommonLibrary {

	public static String screenHeading = "custom_title_label";
	public static String textAIRMade = "lending_screen_custom_text_element_accessibility_id_0_0";
	public static String textBankOfAmerica = "lending_screen_custom_text_element_accessibility_id_1_0";
	public static String textHSBC = "lending_screen_custom_text_element_accessibility_id_1_1";
	public static String closeButton = "lending_secondary_button";

	@Then("^verify that Annual Interest Rate screen is displayed$")
	public void verify_that_Annual_Interest_Rate_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot();
		findByAny(screenHeading).isDisplayed();
		findByAny(textAIRMade).isDisplayed();
	}

	@Then("^user clicks on Close button on the AIR pop up$")
	public void user_clicks_on_Close_button_on_the_screen() {
		setStepName("Then");
		findByAny(closeButton).click();
		sleep(500);
	}
}
