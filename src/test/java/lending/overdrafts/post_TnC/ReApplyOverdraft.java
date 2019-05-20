package lending.overdrafts.post_TnC;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lending.common.library.CommonLibrary;
import lending.common.library.CommonStepDefinitions;

import static com.factory.mobile.driver.AppiumDriverManager.*;

public class ReApplyOverdraft extends CommonLibrary {
	public static String reApplyHeading;
	public static String reApplyBody;
	public static String whatNext;
	public static String exploreOne;
	public static String alternativeFinancing;
	public static String alternativeFinancingDesc;
	public static String appealYourDecision;
	public static String appealYourDecisionDesc;
	public static String notNowBtn;

	@Then("^verify that Re-apply Overdraft screen is displayed$")
	public void verify_that_Re_apply_Overdraft_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot();
		findByAny(reApplyHeading).isDisplayed();
	}

	@Then("^verify that screen body \"([^\"]*)\" displayed on the screen$")
	public void verify_that_screen_body_displayed_on_the_screen(String expected) {
		setStepName("Then");
		findByAny(reApplyBody).verifyContains(expected);
	}

	@Then("^verify that date in \"([^\"]*)\" component is (\\d+) days from today on the screen$")
	public void verify_that_date_in_re_apply_from_component_is_days_from_today_on_the_screen(String expected,
			int days) {
		findByAny(reApplyBody).verifyContains(expected + " " + modifiedDate(days));
	}

	@Given("^that user is on Re-Apply overdraft screen$")
	public void that_user_is_on_Re_Apply_overdraft_screen() throws Throwable {
		setStepName("Given");
		findByAny(reApplyHeading).isDisplayed();
	}

	@Then("^verify that Re-apply overdraft heading \"([^\"]*)\" is displayed$")
	public void verify_that_Re_apply_overdraft_heading_is_displayed(String arg1) throws Throwable {
		setStepName("Then");
		findByAny(reApplyHeading).verifyEqualsTo(arg1);
	}

	@Then("^verify that What Next lable \"([^\"]*)\" is displayed on the screen$")
	public void verify_that_What_Next_lable_is_displayed_on_the_screen(String arg1) throws Throwable {
		setStepName("Then");
		findByAny(whatNext).verifyEqualsTo(arg1);
	}

	@Then("^verify that Explore options \"([^\"]*)\" is displayed on the screen$")
	public void verify_that_Explore_options_is_displayed_on_the_screen(String arg1) throws Throwable {
		setStepName("Then");
		findByAny(exploreOne).verifyEqualsTo(arg1);
	}

	@Then("^verify that Alternative financing \"([^\"]*)\" is displayed on the screen$")
	public void verify_that_Alternative_financing_is_displayed_on_the_screen(String arg1) throws Throwable {
		setStepName("Then");
		findByAny(alternativeFinancing).verifyEqualsTo(arg1);
	}

	@Then("^verify that Alternative financing description \"([^\"]*)\" is displayed on the screen$")
	public void verify_that_Alternative_financing_subText_is_displayed_on_the_screen(String arg1) throws Throwable {
		setStepName("Then");
		findByAny(alternativeFinancingDesc).verifyEqualsTo(arg1);
	}

	@Then("^verify that Appeal your decision \"([^\"]*)\" is displayed on the screen$")
	public void verify_that_Appeal_your_decision_is_displayed_on_the_screen(String arg1) throws Throwable {
		setStepName("Then");
		findByAny(appealYourDecision).verifyEqualsTo(arg1);
	}

	@Then("^verify that Appeal your decision description \"([^\"]*)\" is displayed on the screen$")
	public void verify_that_Appeal_your_decision_subText_is_displayed_on_the_screen(String arg1) throws Throwable {
		setStepName("Then");
		findByAny(appealYourDecisionDesc).verifyEqualsTo(arg1);
	}

	@Then("^verify that Not now CTA is displayed on the screen$")
	public void verify_that_Not_now_CTA_is_displayed_on_the_screen() throws Throwable {
		setStepName("Then");
		findByAny(notNowBtn).isDisplayed();
	}

	@Given("^user clicks on Not now button on the screen$")
	public void user_clicks_on_Not_now_button_on_the_screen() throws Throwable {
		setStepName("Then");
		findByAny(notNowBtn).click();
		sleep(500);
	}

	@When("^user clicks on Consider alternative financing option on the screen$")
	public void user_clicks_on_Consider_alternative_financing_option_on_the_screen() throws Throwable {
		setStepName("Then");
		findByAny(alternativeFinancing).click();
		sleep(2000);
	}

	@Then("^user clicks on Appeal your decision option on the screen$")
	public void user_clicks_on_Appeal_your_decision_option_on_the_screen() throws Throwable {
		setStepName("Then");
		findByAny(appealYourDecision).click();
		sleep(2000);
	}

}
