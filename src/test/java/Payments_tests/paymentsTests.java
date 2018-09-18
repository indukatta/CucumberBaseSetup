package Payments_tests;

import Onboarding_tests.Base_test;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.BusinessDetailsForm;
import pageObjects.BusinessSearch;
import pageObjects.OngoingSourceOfWealth;
import pageObjects.SetUp;
import paymentsPageObjects.AvailableBalance;

class paymentTests extends Base_test {
    private AvailableBalance availableBalance;


    @BeforeMethod
    public void beforeMethod() {
        availableBalance = new AvailableBalance(driver);
    }


    @Test(priority = 1 , description = "Is available balance the same on both sides" )
    public void test1 (){
        Assert.assertTrue(availableBalance.isAvailBalanceEqual());
    }


}
