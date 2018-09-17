package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
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

    public BusinessDetailsForm(IOSDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy (name = "next_button_default_title")
    private MobileElement nextButton;

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"You and your business\"]")//FIXME get accessibility id
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

    @FindBy(name = "radio_buttons_view_default.affirmative")
    private MobileElement tradingAddressDifferentToBusiness;

    @FindBy(name = "radio_buttons_view_default.negative")
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
        navigateToBusinessDetails();
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

    public void navigateToBusinessDetails(){
        setUp.passThroughSetUp();
        businessSearch.passThroughBusinessSearch();
    }

    public boolean prePopulatedInformationNotEditible(){
        navigateToBusinessDetails();
        boolean owner = !isOwnersNameTextboxEnabled();
        boolean name = !isBusinessNameTextboxEnabled();
        return owner && name;
    }

    public boolean tradingAddressSameAsRegisteredBusinessAddress(){
        navigateToBusinessDetails();
        scrollDown(tradingAddressSameAsBusiness);
        click(tradingAddressSameAsBusiness);
        return readText(businessAddress).equalsIgnoreCase(readText(tradingAddressTextbox));
    }

    public boolean tradingAddressDifferentFromRegisteredBusinessAddress(){
        navigateToBusinessDetails();
        scrollDown(tradingAddressDifferentToBusiness);
        click(tradingAddressDifferentToBusiness);
        writeText(addressSearchTexbox, "BT42FS");
        clickGenericIostableCell();
        return readText(tradingAddressTextbox).equalsIgnoreCase("1 Carolhill Gardens\nBelfast\n" +
                "BT4 2FS\nUnited Kingdom");
    }

    public boolean addressNotFound(){
        navigateToBusinessDetails();
        scrollDown(tradingAddressDifferentToBusiness);
        click(tradingAddressDifferentToBusiness);
        writeText(addressSearchTexbox, "BT9012F");
        return false; //FIXME Needs error message
    }

    public boolean jurisdictionOfTaxResidencyDisplayed(){
        navigateToBusinessDetails();
        scrollDown(jurisdictionOfTaxResidency);
        return jurisdictionOfTaxResidency.isDisplayed();
    }

    public boolean jurisdictionOfTaxResidencykeyboardVisible(){
        navigateToBusinessDetails();
        scrollDown(jurisdictionOfTaxResidency);
        click(jurisdictionOfTaxResidency);
        return isKeyboardVisible();
    }

    public boolean jurisdictionOfTaxResidencyNoCountryFound(){
        navigateToBusinessDetails();
        scrollDown(jurisdictionOfTaxResidency);
        click(jurisdictionOfTaxResidency);
        writeCountry("Not a country");
        return IosTableCellCount() == 0;
    }

    public boolean jurisdictionOfTaxResidencyDynamicList(){
        navigateToBusinessDetails();
        scrollDown(jurisdictionOfTaxResidency);
        click(jurisdictionOfTaxResidency);
        writeCountry("United");
        String countOne = String.valueOf(IosTableCellCount());
        writeCountry(" Kingdom");
        new WebDriverWait(driver, 2).until(ExpectedConditions.invisibilityOfElementLocated(By.name("United States")));
        String countTwo = String.valueOf(IosTableCellCount());
        click(countrySearchExitButton);
        return !countOne.equals(countTwo);
    }

    public boolean jurisdictionOfTaxResidencySelectCountry(){
        scrollDown(jurisdictionOfTaxResidency);
        click(jurisdictionOfTaxResidency);
        clearCountry();
        String country = generator.setCountry();
        writeCountry(country);
        clickGenericIostableCell();
        return readText(jurisdictionOfTaxResidency).equals(country);
    }

    public boolean uniqueTaxReferenceNumberDisplayed(){
        navigateToBusinessDetails();
        scrollDown(uniqueTaxReferenceNumber);
        return uniqueTaxReferenceNumber.isDisplayed();
    }

    public boolean uniqueTaxReferenceNumberKeyboard(){
        navigateToBusinessDetails();
        scrollDown(uniqueTaxReferenceNumber);
        click(uniqueTaxReferenceNumber);
        return isKeyboardVisible();
    }

    public boolean uniqueTaxReferenceNumberValidation(){
        navigateToBusinessDetails();
        click(tradingAddressSameAsBusiness);
        scrollDown(additionalDetails);
        writeText(additionalDetails, "Additional Details");
        scrollDown(jurisdictionOfTaxResidency);
        jurisdictionOfTaxResidencySelectCountry();
        scrollDown(uniqueTaxReferenceNumber);
        boolean nextButtonDisabled = !isNextButtonEnabled();
        String random = generator.setRandomValue(9, "NUMERIC");
        writeText(uniqueTaxReferenceNumber, random);
        writeText(uniqueTaxReferenceNumber, "01");
        boolean utrNumberLength = readText(uniqueTaxReferenceNumber).equals(random + "0");
        boolean nextButtonEnabled  = isNextButtonEnabled();
        return nextButtonDisabled && utrNumberLength && nextButtonEnabled;
    }

    public void populateFieldsExceptAdditionalDetails(){
        navigateToBusinessDetails();
        scrollDown(tradingAddressSameAsBusiness);
        click(tradingAddressSameAsBusiness);
        scrollDown(jurisdictionOfTaxResidency);
        jurisdictionOfTaxResidencySelectCountry();
        scrollDown(uniqueTaxReferenceNumber);
        writeText(uniqueTaxReferenceNumber, generator.setRandomValue(10, "NUMERIC"));
        scrollUp(additionalDetails);
    }

    public boolean additionalDetailsDisplayed(){
        navigateToBusinessDetails();
        scrollDown(additionalDetails);
        return additionalDetails.isDisplayed();
    }

    public boolean additionalDetailsKeyboard(){
        navigateToBusinessDetails();
        scrollDown(additionalDetails);
        click(additionalDetails);
        return isKeyboardVisible();
    }

    public boolean additionalDetailsNoCharacters(){
        populateFieldsExceptAdditionalDetails();
        scrollDown(additionalDetails);
        clearText(additionalDetails);
        return !isNextButtonEnabled();
    }

    public boolean additionalDetailsLessThanTwoCharacters(){
        writeText(additionalDetails, "A");
        boolean addtionalDetailsText = readText(additionalDetails).equals("A");
        boolean button = !isNextButtonEnabled();
        clearText(additionalDetails);
        return addtionalDetailsText && button;
    }

    public boolean additionalDetailsMoreThan255Characters(){
        writeText(additionalDetails, generator.setRandomValue(254, "ALPHANUMERIC"));
        String one = readText(additionalDetails);
        writeText(additionalDetails, "01");
        boolean addtionalDetailsText = readText(additionalDetails).equals(one + "0");
        boolean button = isNextButtonEnabled();
        clearText(additionalDetails);
        return addtionalDetailsText && button;
    }

    public boolean additionalDetailsValidEntry(){
        writeText(additionalDetails, "01");
        boolean buttonOne = isNextButtonEnabled();
        clearText(additionalDetails);
        writeText(additionalDetails, generator.setRandomValue(255, "ALPHANUMERIC"));
        boolean buttonTwo = isNextButtonEnabled();
        return buttonOne && buttonTwo;
    }

    public void passThroughBusinessDetailsForm(){
        click(tradingAddressSameAsBusiness);
        scrollDown(additionalDetails);
        writeText(additionalDetails, "Additional Details");
        jurisdictionOfTaxResidencySelectCountry();
        scrollDown(uniqueTaxReferenceNumber);
        writeText(uniqueTaxReferenceNumber, generator.setRandomValue(10, "NUMERIC"));
        click(nextButton);
    }

    public void populateBusinessDetailsForm(String name, String country, String utr){
        writeText(tradingName, name);
        click(tradingAddressSameAsBusiness);
        scrollDown(additionalDetails);
        writeText(additionalDetails, "Additional Details");
        scrollDown(jurisdictionOfTaxResidency);
        click(jurisdictionOfTaxResidency);
        writeCountry(country);
        clickGenericIostableCell();
        scrollDown(uniqueTaxReferenceNumber);
        writeText(uniqueTaxReferenceNumber, utr);
        click(nextButton);
    }

    public void scrollToTopOfPage(){
        scrollUp(businessReviewTitle);
    }

    public void clickBackNavigation(){
        click(backNavigation);
    }
}
