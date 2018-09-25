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

        @Test(priority = 7 , description = "Ensures all summary elements are on the page" )
        public void CUICE5920 () { Assert.assertTrue(availableBalance.isAllSummaryDisplayed()); }

        // CUICE-637

        @Test(priority = 8 , description = "Checks name field validation" )
        public void CUICE5547 () { Assert.assertTrue(availableBalance.payeeDetailsNameField()); }

        @Test(priority = 9 , description = "Checks sort code is written in correct format" )
        public void CUICE5548 () { Assert.assertTrue(availableBalance.sortCodeValidator()); }

        @Test(priority = 10 , description = "Ensures only valid details are entered into account" )
        public void CUICE5549 () { Assert.assertTrue(availableBalance.accountNumberValidator()); }

        @Test(priority = 11 , description = "Ensure continue button is enabled when all fields are filled" )
        public void CUICE5550 () { Assert.assertTrue(availableBalance.isContinueButtonWorking()); }

        @Test(priority = 12, description = "Ensures all elements on payee details page is displayed" )
        public void CUICE5546 () { Assert.assertTrue(availableBalance.startPaymentJourneyAndEnterPayeeDetails()); }

        // CUICE-642

        @Test(priority = 13 , description = "Ensures only valid amounts can be accepted" )
        public void CUICE5552 () { Assert.assertTrue(availableBalance.paymentAmountValidator()); }

        @Test(priority = 14 , description = "Ensures correct currency is displayed" )
        public void CUICE5554 () { Assert.assertTrue(availableBalance.isCurrencyDisplayed()); }

        @Test(priority = 15 , description = "Ensures continue button on payment page works correctly" )
        public void CUICE5556 () { Assert.assertTrue(availableBalance.isContinuebtnEnabled()); }

        @Test(priority = 16 , description = "Checks that pound sign is not displayed whilst amount field is inactive and empty" )
        public void ac7 () { Assert.assertTrue(availableBalance.isGpbDisplayedInactive()); }

        @Test(priority = 17 , description = "Ensures only valid entries in reference field are allowed" )
        public void CUICE5555 () { Assert.assertTrue(availableBalance.referenceFieldValidator()); }






}
