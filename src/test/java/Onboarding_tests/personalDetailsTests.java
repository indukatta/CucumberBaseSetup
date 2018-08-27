package Onboarding_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.BusinessDetailsForm;
import pageObjects.BusinessSearch;
import pageObjects.PersonalDetailsForm;
import pageObjects.SetUp;
import testData.RandomDataGenerator;

public class personalDetailsTests extends Base_test {

    private RandomDataGenerator generator;

    private SetUp setUp;
    private BusinessSearch businessSearch;
    private BusinessDetailsForm business;
    private PersonalDetailsForm details;

    @BeforeMethod
    public void beforeMethod() throws Exception {

        generator = new RandomDataGenerator();

        setUp = new SetUp(driver);
        businessSearch = new BusinessSearch(driver);
        business = new BusinessDetailsForm(driver);
        details = new PersonalDetailsForm(driver);
    }

    @Test(priority = 1, description = "Information Prepopulated and Displayed to User")
    public void CUICE4142(){
        Assert.assertTrue(details.personalDetailsDisplayed());
    }

    @Test(priority = 2, description = "Non-Editing of Pre-populated Information")
    public void CUICE4141(){
        Assert.assertTrue(details.personalDetailsNotEditible());
    }

    @Test(priority = 3, description = "Navigate Back To Company Search Screen")
    public void CUICE4144(){
        Assert.assertTrue(details.navigateBackToBusinessSearch());
    }

}
