package pageObjects.Lending;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static com.factory.mobile.driver.MobileDriverManager.*;

public class ProductSelection {

	public static String productSelectionHeader;
	public static String productIcon;
	public static String productName;
	public static String productBenefit;
	public static String linkFindOutMore;
	public static String buttonApply;
	public static String buttonSkip;

	@Given("^user is on Product Selection screen$")
	public void user_is_on_Product_Selection_screen() throws Throwable {
		// code to navigate to Product Selection screen if not.
	}

	@When("^user clicks on find out more link$")
	public void user_clicks_on_find_out_more_link() throws Throwable {
		findByAny(linkFindOutMore).click();
	}

	// Action(s) on screen ....
	@When("^user clicks on Apply button$")
	public void user_clicks_on_Apply_button() throws Throwable {
		findByAny(buttonApply).click();
	}

	@When("^user clicks on Skip button$")
	public void user_clicks_on_Skip_button() throws Throwable {
		findByAny(buttonSkip).click();
	}

	// Verification(s) on screen ....
	@Then("^verify product selection header as \"([^\"]*)\" on screen$")
	public void verify_product_selection_header_as_on_screen(String expected) throws Throwable {
		findByAny(productSelectionHeader).verifyEqualsTo(expected);
	}

	@Then("^verify product name as \"([^\"]*)\" on screen$")
	public void verify_product_name_as_on_screen(String expected) throws Throwable {
		findByAny(productName).verifyEqualsTo(expected);
	}

	@Then("^verify product benefit as \"([^\"]*)\" on screen$")
	public void verify_product_benefit_as_on_screen(String expected) throws Throwable {
		findByAny(productBenefit).verifyEqualsTo(expected);
	}

	@Then("^verify link \"([^\"]*)\" on screen$")
	public void verify_link_on_screen(String expected) throws Throwable {
		findByAny(linkFindOutMore).verifyEqualsTo(expected);
	}

	@Then("^verify apply as \"([^\"]*)\" on screen$")
	public void verify_apply_as_on_screen(String expected) throws Throwable {
		findByAny(buttonApply).isDisplayed();
		findByAny(buttonApply).verifyEqualsTo(expected);
	}

	@Then("^verify skip as \"([^\"]*)\" on screen$")
	public void verify_skip_as_on_screen(String expected) throws Throwable {
		findByAny(buttonSkip).isDisplayed();
		findByAny(buttonSkip).verifyEqualsTo(expected);
	}

	@Then("^verify icon displayed on screen$")
	public void verify_icon_displayed_on_screen() throws Throwable {
		findByAny(productIcon).isDisplayed();
	}

	@Then("^Verify broken link for icon image on the screen$")
	public void verify_broken_link_for_icon_image_on_the_screen() throws Throwable {
		reportSkip("Verify Broken Icon", "Verify that icon appearing on screen is not broken.");
	}

	@Then("^Verify product name, description and Find out more are left aligned$")
	public void verify_product_name_description_and_Find_out_more_are_left_aligned() throws Throwable {
		reportSkip("Product Alignment", "Verify that product name, description and Find out more are left aligned.");
	}

	@Then("^Verify Apply and Skip buttons are center aligned$")
	public void verify_Apply_and_Skip_buttons_are_center_alligned() throws Throwable {
		reportSkip("Button Alignment", "Verify that Apply and Skip buttons are center aligned.");
	}

	@Then("^Verify Apply button is auto highlighted$")
	public void verify_Apply_button_is_auto_highlighted() throws Throwable {
		reportSkip("Appluy Button", "Verify that Apply button is auto highlighted");
	}

	@Then("^Verify overall UI of Product Selection screen as per UX$")
	public void verify_overall_UI_of_Product_Selection_screen_as_per_UX() throws Throwable {
		reportSkip("Overall UI", "Verify overall UI of Product Details screen is as per UX and usability.");
	}

}
