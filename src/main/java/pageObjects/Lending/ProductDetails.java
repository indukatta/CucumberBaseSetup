package pageObjects.Lending;

import cucumber.api.java.en.Then;
import static com.factory.mobile.driver.MobileDriverManager.*;
public class ProductDetails {

	public static String productName;
	public static String productDescription;
	public static String featuresAndBenefitsHeading;
	public static String featuresAndBenefits;
	public static String productRange;
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
	
	
}
