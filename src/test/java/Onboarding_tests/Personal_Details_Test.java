package Onboarding_tests;

import com.sun.source.tree.AssertTree;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.*;
import testData.RandomDataGenerator;
import utils.GuiCommands;

public class Personal_Details_Test extends Base_test{

    //private OnboardingPersonalDetails details;
//    private OnboardingSetUp newCustomer;
//    private OnboardingBusinessDetails businessDetails;


    private RandomDataGenerator generator;
    private GuiCommands commands;

    private SetUp setUp;
    private BusinessSearch businessSearch;
    private BusinessDetailsForm business;
    private PersonalDetailsForm details;

    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void beforeMethod() throws Exception {
        //details = new OnboardingPersonalDetails(driver);
//        newCustomer = new OnboardingSetUp(driver);
//        businessDetails = new OnboardingBusinessDetails(driver);


        generator = new RandomDataGenerator();
        commands = new GuiCommands(driver);

        setUp = new SetUp(driver);
        businessSearch = new BusinessSearch(driver);
        business = new BusinessDetailsForm(driver);
        details = new PersonalDetailsForm(driver);
    }

//    @Test
//    public void placeholder(){
//        newCustomer.onBoard();
//        businessDetails.onBoard();
//        details.onBoard();
//    }

    @Test (description = "CUICE4445, CUICE4446, CUICE4447, CUICE4448, CUICE4343, CUICE4345, CUICE4346")
    public void phoneAndEmailTests(){
        setUp.clickContinue();
        setUp.clickConfirm();
        Assert.assertTrue(setUp.phoneNumberTitleDisplayed());
        softAssert.assertFalse(setUp.nextButtonEnabled());

        setUp.clickPhoneNumberTextbox();
        softAssert.assertTrue(setUp.isKeyboardDisplayed());

        //invalid phone entry
        setUp.writePhoneNumber("01234567890");

        softAssert.assertFalse(setUp.nextButtonEnabled());
        setUp.clearPhoneNumber();
        setUp.writePhoneNumber("+441234567890");

        softAssert.assertFalse(setUp.nextButtonEnabled());
        setUp.clearPhoneNumber();
        setUp.writePhoneNumber("0723456789");

        softAssert.assertFalse(setUp.nextButtonEnabled());
        setUp.clearPhoneNumber();
        setUp.writePhoneNumber("071345678901");

        softAssert.assertFalse(setUp.nextButtonEnabled());
        setUp.clearPhoneNumber();

        //valid phone entry
        setUp.writePhoneNumber(generator.setPhoneNumber());
        Assert.assertTrue(setUp.nextButtonEnabled());
        setUp.clickNext();

        Assert.assertTrue(setUp.emailTitleDisplayed());
        softAssert.assertFalse(setUp.nextButtonEnabled());
        setUp.clickEmailTextbox();
        softAssert.assertTrue(setUp.isKeyboardDisplayed());

        //CUICE-4346 Email Address validation - negative
        setUp.writeEmail(generator.setIncorrectEmail());
        softAssert.assertFalse(setUp.nextButtonEnabled());
        setUp.clearEmail();

        //CUICE-4345 Email Address validation - positive
        setUp.writeEmail(generator.setEmail());
        Assert.assertTrue(setUp.nextButtonEnabled());
        setUp.clickNext();

        softAssert.assertAll();
    }


