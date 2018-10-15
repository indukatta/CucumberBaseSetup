package Payments_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import paymentsPageObjects.AvailableBalance;
import paymentsPageObjects.DirectDebit;
import testUtils.Base_test;

public class directDebit_tests extends Base_test {

    private DirectDebit directDebit;

    @BeforeMethod
    public void beforeMethod() {
        directDebit = new DirectDebit(driver);
    }

    @Test(priority = 1, description = "Direct debit list empty state")
    public void CUICE6874() {
        Assert.assertTrue(directDebit.emptyState());
    }

    @Test(priority = 2, description = "Back Button from manage scheduled payments")
    public void CUICE6875() {
        Assert.assertTrue(directDebit.BBValidation());
    }

    @Test(priority = 3, description = "Informative text is shown")
    public void CUICE6876() {
        Assert.assertTrue(directDebit.isInformativeTextShown());
    }

    @Test(priority = 4, description = "Direct debit list display")
    public void CUICE6862() {Assert.assertTrue(directDebit.displayDD());}
}
