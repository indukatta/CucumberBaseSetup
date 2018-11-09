package pageObjects.Lending;

import static com.factory.mobile.driver.MobileDriverManager.*;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import java.util.List;

public class ProductDetails {

	public static String productName;
	public static String productDescription;
	public static String featuresAndBenefitsHeading;
	public static String featuresAndBenefits;
	public static String overdraftRange;
	public static String productFeeAndInterest;
	public static String productWarning;
	public static String rateAndChargesHeading;
	public static String termsAndConditionsHeading;
	public static String termsAndConditions;
	public static String downloadPDF;

	@Then("^verify Product Details screen is displayed$")
	public void verify_Product_Details_screen_is_displayed() throws Throwable {
		findByAny(productName).isDisplayed();
		findByAny(productName).verifyEqualsTo("Business Overdrafts");
	}

	@Given("^user is on Product Details screen$")
	public void user_is_on_Product_Details_screen() throws Throwable {
		findByAny(productName).isDisplayed();
		findByAny(productName).verifyEqualsTo("Business Overdrafts");
	}

	@Then("^verify product description as \"([^\"]*)\" on screen$")
	public void verify_product_description_as_on_screen(String expected) throws Throwable {
		findByAny(productDescription).verifyEqualsTo(expected);
	}

	@Then("^verify feature and benefit heading as \"([^\"]*)\" on screen$")
	public void verify_feature_and_benefit_heading_as_on_screen(String expected) throws Throwable {
		findByAny(featuresAndBenefitsHeading).verifyEqualsTo(expected);
	}

	@Then("^verify features and benefits on the screen$")
	public void verify_features_and_benefits_on_the_screen(DataTable expected) throws Throwable {
		List<String> features = expected.asList(String.class);
		for (String feature : features) {
			System.out.println(feature);
		}
		String[] featureAndBenefit = features.toArray(new String[features.size()]);
		findByAny(featuresAndBenefits).verifyAllEqualsTo(featureAndBenefit);
	}

	@Then("^overdraft fee and interest$")
	public void overdraft_fee_and_interest(DataTable expected) throws Throwable {
		List<String> odFeeAndInts = expected.asList(String.class);
		for (String odFeeAndInt : odFeeAndInts) {
			System.out.println(odFeeAndInt);
		}
		String[] featureAndBenefit = odFeeAndInts.toArray(new String[odFeeAndInts.size()]);
		findByAny(productFeeAndInterest).verifyAllEqualsTo(featureAndBenefit);
	}

	@Then("^verify rate and charges heading as \"([^\"]*)\" on screen$")
	public void verify_rate_and_charges_heading_as_on_screen(String expected) throws Throwable {
		findByAny(rateAndChargesHeading).verifyEqualsTo(expected);
	}

	@Then("^verify terms and conditions heading as \"([^\"]*)\" on screen$")
	public void verify_terms_and_conditions_heading_as_on_screen(String expected) throws Throwable {
		findByAny(termsAndConditionsHeading).verifyEqualsTo(expected);
	}

	@Then("^verify terms and conditions details as \"([^\"]*)\"$")
	public void verify_terms_and_conditions_details_as(String expected) throws Throwable {
		findByAny(termsAndConditions).verifyEqualsTo(expected);
	}

	@Then("^user clicks on terms and condition$")
	public void user_clicks_on_terms_and_condition() throws Throwable {
		findByAny(termsAndConditions).click();
	}

	@Then("^verify product name as \"([^\"]*)\" not displayed$")
	public void verify_product_name_as_not_displayed(String expected) throws Throwable {
		findByAny(productName).verifyNotEqualsTo(expected);
	}

	@Then("^verify overdraft range \"([^\"]*)\" is displayed on product details screen$")
	public void verify_overdraft_range_is_displayed_on_product_details_screen(String expected) throws Throwable {
		findByAny(overdraftRange).verifyEqualsTo(expected);
	}

	@Then("^verify product waring \"([^\"]*)\" is displayed on product details screen$")
	public void verify_product_waring_is_displayed_on_product_details_screen(String expected) throws Throwable {
		findByAny(productWarning).verifyEqualsTo(expected);
	}

	@Then("^verify product name \"([^\"]*)\" on Product Details screen$")
	public void verify_product_name_on_Product_Details_screen(String expected) throws Throwable {
		findByAny(productName).verifyEqualsTo(expected);
	}

	@Then("^Verify product name and description are center aligned$")
	public void verify_product_name_and_description_are_center_aligned() throws Throwable {
		reportSkip("Product Name & Description", "Verify that product name and description are center aligned");
	}

	@Then("^Verify other components and sub screens are left alligned$")
	public void verify_other_components_and_sub_screens_are_left_alligned() throws Throwable {
		reportSkip("Component Alignment", "Verify other components are left aligned.");
	}

	@Then("^Verify outline for each components and/or sub screen$")
	public void verify_outline_for_each_components_and_or_sub_screen() throws Throwable {
		reportSkip("Screen Outline", "Verify that outline on the screen are aligned with the text.");
	}

	@Then("^Verify spacing between each components and/or sub screen$")
	public void verify_spacing_between_each_components_and_or_sub_screen() throws Throwable {
		reportSkip("Component Spacing", "Verify that each components and sub screen and enter separated.");
	}

	@Then("^Verify each section header is bold$")
	public void verify_each_section_header_is_bold() throws Throwable {
		reportSkip("Section Header", "Verify that header on screen are in bold.");
	}

	@Then("^Verify indentation for Features and Benefits$")
	public void verify_indentation_for_Features_and_Benefits() throws Throwable {
		reportSkip("Indentation", "Verify that indentation for Features and Benefits are as per UX");
	}

	@Then("^Verify overall UI of Product Details screen as per UX$")
	public void verify_overall_UI_of_Product_Details_screen_as_per_UX() throws Throwable {
		reportSkip("Overall UI", "Verify overall UI of Product Details screen is as per UX and usability.");
	}
}
