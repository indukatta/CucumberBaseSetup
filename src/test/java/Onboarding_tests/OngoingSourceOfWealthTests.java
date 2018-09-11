package Onboarding_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.BusinessDetailsForm;
import pageObjects.BusinessSearch;
import pageObjects.OngoingSourceOfWealth;
import pageObjects.SetUp;

public class OngoingSourceOfWealthTests extends Base_test {
    private SetUp setUp;
    private BusinessSearch businessSearch;
    private BusinessDetailsForm business;
    private OngoingSourceOfWealth ongoingSourceOfWealth;

    @BeforeMethod
    public void beforeMethod() {
        setUp = new SetUp(driver);
        businessSearch = new BusinessSearch(driver);
        business = new BusinessDetailsForm(driver);
        ongoingSourceOfWealth = new OngoingSourceOfWealth(driver);
    }

    @Test(priority = 1, description = "Go to page after ongoing source of wealth" )
    public void test1(){
        Assert.assertTrue(ongoingSourceOfWealth.passThroughOngoingSourceOfWealth());
    }

}
