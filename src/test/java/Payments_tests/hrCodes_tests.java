package Payments_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import paymentsPageObjects.AvailableBalance;
import testUtils.Base_test;

public class hrCodes_tests extends Base_test {

    private AvailableBalance availableBalance;

    @BeforeMethod
    public void beforeMethod() {
        availableBalance = new AvailableBalance(driver);
    }

    @Test(priority = 1 , description = "View payment success page" )
    public void CUICE6354 () {
        Assert.assertTrue(availableBalance.successPageDisplayed());
    }
    @Test(priority = 2 , description = "Faster payment placeholder disclaimer" )
    public void CUICE6355 () {
        Assert.assertTrue(availableBalance.disclaimerShown());
    }
    @Test(priority = 3 , description = "Done CTA on success page" )
    public void CUICE6356 () {
        Assert.assertTrue(availableBalance.doneButtonValidation());
    }
    @Test(priority = 4 , description = "Display relevant message for sent status brcs" )
    public void CUICE () {
        Assert.assertTrue(availableBalance.sentStatusMessageCheck());
    }

}
