package lending.overdrafts.post_TnC;

import cucumber.api.java.en.Then;
import lending.overdrafts.pre_TnC.CommonLibrary;

import static com.factory.mobile.driver.AppiumDriverManager.*;

public class ReApplyOverdraft extends CommonLibrary {
	public static String screenHeading;
	public static String screenBody;
	public static String whatNext;
	public static String declineFooter;
	public static String declineNotNow;

	@Then("^verify that Re-apply Overdraft screen is displayed$")
	public void verify_that_Re_apply_Overdraft_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot();
		findByAny(screenHeading).isDisplayed();
	}
	@Then("^close existing open application for the next scenario$")
	public void close_existing_open_application_for_the_next_scenario() {
		setStepName("Then");
		updateApplicationDate();
	}

	@Then("^verify that screen body \"([^\"]*)\" displayed on the screen$")
	public void verify_that_screen_body_displayed_on_the_screen(String expected) {
		setStepName("Then");
		findByAny(screenBody).verifyEqualsTo(expected);
	}

	@Then("^verify that date in \"([^\"]*)\" component displays (\\d+) days from today on the screen$")
	public void verify_that_date_in_Re_apply_from_component_displays_days_from_today_on_the_screen(String expected, int days) {
		findByAny(declineFooter).verifyEqualsTo(expected + " " + modifiedDate(days));
	}
	
}
