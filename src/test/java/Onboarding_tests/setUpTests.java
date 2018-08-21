package Onboarding_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.SetUp;
import testData.RandomDataGenerator;
import utils.GuiCommands;

public class setUpTests extends Base_test {

    private RandomDataGenerator generator;
    private GuiCommands commands;

    private SetUp setUp;

    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void beforeMethod() {

        generator = new RandomDataGenerator();
        commands = new GuiCommands(driver);

        setUp = new SetUp(driver);
    }

    @Test(priority = 1)
    public void navigateToPhoneEntry(){
        setUp.clickContinue();
        setUp.clickConfirm();
        Assert.assertTrue(setUp.phoneNumberTitleDisplayed());
        softAssert.assertFalse(setUp.nextButtonEnabled());
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void testPhoneEntry(){
        setUp.clickPhoneNumberTextbox();
        softAssert.assertTrue(setUp.isKeyboardDisplayed(), "CUICE");

        //invalid phone entry
        setUp.writePhoneNumber("01234567890");
        softAssert.assertFalse(setUp.nextButtonEnabled(), "");

        setUp.clearPhoneNumber();
        setUp.writePhoneNumber("+441234567890");
        softAssert.assertFalse(setUp.nextButtonEnabled(), "");

        setUp.clearPhoneNumber();
        setUp.writePhoneNumber("0723456789");
        softAssert.assertFalse(setUp.nextButtonEnabled(), "");

        setUp.clearPhoneNumber();
        setUp.writePhoneNumber("071345678901");
        softAssert.assertFalse(setUp.nextButtonEnabled(), "");

        setUp.clearPhoneNumber();
        //valid phone entry
        setUp.writePhoneNumber(generator.setPhoneNumber());
        Assert.assertTrue(setUp.nextButtonEnabled(), "");

        setUp.clickNext();
    }

//    @Test(priority = 3)
//    public void testEmailEntry(){
//        Assert.assertTrue(setUp.emailTitleDisplayed(), "");
//        softAssert.assertFalse(setUp.nextButtonEnabled(), "");
//
//        setUp.clickEmailTextbox();
//        softAssert.assertTrue(setUp.isKeyboardDisplayed(), "");
//
//        //CUICE-4346 Email Address validation - negative
//        for (int i = 0; i < 6; i++){
//            setUp.writeEmail(generator.setIncorrectEmail("ALL", i));
//            softAssert.assertFalse(setUp.nextButtonEnabled(), "CUICE-4346" + " " + i);
//
//            setUp.clearEmail();
//        }
//
//        //CUICE-4345 Email Address validation - positive
//        for (int i = 0; i < 5; i++){
//            setUp.writeEmail(generator.setEmail("ALL", i));
//            softAssert.assertTrue(setUp.nextButtonEnabled(), "CUICE-4345" + " " + i);
//
//            setUp.clearEmail();
//        }
//        setUp.clickNext();
//
//        softAssert.assertAll();
//    }
}
