package lending.overdrafts.pre_TnC;

import static com.factory.mobile.driver.AppiumDriverManager.*;
import static com.factory.services.wrapper.RestAssuredManager.getLastValueFromJSON;
import static com.factory.services.wrapper.RestAssuredManager.httpGet;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lending.common.library.CommonLibrary;

public class ProductSelection extends CommonLibrary {

	public static String screenTitle;
	public static String selectProductDescription;
	public static String productIcon;
	public static String productName;
	public static String productBenefit;
	public static String linkFindOutMore;
	public static String buttonApply;
	public static String eligibility;
	public static String eligibilityPage;
	public static String breadcrumb;

	@Given("^that user is on Product Selection screen$")
	public void that_user_is_on_Product_Selection_screen() throws Throwable {
		setStepName("Given");
		findByAny(screenTitle).isDisplayed();
		findByAny(productName).isDisplayed();
	}

	@Then("^verify that Product Selection screen is displayed$")
	public void verify_Product_Details_screen_is_displayed() throws Throwable {
		setStepName("Then");
		captureScreenshot();
		findByAny(screenTitle).isDisplayed();
		findByAny(productName).isDisplayed();
	}

	@Then("^verify product selection screen title \"([^\"]*)\" is displayed$")
	public void verify_product_selection_screen_title_is_displayed(String expected) {
		setStepName("Then");
		findByAny(screenTitle).verifyEqualsTo(expected);
	}

	@When("^user clicks on find out more link$")
	public void user_clicks_on_find_out_more_link() throws Throwable {
		setStepName("When");
		findByAny(linkFindOutMore).click();
		sleep(1000);
	}

	@When("^user clicks on Apply button on Product Selection$")
	public void user_clicks_on_Apply_button_on_Product_Selection_screen() throws Throwable {
		setStepName("When");
		findByAny(buttonApply).click();
		sleep(3000);
		httpGet("product-categories", false);
		applicationID = getLastValueFromJSON("data/applications/id").toString();
		System.out.println("applicationID: " + applicationID);
	}

	@When("^verify that \"([^\"]*)\" button is shown on product selection screen$")
	public void verify_that_Apply_or_Re_Apply_button_is_shown_on_product_selection_screen(String expected)
			throws Throwable {
		setStepName("When");
		findByAny(buttonApply).verifyEqualsTo(expected);
		sleep(3000);
	}

	@Then("^verify Select Products description \"([^\"]*)\" on screen$")
	public void verify_Select_Products_description_on_screen(String expected) throws Throwable {
		setStepName("Then");
		findByAny(selectProductDescription).verifyEqualsTo(expected);
	}

	@Then("^verify product name \"([^\"]*)\" on Select Products screen$")
	public void verify_product_name_on_screen(String expected) throws Throwable {
		setStepName("Then");
		findByAny(productName).verifyEqualsTo(expected);
	}

	@Then("^verify product benefit \"([^\"]*)\" on screen$")
	public void verify_product_benefit_on_screen(String expected) throws Throwable {
		setStepName("Then");
		findByAny(productBenefit).verifyEqualsTo(expected);
	}

	@Then("^verify Find Out More link \"([^\"]*)\" on screen$")
	public void verify_find_out_more_link_on_screen(String expected) throws Throwable {
		setStepName("Then");
		findByAny(linkFindOutMore).verifyEqualsTo(expected);
	}

	@Then("^verify Apply button \"([^\"]*)\" on screen$")
	public void verify_apply_button_on_screen(String expected) throws Throwable {
		setStepName("Then");
		findByAny(buttonApply).isDisplayed();
		findByAny(buttonApply).verifyEqualsTo(expected);
	}

	@Then("^verify product icon is displayed on screen$")
	public void verify_product_icon_is_displayed_on_screen() throws Throwable {
		setStepName("Then");
		findByAny(productIcon).isDisplayed();
	}

	@Then("^verify broken link for icon image on the screen$")
	public void verify_broken_link_for_icon_image_on_the_screen() throws Throwable {
		setStepName("Then");
		reportSkip("Verify that icon appearing on screen is not broken.");
	}

	@Then("^verify product name description and Find out more are left aligned$")
	public void verify_product_name_description_and_Find_out_more_are_left_aligned() throws Throwable {
		setStepName("Then");
		reportSkip("Verify that product name, description and Find out more are left aligned.");
	}

	@Then("^verify Apply button center aligned$")
	public void verify_Apply_and_Skip_buttons_are_center_alligned() throws Throwable {
		setStepName("Then");
		reportSkip("Verify that Apply and Skip buttons are center aligned.");
	}

	@Then("^verify Apply button is auto highlighted$")
	public void verify_Apply_button_is_auto_highlighted() throws Throwable {
		setStepName("Then");
		reportSkip("Verify that Apply button is auto highlighted");
	}

	@Then("^verify overall UI of Product Selection screen as per UX$")
	public void verify_overall_UI_of_Product_Selection_screen_as_per_UX() throws Throwable {
		setStepName("Then");
		reportSkip("Verify overall UI of Product Details screen is as per UX and usability.");
	}

	@Then("^verify that check eligibility link \"([^\"]*)\" is displayed on screen$")
	public void verify_that_check_eligibility_link_is_displayed_on_screen(String expected) throws Throwable {
		setStepName("Then");
		findByAny(eligibility).isDisplayed();
		findByAny(eligibility).verifyEqualsTo(expected);
	}

	@Then("^user clicks on check eligibility link on screen$")
	public void user_clicks_on_check_eligibility_link_on_screen() {
		setStepName("Then");
		findByAny(eligibility).click();
		sleep(3000);
		captureScreenshot();
	}

	@Then("^verify that check eligibility page \"([^\"]*)\" is displayed on screen$")
	public void verify_that_check_eligibility_page_is_displayed_on_screen(String expected) throws Throwable {
		setStepName("Then");
		findByAny(eligibilityPage).verifyAttributesAllEqualsTo("name", expected);
	}

}
