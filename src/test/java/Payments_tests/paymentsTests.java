package Payments_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import paymentsPageObjects.AvailableBalance;
import testUtils.Base_test;

public class paymentsTests extends Base_test {


        private AvailableBalance availableBalance;

        @BeforeMethod
        public void beforeMethod() {

            availableBalance = new AvailableBalance(driver);

        }
        //CUICE-779
        @Test(priority = 1 , description = "Ensure available balance the same one summary page and in payment page " )
        public void CUICE5614 () {
            Assert.assertTrue(availableBalance.isAvailBalanceEqual());
        }

        // CUICE-658

        @Test(priority = 2 , description = "Ensures cancel button resets all entries and goes back to landing page" )
        public void CUICE5890 () {
        Assert.assertTrue(availableBalance.cancelButtonVerification());
          }

        @Test(priority = 3 , description = "Ensures back button on summary page goes the the right place" )
        public void CUICE5893 () {
            Assert.assertTrue(availableBalance.goBackFromSummaryPage());
        }

        @Test(priority = 4 , description = "Ensures back button on payee details page goes to the right place and details are removed" )
        public void CUICE5891 () {
            Assert.assertTrue(availableBalance.goBackFromPayeeDetails()); }

        @Test(priority = 5 , description = "Ensures back button on payment details page goes the the right place" )
        public void CUICE5892 () { Assert.assertTrue(availableBalance.goBackFromPaymentsDetailsPage()); }

        @Test(priority = 6 , description = "Ensures information is retained when back button from " )
        public void CUICE5900 () { Assert.assertTrue(availableBalance.isPaymentInfoKept()); }

        // CUICE-656

        @Test(priority = 7 , description = "Ensures information is retained when back button from " )
        public void CUICE5920 () { Assert.assertTrue(availableBalance.isAllSummaryDisplayed()); }







}
