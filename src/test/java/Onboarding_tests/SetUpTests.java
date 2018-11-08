package Onboarding_tests;

import static com.factory.mobile.driver.MobileDriverManager.endReports;
import static com.factory.mobile.driver.MobileDriverManager.startReports;
import static com.factory.mobile.driver.MobileDriverManager.startTest;
import static com.factory.mobile.driver.MobileDriverManager.endTest;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.Onboarding.BusinessDetailsForm;
import pageObjects.Onboarding.BusinessSearch;
import pageObjects.Onboarding.SetUp;
import testUtils.Base_test;
import testUtils.TestListener;

@Listeners(TestListener.class)
public class SetUpTests extends Base_test {

    private SetUp setUp;
    private BusinessSearch businessSearch;
    private BusinessDetailsForm business;

	@BeforeTest
	public void startTestReport() {
		startReports("setupTests");
	}
	@AfterTest
	public void endTestReport() {
		endReports();
	}
	
    @BeforeMethod
    public void beforeMethod() {
        setUp = new SetUp(driver);
        businessSearch = new BusinessSearch(driver);
        business = new BusinessDetailsForm(driver);
    }

    @Test (priority = 1, description = "Phone Number Entry Field Displayed")
    public void CUICE4445(){
    	startTest("Phone Number Entry Field Displayed");
        Assert.assertTrue(setUp.isPhoneNumberFieldDisplayed());
        endTest();
    }

    @Test (priority = 2, description = "Phone Number Keyboard Displayed")
    public void CUICE4446(){
    	startTest("Phone Number Keyboard Displayed");
        Assert.assertTrue(setUp.isPhoneKeyboardDisplayed());
        endTest();
    }

//    @Test (priority = 3, description = "Phone Number Validation valid phone number")
//    public void CUICE4447(){
//        Assert.assertTrue(setUp.validPhonenumber());
//    }
//
//    @Test (priority = 4, description = "Phone Number Validation invalid phone number")
//    public void CUICE4448(){
//        Assert.assertTrue(setUp.invalidPhoneNumber());
//    }
//
//    @Test(priority = 5, description = "Email Keyboard Entry")
//    public void CUICE4343(){
//        Assert.assertTrue(setUp.isEmailKeyboardDisplayed());
//    }
//
//    @Test(priority = 6, description = "Display Email Address Field")
//    public void CUICE4344(){
//        Assert.assertTrue(setUp.isEmailFieldDisplayed());
//    }
//
//    @Test(priority = 7, description = "Email Address Validation positive email")
//    public void CUICE4345(){
//        Assert.assertTrue(setUp.validEmail());
//    }
//
//    @Test(priority = 8, description = "Email Address Validation invalid email")
//    public void CUICE4346(){
//        Assert.assertTrue(setUp.invalidEmail());
//    }
//
//    @Test(priority = 9, description = "Default to Application Start Page Once Mobile Set Up is Complete")
//    public void CUICE4105(){
//        Assert.assertTrue(setUp.landingPageDisplayed());
//    }
//
//    @Test(priority = 10, description = "Application Start Screen Description")
//    public void CUICE4815(){
//        Assert.assertTrue(setUp.landingPageDescription());
//    }
//
//    @Test(priority = 11, description = "Application Start Screen Navigation - Continue")
//    public void CUICE4816(){
//        setUp.passThroughSetUp();
//        setUp.clickNext();
//        Assert.assertTrue(businessSearch.businessSearchTitleDisplayed());
//    }
}
