package pageObjects.Onboarding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testData.CheckBoxElements;
import testData.RandomDataGenerator;
import utils.GuiCommands;

import java.util.concurrent.TimeUnit;

public class OngoingSourceOfWealth  extends GuiCommands {

    SetUp setUp = new SetUp(driver);
    BusinessSearch businessSearch = new BusinessSearch(driver);
    BusinessDetailsForm businessDetailsForm = new BusinessDetailsForm(driver);
    PersonalDetailsForm personalDetailsForm = new PersonalDetailsForm(driver);
    RandomDataGenerator generator = new RandomDataGenerator();
    CheckBoxElements checkBoxElements = new CheckBoxElements(driver);

    public OngoingSourceOfWealth(IOSDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSFindBy(accessibility = "Ongoing Source of Wealth")
    private MobileElement ongoingTitle ;

    @iOSFindBy(xpath = "//XCUIElementTypeTextField[@name=\"ongoing_source_of_wealth.turnover.heading\"]") //FIXME get unique accessibility id
    private MobileElement annualTurnoverTextField;

    @iOSFindBy(accessibility = "ongoing_source_of_wealth.fundingSource.heading")
    private MobileElement fundingTextField;

    @iOSFindBy(accessibility = "search exit button")
    private MobileElement fundingSearchExitButton;

    @iOSFindBy(accessibility = "ongoing_source_of_wealth_selection.confirm")
    private MobileElement searchConfirmButton;

    @iOSFindBy(accessibility = "country_search.search_field_title")
    private MobileElement countrySearchTextField;

    @iOSFindBy(accessibility = "ongoing_source_of_wealth.fundingCountry.heading")
    private MobileElement fundingCountryTextField;

    @iOSFindBy(accessibility = "search exit button")
    private MobileElement countrySearchExitButton;

    @iOSFindBy(accessibility = "next_button_default_title")
    private MobileElement nextButton;

    @iOSFindBy(accessibility = "GBP")
    private MobileElement gbpTitle;

    @iOSFindBy(accessibility = "ongoing_source_of_wealth.optional_other")
    private MobileElement otherTextField;

    @iOSFindBy(accessibility = "You and your business")
    private MobileElement wealthBackButton;

    @iOSFindBy(accessibility = "Business Details")
    private MobileElement businessDetailsBackButton;

    @iOSFindBy(accessibility = "You and your business")
    private MobileElement ownershipBackButton;

    @iOSFindBy(accessibility = "business_search.search_field_title.initial")
    private MobileElement businessSearchField;

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"You and your business\"]")
    private MobileElement businessSearchBackButton;

    //check box elements
    @iOSFindBy(accessibility = "Gift")
    private MobileElement gift;

    @iOSFindBy(accessibility = "Other")
    private MobileElement other;



    //Elements Displayed

    public boolean isOngoingPageDisplayed() { return ongoingTitle.isDisplayed(); }

    // Elements Enabled

    public boolean isNextButtonEnabled(){return nextButton.isEnabled(); }

    // Click Methods

    public void clickBuisinessFunding() { click(fundingTextField);}

    public void clickFundingOption(String funding){
       MobileElement element = (MobileElement) driver.findElement(By.name(funding));
       click(element);
    }

    public void clickSearchConfirmButton(){click((searchConfirmButton));}

    public void clickFundingSearchExitButton (){ click(fundingSearchExitButton);}

    public void clickCountry(){ click(fundingCountryTextField); }

    public void clickCountrySearchExitButton(){ click(countrySearchExitButton); }

    public void clickNextButton() { click(nextButton); }

    // Write Methods
    public void writeAnnualTurnover (int amount){writeNumber(annualTurnoverTextField,amount);}

    // Clear Methods
    public void clearAnnualTurnover (){clearText(annualTurnoverTextField);}


    public void navigateToOngoingSourceOfWealth (){
        setUp.passThroughSetUp();
        businessSearch.passThroughBusinessSearch();
        businessDetailsForm.passThroughBusinessDetailsForm();
        personalDetailsForm.passThroughPersonalDetailsForm();

    }

    public boolean wealthFieldsDisplayed(){
        navigateToOngoingSourceOfWealth();
        boolean one = annualTurnoverTextField.isDisplayed();
        boolean two =  fundingTextField.isDisplayed();
        boolean three = fundingCountryTextField.isDisplayed();

        return  one && two && three;
    }

    public boolean checkAllFieldsAreFilled(){

        navigateToOngoingSourceOfWealth();
        writeAnnualTurnover(50000);
        boolean two = !isNextButtonEnabled();
        clickBuisinessFunding();
        checkBoxElements.clickRandomElement();
        clickSearchConfirmButton();
        boolean three =!isNextButtonEnabled();

        return   two && three;
    }

