package pageObjects.Onboarding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testData.RandomDataGenerator;
import utils.GuiCommands;

public class SourceOfFunds extends GuiCommands {

    SetUp setUp = new SetUp(driver);
    BusinessSearch businessSearch = new BusinessSearch(driver);
    BusinessDetailsForm businessDetailsForm = new BusinessDetailsForm(driver);
    PersonalDetailsForm personalDetailsForm = new PersonalDetailsForm(driver);
    OngoingSourceOfWealth ongoingSourceOfWealth = new OngoingSourceOfWealth(driver);
    RandomDataGenerator generator = new RandomDataGenerator();

    public SourceOfFunds(IOSDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSFindBy(accessibility = "Source of Funds")
    private MobileElement sourceOfFundstitle;

    @iOSFindBy (xpath = "//XCUIElementTypeTextField[@name=\"depositors.last_twelve_months_amount\"]")  //FIXME get unique accessibility id
    private MobileElement valueOfCashDepositorField;

    @iOSFindBy (xpath = "//XCUIElementTypeTextField[@name=\"depositors.depositors_total_amount.header\"]")  //FIXME get unique accessibility id
    private MobileElement totalDepositMoneyField;

    @iOSFindBy (accessibility = "depositors.depositors_count_textfield.header")
    private MobileElement numberOfDepositors;

    @iOSFindBy (accessibility = "depositors.add_depositor_details.buttonTitle")
    private MobileElement depositorDetailButton;

    @iOSFindBy (accessibility = "Ff Gg")
    private MobileElement depositorDetail;

    @iOSFindBy (accessibility = "next_button_default_title")
    private  MobileElement nextButton;

    // Depositor Screen
    @iOSFindBy (accessibility = "Depositors")
    private MobileElement depositorsTitle;

    @iOSFindBy (accessibility = "depositor.name_of_depositor.header")
    private MobileElement nameOfDepositor;

    @iOSFindBy (accessibility = "depositor.transferral_method.header")
    private MobileElement depositorTransferralMethod;

    @iOSFindBy(accessibility = "toolbar_done")
    private MobileElement doneButton;

    @iOSFindBy (accessibility = "depositor.transferral_origin.header")
    private MobileElement fundTransfer;

    @iOSFindBy (accessibility = "depositor.bank_origin_country.header")
    private MobileElement countryField;

    @iOSFindBy(accessibility = "country_search.search_field_title")
    private MobileElement countrySearchField;

    @iOSFindBy (accessibility = "search exit button")
    private MobileElement countryExitButton;

    @iOSFindBy (xpath = "//XCUIElementTypeTextField[@name=\"depositor.transferral_amount.header\"]")  //FIXME get unique accessibility id
    private MobileElement howMuchTransferred;

    @iOSFindBy (accessibility = "depositor.funds_generated.header")
    private  MobileElement howFundsGenerated;

    @iOSFindBy(accessibility = "ongoing_source_of_wealth_selection.confirm")
    private MobileElement confirmButton;

    @iOSFindBy(accessibility = "Gift")
    public MobileElement gift;

    @iOSFindBy ( accessibility = "search exit button")
    private MobileElement howFundsGeneratedExitButton;

    @iOSFindBy ( accessibility = "next_button_default_title")
    private MobileElement depositorNextButon;
    
    // Element Displayed
    public boolean isSourceOfFundsPageDisplayed() { return sourceOfFundstitle.isDisplayed(); }

    public boolean isDepositorsPageDisplayed() { return depositorsTitle.isDisplayed(); }

    // Element Enabled
    public boolean isNextButtonEnabled() { return nextButton.isEnabled(); }

    // Clicking Source of funds
    public void clickValueOfCashDepositor() { click(valueOfCashDepositorField); }

    public void clickTotalDepositMoney() { click(totalDepositMoneyField); }

    public void clickNumberOfDepositors() { click(numberOfDepositors); }

    public void clickDepositorDetailButton() { click(depositorDetailButton); }

    public void clickNextButton() { click(nextButton); }

    public void clickHowManyDepositprDoneButton() { click(doneButton); }

    // Clicking Depositor
    public void clickInsertName() { click(nameOfDepositor); }

    public void clickDepositorTransferralMethod() { click(depositorTransferralMethod); }

    public void clickHowFundTransferredDoneButton() { click(doneButton); }

    public void clickWhereFundTransferFrom() { click(fundTransfer); }

    public void clickWhereFundsTransferredFromDoneButton() { click(doneButton); }

    public void clickCountry() { click(countryField); }

    public void clickCountryExitButton() { click(countryExitButton); }

    public void clickHowMuchTransferred() { click(howMuchTransferred); }

    public void clickHowFundsGenerated() { click(howFundsGenerated); }

    public void clickHowFundsGeneratedExitButton() { click(howFundsGeneratedExitButton); }

    public void clickDepositorNextButton() { click(depositorNextButon); }

    //Write Methods
    public void writeValueOfCashDeposit(int amount) { writeNumber(valueOfCashDepositorField, amount);}

    public void wrireTotalDepositMoney(int amount) { writeNumber(totalDepositMoneyField, amount);}

    public void writeDepositorsName(String name) { writeText(nameOfDepositor, name);}

    public void writeHowMuchIsGoingToBeTransferred(int amount) { writeNumber(howMuchTransferred, amount);}

    // Clear Methods
    public void clearValueOfCashDeposit() { clearText(valueOfCashDepositorField);}

    public void clearTotalDepositMoney() { clearText(totalDepositMoneyField);}

    public void clearDepositorsName() { clearText(nameOfDepositor);}

    public void clearHowMuchIsGoingToBeTransferred() { clearText(howMuchTransferred);}

    // Custom Methods
    public void clickFundingOption(String funding){
        MobileElement element = (MobileElement) driver.findElement(By.name(funding));
        click(element);
    }

    public boolean navigateToSourceOfFunds() {
        ongoingSourceOfWealth.passThroughOngoingSourceOfWealth();
        return isSourceOfFundsPageDisplayed();
    }

    public void passThrougSourceOfFunds() {
        navigateToSourceOfFunds();
        writeValueOfCashDeposit(500);
        wrireTotalDepositMoney(200);
        clickDepositorDetailButton();
        writeDepositorsName("Alex Warner");
        clickDepositorTransferralMethod();
        clickHowFundTransferredDoneButton();
        clickCountry();
        writeText(countrySearchField, generator.setCountry());
        clickGenericIostableCell();
        writeHowMuchIsGoingToBeTransferred(100);
        clickHowFundsGenerated();
        click(gift);
        click(confirmButton);
        clickDepositorNextButton();
        clickNextButton();
    }

    public void populateSourceOfFunds(String cash, String depositTotal, String depositor, String transferTotal , String howFundsGenerated) {
        writeText(valueOfCashDepositorField, cash);
        writeText(totalDepositMoneyField, depositTotal);
        clickDepositorDetailButton();
        writeDepositorsName(depositor);
        clickDepositorTransferralMethod();
        clickHowFundTransferredDoneButton();
        clickCountry();
        writeText(countrySearchField, generator.setCountry());
        clickGenericIostableCell();
        writeText(howMuchTransferred, transferTotal);
        clickHowFundsGenerated();
        clickFundingOption(howFundsGenerated);
        click(confirmButton);
        clickDepositorNextButton();
        clickNextButton();
    }
}





