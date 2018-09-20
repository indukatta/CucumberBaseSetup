package CSM_Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.CSM.MessagingScreen;
import pageObjects.CSM.SupportScreen;
import pageObjects.Login.Login;
import testUtils.Base_test;

public class messagingScreenTests extends Base_test {

    private Login login;
    private SupportScreen supportScreen;
    private MessagingScreen messagingScreen;




    @BeforeMethod
    public void beforeMethod() {
        login = new Login(driver);
        supportScreen = new SupportScreen(driver);
        messagingScreen = new MessagingScreen(driver);

    }

    @Test(priority = 1, description = "Navigate to messaging screen")
    public void CUICE2() {
        Assert.assertTrue(messagingScreen.navigateToMessagingScreen());
    }

    @Test(priority = 2, description = "Type and send in message box")
    public void CUICE3() {
        Assert.assertTrue(messagingScreen.writeToMessagingScreen());
    }

}




