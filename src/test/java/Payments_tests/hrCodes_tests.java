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
    public void CUICE6829 () {
        Assert.assertTrue(availableBalance.sentStatusMessageCheck());
    }

    @Test(priority = 5 , description = "Display edit payment failure page" )
    public void CUICE7104 () {
        Assert.assertTrue(availableBalance.editStatusMessageCheck());
    }

    @Test(priority = 6 , description = "Edit sort code, account number or name" )
    public void CUICE7105 () {
        Assert.assertTrue(availableBalance.editPayeeDetailsCode());
    }

    @Test(priority = 7 , description = "Issue with available balance or limits" )
    public void CUICE7106 () {
        Assert.assertTrue(availableBalance.editPaymentDetailsCode());
    }

    @Test(priority = 8 , description = "Issue with available balance or limits" )
    public void CUICE7122 () {
        Assert.assertTrue(availableBalance.failureStatusMessageCheck());
    }

    @Test(priority = 9 , description = "Display Yes/No pop-up" )
    public void CUICE7078 () {
        Assert.assertTrue(availableBalance.duplicatePopUpDisplay());
    }

    @Test(priority = 10 , description = "Click No on yes/no pop-up" )
    public void CUICE7079 () { Assert.assertTrue(availableBalance.clickNoPopUp()); }

    @Test(priority = 11 , description = "Click Yes on yes/no pop-up" )
    public void CUICE7080 () {
        Assert.assertTrue(availableBalance.clickYesPopUp());
    }

    @Test(priority = 12 , description = "Display yes/no pop-up for bacs codes" )
    public void CUICE7211 () {
        Assert.assertTrue(availableBalance.bacsPopUpDisplay());
    }

    @Test(priority = 13 , description = "Click no on bacs yes/no pop up" )
    public void CUICE7212 () {
        Assert.assertTrue(availableBalance.bacsSelectNo());
    }

    @Test(priority = 13 , description = "Click Yes Happy Path for bacs" )
    public void CUICE7213 () {
        Assert.assertTrue(availableBalance.bacsSelectYes());
    }

    @Test(priority = 13 , description = "Display yes no pop-up for chaps" )
    public void CUICE7230 () {
        Assert.assertTrue(availableBalance.chapsPopUpDisplay());
    }

    @Test(priority = 13 , description = "chaps click yes happy path" )
    public void CUICE7232 () { Assert.assertTrue(availableBalance.chapsSelectYes()); }

    @Test(priority = 13 , description = "chaps click no on chaps pop up" )
    public void CUICE7231 () { Assert.assertTrue(availableBalance.chapsSelectNo()); }

    @Test(priority = 13 , description = "display yes/no pop-up for fraud" )
    public void CUICE7251 () {
        Assert.assertTrue(availableBalance.fruadPopUpDisplay());
    }

    @Test(priority = 13 , description = "click no on fraud pop-up" )
    public void CUICE7252 () { Assert.assertTrue(availableBalance.fruadSelectNo()); }

    @Test(priority = 13 , description = "Fraud issue after cut off display popup" )
    public void CUICE7253 () { Assert.assertTrue(availableBalance.fraudSelectYes()); }

    @Test(priority = 13 , description = "Agency bank scenario 1" )
    public void CUICE7254 () { Assert.assertTrue(availableBalance.agencyMainSelectYes()); }

    @Test(priority = 13 , description = "Agency bank scenario 2" )
    public void CUICE7255 () { Assert.assertTrue(availableBalance.agencySideSelectYes()); }

    @Test(priority = 13 , description = "Agency bank scenario 1" )
    public void CUICE7257 () { Assert.assertTrue(availableBalance.agencyOtheSelectYes()); }














}