    @Test (description = "CUICE3979, CUICE3980, CUICE3980, CUICE3981, CUICE3982, CUICE3995, CUICE3996, CUICE3998")
    private void businessSearchTests(){
        setUp.passThroughSetUp();
        Assert.assertTrue(businessSearch.coverPageTitleDisplayed());

        //CUICE-3979 LOOKUP MY BUSINESS - Search by Business Name
        businessSearch.clickNextButton();
        Assert.assertTrue(businessSearch.businessSearchTitleDisplayed());

        businessSearch.clickBusinessSearchBoxTitle();
        softAssert.assertTrue(business.isKeyboardVisible());

        businessSearch.writeBusinessTitle("ZXE");
        softAssert.assertTrue(commands.IosTableCellCount()>0);

        String countOne = String.valueOf(commands.IosTableCellCount());
        businessSearch.writeBusinessTitle("N");
        new WebDriverWait(driver, 1).until(ExpectedConditions.invisibilityOfElementLocated(By.name("ZX EVENTS LTD")));
        softAssert.assertTrue(commands.IosTableCellCount()>0);

        String countTwo = String.valueOf(commands.IosTableCellCount());
        softAssert.assertNotEquals(countOne, countTwo);
        businessSearch.clearBusinessSearch();

        //CUICE-3980 LOOKUP MY BUSINESS - Search Company Registration Number
        businessSearch.writeBusinessTitle("065");
        softAssert.assertTrue(commands.IosTableCellCount()>0);

        String countThree = String.valueOf(commands.IosTableCellCount());
        businessSearch.writeBusinessTitle("87021");
        new WebDriverWait(driver, 1).until(ExpectedConditions.invisibilityOfElementLocated(By.name("EVANGELINA P LTD")));
        softAssert.assertTrue(commands.IosTableCellCount()>0);

        String countFour = String.valueOf(commands.IosTableCellCount());
        softAssert.assertNotEquals(countThree, countFour);
        businessSearch.clearBusinessSearch();

        //CUICE-3981 LOOKUP MY BUSINESS - Search by business name - no business found
        businessSearch.writeBusinessTitle("AN GHNÓ NA BEATHA");
        softAssert.assertTrue(businessSearch.noBusinessFoundErrorDisplayed());
        businessSearch.clearBusinessSearch();

        //CUICE-3982 LOOKUP MY BUSINESS - Search by company reg number - no business found
        businessSearch.writeBusinessTitle("01234567");
        softAssert.assertTrue(businessSearch.noBusinessFoundErrorDisplayed());
        businessSearch.clickSearchExitButton();

        //CUICE-3995 - LOOKUP MY BUSINESS - Selection of company
        businessSearch.clickBusinessSearchBoxTitle();
        businessSearch.writeBusinessTitle("THE GREAT BRITISH SAUSAGE COMPANY");
        businessSearch.clickTableCell("THE GREAT BRITISH SAUSAGE COMPANY LTD");
        //check results are returned
        Assert.assertTrue(business.getOwnersName().length()>0);//FIXME:Needs better validation
        Assert.assertTrue(business.getBusinessName().length() > 0);
        Assert.assertTrue(business.getBusinessAddress().length() > 0);

        //CUICE-3996 LOOKUP MY BUSINESS - Navigate back to company Search Screen
        business.clickBackNavigation();
        Assert.assertTrue(businessSearch.businessSearchTitleDisplayed());

        //CUICE-3995 - LOOKUP MY BUSINESS - Selection of company
        businessSearch.writeBusinessTitle("06587021");
        businessSearch.clickTableCell("THE GREAT BRITISH SAUSAGE COMPANY LTD");
        //CUICE-3998 - LOOKUP MY BUSINESS - Information Pre-populated and displayed back to user
        Assert.assertTrue(business.getOwnersName().length()>0);//FIXME:Needs better validation
        Assert.assertTrue(business.getBusinessName().length() > 0);
        Assert.assertTrue(business.getBusinessAddress().length() > 0);

        softAssert.assertAll();
    }

    @Test (description = "CUICE4581, CUICE4583, CUICE4584, CUICE4000, CUICE4541, CUICE4542, CUICE4543, CUICE4544, CUICE4555")
    private void businessFormTests(){
        setUp.passThroughSetUp();
        businessSearch.passThroughBusinessSearch();

        //CUICE-4581 - Display of trading address address/ Business Address Checkboxes
        softAssert.assertTrue(business.tradingAddressDifferentToResidentialDisplayed());
        softAssert.assertTrue(business.tradingAddressSameAsResidentialDisplayed());
        softAssert.assertFalse(business.isTradingAddressDifferentToResidentialSelected());
        softAssert.assertFalse(business.isTradingAddressSameAsResidentialSelected());
        softAssert.assertFalse(business.isNextButtonEnabled());

        business.clickTradingAddressDifferentToResidential();
        softAssert.assertTrue(business.isAddressLookupTitleDisplayed());
        softAssert.assertTrue(business.isAddressLookupSearchDisplayed());

        businessSearch.clickSearchExitButton();
        softAssert.assertFalse(business.isTradingAddressDifferentToResidentialSelected());
        softAssert.assertFalse(business.isTradingAddressSameAsResidentialSelected());
        softAssert.assertFalse(business.isNextButtonEnabled());

        //CUICE-4583 - Same trading address as Business Address
        softAssert.assertTrue(business.tradingAddressDifferentToResidentialDisplayed());
        softAssert.assertFalse(business.isNextButtonEnabled());

        business.clickTradingAddressSameAsResidential();
        softAssert.assertEquals(business.getTradingAddress(), business.getBusinessAddress());

        //CUICE-4000 - LOOKUP MY BUSINESS - Non-Editing of Pre-populated Information
        softAssert.assertFalse(business.isOwnersNameTextboxEnabled());
        softAssert.assertFalse(business.isBusinessNameTextboxEnabled());
        softAssert.assertFalse(business.isBusinessAddressTextboxEnabled());
        softAssert.assertFalse(business.isTradingAddressEnabled());
        //FIXME add sic code

        business.scrollDownToBottom();
        business.writeAdditionalDetails("Additional Details");
        softAssert.assertTrue(business.isJurisdictionOfTaxResidencyDisplayed());

        business.clickJurisdictionOfTaxResidency();
        softAssert.assertTrue(business.isKeyboardVisible());

        business.writeCountry("Not a country");
        softAssert.assertEquals(commands.IosTableCellCount(), 0);

        business.clearCountry();
        business.writeCountry("United");
        String countOne = String.valueOf(commands.IosTableCellCount());
        business.writeCountry(" Kingdom");
        new WebDriverWait(driver, 2).until(ExpectedConditions.invisibilityOfElementLocated(By.name("United States")));
        String countTwo = String.valueOf(commands.IosTableCellCount());
        softAssert.assertNotEquals(countOne,countTwo);

        business.clearCountry();
        String country = generator.setCountry();
        business.writeCountry(country);
        business.clickTableCell(country);
        softAssert.assertEquals(business.getJurisdictionOfTaxResidency(), country);

        //CUICE-1232 - UTR's
        softAssert.assertTrue(business.isUTRDisplayed());
        business.clickUTR();
        softAssert.assertTrue(business.isKeyboardVisible());
        business.writeUTR(generator.setRandomValue(9, "Numeric"));
        softAssert.assertFalse(business.isNextButtonEnabled());

        //CUICE-1232 - UTR's
        business.writeUTR("01");
        String actual = business.getUTR();
        String expected = generator.getRandomValue() + "0";
        softAssert.assertEquals(actual, expected);
        softAssert.assertTrue(business.isNextButtonEnabled());

        business.scrollUpToTop();
        softAssert.assertTrue(business.isTradingNameDisplayed());
        softAssert.assertTrue(business.verifyTextboxIsEmpty());
        softAssert.assertTrue(business.isNextButtonEnabled());
        business.clickTradingName();
        softAssert.assertTrue(business.isKeyboardVisible());

        business.writeTradingName(generator.setRandomValue(81, "Alphanumeric"));
        softAssert.assertEquals(business.getTradingName().length(), 80);
        business.clickNextButton();

        Assert.assertTrue(details.isOwnershipTitleDisplayed());

        softAssert.assertAll();
    }

