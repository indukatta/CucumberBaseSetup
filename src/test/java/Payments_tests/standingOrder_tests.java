package Payments_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import paymentsPageObjects.DirectDebit;
import paymentsPageObjects.StandingOrder;
import testUtils.Base_test;

public class standingOrder_tests extends Base_test {
    private StandingOrder standingOrder;

    @BeforeMethod
    public void beforeMethod() {
        standingOrder = new StandingOrder(driver);
    }

    @Test(priority = 1, description = "Toggle display")
    public void CUICE7312() {
        Assert.assertTrue(standingOrder.manageScheduleIsDisplayed());
    }

    @Test(priority = 2, description = "Switch between payment types")
    public void CUICE7314() {
        Assert.assertTrue(standingOrder.switchTabVerification());
    }

    @Test(priority = 3, description = "Scheduled payments page header text")
    public void CUICE7315() {
        Assert.assertTrue(standingOrder.scheduleHeaderIsDisplayed());
    }

    @Test(priority = 4, description = "Do not refresh DD and SO lists after they have been displayed")
    public void CUICE7535() { Assert.assertTrue(standingOrder.refreshCheck()); }

}
