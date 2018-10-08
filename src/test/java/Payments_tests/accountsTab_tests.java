package Payments_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import paymentsPageObjects.AccountsTab;
import paymentsPageObjects.AvailableBalance;
import testUtils.Base_test;

public class accountsTab_tests extends Base_test {

    private AccountsTab accountsTab;

    @BeforeMethod
    public void beforeMethod() {
        accountsTab = new AccountsTab(driver);
    }

    @Test(priority = 1 , description = "Empty state - user has no transactions on their account" )
    public void CUICE6603 () {
        Assert.assertTrue(accountsTab.emptyStateVerification());
    }

    @Test(priority = 2 , description = "Empty state - user has no transactions on their account" )
    public void CUICE6601 () {
        Assert.assertTrue(accountsTab.titleDisplayVerification());
    }

}
