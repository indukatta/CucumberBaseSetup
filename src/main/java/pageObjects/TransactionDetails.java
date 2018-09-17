package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.support.FindBy;
import utils.GuiCommands;

public class TransactionDetails extends GuiCommands {

    SourceOfFunds sourceOfFunds = new SourceOfFunds(driver);

    public TransactionDetails(IOSDriver driver) {
        super(driver);
    }

    @FindBy(name = "Transaction details")
    private MobileElement transactionDetailsTitle;

    @FindBy(name = "transaction_details.account_usage")
    private MobileElement accountUsageTextField;

    @FindBy(name = "transaction_details.expected_payments")
    private MobileElement expectedPayTextField;

    @FindBy(name = "next_button_default_title")
    private MobileElement nextButton;

    @FindBy(name = "toolbar_done")
    private MobileElement pickerWheelDone;

    // Summary page elements

    @FindBy(name = "submit")
    private MobileElement submitButton;

    @FindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Summary\"]")
    private MobileElement applicationSummaryTitle;

    @FindBy (name = "All Done!")
    private MobileElement allDoneMessage;


// Elements Displayed

    public boolean isTransactionDetailsPageDisplayed() {return transactionDetailsTitle.isDisplayed(); }

    public boolean isSummaryPageDisplayed(){ return applicationSummaryTitle.isDisplayed(); }

    public boolean isAllDoneDisplayed() { return allDoneMessage.isDisplayed();}

//Elements Enabled

    public boolean isNextButtonEnabled () { return nextButton.isEnabled(); }

// Click Methods

    public void clickAccountUsageField(){ click(accountUsageTextField); }

    public void clickExpectedPayField() { click(expectedPayTextField); }

    public void clickNextButton() { click(nextButton);}

    public void clickDone() {click(pickerWheelDone);}

    public  void clickSubmit() {click(submitButton);}

//Custom Methods

    public void passThroughTransactionDetails(){
        clickAccountUsageField();
        clickDone();
        clickExpectedPayField();
        clickDone();
        clickNextButton();
    }

    public boolean navigateToTransactionDetails(){
        sourceOfFunds.passThrougSourceOfFunds();
        return isTransactionDetailsPageDisplayed();
    }

    public boolean passThroughSummaryPage(){
        passThroughTransactionDetails();
        clickSubmit();
        return isAllDoneDisplayed();
    }
}