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

        @Test(priority = 1 , description = "ensure available balance the same one summary page and in payment page " )
        public void CUICE779 () {
            Assert.assertTrue(availableBalance.isAvailBalanceEqual());
        }

        @Test(priority = 2 , description = "Ensures cancel button resets all entries and goes back to landing page" )
        public void CUICE5890 () {
        Assert.assertTrue(availableBalance.cancelButtonVerification());
          }

        @Test(priority = 3 , description = "Ensures back button on summary page goes the the right place" )
        public void CUICE5893 () {
            Assert.assertTrue(availableBalance.goBackFromSummaryPage());
        }
        @Test(priority = 2 , description = "Ensures cancel button resets all entries and goes back to landing page" )

        public void CUICE589 () {
            Assert.assertTrue(availableBalance.cancelButtonVerification());
        }





}
