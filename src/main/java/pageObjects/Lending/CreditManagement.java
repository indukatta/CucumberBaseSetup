package pageObjects.Lending;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static com.factory.mobile.driver.MobileDriverManager.*;

public class CreditManagement {
	public static String footerMore;
	public static String linkCreditLending;

	@Given("^user is on the XX screen$")
	public void user_is_on_the_Credit_Management_screen1() throws Throwable {
	    
	}
	
	@When("^user clicks on the Product Selection link$")
	public void user_clicks_on_the_Product_Selection_link() throws Throwable {
		findByAny(footerMore).click();
		findByAny(linkCreditLending).click();
	}

	@Then("^verify that XX screen is displayed$")
	public void verify_that_XX_screen_is_displayed() throws Throwable {

	}

	@Then("^verify lending question screen is displayed$")
	public void verify_lending_question_screen_is_displayed() throws Throwable {
		// code to verify lending question screen
	}

}