    public boolean incorrectAmounts(){
        navigateToOngoingSourceOfWealth();
        clickBuisinessFunding();
        checkBoxElements.clickRandomElement();
        clickSearchConfirmButton();
        clickCountry();
        writeText(countrySearchTextField, generator.setCountry());
        clickGenericIostableCell();

        int[] incorrectValues = {0,110000000};
        int[] correctValues = {1,25000,100000000};

        boolean one = true;
        boolean two = true;
        boolean three = true;

        for (int i :incorrectValues){

            writeNumber(annualTurnoverTextField,i);
            if(!isNextButtonEnabled()){;
            clearAnnualTurnover();
             }
            else{
                clearAnnualTurnover();
                 one= false;}
        }
        for (int i :correctValues){

            writeNumber(annualTurnoverTextField,i);
            if(isNextButtonEnabled()){;
                clearAnnualTurnover();
                 }
            else{
                clearAnnualTurnover();
                 two = false;}
        }
        writeDecimal(annualTurnoverTextField,10.21);

        if(isNextButtonEnabled()){;
            clearAnnualTurnover();
        }
        else{
            clearAnnualTurnover();
             three = false;}
        return  one && two && three;
    }
    public boolean isGbpDisplayed (){
        return gbpTitle.isDisplayed();
    }
    public boolean isCountryListShown (){
        navigateToOngoingSourceOfWealth();
        clickCountry();
        return countrySearchTextField.isDisplayed();
    }

    public boolean doFieldsClearWithNewSearch(){

        navigateToOngoingSourceOfWealth();
        writeAnnualTurnover(20);
        clickBuisinessFunding();
        checkBoxElements.clickRandomElement();
        clickSearchConfirmButton();
        clickCountry();
        writeText(countrySearchTextField, generator.setCountry());
        clickGenericIostableCell();
        click(wealthBackButton);
        click(businessDetailsBackButton);
        click(ownershipBackButton);
        click(businessSearchBackButton);

        writeText(businessSearchField,"GLA");
        clickGenericIostableCell();
        businessDetailsForm.passThroughBusinessDetailsForm();
        personalDetailsForm.passThroughPersonalDetailsForm();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String field1 = annualTurnoverTextField.getText();

        if (Integer.parseInt(field1) ==  0){
            return true;
        }
        else{
            return false;
        }

    }

    public boolean checkOtherFieldValidity (){

        navigateToOngoingSourceOfWealth();
        writeAnnualTurnover(20);
        clickBuisinessFunding();
        click(other);
        clickSearchConfirmButton();
        clickCountry();
        writeText(countrySearchTextField, generator.setCountry());
        clickGenericIostableCell();
        if (nextButton.isEnabled()) return false;
        writeText(otherTextField,generator.setRandomValue(1,"ALPHANUMERIC"));
        if (nextButton.isEnabled()) return false;
        clearText(otherTextField);
        writeText(otherTextField,generator.setRandomValue(256,"ALPHANUMERIC"));
        if (nextButton.isEnabled()) return false;
        clearText(otherTextField);
        writeText(otherTextField,generator.setRandomValue(2,"ALPHANUMERIC"));
        boolean one = isNextButtonEnabled();
        clearText(otherTextField);
        writeText(otherTextField,generator.setRandomValue(255,"ALPHANUMERIC"));
        boolean two = isNextButtonEnabled();


        return one&&two;

    }


    public boolean canAllFundingOptionsBeChosen(){

        navigateToOngoingSourceOfWealth();
        writeAnnualTurnover(20);
        clickBuisinessFunding();
        checkBoxElements.clickAllCheckboxElements();
        click(other);
        clickSearchConfirmButton();
        writeText(otherTextField,"Other Element");
        clickCountry();
        writeText(countrySearchTextField, generator.setCountry());
        clickGenericIostableCell();
        clickNextButton();

        return !isOngoingPageDisplayed();
    }

    public boolean passThroughOngoingSourceOfWealth(){
        navigateToOngoingSourceOfWealth();
        writeAnnualTurnover(20);
        clickBuisinessFunding();
        checkBoxElements.clickRandomElement();
        clickSearchConfirmButton();
        clickCountry();
        writeText(countrySearchTextField, generator.setCountry());
        clickGenericIostableCell();
        writeText(otherTextField,"Other Element");
        clickCountry();
        writeText(countrySearchTextField, generator.setCountry());
        clickGenericIostableCell();
        clickNextButton();
        return !isOngoingPageDisplayed();
    }

    public void populateSourceOfWealth(String turnover, String funding, String country){
        writeText(annualTurnoverTextField, turnover);
        clickBuisinessFunding();
        clickFundingOption(funding);
        clickSearchConfirmButton();
        clickCountry();
        writeText(countrySearchTextField, country);
        clickGenericIostableCell();
        clickNextButton();
    }

}
