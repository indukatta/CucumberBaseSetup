package pageObjects.Onboarding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import testData.CheckBoxElements;
import testData.RandomDataGenerator;
import utils.GuiCommands;

public class InitialWealth extends GuiCommands {

    SetUp setUp = new SetUp(driver);
    BusinessSearch businessSearch = new BusinessSearch(driver);
    BusinessDetailsForm businessDetailsForm = new BusinessDetailsForm(driver);
    PersonalDetailsForm personalDetailsForm = new PersonalDetailsForm(driver);
    OngoingSourceOfWealth ongoingSourceOfWealth = new OngoingSourceOfWealth(driver);
    RandomDataGenerator generator = new RandomDataGenerator();
    CheckBoxElements checkBoxElements = new CheckBoxElements(driver);

    public InitialWealth(IOSDriver driver) {
        super(driver);
    }

    @iOSFindBy (accessibility = "Initial Source of Wealth")
    private MobileElement initialWealthTitle;

    @iOSFindBy(accessibility = "initial_source_of_wealth.amount.heading")
    private MobileElement initialAmountTextField;

    @iOSFindBy(accessibility = "initial_source_of_wealth.number_of_investors.heading")
    private MobileElement numOfInvestorsTextField;

    @iOSFindBy(accessibility = "initial_source_of_wealth.add_investor")
    private MobileElement investorDetailsButton;

    @iOSFindBy(accessibility = "next_button_default_title")
    private MobileElement nextButton;

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Business financials\"]")
    private MobileElement initialWealthBB;

    @iOSFindBy(accessibility = "Investor Details")
    private MobileElement investorsDetailsTitle;

    @iOSFindBy(accessibility = "investor_details.name.heading")
    private MobileElement investorNameField;

    @iOSFindBy(accessibility = "investor_details.amount.heading")
    private MobileElement investorAmount;

    @iOSFindBy(accessibility = "investor_details.country.heading")
    private MobileElement investorCountry;

    @iOSFindBy(accessibility = "investor_details.funding_source.heading")
    private MobileElement howFundsGenerated;

    @iOSFindBy(accessibility = "search exit button")
    private MobileElement exitButton;

    @iOSFindBy(accessibility = "ongoing_source_of_wealth_selection.confirm")
    private MobileElement confirmButton;

    @iOSFindBy(accessibility = "Gift")
    private  MobileElement gift;

    @iOSFindBy(accessibility = "country_search.search_field_title")
    private MobileElement countrySearchfield;

    @iOSFindBy(accessibility = "toolbar_done")
    private MobileElement pickerWheelDone;


    //Elements Displayed

    public boolean isInitialWealthPageDisplayed() { return initialWealthTitle.isDisplayed(); }

    public boolean isInvestorsDetailsPageDisplayed() { return investorsDetailsTitle.isDisplayed(); }


    // Elements Enabled

    public boolean isNextButtonEnabled(){return nextButton.isEnabled(); }

    // Click Methods

    public void clickNext(){ click(nextButton);}

    public void clickConfirm() {click(confirmButton);}

    public void clickExit(){click(exitButton);}

    //Custom Methods

    public void navigateToInitialWealth(){
        setUp.passThroughSetUp();
        businessSearch.passThroughBusinessUnderThreeYearsSearch();
        businessDetailsForm.passThroughBusinessDetailsForm();
        personalDetailsForm.passThroughPersonalDetailsForm();
        ongoingSourceOfWealth.passThroughOngoingSourceOfWealth();

    }

    public void passThroughInitalWealth(){
        writeNumber(initialAmountTextField,10800);
        click(investorDetailsButton);
        writeText(investorNameField,"Michael Jackson");
        writeNumber(investorAmount,1080);
        click(investorCountry);
        writeText(countrySearchfield, generator.setCountry());
        clickGenericIostableCell();
        click(howFundsGenerated);
        checkBoxElements.clickRandomElement();
        clickConfirm();
        clickNext();
        clickNext();
    }
    public void populateInitialWealth(String name, String initialAmount, String investAmount){
        writeText(initialAmountTextField,initialAmount);
        click(investorDetailsButton);
        writeText(investorNameField,name);
        writeText(investorAmount,investAmount);
        click(investorCountry);
        writeText(countrySearchfield, generator.setCountry());
        clickGenericIostableCell();
        click(howFundsGenerated);
        checkBoxElements.clickRandomElement();
        clickConfirm();
        clickNext();
        clickNext();
    }





}
