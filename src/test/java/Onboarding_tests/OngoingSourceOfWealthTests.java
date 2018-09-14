package Onboarding_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.BusinessDetailsForm;
import pageObjects.BusinessSearch;
import pageObjects.OngoingSourceOfWealth;
import pageObjects.SetUp;

public class OngoingSourceOfWealthTests extends Base_test {
    private SetUp setUp;
    private BusinessSearch businessSearch;
    private BusinessDetailsForm business;
    private OngoingSourceOfWealth ongoingSourceOfWealth;

    @BeforeMethod
    public void beforeMethod() {
        setUp = new SetUp(driver);
        businessSearch = new BusinessSearch(driver);
        business = new BusinessDetailsForm(driver);
        ongoingSourceOfWealth = new OngoingSourceOfWealth(driver);
    }


    @Test(priority = 1 , description = "Makes sure only when all fields are filled the next button is shown" )
    public void CUICE5113 (){
        Assert.assertTrue(ongoingSourceOfWealth.checkAllFieldsAreFilled());
    }

    @Test(priority = 2, description = "Ensures only correct amounts can be entered into the amount field" )
    public void CUICE5114(){

        Assert.assertTrue(ongoingSourceOfWealth.incorrectAmounts());
        Assert.assertTrue(ongoingSourceOfWealth.isGbpDisplayed());
    }

    @Test(priority = 3, description = "Ensures all checkbox elements can be selected " )
    public void CUICE5115(){
        Assert.assertTrue(ongoingSourceOfWealth.canAllFundingOptionsBeChosen());
    }

    @Test(priority = 4 , description = "When other option is filled it adds another mandatory field to the wealth screen" )
    public void CUICE5902 (){
        Assert.assertTrue(ongoingSourceOfWealth.checkOtherFieldValidity());
    }

    @Test(priority = 5 , description = "Checks if the country list be seen" )
    public void CUICE5116 () {
        Assert.assertTrue(ongoingSourceOfWealth.isCountryListShown());
    }

    @Test(priority = 6 , description = "Check that customer information is cleared when selected company changes" )
    public void CUICE5903 () {
        Assert.assertTrue(ongoingSourceOfWealth.doFieldsClearWithNewSearch());
    }

}
