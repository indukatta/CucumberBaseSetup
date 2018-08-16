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

public class businessDetailsTests extends Base_test {

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

    @Test
    public void naviagateToBusinessDetailsForm(){
        setUp.passThroughSetUp();
        businessSearch.passThroughBusinessSearch();

        Assert.assertTrue(business.isBusinessReviewTitleDisplayed());
    }

    /**
     * User Story CUICE-1235
     */
    @Test(priority = 1)
    public void TradingAddressSameAsBusinessAddress(){
        setUp.passThroughSetUp();
        businessSearch.passThroughBusinessSearch();

        //CUICE-4581 - Display of trading address address/ Business Address Checkboxes
        softAssert.assertTrue(business.tradingAddressDifferentToResidentialDisplayed(), "1");
        softAssert.assertTrue(business.tradingAddressSameAsResidentialDisplayed(), "2");
        softAssert.assertFalse(business.isTradingAddressDifferentToResidentialSelected(), "3");
        softAssert.assertFalse(business.isTradingAddressSameAsResidentialSelected(), "4");
        softAssert.assertFalse(business.isNextButtonEnabled());

        //CUICE-4583 - Same trading address as Business Address
        business.clickTradingAddressSameAsResidential();
        softAssert.assertEquals(business.getTradingAddress(), business.getBusinessAddress(), "12");

        business.clickTradingAddressDifferentToResidential();
        softAssert.assertTrue(business.isAddressLookupTitleDisplayed(), "5");
        softAssert.assertTrue(business.isAddressLookupSearchDisplayed(), "6");

        businessSearch.clickSearchExitButton();
        softAssert.assertFalse(business.isTradingAddressDifferentToResidentialSelected(), "7");
        softAssert.assertFalse(business.isTradingAddressSameAsResidentialSelected(), "8");
        softAssert.assertFalse(business.isNextButtonEnabled(), "9");

        softAssert.assertAll();
    }

    @Test()
    public void personalJurisdictionOfTaxResidency(){

    }

    /**
     * US CUICE-2418
     */
    @Test()
    public void provideTradingName(){
        business.scrollUpToTop();
        softAssert.assertTrue(business.isTradingNameDisplayed(), "CUICE-4553");
        softAssert.assertTrue(business.verifyTextboxIsEmpty(), "CUICE-4850");
        softAssert.assertTrue(business.isNextButtonEnabled(), "CUICE-");

        business.clickTradingName();
        softAssert.assertTrue(business.isKeyboardVisible(), "CUICE-4554");

        business.writeTradingName(generator.setRandomValue(81, "ALPHANUMERIC"));
        softAssert.assertEquals(business.getTradingName().length(), 80, "CUICE-4554");

        softAssert.assertAll();
    }

    @Test(description = "CUICE4581, CUICE4583, CUICE4584, CUICE4000, CUICE4541, CUICE4542, CUICE4543, CUICE4544, CUICE4555")
    private void businessFormTests() {
        setUp.passThroughSetUp();
        businessSearch.passThroughBusinessSearch();

        //CUICE-4581 - Display of trading address address/ Business Address Checkboxes
        softAssert.assertTrue(business.tradingAddressDifferentToResidentialDisplayed(), "1");
        softAssert.assertTrue(business.tradingAddressSameAsResidentialDisplayed(), "2");
        softAssert.assertFalse(business.isTradingAddressDifferentToResidentialSelected(), "3");
        softAssert.assertFalse(business.isTradingAddressSameAsResidentialSelected(), "4");
        softAssert.assertFalse(business.isNextButtonEnabled());

        business.clickTradingAddressDifferentToResidential();
        softAssert.assertTrue(business.isAddressLookupTitleDisplayed(), "5");
        softAssert.assertTrue(business.isAddressLookupSearchDisplayed(), "6");

        businessSearch.clickSearchExitButton();
        softAssert.assertFalse(business.isTradingAddressDifferentToResidentialSelected(), "7");
        softAssert.assertFalse(business.isTradingAddressSameAsResidentialSelected(), "8");
        softAssert.assertFalse(business.isNextButtonEnabled(), "9");

        //CUICE-4583 - Same trading address as Business Address
        softAssert.assertTrue(business.tradingAddressDifferentToResidentialDisplayed(), "10");
        softAssert.assertFalse(business.isNextButtonEnabled(), "11");

        business.clickTradingAddressSameAsResidential();
        softAssert.assertEquals(business.getTradingAddress(), business.getBusinessAddress(), "12");

        //CUICE-4000 - LOOKUP MY BUSINESS - Non-Editing of Pre-populated Information
        softAssert.assertFalse(business.isOwnersNameTextboxEnabled(), "13");
        softAssert.assertFalse(business.isBusinessNameTextboxEnabled(), "14");
        //softAssert.assertFalse(business.isBusinessAddressTextboxEnabled(), "15");
        //softAssert.assertFalse(business.isTradingAddressEnabled(), "16");
        //FIXME add sic code

        business.scrollDownToBottom();
        business.writeAdditionalDetails("Additional Details");
        softAssert.assertTrue(business.isJurisdictionOfTaxResidencyDisplayed(), "17");

        business.scrollDownToBottom();
        business.clickJurisdictionOfTaxResidency();
        softAssert.assertTrue(business.isKeyboardVisible(), "18");

        business.writeCountry("Not a country");
        softAssert.assertEquals(commands.IosTableCellCount(), 0, "19");

        business.clearCountry();
        business.writeCountry("United");
        String countOne = String.valueOf(commands.IosTableCellCount());
        business.writeCountry(" Kingdom");
        new WebDriverWait(driver, 2).until(ExpectedConditions.invisibilityOfElementLocated(By.name("United States")));
        String countTwo = String.valueOf(commands.IosTableCellCount());
        softAssert.assertNotEquals(countOne, countTwo, "20");

        business.clearCountry();
        String country = generator.setCountry();
        business.writeCountry(country);
        business.clickTableCell();
        softAssert.assertEquals(business.getJurisdictionOfTaxResidency(), country, "21");

        //CUICE-1232 - UTR's
        softAssert.assertTrue(business.isUTRDisplayed(), "22");
        business.clickUTR();
        softAssert.assertTrue(business.isKeyboardVisible());
        business.writeUTR(generator.setRandomValue(9, "Numeric"));
        softAssert.assertFalse(business.isNextButtonEnabled(), "23");

        //CUICE-1232 - UTR's
        business.writeUTR("01");
        String actual = business.getUTR();
        String expected = generator.getRandomValue() + "0";
        softAssert.assertEquals(actual, expected, "24");
        softAssert.assertTrue(business.isNextButtonEnabled(), "25");

        business.scrollUpToTop();
        softAssert.assertTrue(business.isTradingNameDisplayed(), "26");
        softAssert.assertTrue(business.verifyTextboxIsEmpty(), "27");
        softAssert.assertTrue(business.isNextButtonEnabled(), "28");
        business.clickTradingName();
        softAssert.assertTrue(business.isKeyboardVisible(), "29");

        business.writeTradingName(generator.setRandomValue(81, "Alphanumeric"));
        softAssert.assertEquals(business.getTradingName().length(), 80, "30");
        business.clickNextButton();

        Assert.assertTrue(details.isOwnershipTitleDisplayed(), "31");

        softAssert.assertAll();
    }
}
