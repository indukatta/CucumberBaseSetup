package CSM_Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.CSM.SupportScreen;
import pageObjects.Login.Login;
import testUtils.Base_test;

public class supportScreenTests extends Base_test {

    private Login login;
    private SupportScreen supportScreen;

    @BeforeMethod
    public void beforeMethod() {
        login = new Login(driver);
        supportScreen = new SupportScreen(driver);
    }

    @Test(priority = 1, description = "Navigate to support screen")
    public void CUICE1() {
        Assert.assertTrue(supportScreen.navigateToSupportScreen());
    }


}

