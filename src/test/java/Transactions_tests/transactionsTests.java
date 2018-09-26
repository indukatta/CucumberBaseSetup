package Transactions_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Login.Login;
import pageObjects.Transactions.Transactions;
import testUtils.Base_test;

public class transactionsTests extends Base_test {
    Login login = new Login(driver);
    private Transactions Transactions;

    @BeforeMethod
    public void beforeMethod() throws Exception {
        Transactions = new Transactions(driver);
    }

    @Test(priority = 1, description = "Login and view transactions details")
    public void CUICE5464() {
        Assert.assertTrue(Transactions.passThroughLogin());
    }

    @Test(priority = 2, description = "Login and view account balance and available balance - Error message if available balance cannot be displayed")
    public void CUICE4959() {
        Assert.assertTrue(Transactions.incorrectLogin());
    }

    @Test(priority = 3, description = "Login and view account balance and available balance - Error message if available balance cannot be displayed")
    public void CUICE4946() {
        Assert.assertTrue(Transactions.incorrectPassword());
    }

    @Test(priority = 4, description = "Login and view account balance and available balance and check position of Account / Available Balance")
    public void CUICE4945() {
        Assert.assertTrue(Transactions.showPasswordCheckBox());
    }

    @Test(priority = 5, description = "Check if Current Account Details are showing such as account number and sort-code")
    public void CUICE4944() {
        Assert.assertTrue(Transactions.navigateToPasswordField());
    }

    @Test(priority = 6, description = "Login and view account available balance")
    public void CUICE4943() {
        Assert.assertTrue(Transactions.navigateToPasswordScreen());
    }

    @Test(priority = 7, description = "Login and view account account balance")
    public void CUICE4941() {
        Assert.assertTrue(Transactions.navigateToUsernameFieldBox());
    }

    @Test(priority = 8, description = "Scroll through my transaction list to view older transactions, maximum of three months")
    public void CUICE4813() {
        Assert.assertTrue(Transactions.navigateToUsernamePage());
    }

    @Test(priority = 9, description = "Navigate to the balance and log out")
    public void CUICE4812() {
        Assert.assertTrue(Transactions.logoutTest());
    }

    @Test(priority = 10, description = "Navigate to the balance and log out")
    public void CUICE4811() {
        Assert.assertTrue(Transactions.logoutTest());
    }

    @Test(priority = 11, description = "Navigate to the balance and log out")
    public void CUICE4810() {
        Assert.assertTrue(Transactions.logoutTest());
    }

    @Test(priority = 12, description = "Navigate to the balance and log out")
    public void CUICE4809() {
        Assert.assertTrue(Transactions.logoutTest());
    }

    @Test(priority = 13, description = "Navigate to the balance and log out")
    public void CUICE4808() {
        Assert.assertTrue(Transactions.logoutTest());

    }

    @Test(priority = 14, description = "Navigate to the balance and log out")
    public void CUICE4807() {
        Assert.assertTrue(Transactions.logoutTest());
    }

    @Test(priority = 15, description = "Navigate to the balance and log out")
    public void CUICE4806() {
        Assert.assertTrue(Transactions.logoutTest());
    }
}