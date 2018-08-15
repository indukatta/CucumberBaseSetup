package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GuiCommands;

public class BusinessDetailsForm extends GuiCommands {

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
    private MobileElement tradingAddressDifferentToResidential;

    @FindBy(name = "checkbox_default.negative")
    private MobileElement tradingAddressSameAsResidential;

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


    //Methods for elements displayed?
    public boolean businessReviewTitleDisplayed(){
        return businessReviewTitle.isDisplayed();
    }

    public boolean tradingAddressDifferentToResidentialDisplayed(){
        return tradingAddressDifferentToResidential.isDisplayed();
    }

    public boolean tradingAddressSameAsResidentialDisplayed(){
        return tradingAddressSameAsResidential.isDisplayed();
    }

    public boolean isAddressLookupTitleDisplayed(){
        return addressLookupTitle.isDisplayed();
    }

    public boolean isAddressLookupSearchDisplayed(){
        return addressSearchTexbox.isDisplayed();
    }

    public boolean isJurisdictionOfTaxResidencyDisplayed(){
        return jurisdictionOfTaxResidencyTextboxTitle.isDisplayed();
    }

    public boolean isUTRDisplayed(){
        return uniqueTaxReferenceNumber.isDisplayed();
    }

    public boolean isTradingNameDisplayed(){
        return tradingName.isDisplayed();
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

    public boolean isTradingAddressEnabled(){
        return tradingAddressTextbox.isEnabled();
    }

    public boolean isNextButtonEnabled(){
        return nextButton.isEnabled();
    }

    //getters
    public String getOwnersName(){
        return readText(beneficialOwner);
    }

    public String getBusinessName(){
        return readText(businessName);
    }

    public String getBusinessAddress(){
        return readText(businessAddress);
    }

    public String getTradingAddress(){
        return readText(tradingAddressTextbox);
    }

    public String getUTR() {
        return readText(uniqueTaxReferenceNumber);
    }

    public String getTradingName(){
        return readText(tradingName);
    }

    public String getJurisdictionOfTaxResidency(){
        return readText(jurisdictionOfTaxResidency);
    }

    //Checkbox default selection
    public boolean isTradingAddressDifferentToResidentialSelected(){
        if (CheckboxSelected(tradingAddressDifferentToResidential) == 1){
            return true;
        } else {
            return false;
        }
    }

    public boolean isTradingAddressSameAsResidentialSelected(){
        if (CheckboxSelected(tradingAddressSameAsResidential) == 1){
            return true;
        } else {
            return false;
        }
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
        click(tradingAddressDifferentToResidential);
    }

    public void clickTradingAddressSameAsResidential(){
        click(tradingAddressSameAsResidential);
    }

    public void clickJurisdictionOfTaxResidency(){
        click(jurisdictionOfTaxResidency);
    }

    public void clickUTR(){
        click(uniqueTaxReferenceNumber);
    }

    public void clickTradingName(){
        click(tradingName);
    }

    public void clickBackNavigation(){
        click(backNavigation);
    }

    public void clickNextButton(){
        click(nextButton);
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

    public void scrollDownToBottom(){
        scrollDown(uniqueTaxReferenceNumber);
    }

    public void scrollUpToTop(){
        scrollUp(businessReviewTitle);
    }

    public void clickTableCell(String locator){
        clickIosTableCell(locator);
    }
}
