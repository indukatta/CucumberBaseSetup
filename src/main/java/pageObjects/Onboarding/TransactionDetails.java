package pageObjects.Onboarding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import utils.GuiCommands;

public class TransactionDetails extends GuiCommands {

    SourceOfFunds sourceOfFunds = new SourceOfFunds(driver);

    public TransactionDetails(IOSDriver driver) {
        super(driver);
    }

    @iOSFindBy(accessibility = "Transaction details")
    private MobileElement transactionDetailsTitle;

    @iOSFindBy(accessibility = "transaction_details.account_usage")
    private MobileElement accountUsageTextField;

    @iOSFindBy(accessibility = "transaction_details.expected_payments")
    private MobileElement expectedPayTextField;

    @iOSFindBy(accessibility = "next_button_default_title")
    private MobileElement nextButton;

    @iOSFindBy(accessibility = "toolbar_done")
    private MobileElement pickerWheelDone;

    // Summary page elements
    @iOSFindBy(accessibility = "submit")
    private MobileElement submitButton;

    @iOSFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Summary\"]")
    private MobileElement applicationSummaryTitle;

    @iOSFindBy (accessibility = "All Done!")
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
        scrollToEnd();
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