package Payments_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import paymentsPageObjects.AvailableBalance;
import testUtils.Base_test;

class paymentTests extends Base_test {
    private AvailableBalance availableBalance;


    @BeforeMethod
    public void beforeMethod() {
        availableBalance = new AvailableBalance(driver);
    }

    @Test(priority = 1 , description = "Is available balance the same on both sides" )
    public void CUICE779() { Assert.assertTrue(availableBalance.isAvailBalanceEqual());
    }
    @Test(priority = 2 , description = "Ensures the cancel button is function and redirects to the correct page" )
    public void CUICE5890() { Assert.assertTrue(availableBalance.cancelButtonVerification());
    }



}
