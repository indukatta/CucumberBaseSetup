package pageObjects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;
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
    public MobileElement gift;

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

    //Custom Methods
    public boolean navigateToOngoingSourceOfWealth (){
        personalDetailsForm.passThroughPersonalDetailsForm();
        return isOngoingPageDisplayed();
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
