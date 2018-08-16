package Onboarding_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.BusinessDetailsForm;
import pageObjects.BusinessSearch;
import pageObjects.PersonalDetailsForm;
import pageObjects.SetUp;
import testData.RandomDataGenerator;
import utils.GuiCommands;

public class personalDetailsTests extends Base_test {

    private RandomDataGenerator generator;
    private GuiCommands commands;

    private SetUp setUp;
    private BusinessSearch businessSearch;
    private BusinessDetailsForm business;
    private PersonalDetailsForm details;

    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void beforeMethod() throws Exception {

        generator = new RandomDataGenerator();
        commands = new GuiCommands(driver);

        setUp = new SetUp(driver);
        businessSearch = new BusinessSearch(driver);
        business = new BusinessDetailsForm(driver);
        details = new PersonalDetailsForm(driver);
    }

    @Test(priority = 1)
    public void navigateToPersonalDeatils(){
        setUp.passThroughSetUp();
        businessSearch.passThroughBusinessSearch();
        business.populateAllFieldsAndClickNext();

        Assert.assertTrue(details.isOwnershipTitleDisplayed());
        details.clickConfirmOwnership();

        Assert.assertTrue(details.isPersonalDetailsTitlePageDisplayed());
    }

    @Test(priority = 2)
    public void selectGovIDType(){
        softAssert.assertTrue(details.isGovernmentIdTypeDisplayed());
        softAssert.assertEquals(details.getPersonIdType(), "Choose type");

        details.selectIdType("Passport");
        details.pickerWheelDone();
        softAssert.assertEquals(details.getPersonIdType(), "Passport");

        details.selectIdType("Drivers Licence");
        details.pickerWheelDone();
        softAssert.assertEquals(details.getPersonIdType(), "Drivers Licence");

        details.selectIdType("Passport");
        details.pickerWheelDone();
        softAssert.assertEquals(details.getPersonIdType(), "Passport");
    }

    @Test(priority = 3, description = "CUICE-4639, CUICE-4640, CUICE-4642, CUICE-4643")
    public void personalJurisdictionOfTaxResidency(){

        softAssert.assertTrue(details.isJurisdictionOfTaxResidencyDisplayed(), "CUICE-4639");

        details.clickJurisdictionOfTaxResidency();
        softAssert.assertTrue(business.isKeyboardVisible(), "CUICE-4640");

        business.writeCountry("Not a country");
        softAssert.assertEquals(commands.IosTableCellCount(), 0, "CUICE-4643");

        business.clearCountry();
        business.writeCountry("United");
        String countOne = String.valueOf(commands.IosTableCellCount());
        business.writeCountry(" Kingdom");
        new WebDriverWait(driver, 2).until(ExpectedConditions.invisibilityOfElementLocated(By.name("United States")));
        String countTwo = String.valueOf(commands.IosTableCellCount());
        softAssert.assertNotEquals(countOne, countTwo, "CUICE-4642");

        business.clearCountry();
        String country = generator.setCountry();
        business.writeCountry(country);
        business.clickTableCell();
        softAssert.assertEquals(details.getPersonJurisdictionOfTaxResidency(), country, "CUICE-4642");

        softAssert.assertAll();
    }
}
