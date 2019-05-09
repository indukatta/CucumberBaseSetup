package lending.overdrafts.post_TnC;

import cucumber.api.java.en.Then;
import lending.common.library.CommonLibrary;

import static com.factory.mobile.driver.AppiumDriverManager.*;

public class ReApplyOverdraft extends CommonLibrary {
	public static String screenHeading;
	public static String screenBody;
	public static String whatNext;
	public static String declineNotNow;

	@Then("^verify that Re-apply Overdraft screen is displayed$")
	public void verify_that_Re_apply_Overdraft_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot();
		findByAny(screenHeading).isDisplayed();
	}

	@Then("^verify that screen body \"([^\"]*)\" displayed on the screen$")
	public void verify_that_screen_body_displayed_on_the_screen(String expected) {
		setStepName("Then");
		findByAny(screenBody).verifyContains(expected);
	}

	@Then("^verify that date in \"([^\"]*)\" component displays (\\d+) days from today on the screen$")
	public void verify_that_date_in_Re_apply_from_component_displays_days_from_today_on_the_screen(String expected, int days) {
		findByAny(screenBody).verifyContains(expected + " " + modifiedDate(days));
	}
	
}
