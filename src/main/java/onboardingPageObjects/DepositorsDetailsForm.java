package pageObjects;
package onboardingPageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.support.FindBy;
import testData.RandomDataGenerator;
import utils.GuiCommands;

public class DepositorsDetailsForm extends GuiCommands {

    RandomDataGenerator generator = new RandomDataGenerator();

    public DepositorsDetailsForm(IOSDriver driver) {
        super(driver);
    }

    @FindBy(name = "Depositors")
    private MobileElement depositorsDetailsTitle;

    @FindBy(name = "depositor.name_of_depositor.header")
    private MobileElement depositorsNameTextField;

    @FindBy(name = "depositor.transferral_method.header")
    private MobileElement transferMethodTextField;

    @FindBy(name = "depositor.transferral_origin.header")
    private  MobileElement transferOriginTextField;

    @FindBy(name = "depositor.bank_origin_country.header")
    private MobileElement originCountryTextField;

    @FindBy(name = "country_search.search_field_title")
    private MobileElement countrySearchField;

    @FindBy(name = "search exit button")
    private MobileElement searchExitButton;

    @FindBy(xpath = "//XCUIElementTypeTextField[@name=\"depositor.transferral_amount.header\"]") //FIXME get accessibility id
    private MobileElement transferAmountTextField;

    @FindBy(name = "depositor.funds_generated.header")
    private MobileElement generatedFundsTextField;

    @FindBy(name = "next_button_default_title")
    private MobileElement nextButton;

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"Business financials\"]")
    private MobileElement backButton;

    @FindBy(xpath = "toolbar_done")
    private MobileElement pickerWheelDone;

    @FindBy(name = "Gift")
    private MobileElement gift;




    // Elements Displayed

    public boolean isDepositorsDetialsPageDisplayed(){ return depositorsDetailsTitle.isDisplayed(); }


    //Elements Enabled

    public  boolean isNextButtonEnabled () { return nextButton.isEnabled();}


    // Click Methods

    public void clickCountryField() { click(originCountryTextField); }

    public void clickTransferMethod() { click(transferMethodTextField); }

    public void clickTransferOrigin() { click(transferOriginTextField); }

    public void clickGeneratedFunds(){ click(generatedFundsTextField); }

    public void clickBackButton() { click(backButton); }

    public void clickNextButton() { click(nextButton); }

    public void clickDone() { click(pickerWheelDone);}



    //Write Methods

    public void writeDepositorName(String name){ writeText(depositorsNameTextField,name);}

    public void writeTransferAmount(int amount){ writeNumber(transferAmountTextField,amount); }



    //Clear Methods
    public void clearTransferAmount (){ clearText(transferAmountTextField); }

    //Custom Methods

    public void navigateToDepositiorsDetailsForm(){}

    public void passThroughDepositiorsDetailsForm(){

        writeDepositorName("John Doe");
        clickTransferMethod();
        clickDone();
        clickTransferOrigin();
        clickDone();
        clickCountryField();
        writeText(countrySearchField, generator.setCountry());
        clickGenericIostableCell();
        writeTransferAmount(10);
        clickGeneratedFunds();
        click(gift);
        clickNextButton();
        clickNextButton();


    }



}
