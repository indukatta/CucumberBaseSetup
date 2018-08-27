package Onboarding_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.BusinessDetailsForm;
import pageObjects.BusinessSearch;
import pageObjects.SetUp;

public class businessFormTests extends Base_test {

    private SetUp setUp;
    private BusinessSearch businessSearch;
    private BusinessDetailsForm business;

    @BeforeMethod
    public void beforeMethod() {
        setUp = new SetUp(driver);
        businessSearch = new BusinessSearch(driver);
        business = new BusinessDetailsForm(driver);
    }

    @Test(priority = 1, description = "Display of Trading Address/Business Address Checkboxes" )
    public void CUICE4581(){
        Assert.assertTrue(business.noDefaultCheckboxSelection());
    }

    @Test(priority = 2, description = "Trading Address Same as business address" )
    public void CUICE4583(){
        Assert.assertTrue(business.tradingAddressSameAsRegisteredBusinessAddress());
    }

    @Test(priority = 3, description = "Trading Address Different as business address" )
    public void CUICE4584(){
        Assert.assertTrue(business.tradingAddressDifferentFromRegisteredBusinessAddress());
    }

    @Test(priority = 4, description = "Trading Address Different as business address, no address found" )
    public void CUICE4585(){
        Assert.assertTrue(business.addressNotFound());//FIXME: Will fail because of wiremock
    }

    @Test(priority = 5, description = "Display of Jurisdiction of tax residency field" )
    public void CUICE4541(){
        Assert.assertTrue(business.jurisdictionOfTaxResidencyDisplayed());
    }

    @Test(priority = 6, description = "AlphaNumeric Keyboard Entry")
    public void CUICE4542(){
        Assert.assertTrue(business.jurisdictionOfTaxResidencykeyboardVisible());
    }

    @Test(priority = 7, description = "Invalid Jurisdiction of Tax Residency Lookup")
    public void CUICE4544(){
        Assert.assertTrue(business.jurisdictionOfTaxResidencyNoCountryFound());
    }

    @Test(priority = 8, description = "Jurisdiction of Tax Residency Lookup Function")
    public void CUICE4543(){
        Assert.assertTrue(business.jurisdictionOfTaxResidencyDynamicList());
        Assert.assertTrue(business.jurisdictionOfTaxResidencySelectCountry());
    }

    @Test(priority = 9, description = "Display of UTR Question")
    public void CUICE4351(){
        Assert.assertTrue(business.uniqueTaxReferenceNumberDisplayed());
    }

    @Test(priority = 10, description = "Numeric Keyboard Entry")
    public void CUICE4352(){
        Assert.assertTrue(business.uniqueTaxReferenceNumberKeyboard());
    }

    @Test(priority = 11, description = "Unique Tax Reference Validation")
    public void CUICE4353ANDCUICE4354(){
        Assert.assertTrue(business.uniqueTaxReferenceNumberValidation());
    }

    @Test(priority = 12, description = "Display Additional Details")
    public void CUICE5158(){
        Assert.assertTrue(business.additionalDetailsDisplayed());
    }

    @Test(priority = 13, description = "Additional Details Keyboard")
    public void CUICE5159(){
        Assert.assertTrue(business.additionalDetailsKeyboard());
    }

    @Test(priority = 14, description = "Additional Details Validation")
    public void CUICE5160(){
        Assert.assertTrue(business.additionalDetailsNoCharacters());
        Assert.assertTrue(business.additionalDetailsLessThanTwoCharacters());
        Assert.assertTrue(business.additionalDetailsMoreThan255Characters());
        Assert.assertTrue(business.additionalDetailsValidEntry());
    }
}
