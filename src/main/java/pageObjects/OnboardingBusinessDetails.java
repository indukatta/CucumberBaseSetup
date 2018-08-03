package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.CommonValidations;
import utils.ExcelUtils;
import utils.GuiCommands;

import java.net.NetworkInterface;
import java.util.concurrent.TimeUnit;

public class OnboardingBusinessDetails extends GuiCommands {

    private String coverPageTitle = "Great, you're ready to get started!";
    private String nextButton = "Next";
    private String businessSearchTitle = "Your Business";
    private String businessSearchBoxTitle = "business_search.search_field_title";
    private String searchTexfield = "search_textfield";
    private String searchExitButton = "search exit button";
    private String beneficialOwner = "business_details.beneficial_owner";
    private String backNavigation = "You and your business";
    private String businessName = "business_details.name";
    private String businessAddress = "business_details.address";
    private String tradingName = "business_details.trading_name";
    private String tradingAddressDifferentToResidential = "checkbox_default.affirmative";
    private String tradingAddressSameAsResidential = "checkbox_default.negative";
    private String tradingAddressTextbox = "business_details.trading_address";
    private String businessActivity = "business_details.activity";
    private String additionalDetails = "business_details.additional_details";
    private String jurisdictionOfTaxResidency = "business_details.tax_residency";
    private String uniqueTaxReferenceNumber = "business_details.utr";
    private String noBusinessFoundError = "We are currently experiencing some technical issues. " +
            "Please log back into Iceberg to continue with your sign up later";//FIXME:get a better error message
    private String addressLookupTitle = "Address (number / postcode)";

    public OnboardingBusinessDetails(AppiumDriver driver) {
        super(driver);
    }

    private CommonValidations validate = new CommonValidations(driver);
    private ExcelUtils excelUtils = new ExcelUtils();

    public void onBoard(boolean tradingAddressSameAsBusiness){
        //verify page navigation
        validate.assertIsDisplayed(coverPageTitle);
        click(nextButton);
        validate.assertIsDisplayed(businessSearchBoxTitle);

        click(businessSearchBoxTitle);
        validate.verifyKeyboardVisible();

        //CUICE-3979 LOOKUP MY BUSINESS - Search by Business Name
        writeText(businessSearchBoxTitle, "ZXE");
        validate.assertResultsReturned(IosTableCellCount());
        String countOne = String.valueOf(IosTableCellCount());
        writeText(businessSearchBoxTitle, "N");
        new WebDriverWait(driver, 2).until(ExpectedConditions.invisibilityOfElementLocated(By.name("ZX EVENTS LTD")));
        validate.assertResultsReturned(IosTableCellCount());
        String countTwo = String.valueOf(IosTableCellCount());
        validate.assertNotEqual(countOne, countTwo);
        clearText(businessSearchBoxTitle);

        //CUICE-3980 LOOKUP MY BUSINESS - Search Company Registration Number
        writeText(businessSearchBoxTitle, "065");
        validate.assertResultsReturned(IosTableCellCount());
        String countBefore = String.valueOf(IosTableCellCount());
        writeText(businessSearchBoxTitle, "87021");
        new WebDriverWait(driver, 2).until(ExpectedConditions.invisibilityOfElementLocated(By.name("EVANGELINA P LTD")));
        validate.assertResultsReturned(IosTableCellCount());
        String countAfter = String.valueOf(IosTableCellCount());
        validate.assertNotEqual(countBefore, countAfter);
        clearText(businessSearchBoxTitle);

        //CUICE-3981 LOOKUP MY BUSINESS - Search by business name - no business found
        writeText(businessSearchBoxTitle, "AN GHNÓ NA BEATHA");
        validate.assertIsDisplayed(noBusinessFoundError);
        clearText(businessSearchBoxTitle);

        //CUICE-3982 LOOKUP MY BUSINESS - Search by company reg number - no business found
        writeText(businessSearchBoxTitle, "01234567");
        validate.assertIsDisplayed(noBusinessFoundError);
        click(searchExitButton);

        //CUICE-3995 - LOOKUP MY BUSINESS - Selection of company
        click(businessSearchBoxTitle);
        writeText(businessSearchBoxTitle, "THE GREAT BRITISH SAUSAGE COMPANY");
        click("THE GREAT BRITISH SAUSAGE COMPANY LTD");
        //check results are returned
        Assert.assertTrue(readText(beneficialOwner).length() > 0);//FIXME:Needs better validation
        Assert.assertTrue(readText(businessName).length() > 0);
        Assert.assertTrue(readText(businessAddress).length() > 0);

        //CUICE-3996 LOOKUP MY BUSINESS - Navigate back to company Search Screen
        click(backNavigation);
        validate.assertIsDisplayed(businessSearchTitle);

        //CUICE-3995 - LOOKUP MY BUSINESS - Selection of company
        writeText(businessSearchBoxTitle, "06587021");
        click("THE GREAT BRITISH SAUSAGE COMPANY LTD");

        //CUICE-3998 - LOOKUP MY BUSINESS - Information Pre-populated and displayed back to user
        Assert.assertTrue(readText(beneficialOwner).length() > 0);//FIXME:Needs better validation
        Assert.assertTrue(readText(businessName).length() > 0);
        Assert.assertTrue(readText(businessAddress).length() > 0);

        validate.verifyCheckboxIsNotSelected(tradingAddressSameAsResidential, "");
        validate.verifyCheckboxIsNotSelected(tradingAddressDifferentToResidential, "");
        validate.verifyNotEnabled(nextButton, "");

        click(tradingAddressDifferentToResidential);
        validate.verifyIsDisplayed(addressLookupTitle);
        click(searchExitButton);
        validate.verifyIsDisplayed(tradingAddressDifferentToResidential);
        validate.verifyNotEnabled(nextButton, "");

        click(tradingAddressSameAsResidential);
        validate.verifyEquals(readText(tradingAddressTextbox), readText(businessAddress));

        //CUICE-4000 - LOOKUP MY BUSINESS - Non-Editing of Pre-populated Information
        validate.verifyNotEnabled(beneficialOwner, "CUICE-4000");
        validate.verifyNotEnabled(businessName, "CUICE-4000");
        validate.verifyNotEnabled(businessAddress, "CUICE-4000");
        validate.verifyNotEnabled(tradingAddressTextbox, "CUICE-4000");

        //SIC CODES
        ExcelUtils.setExcelFile();
    }
}
