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

public class businessSearchTests extends Base_test {

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
    public void navigateToBUsinessSearch(){
        setUp.passThroughSetUp();
        Assert.assertTrue(businessSearch.coverPageTitleDisplayed());
    }

    @Test
    public void searchByBusinessName(){
        //CUICE-3979 LOOKUP MY BUSINESS - Search by Business Name
        businessSearch.clickNextButton();
        Assert.assertTrue(businessSearch.businessSearchTitleDisplayed());

        businessSearch.clickBusinessSearchBoxTitle();
        softAssert.assertTrue(business.isKeyboardVisible());

        businessSearch.writeBusinessTitle("ZXE");
        softAssert.assertTrue(commands.IosTableCellCount() > 0);

        String countOne = String.valueOf(commands.IosTableCellCount());
        businessSearch.writeBusinessTitle("N");
        new WebDriverWait(driver, 1).until(ExpectedConditions.invisibilityOfElementLocated(By.name("ZX EVENTS LTD")));
        softAssert.assertTrue(commands.IosTableCellCount() > 0);

        String countTwo = String.valueOf(commands.IosTableCellCount());
        softAssert.assertNotEquals(countOne, countTwo);

        businessSearch.clearBusinessSearch();

        softAssert.assertAll();
    }

    @Test
    public void searchCompanyByRegistrationNumber(){
        //CUICE-3980 LOOKUP MY BUSINESS - Search Company Registration Number
        businessSearch.writeBusinessTitle("065");
        softAssert.assertTrue(commands.IosTableCellCount() > 0);

        String countThree = String.valueOf(commands.IosTableCellCount());
        businessSearch.writeBusinessTitle("87021");
        new WebDriverWait(driver, 1).until(ExpectedConditions.invisibilityOfElementLocated(By.name("EVANGELINA P LTD")));
        softAssert.assertTrue(commands.IosTableCellCount() > 0);

        String countFour = String.valueOf(commands.IosTableCellCount());
        softAssert.assertNotEquals(countThree, countFour);
        businessSearch.clearBusinessSearch();

        softAssert.assertAll();
    }

    @Test
    public void searchNoBusinessFound(){
        //CUICE-3981 LOOKUP MY BUSINESS - Search by business name - no business found
        businessSearch.writeBusinessTitle("AN GHNÓ NA BEATHA");
        softAssert.assertTrue(businessSearch.noBusinessFoundErrorDisplayed());

        businessSearch.clearBusinessSearch();

        //CUICE-3982 LOOKUP MY BUSINESS - Search by company reg number - no business found
        businessSearch.writeBusinessTitle("01234567");
        softAssert.assertTrue(businessSearch.noBusinessFoundErrorDisplayed());

        businessSearch.clickSearchExitButton();

        softAssert.assertAll();
    }

    @Test
    public void selectionOfCompany(){
        //CUICE-3995 - LOOKUP MY BUSINESS - Selection of company
        businessSearch.clickBusinessSearchBoxTitle();
        businessSearch.writeBusinessTitle("THE GREAT BRITISH SAUSAGE COMPANY");
        businessSearch.clickTableCell("THE GREAT BRITISH SAUSAGE COMPANY LTD");

        //check results are returned
        Assert.assertTrue(business.getOwnersName().length() > 0);//FIXME:Needs better validation
        Assert.assertTrue(business.getBusinessName().length() > 0);
        Assert.assertTrue(business.getBusinessAddress().length() > 0);

        //CUICE-3996 LOOKUP MY BUSINESS - Navigate back to company Search Screen
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"You and your business\"]")).click();//FIXME:get accessibility ID
        //business.clickBackNavigation();
        Assert.assertTrue(businessSearch.businessSearchTitleDisplayed());

        //CUICE-3995 - LOOKUP MY BUSINESS - Selection of company
        businessSearch.writeBusinessTitle("06587021");
        businessSearch.clickTableCell("THE GREAT BRITISH SAUSAGE COMPANY LTD");

        //CUICE-3998 - LOOKUP MY BUSINESS - Information Pre-populated and displayed back to user
        Assert.assertTrue(business.getOwnersName().length() > 0);//FIXME:Needs better validation
        Assert.assertTrue(business.getBusinessName().length() > 0);
        Assert.assertTrue(business.getBusinessAddress().length() > 0);

        //Details Cannot be Edited
        Assert.assertFalse(business.isOwnersNameTextboxEnabled());//FIXME:Needs better validation
        Assert.assertFalse(business.isBusinessNameTextboxEnabled());
        Assert.assertFalse(business.isBusinessAddressTextboxEnabled());

        softAssert.assertAll();
    }

    @Test(description = "CUICE3979, CUICE3980, CUICE3980, CUICE3981, CUICE3982, CUICE3995, CUICE3996, CUICE3998")
    public void businessSearchTests() {
        setUp.passThroughSetUp();
        Assert.assertTrue(businessSearch.coverPageTitleDisplayed());

        //CUICE-3979 LOOKUP MY BUSINESS - Search by Business Name
        businessSearch.clickNextButton();
        Assert.assertTrue(businessSearch.businessSearchTitleDisplayed());

        businessSearch.clickBusinessSearchBoxTitle();
        softAssert.assertTrue(business.isKeyboardVisible());

        businessSearch.writeBusinessTitle("ZXE");
        softAssert.assertTrue(commands.IosTableCellCount() > 0);

        String countOne = String.valueOf(commands.IosTableCellCount());
        businessSearch.writeBusinessTitle("N");
        new WebDriverWait(driver, 1).until(ExpectedConditions.invisibilityOfElementLocated(By.name("ZX EVENTS LTD")));
        softAssert.assertTrue(commands.IosTableCellCount() > 0);

        String countTwo = String.valueOf(commands.IosTableCellCount());
        softAssert.assertNotEquals(countOne, countTwo);
        businessSearch.clearBusinessSearch();

        //CUICE-3980 LOOKUP MY BUSINESS - Search Company Registration Number
        businessSearch.writeBusinessTitle("065");
        softAssert.assertTrue(commands.IosTableCellCount() > 0);

        String countThree = String.valueOf(commands.IosTableCellCount());
        businessSearch.writeBusinessTitle("87021");
        new WebDriverWait(driver, 1).until(ExpectedConditions.invisibilityOfElementLocated(By.name("EVANGELINA P LTD")));
        softAssert.assertTrue(commands.IosTableCellCount() > 0);

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
        Assert.assertTrue(business.getOwnersName().length() > 0);//FIXME:Needs better validation
        Assert.assertTrue(business.getBusinessName().length() > 0);
        Assert.assertTrue(business.getBusinessAddress().length() > 0);

        //CUICE-3996 LOOKUP MY BUSINESS - Navigate back to company Search Screen

        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"You and your business\"]")).click();//FIXME:get accessibility ID
        //business.clickBackNavigation();
        Assert.assertTrue(businessSearch.businessSearchTitleDisplayed());

        //CUICE-3995 - LOOKUP MY BUSINESS - Selection of company
        businessSearch.writeBusinessTitle("06587021");
        businessSearch.clickTableCell("THE GREAT BRITISH SAUSAGE COMPANY LTD");
        //CUICE-3998 - LOOKUP MY BUSINESS - Information Pre-populated and displayed back to user
        Assert.assertTrue(business.getOwnersName().length() > 0);//FIXME:Needs better validation
        Assert.assertTrue(business.getBusinessName().length() > 0);
        Assert.assertTrue(business.getBusinessAddress().length() > 0);

        softAssert.assertAll();
    }
}
