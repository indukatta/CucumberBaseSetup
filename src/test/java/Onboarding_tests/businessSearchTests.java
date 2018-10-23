package Onboarding_tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Onboarding.BusinessDetailsForm;
import pageObjects.Onboarding.BusinessSearch;
import pageObjects.Onboarding.SetUp;
import testUtils.Base_test;

public class businessSearchTests extends Base_test {

    private SetUp setUp;
    private BusinessSearch businessSearch;
    private BusinessDetailsForm business;

    @BeforeMethod
    public void beforeMethod() {
        setUp = new SetUp(driver);
        businessSearch = new BusinessSearch(driver);
        business = new BusinessDetailsForm(driver);
    }

    @Test(priority = 1, description = "Alphanumeric Keyboard Entry")
    public void CUICE3978(){
        Assert.assertTrue(businessSearch.businessSearchKeyboard());
    }

    @Test(priority = 2, description = "Search Business By Name")
    public void CUICE3979(){
        Assert.assertTrue(businessSearch.searchByBusinessName());
    }

    @Test(priority = 3, description = "Search Company By Registration Number")
    public void CUICE3980(){
        Assert.assertTrue(businessSearch.searchByRegistrationNumber());
    }

    @Test(priority = 4, description = "Search by Business Name - No Business Found")
    public void CUICE3981(){
        Assert.assertTrue(businessSearch.noBussinessFoundSearchByBusinessName());
    }

    @Test(priority = 5, description = "Search by Company Registration Number - No Business Found")
    public void CUICE3982(){
        Assert.assertTrue(businessSearch.noBussinessFoundErrorSearchByBusinessNumber());
    }

    @Test(priority = 6, description = "Selection of company")
    public void CUICE3995(){
        Assert.assertTrue(businessSearch.selectionOfCompanyByBusinessName());
    }

    @Test(priority = 7, description = "Go Back To Searching a company")
    public void CUICE3996(){
        businessSearch.selectionOfCompanyByBusinessName();
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"You and your business\"]")).click();//FIXME:get accessibility ID
        Assert.assertTrue(businessSearch.businessSearchTitleDisplayed());
    }

    @Test(priority = 8, description = "Cancel a Search")
    public void CUICE5182(){
        Assert.assertTrue(businessSearch.cancelSearch());
    }

    @Test(priority = 9, description = "Informated Pre-populated and Displayed to user")
    public void CUICE3998(){
        Assert.assertTrue(businessSearch.isBusinessInformationDisplayed());
    }

    @Test(priority = 10, description = "Non-Editing of Pre-populated Information")
    public void CUICE4000(){
        Assert.assertTrue(business.prePopulatedInformationNotEditible());
    }
}
