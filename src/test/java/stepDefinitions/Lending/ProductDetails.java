package stepDefinitions.Lending;

import static com.factory.mobile.driver.MobileDriverManager.*;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import java.util.List;

public class ProductDetails extends CommonLibrary {

	public static String productDetailsHeader;
	public static String productName;
	public static String productDescription;
	public static String featuresAndBenefitsHeading;
	public static String featuresAndBenefits;
	public static String overdraftRange;
	public static String overdratfsInformations;
	public static String termsAndConditionsHeading;
	public static String downloadPDF;
	
	@Given("^user is on Product Details screen$")
	public void user_is_on_Product_Details_screen() throws Throwable {
		setStepName("Given");
		captureScreenshot();
		findByAny(productName).isDisplayed();
		findByAny(productName).verifyEqualsTo("Business Overdrafts");
	}
	
	@Then("^verify Product Details screen is displayed$")
	public void verify_Product_Details_screen_is_displayed() throws Throwable {
		setStepName("Then");
		captureScreenshot();
		findByAny(productName).isDisplayed();
		findByAny(productName).verifyEqualsTo("Business Overdrafts");
	}

	@Then("^verify product description \"([^\"]*)\" on screen$")
	public void verify_product_description_on_screen(String expected) throws Throwable {
		setStepName("Then");
		findByAny(productDescription).verifyEqualsTo(expected);
	}

	@Then("^verify feature and benefit heading \"([^\"]*)\" on screen$")
	public void verify_feature_and_benefit_heading_on_screen(String expected) throws Throwable {
		setStepName("Then");
		findByAny(featuresAndBenefitsHeading).verifyEqualsTo(expected);
	}

	@Then("^verify features and benefits on the screen$")
	public void verify_features_and_benefits_on_the_screen(DataTable expected) throws Throwable {
		setStepName("Then");
		List<String> features = expected.asList(String.class);
		for (String feature : features) {
			System.out.println("feature: "+feature);
//			findByAny(featuresAndBenefits).verifyEqualsTo(feature);
		}
	}

	@Then("^overdraft fee and interest$")
	public void overdraft_fee_and_interest(DataTable expected) throws Throwable {
		setStepName("Then");
		List<String> odFeeAndInts = expected.asList(String.class);
		for (String odFeeAndInt : odFeeAndInts) {
			System.out.println("odFeeAndInt: "+odFeeAndInt);
//			findByAny(overdratfsInformations).verifyEqualsTo(odFeeAndInt);
		}
	}

	@Then("^verify terms and conditions heading \"([^\"]*)\" on screen$")
	public void verify_terms_and_conditions_heading_on_screen(String expected) throws Throwable {
		setStepName("Then");
		findByAny(termsAndConditionsHeading).verifyEqualsTo(expected);
	}

	@Then("^user clicks on terms and condition$")
	public void user_clicks_on_terms_and_condition() throws Throwable {
		setStepName("Then");
		functionNotImplemented();
	}

	@Then("^verify overdraft range \"([^\"]*)\" is displayed on product details screen$")
	public void verify_overdraft_range_is_displayed_on_product_details_screen(String expected) throws Throwable {
		setStepName("Then");
		findByAny(overdraftRange).verifyEqualsTo(expected);
	}

	@Then("^verify product waring \"([^\"]*)\" is displayed on product details screen$")
	public void verify_product_waring_is_displayed_on_product_details_screen(String expected) throws Throwable {
		setStepName("Then");
		findByAny(overdratfsInformations).verifyContains(expected);
	}

	@Then("^verify product name \"([^\"]*)\" on Product Details screen$")
	public void verify_product_name_on_Product_Details_screen(String expected) throws Throwable {
		setStepName("Then");
		findByAny(productName).verifyEqualsTo(expected);
	}

	@Then("^verify product name and description are center aligned$")
	public void verify_product_name_and_description_are_center_aligned() throws Throwable {
		setStepName("Then");
		reportSkip("Verify that product name and description are center aligned");
	}

	@Then("^verify other components and sub components are left aligned$")
	public void verify_other_components_and_sub_components_are_left_alligned() throws Throwable {
		setStepName("Then");
		reportSkip("Verify other components are left aligned.");
	}

	@Then("^verify outline for each components and/or sub screen$")
	public void verify_outline_for_each_components_and_or_sub_screen() throws Throwable {
		setStepName("Then");
		reportSkip("Verify that outline on the screen are aligned with the text.");
	}

	@Then("^verify spacing between each components and/or sub screen$")
	public void verify_spacing_between_each_components_and_or_sub_screen() throws Throwable {
		setStepName("Then");
		reportSkip("Verify that each components and sub screen and enter separated.");
	}

	@Then("^verify each section header is bold$")
	public void verify_each_section_header_is_bold() throws Throwable {
		setStepName("Then");
		reportSkip("Verify that header on screen are in bold.");
	}

	@Then("^verify indentation for Features and Benefits$")
	public void verify_indentation_for_Features_and_Benefits() throws Throwable {
		setStepName("Then");
		reportSkip("Verify that indentation for Features and Benefits are as per UX");
	}

	@Then("^verify overall UI of Product Details screen as per UX$")
	public void verify_overall_UI_of_Product_Details_screen_as_per_UX() throws Throwable {
		setStepName("Then");
		reportSkip("Verify overall UI of Product Details screen is as per UX and usability.");
	}
}
