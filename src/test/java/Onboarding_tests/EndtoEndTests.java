package Onboarding_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.*;

public class EndtoEndTests extends Base_test {
    private SetUp setUp;
    private BusinessSearch businessSearch;
    private BusinessDetailsForm business;
    private OngoingSourceOfWealth ongoingSourceOfWealth;
    private TransactionDetails transactionDetails;

    @BeforeMethod
    public void beforeMethod() {
        setUp = new SetUp(driver);
        businessSearch = new BusinessSearch(driver);
        business = new BusinessDetailsForm(driver);
        ongoingSourceOfWealth = new OngoingSourceOfWealth(driver);
        transactionDetails = new TransactionDetails(driver);
    }

    @Test(priority = 1, description = "Go to page after ongoing source of wealth" )
    public void test1(){
        Assert.assertTrue(transactionDetails.passThroughSummaryPage());
    }

}
