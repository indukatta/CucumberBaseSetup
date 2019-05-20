package lending.overdrafts.pre_TnC;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lending.common.library.CommonLibrary;
import lending.common.library.CommonStepDefinitions;

import static com.factory.mobile.driver.AppiumDriverManager.*;
import static com.factory.mobile.driver.AppiumDriverManager.setStepName;

public class AmountOfBorrowing extends CommonLibrary {
	public static String amtOfBorrowingInput;
	public static String amtOfBorrowingSlider;
	public static String amtOfBorrowingMax;
	public static String monthyFee;
	public static String screenEAR;
	public static String amtOfBorrowingSubTitle;
	public static String cancel;
	public static String done;
	
	@Then("^verify that Amount of Borrowing screen is displayed$")
	public void verify_that_Amount_of_Borrowing_Yes_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot("AmountOfBorrowing");
		findByAny(CommonStepDefinitions.screenTitle).isDisplayed();
		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();
	}

	@Given("^user is on Amount of Borrowing question screen$")
	public void user_is_on_Amount_of_Borrowing_Yes_question_screen() {
		setStepName("Given");
		findByAny(CommonStepDefinitions.screenQuestion).isDisplayed();
	}

	@Then("^verify Amount of Borrowing title \"([^\"]*)\" on screen$")
	public void verify_Amount_of_Borrowing_Yes_title_on_screen(String arg1) {
		setStepName("Then");
	    findByAny(CommonStepDefinitions.screenTitle).verifyEqualsTo(arg1);
	}

	@Then("^verify Amount of Borrowing question \"([^\"]*)\" on screen$")
	public void verify_Amount_of_Borrowing_Yes_question_on_screen(String arg1) {
		setStepName("Then");
		findByAny(CommonStepDefinitions.screenQuestion).verifyEqualsTo(arg1);
	}

	@Then("^verify that Amount of borrowing slider is displayed on the screen$")
	public void verify_that_Amount_of_borrowing_slider_is_displayed_on_the_screen() {
		setStepName("Then");
		findByAny(amtOfBorrowingSlider).isDisplayed();
	}

	@Then("^verify that monthly fee component \"([^\"]*)\" is displayed on the screen$")
	public void verify_that_monthly_fee_component_is_displayed_on_the_screen(String arg1) {
		setStepName("Then");
		findByAny(monthyFee).verifyEqualsTo(arg1);
	}

	@Then("^verify that EAR component \"([^\"]*)\" is displayed on the screen$")
	public void verify_that_EAR_component_is_displayed_on_the_screen(String arg1) {
		setStepName("Then");
		findByAny(screenEAR).verifyEqualsTo(arg1);
	}

	@When("^user selects an amount (\\d+) on Amount of Borrowing Yes screen$")
	public void user_selects_an_amount_on_Amount_of_Borrowig_Yes_screen(float arg1) {
		setStepName("When");
		findByAny(amtOfBorrowingSlider).setValue(arg1/10000);
	}

	@Then("^verify that monthly fee (\\d+)\\.(\\d+) is calculated and correct on the screen$")
	public void verify_that_monthly_fee_is_calculated_and_is_correct_on_the_screen(int arg1, int arg2){
		setStepName("Then");
		captureScreenshot();
		findByAny(monthyFee).verifyContains(arg1+"."+arg2);
	}

	@When("^user selects option on Amount of Borrowig Yes screen$")
	public void user_selects_option_on_Amount_of_Borrowig_Yes_screen() {
		setStepName("When");
		findByAny(amtOfBorrowingSlider).setValue(".8");
	}
	
	@Then("^verify that updated amount \"([^\"]*)\" is displayed on the screen$")
	public void verify_that_updated_amount_is_displayed_on_the_screen(String expected) {
		findByAny(amtOfBorrowingInput).verifyEqualsTo(expected);
	}
	
}
