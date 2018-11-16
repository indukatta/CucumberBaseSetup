package stepDefinitions.Lending;

import static com.factory.mobile.driver.MobileDriverManager.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.Login.Login;
import pageObjects.More.More;

public class CreditManagement extends CommonLibrary {

	@Given("^that user is on the Credit Management screen$")
	public void that_user_is_on_the_Credit_Management_screen() throws Throwable {
		if (!alreadyLoggedIn) {
			setStepName("Given");
			Login login = new Login(driver);
			login.loginAsUser("TESTUSER", "TESTPASSWORD");
			alreadyLoggedIn = true;
		}else {
			setStepName("Given");
			reportPass("User is already logged in to Iceberg application.");
		}
		
	}

	@When("^user clicks on the Credit & Lending link$")
	public void user_clicks_on_the_Credit_and_Lending_link() throws Throwable {
		setStepName("When");
		More more = new More(driver);
		more.navigateToCreditAndLending();
		sleep(5);
	}

	@Then("^verify that XX screen is displayed$")
	public void verify_that_Credit_Management_screen_is_displayed() throws Throwable {
		setStepName("Then");
		functionNotImplemented();
	}

	@Then("^verify lending question screen is displayed$")
	public void verify_lending_question_screen_is_displayed() throws Throwable {
		setStepName("Then");
		functionNotImplemented();
	}

}
