package Onboarding_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Login.Login;
import testUtils.Base_test;

public class loginTests extends Base_test {

    private Login login;

    @BeforeMethod
    public void beforeMethod() throws Exception {
        login = new Login(driver);
    }

    @Test(priority = 1, description = "Login with username & password then logout")
    public void CUICE5474() {
    Assert.assertTrue(login.passThroughLogin());
    }

    @Test(priority = 2, description = "login with incorrect username")
    public void CUICE5476(){
    Assert.assertTrue(login.incorrectLogin());
    }

    @Test(priority = 3, description = "login with incorrect username")
    public void CUICE5477(){
    Assert.assertTrue(login.incorrectPassword());
    }

        /*
        @Test(priority = 3, description = "Navigate Back To Company Search Screen")
        public void CUICE4144(){
            Assert.assertTrue(details.navigateBackToBusinessSearch());
        }
        */
    }


