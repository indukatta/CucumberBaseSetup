package Onboarding_tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.BusinessDetailsForm;
import pageObjects.BusinessSearch;

@Listeners(TestListener.class)
public class OnboardingTests extends Base_test {

    private BusinessSearch businessSearch;
    private BusinessDetailsForm business;

    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void beforeMethod() {
        businessSearch = new BusinessSearch(driver);
        business = new BusinessDetailsForm(driver);
    }

    @Test (description = "CUICE-3979, CUICE-3980, CUICE-3980, CUICE-3981, CUICE-3982, CUICE-3995, CUICE-3996, CUICE-3998")
    public void BusinessSearchTests(){
        Assert.assertTrue(businessSearch.navigateToBusinessSearch());
        softAssert.assertTrue(businessSearch.searchByBusinessName());
        softAssert.assertTrue(businessSearch.searchByRegistrationNumber());
        softAssert.assertTrue(businessSearch.noBussinessFoundSearchByBusinessName());
        businessSearch.clearBusinessSearch();
        softAssert.assertTrue(businessSearch.noBussinessFoundErrorSearchByBusinessNumber());
        businessSearch.clearBusinessSearch();
        softAssert.assertTrue(businessSearch.cancelSearch());
        softAssert.assertTrue(businessSearch.selectionOfCompanyByBusinessName());
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"You and your business\"]")).click();//FIXME:get accessibility ID
        softAssert.assertTrue(businessSearch.businessSearchTitleDisplayed());
        softAssert.assertTrue(businessSearch.selectionOfCompanyByBusinessRegNumber());
        softAssert.assertAll();
    }

    @Test
    public void naviagateToBusinessDetailsForm(){
        Assert.assertTrue(business.navigateToBusinessDetails());
        softAssert.assertTrue(business.prePopulatedInformationNotEditible());
        softAssert.assertTrue(business.noDefaultCheckboxSelection());
        softAssert.assertTrue(business.tradingAddressSameAsRegisteredBusinessAddress());
        business.writeAdditionalDetails("Additional Details");
        softAssert.assertTrue(business.jurisdictionOfTaxResidencyNoCountryFound());
        business.clickCountrySearchExitButton();
        softAssert.assertTrue(business.jurisdictionOfTaxResidencyDynamicList());
        softAssert.assertTrue(business.jurisdictionOfTaxResidencySelectCountry());
        softAssert.assertTrue(business.uniqueTaxReferenceNumber());
        softAssert.assertTrue(business.additionalDetails());
        softAssert.assertAll();
    }
}
