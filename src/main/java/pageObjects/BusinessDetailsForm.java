package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testData.RandomDataGenerator;
import utils.GuiCommands;

public class BusinessDetailsForm extends GuiCommands {

    RandomDataGenerator generator = new RandomDataGenerator();
    SetUp setUp = new SetUp(driver);
    BusinessSearch businessSearch = new BusinessSearch(driver);

    public BusinessDetailsForm(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy (name = "Next")
    private MobileElement nextButton;

    @FindBy(name = "You and your business")
    private MobileElement backNavigation;

    @FindBy(name = "Review and confirm your details. " +
            "Be aware that once you've confirmed them they can't be changed.")
    private MobileElement businessReviewTitle;

    @FindBy(name = "business_details.beneficial_owner")
    private MobileElement beneficialOwner;

    @FindBy(name = "business_details.name")
    private MobileElement businessName;

    @FindBy(name = "business_details.address")
    private MobileElement businessAddress;

    @FindBy(name = "business_details.trading_name")
    private MobileElement tradingName;

    @FindBy(name = "checkbox_default.affirmative")
    private MobileElement tradingAddressDifferentToBusiness;

    @FindBy(name = "checkbox_default.negative")
    private MobileElement tradingAddressSameAsBusiness;

    @FindBy(name = "business_details.trading_address")
    private MobileElement tradingAddressTextbox;

    @FindBy(name = "business_details.activity")
    private MobileElement businessActivity;

    @FindBy(name = "business_details.additional_details")
    private MobileElement additionalDetails;

    @FindBy(name = "Jurisdiction of Tax residency")
    private MobileElement jurisdictionOfTaxResidencyTextboxTitle;

    @FindBy(name = "business_details.tax_residency")
    private MobileElement jurisdictionOfTaxResidency;

    @FindBy(name = "country_search.search_field_title")
    private MobileElement countriesList;

    @FindBy(name = "business_details.utr")
    private MobileElement uniqueTaxReferenceNumber;

    @FindBy(name = "Address (number / postcode)")
    private MobileElement addressLookupTitle;

    @FindBy(name = "address_search.search_field_title")
    private MobileElement addressSearchTexbox;

    @FindBy(name = "search exit button")
    private MobileElement countrySearchExitButton;


    //Methods for elements displayed?
    public boolean businessReviewTitleDisplayed(){
        return businessReviewTitle.isDisplayed();
    }

    public boolean tradingAddressDifferentToResidentialDisplayed(){
        scrollDown(tradingAddressSameAsBusiness);
        return tradingAddressDifferentToBusiness.isDisplayed();
    }

    public boolean tradingAddressSameAsResidentialDisplayed(){
        return tradingAddressSameAsBusiness.isDisplayed();
    }

    public boolean isAddressLookupTitleDisplayed(){
        return addressLookupTitle.isDisplayed();
    }

    public boolean isAddressLookupSearchDisplayed(){
        return addressSearchTexbox.isDisplayed();
    }

    public boolean isJurisdictionOfTaxResidencyDisplayed(){
        return jurisdictionOfTaxResidencyTextboxTitle.isEnabled();
    }

    public boolean isUTRDisplayed(){
        return uniqueTaxReferenceNumber.isDisplayed();
    }

    public boolean isTradingNameDisplayed(){
        scrollDown(tradingName);
        return tradingName.isDisplayed();
    }

    public boolean isBusinessReviewTitleDisplayed(){
        return businessReviewTitle.isDisplayed();
    }

    //Methods for elements enabled
    public boolean isOwnersNameTextboxEnabled(){
        return beneficialOwner.isEnabled();
    }

    public boolean isBusinessNameTextboxEnabled(){
        return businessName.isEnabled();
    }

    public boolean isBusinessAddressTextboxEnabled(){
        return businessAddress.isEnabled();
    }

    public boolean isSicCodeEnabled(){
        return businessActivity.isEnabled();
    }

    public boolean isTradingAddressEnabled(){
        return tradingAddressTextbox.isEnabled();
    }

    public boolean isNextButtonEnabled(){
        return nextButton.isEnabled();
    }

    //Checkbox default selection
    public boolean noDefaultCheckboxSelection(){
        return CheckboxSelected(tradingAddressDifferentToBusiness) != 1 && CheckboxSelected(tradingAddressSameAsBusiness) != 1;
    }

    //WRITE METHODS
    public void writeTradingName(String name){
        writeText(tradingName, name);
    }

    public void writeAdditionalDetails(String details){
        writeText(additionalDetails, details);
    }

    public void writeCountry(String country){
        writeText(countriesList, country);
    }

    public void writeUTR(String utr){
        writeText(uniqueTaxReferenceNumber, utr);
    }

    //CLEAR METHODS
    public void clearCountry(){
        clearText(countriesList);
    }

    //CLICK METHODS
    public void clickTradingAddressDifferentToResidential(){
        click(tradingAddressDifferentToBusiness);
    }

    public void clickTradingAddressSameAsResidential(){
        click(tradingAddressSameAsBusiness);
    }

    public void clickJurisdictionOfTaxResidency(){
        click(jurisdictionOfTaxResidency);
    }

    public void clickNextButton(){
        click(nextButton);
    }

    public void clickCountrySearchExitButton(){
        click(countrySearchExitButton);
    }

    //CUSTOM METHODS
    public boolean verifyTextboxIsEmpty() {
        try {
            MobileElement element = (MobileElement) driver.findElement(By.name("business_details.trading_name"));
            String s = element.getText();
            if (s != null) {
                return false;
            } else {
                return true;
            }
        } catch (NullPointerException e) {
            return true;
        }
    }

    public boolean isKeyboardVisible(){
        return doesKeyboardExist();
    }



    public void populateAllFieldsAndClickNext(){
        click(tradingAddressSameAsBusiness);
        writeText(additionalDetails, "Additional Details");
        click(jurisdictionOfTaxResidency);
        writeText(countriesList, generator.setCountry());
        clickGenericIostableCell();
        writeText(uniqueTaxReferenceNumber, generator.setRandomValue(10, "NUMERIC"));
        click(nextButton);
    }

    public boolean navigateToBusinessDetails(){
        setUp.passThroughSetUp();
        businessSearch.passThroughBusinessSearch();
        return isBusinessReviewTitleDisplayed();
    }

    public boolean prePopulatedInformationNotEditible(){
        boolean owner = isOwnersNameTextboxEnabled();
        boolean name = isBusinessNameTextboxEnabled();
        boolean address = isBusinessAddressTextboxEnabled();
        scrollDown(businessActivity);
        boolean sic = isSicCodeEnabled();
        scrollUp(businessReviewTitle);
        return owner && name && address && sic;
    }

    public boolean tradingAddressSameAsRegisteredBusinessAddress(){
        scrollDown(tradingAddressSameAsBusiness);
        click(tradingAddressSameAsBusiness);
        return readText(businessAddress).equalsIgnoreCase(readText(tradingAddressTextbox));
    }

    public boolean tradingAddressDifferentFromRegisteredBusinessAddress(){
        scrollDown(tradingAddressDifferentToBusiness);
        click(tradingAddressDifferentToBusiness);
        writeText(addressSearchTexbox, "3B475BP");
        clickGenericIostableCell();
        return readText(businessAddress).equalsIgnoreCase("Wiremock Barn, Wiremark Lane\nStoke Prior\n" +
                "Bromsgrove\nB60 4BH\nUnited Kingdom");
    }

    public boolean jurisdictionOfTaxResidencyNoCountryFound(){
        scrollDown(jurisdictionOfTaxResidency);
        click(jurisdictionOfTaxResidency);
        boolean keyboard = isKeyboardVisible();
        writeCountry("Not a country");
        return IosTableCellCount() == 0 && keyboard;
    }

    public boolean jurisdictionOfTaxResidencyDynamicList(){
        scrollDown(jurisdictionOfTaxResidency);
        click(jurisdictionOfTaxResidency);
        writeCountry("United");
        String countOne = String.valueOf(IosTableCellCount());
        writeCountry(" Kingdom");
        new WebDriverWait(driver, 2).until(ExpectedConditions.invisibilityOfElementLocated(By.name("United States")));
        String countTwo = String.valueOf(IosTableCellCount());
        return !countOne.equals(countTwo);
    }

    public boolean jurisdictionOfTaxResidencySelectCountry(){
        clearCountry();
        String country = generator.setCountry();
        writeCountry(country);
        clickGenericIostableCell();
        return readText(jurisdictionOfTaxResidency).equals(country);
    }

    public boolean uniqueTaxReferenceNumber(){
        scrollDown(uniqueTaxReferenceNumber);
        String random = generator.setRandomValue(9, "NUMERIC");
        writeText(uniqueTaxReferenceNumber, random);
        boolean nextButtonDisabled = !isNextButtonEnabled();
        writeText(uniqueTaxReferenceNumber, "01");
        boolean utrNumberLength = readText(uniqueTaxReferenceNumber).equals(random + "0");
        boolean nextButtonEnabled  = isNextButtonEnabled();
        return nextButtonDisabled && utrNumberLength && nextButtonEnabled;
    }

    public boolean additionalDetails(){
        scrollUp(additionalDetails);
        clearText(additionalDetails);
        boolean nextButton = isNextButtonEnabled();
        writeText(additionalDetails, "Additional Details");
        boolean adttionalDetailsText = readText(additionalDetails).equals("Additional Details");
        boolean button = isNextButtonEnabled();
        return nextButton && adttionalDetailsText && button;
    }
}
