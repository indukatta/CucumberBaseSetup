package Onboarding_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Onboarding.PersonalDetailsForm;
import testUtils.Base_test;

public class personalDetailsTests extends Base_test {

    private PersonalDetailsForm details;

    @BeforeMethod
    public void beforeMethod() throws Exception {
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

    @Test(priority = 4, description = "Error message shows when validation not passed")
    public void CUICE6051(){
        Assert.assertTrue(details.errorMessageDisplayed());
    }

    @Test(priority = 5, description = "When validation is passed error message disappears")
    public void CUICE6056(){
        Assert.assertTrue(details.errorMessageDisappearsWhenValidationPassed());
    }

    @Test(priority = 4, description = "Field is active, no data is entered and user navigates to another field")
    public void CUICE6057(){
        Assert.assertTrue(details.errorMessageDoesNotShow());
    }

    @Test(priority = 4, description = "Error message shows, user deletes data, error disappears")
    public void CUICE6058(){
        Assert.assertTrue(details.errorMessageDisplayed());
    }

}
