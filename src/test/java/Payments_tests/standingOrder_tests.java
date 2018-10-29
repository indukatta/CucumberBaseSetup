package Payments_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import paymentsPageObjects.DirectDebit;
import paymentsPageObjects.StandingOrder;
import testUtils.Base_test;

public class standingOrder_tests extends Base_test {
    private StandingOrder standingOrder;
    private DirectDebit directDebit;

    @BeforeMethod
    public void beforeMethod() {
        standingOrder = new StandingOrder(driver);
        directDebit = new DirectDebit(driver);
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

    @Test(priority = 5, description = "go back from standing order tab")
    public void CUICE7401() { Assert.assertTrue(standingOrder.goBackFromSO()); }

    @Test(priority = 6, description = "Standing order list display")
    public void CUICE7399() { Assert.assertTrue(standingOrder.displaySO()); }

    @Test(priority = 7, description = "Informative text is shown")
    public void CUICE7402() { Assert.assertTrue(standingOrder.isInfoTextShown()); }

    @Test(priority = 8, description = "Failure - display warning in snack bar")
    public void CUICE7038() { Assert.assertTrue(directDebit.isFailureErrMsgDisplayedSO()); }

    @Test(priority = 9, description = "Network error ")
    public void CUICE7040() { Assert.assertTrue(directDebit.isNetworkErrMsgDisplayedSO()); }

    @Test(priority = 10, description = "Retry - display warning in snack bar")
    public void CUICE7039() { Assert.assertTrue(directDebit.isRetryErrMsgDisplayedSO()); }

    @Test(priority = 11, description = "No result - display empty state")
    public void CUICE7037() { Assert.assertTrue(standingOrder.emptyStateSO()); }


}
