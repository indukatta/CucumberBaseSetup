package Payments_tests;

import static com.factory.mobile.driver.AppiumDriverManager.*;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import paymentsPageObjects.AccountsTab;
import testUtils.Base_test;

public class accountsTab_tests extends Base_test {

	private AccountsTab accountsTab;

	@BeforeTest
	public void setupReports() {
		startReports("accountsTab");
	}
	@AfterTest
	public void tearDownAutoExsel() {
		endReports();
	}

	@BeforeMethod
	public void beforeMethod() {
		accountsTab = new AccountsTab(driver);
	}

	@Test(priority = 1, description = "Empty state - user has no transactions on their account")
	public void CUICE6603() {
		startTest("CUICE6603: Empty state - user has no transactions on their account");
		Assert.assertTrue(accountsTab.emptyStateVerification());
		endTest();
	}

	@Test(priority = 2, description = "Empty state - user has no transactions on their account")
	public void CUICE6601() {
		startTest("CUICE6601: Empty state - user has no transactions on their account");
		Assert.assertTrue(accountsTab.titleDisplayVerification());
		endTest();
	}

//	@Test(priority = 3, description = "Months is in active state on months bar (more than 1 month displayed )")
	public void CUICE6724() {
		Assert.assertTrue(accountsTab.moreThanOneMonthsBar());
	}

//	@Test(priority = 4, description = "Months is in active state on months bar (1st month of account) ")
	public void CUICE6723() {
		Assert.assertTrue(accountsTab.oneMonthBar());
	}

}