    @Test(description = "CUICE4141, CUICE4142")
    public void personalDetailsFormTests(){

        Assert.assertTrue(details.isOwnershipTitleDisplayed());
        details.clickConfirmOwnership();
        Assert.assertTrue(details.isPersonalDetailsTitlePageDisplayed());

        //Fields are pre-populated
        Assert.assertTrue(details.getPersonTitle().length() > 0);//FIXME:Needs better validation
        Assert.assertTrue(details.getPersonFirstName().length() > 0);
        Assert.assertTrue(details.getPersonLastName().length() > 0);
        Assert.assertTrue(details.getPersonDOB().length() > 0);
        Assert.assertTrue(details.getPersonNationality().length() > 0);

        //Non editing of pre-populated info
        Assert.assertFalse(details.isPersonTitleEnabled());
        Assert.assertFalse(details.isPersonFirstNameEnabled());
        Assert.assertFalse(details.isPersonLastNameEnabled());
        Assert.assertFalse(details.isPersonDOBEnabled());
        Assert.assertFalse(details.isPersonNationalityEnabled());
    }


    @Test
    private void ownershipPageNavigation(){

    }

    @Test
    private void CUICE4142(){

    }

    @Test
    private void CUICE4141(){

    }

//    @Test
//    private void CUICE4144(){
//        click(backToOwnershipScreen);
//        validate.assertIsDisplayed(ownerShipTitle);
//        click(backToCompanyReview);
//        scrollUp(business.getBusinessReviewTitle());
//        validate.verifyIsDisplayed(business.getBusinessReviewTitle(), "CUICE4144");
//        click(business.getBackNavigation());
//        validate.verifyIsDisplayed(business.getBusinessSearchTitle(), "CUICE4144");
//
//        //navigate back
//        click(business.getBusinessSearchBoxTitle());
//        writeText(business.getBusinessSearchBoxTitle(), "THE GREAT BRITISH SAUSAGE COMPANY");//FIXME: Get stubs
//        click("THE GREAT BRITISH SAUSAGE COMPANY LTD");
//        click(business.getTradingAddressSameAsResidential());
//        click(business.getBusinessActivity());
//        writeText(business.getSicSearchBox(), "Manufacture of metal forming machinery");
//        click("Manufacture of metal forming machinery (28410)");
//        writeText(business.getAdditionalDetails(), "Additional Details");
//        click(business.getJurisdictionOfTaxResidency());
//        writeText(business.getCountriesList(), business.getJurisdictionCountry());
//        clickIosTableCell();
//        writeText(business.getUniqueTaxReferenceNumber(), "1234567890");
//        click(business.getNextButton());
//        click(confirmOwnership);
//        validate.assertIsDisplayed(personalDetailsPageTitle);
//    }
}
