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

   //@Test(priority = 1, description = "Go to page after ongoing source of wealth" )
   // public void test12(){
    //    Assert.assertTrue(ongoingSourceOfWealth.passThroughOngoingSourceOfWealth());
    //}
    /*@Test(priority = 2, description = "Checks if it allows incorrect amounts" )
    public void test1(){
        Assert.assertTrue(ongoingSourceOfWealth.incorrectAmounts());
    }
    @Test(priority = 3, description = "Checks is all fields are displayed" )
    public void test2(){
        Assert.assertTrue(ongoingSourceOfWealth.wealthFieldsDisplayed());
    }

    @Test(priority = 4 , description = "Checks if unless all fields are displayed the next button is disabled" )
    public void test3 (){
        Assert.assertTrue(ongoingSourceOfWealth.checkAllFieldsAreFilled());
    }
    @Test(priority = 5 , description = "Checks to see if amounts are shown in GBP" )
    public void test4 (){
        Assert.assertTrue(ongoingSourceOfWealth.isGbpDisplayed());
    }*/
    @Test(priority = 6 , description = "Ensures wealth details are removed if a different business is searched" )
    public void test6 () {
        Assert.assertTrue(ongoingSourceOfWealth.doFieldsClearWithNewSearch());
    }

}
