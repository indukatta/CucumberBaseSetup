package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testData.RandomDataGenerator;
import utils.GuiCommands;

public class OngoingSourceOfWealth  extends GuiCommands {

    SetUp setUp = new SetUp(driver);
    BusinessSearch businessSearch = new BusinessSearch(driver);
    BusinessDetailsForm businessDetailsForm = new BusinessDetailsForm(driver);
    PersonalDetailsForm personalDetailsForm = new PersonalDetailsForm(driver);
    RandomDataGenerator generator = new RandomDataGenerator();



    public OngoingSourceOfWealth(IOSDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(name = "Ongoing Source of Wealth")
    private MobileElement ongoingTitle ;

    @FindBy(xpath = "//XCUIElementTypeTextField[@name=\"ongoing_source_of_wealth.turnover.heading\"]") //FIXME get unique accessibility id
    private MobileElement annualTurnoverTextField;

    @FindBy(name = "ongoing_source_of_wealth.fundingSource.heading")
    private MobileElement fundingTextField;

    @FindBy(name = "search exit button")
    private MobileElement fundingSearchExitButton;

    @FindBy(name = "ongoing_source_of_wealth_selection.confirm")
    private MobileElement searchConfirmButton;

    @FindBy(name = "country_search.search_field_title")
    private MobileElement countrySearchTextField;

    @FindBy(name = "ongoing_source_of_wealth.fundingCountry.heading")
    private MobileElement fundingCountryTextField;

    @FindBy(name = "search exit button")
    private MobileElement countrySearchExitButton;

    @FindBy(name = "next_button_default_title")
    private MobileElement nextButton;

    @FindBy(name = "Gift")
    private MobileElement gift;

    @FindBy(name = "GBP")
    private MobileElement gbpTitle;

    @FindBy(name = "ongoing_source_of_wealth.optional_other")
    private MobileElement otherTextField;

    @FindBy(name = "You and your business")
    private MobileElement wealthBackButton;

    @FindBy(name = "Business Details")
    private MobileElement businessDetailsBackButton;

    @FindBy(name = "You and your business")
    private MobileElement ownershipBackButton;

    @FindBy(name = "business_search.search_field_title.initial")
    private MobileElement businessSearchField;

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"You and your business\"]")
    private MobileElement businessSearchBackButton;


    //Elements Displayed

    public boolean isOngoingPageDisplayed() { return ongoingTitle.isDisplayed(); }

    // Elements Enabled

    public boolean isNextButtonEnabled(){return nextButton.isEnabled(); }

    // Click Methods

    public void clickBuisinessFunding() { click(fundingTextField);}

    public void clickSearchConfirmButton(){click((searchConfirmButton));}

    public void clickFundingSearchExitButton (){ click(fundingSearchExitButton);}

    public void clickCountry(){ click(fundingCountryTextField); }

    public void clickCountrySearchExitButton(){ click(countrySearchExitButton); }

    public void clickNextButton() { click(nextButton); }

    // Write Methods

    public void writeAnnualTurnover (int amount){writeNumber(annualTurnoverTextField,amount);}

    // Clear Methods

    public void clearAnnualTurnover (){clearText(annualTurnoverTextField);}

    //Custom Methods gthtgt

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
        click(gift);
        clickSearchConfirmButton();
        boolean three =!isNextButtonEnabled();
        return   two && three;
    }

    public boolean incorrectAmounts(){
        navigateToOngoingSourceOfWealth();
        clickBuisinessFunding();
        click(gift);
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
        navigateToOngoingSourceOfWealth();
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
        click(gift);
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

        String field1 = annualTurnoverTextField.getText();
        String field2 = annualTurnoverTextField.getText();
        String field3 = annualTurnoverTextField.getText();

        if (field1.isEmpty() && field2.isEmpty() && field3.isEmpty()){ return true; }
        else {return false;}

    }

    public boolean passThroughOngoingSourceOfWealth(){
        navigateToOngoingSourceOfWealth();
        writeAnnualTurnover(20);
        clickBuisinessFunding();
        click(gift);
        clickSearchConfirmButton();
        clickCountry();
        writeText(countrySearchTextField, generator.setCountry());
        clickGenericIostableCell();
        clickNextButton();

        return !isOngoingPageDisplayed();
    }







}
