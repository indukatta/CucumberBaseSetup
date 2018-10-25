package paymentsPageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.NoSuchElementException;
import pageObjects.Login.Login;
import utils.GuiCommands;
import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;

public class AvailableBalance extends GuiCommands {


    Login login = new Login(driver);

    public AvailableBalance(IOSDriver driver) {
        super(driver);
    }

    @iOSFindBy(accessibility = "welcome.existing_customer_button_title")
    private MobileElement existCustomer;

    @iOSFindBy(accessibility = "login.login_username_textfield_header")
    private MobileElement usernameField;

    @iOSFindBy(accessibility = "next_button_default_title")
    private MobileElement nextButton;

    @iOSFindBy(accessibility = "login.login_password_textfield_header")
    private MobileElement passwordField;

    @iOSFindBy(accessibility = "login.login_button_title")
    private MobileElement loginButton;

    @iOSFindBy(accessibility = "balanceViewTitle")
    private MobileElement hsAvailableBalance;

    @iOSFindBy(accessibility = "tab_bar.payments_title")
    private MobileElement paymentsTab;

    @iOSFindBy(accessibility = "payments.pay_someone_new_title")
    private MobileElement newPaymentButton;

    @iOSFindBy(accessibility = "payee_details.name_textfield_header")
    private MobileElement payeeName;

    @iOSFindBy(accessibility = "payee_details.sort_code_textfield_header")
    private MobileElement payeeSortCode;

    @iOSFindBy(accessibility = "payee_details.account_number_textfield_header")
    private MobileElement payeeAccNumber;

    @iOSFindBy(accessibility = "payments.continue_button_title")
    private MobileElement continueButton;

    @iOSFindBy(xpath = "//XCUIElementTypeTextField[@name=\"payment_details.amount_textfield_header\"]")
    private MobileElement payAmount;

    @iOSFindBy(accessibility = "payment_details.reference_textfield_header")
    private MobileElement reference;

    @iOSFindBy(accessibility = "back arrow")
    private MobileElement payDeteailsBB;

    @iOSFindBy(accessibility = "Cancel")
    private MobileElement cancelButton;

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Paying someone new\"]")
    private MobileElement payNewPersonBB;

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Paying someone new\"]")
    private MobileElement summaryBB;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Paying someone new\"]")
    private MobileElement summaryTitle;

    @iOSFindBy(accessibility = "OK")
    private MobileElement okButton;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Payments\"]")
    private MobileElement paymentsTitle;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Paying someone new\"]")
    private MobileElement payDetailsTitle;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Paying someone new\"]")
    private MobileElement payRefTitle;

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Paying someone new\"]")
    private MobileElement paymentDetailsBB;

    @iOSFindBy(accessibility = "Delete")
    private MobileElement numPadDel;

    @iOSFindBy(accessibility = ".")
    private MobileElement decimalDot;

    @iOSFindBy(accessibility = "balanceViewTitle")
    private MobileElement availableBalance;

    @iOSFindBy(accessibility = "activity_indicator")
    private MobileElement spinner;

    // Summary page elements

    @iOSFindBy(accessibility = "payment_confirmation.sort_code_label_value")
    private MobileElement summarySortCode;

    @iOSFindBy(accessibility = "payment_confirmation.account_number_label_value")
    private MobileElement summaryAccNumber;

    @iOSFindBy(accessibility = "payment_confirmation.reference_label_value")
    private MobileElement summaryReference;

    @iOSFindBy(accessibility = "payment_confirmation.confirm_payment_message")
    private MobileElement disclaimerMessage;

    @iOSFindBy(accessibility = "payment_confirmation.about_to_pay_label_value")
    private MobileElement summaryAmount;

    @iOSFindBy(accessibility = "payment_confirmation.make_payment_button_title")
    private MobileElement makePaymentButton;

    @iOSFindBy(accessibility = "GBP")
    private MobileElement poundSign;

    @iOSFindBy(accessibility = "You have insufficient funds")
    private MobileElement errorMessageFunds;

    @iOSFindBy(accessibility = "Delete")
    private MobileElement deleteKey;

    @iOSFindBy(accessibility = "payment_success.copy_label")
    private MobileElement successMessage;

    @iOSFindBy(accessibility = "payments.done_button_title")
    private MobileElement doneButton;

    @iOSFindBy(accessibility = "payment_failure.close_action_title")
    private MobileElement closeButton;

    @iOSFindBy(accessibility = "payment_failure.edit_action_title")
    private MobileElement editButton;

    @iOSFindBy(accessibility = "payment_confirmation.about_to_pay_label_value")
    private MobileElement sentAmount;

    @iOSFindBy(accessibility = "payment_success.confirmed_label")
    private MobileElement paymentConfrimedTitle;

    @iOSFindBy(accessibility = "ic_green_circle_tick")
    private MobileElement greenTickImage;

    @iOSFindBy(accessibility = "payment_failure.copy_label")
    private MobileElement editFailureMessage;

    @iOSFindBy(accessibility = "try_again")
    private MobileElement tryAgainButton;

    @iOSFindBy(accessibility = "Yes")
    private MobileElement selectYes;

    @iOSFindBy(accessibility = "This payment is identical to a payment you have already sent. Would you like this " +
            "payment to be made as well?")
    private MobileElement duplicatePayMessage;

    @iOSFindBy(accessibility = "No")
    private MobileElement selectNo;

    @iOSFindBy(accessibility = "We are unable to process as a faster payment. Would you like to use the 3 day payment cycle?")
    private MobileElement bacsPayMessage;

    @iOSFindBy(accessibility = "Your payment will not be sent")
    private MobileElement bacsFailMessage;

    @iOSFindBy(accessibility = "Your payment has been sent and will be credited to the beneficiary's account within 3 working days.")
    private MobileElement bacsSuccessMessage;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Payment delay\"]")
    private MobileElement paymentDelayTitle;

    @iOSFindBy(accessibility = "We are unable to process as a faster payment. Would you like us to use the 2 day payment cycle? (H58)")
    private MobileElement chapsMessageh58;

    @iOSFindBy(accessibility = "We are unable to process as a faster payment. Would you like us to use the 2 day payment cycle? (009)")
    private MobileElement chapsMessageh009;

    @iOSFindBy(accessibility = "Your payment has been sent and will be credited to the beneficiary's account within 2 working days. (H98)")
    private MobileElement succeessChapsH98;

    @iOSFindBy(accessibility = "Your payment has been sent and will be credited to the beneficiary's account within 2 working days. (H97)")
    private MobileElement succeessChapsH97;

    @iOSFindBy(accessibility = "We are unable to make this payment today. Do you want us to send the payment tomorrow?")
    private MobileElement fraudMessage;

    @iOSFindBy(accessibility = "We will send your payment tomorrow")
    private MobileElement fraudYesMessage;

    @iOSFindBy(accessibility = "Your payment has been sent and will usually be credited to the beneficiary's account today, subject to our normal fraud checks.")
    private MobileElement agencySuccessMainMsg;

    @iOSFindBy(accessibility = "This payment will be credited to the beneficiary's account within 2 working days. " +
            "Payments made after 3.30pm or on non-working days may not be sent until the next working day.")
    private MobileElement agencySideMessage;

    @iOSFindBy(accessibility = "Your payment has been sent and will be credited to the beneficiary's account within 2 working days. (H96)")
    private MobileElement agencySuccessSideMsg;

    @iOSFindBy(accessibility = "Your payment has been sent and will be credited to the beneficiary's account immediately, subject to our normal fraud checks.")
    private MobileElement supressSuccessMessage;

    @iOSFindBy(accessibility = "This payment should be credited to the beneficiary's account today. Payments made after " +
            "8pm or on non-working days may not be credited until the next working day. Do you wish to continue?")
    private MobileElement agencyMainMessage;

    @iOSFindBy(accessibility = "Confirm Cancellation")
    private MobileElement confimCancelationBox;

    String currentAvailBal;



    HashMap<String, String> brcCodes = new HashMap<>();

    public void addBrcCodes() {
        // Edit Status Brc
        brcCodes.put("H87", "We are unable to process as the payment amount exceeds the daily limit. (H87)");
        brcCodes.put("H88", "We are unable to process as the payment amount exceeds the daily limit. (H88)");
        brcCodes.put("H63", "We are unable to process as the payment amount exceeds the daily limit. (H63)");
        brcCodes.put("H64", "We are unable to process as the payment amount exceeds the daily limit. (H64)");
        brcCodes.put("HI7", "We are unable to process as the payment amount exceeds the daily limit. (HI7)");
        brcCodes.put("456", "The requested payment would result in the maximum deposit to your Tessa / ISA account " +
                "being exceeded. We are therefore unable to deal with your request. (456)");
        brcCodes.put("074", "We are unable to deal with your request due to lack of available funds in the selected " +
                "debit account. Please reduce the payment amount or arrange to have funds available in the account " +
                "before sending this instruction via this method. (074)");
        brcCodes.put("H82", "We are unable to deal with your request due to lack of available funds in the selected " +
                "debit account. Please reduce the payment amount or arrange to have funds available in the account " +
                "before sending this instruction via this method. (H82)");
        brcCodes.put("HG8", "The beneficiary details entered are incorrect. Please check and re-enter. (HG8)");
        brcCodes.put("HE5", "The beneficiary details entered are incorrect. Please check and re-enter. (HE5)");
        brcCodes.put("H95", "The beneficiary details entered are incorrect. Please check and re-enter. (H95)");
        brcCodes.put("H69", "The beneficiary details entered are incorrect. Please check and re-enter. (H69)");
        brcCodes.put("H72", "The beneficiary details entered are incorrect. Please check and re-enter. (H72)");

        // Sent Status Brc

        brcCodes.put("H47", "Your payment has been sent and will be credited to the beneficiary's account immediately," +
                " subject to our normal fraud checks.");
        brcCodes.put("H48", "Your payment has been sent and will usually be credited to the beneficiary's account " +
                "within 2 hours, subject to our normal fraud checks");
        brcCodes.put("H50", "Your payment has been sent and will usually be credited to the beneficiary's account " +
                "today, subject to our normal fraud checks.");
        brcCodes.put("H51", "Your payment has been sent and will usually be credited to the beneficiary's account " +
                "within 2 hours, subject to our normal fraud checks. However, the Credit Card balance will not be " +
                "updated until the next working day");
        brcCodes.put("H54", "Your payment instructions have been received and are being processed.");
        brcCodes.put("H89", "Your payment has been sent and will be credited to the beneficiary's account.");
        brcCodes.put("H41", "Your payment has been accepted however the beneficiary's bankers are unable to confirm " +
                "when the beneficiary will be credited.");
        brcCodes.put("H42", "Your payment has been accepted by the beneficiary's bankers who advise that the beneficiary" +
                " account will be credited today.");
        brcCodes.put("H43", "Your payment has been accepted by the beneficiary's bankers who advise that the " +
                "beneficiary account will be credited by tomorrow.");
        brcCodes.put("H44", "Your payment has been accepted by the beneficiary's bankers who advise that the " +
                "beneficiary account will be credited by the next working day.");
        brcCodes.put("H45", "Your payment has been accepted however the beneficiary's bankers are unable to confirm " +
                "when the beneficiary will be credited.");

        //Failure Status Brc Codes

        brcCodes.put("085", "We are unable to deal with your request. Please try again later. (085)");
        brcCodes.put("H91", "There is currently a problem and we are not able to send this payment. Please try again " +
                "later. (H91)");
        brcCodes.put("H61", "Sorry, an error has occurred. Please check your account and if the payment has not been" +
                " made, then please try again later. (H61)");
        brcCodes.put("051", "The credit account you have selected is not open, so we were unable to make this payment " +
                "for you. Please contact the person you are paying. (051)");
        brcCodes.put("024", "Sorry, you are unable to make payments or transfers from this account. Please contact the" +
                " person you are paying. (024)");
        brcCodes.put("H86", "The sort code entered for this payment is invalid. Please 'Create a new beneficiary' and " +
                "select the beneficiary from the list provided to make this payment. (H68)");
        brcCodes.put("141", "Debits are not allowed on this account. Please contact the person you are paying. (141)");
        brcCodes.put("028", "We are unable to make this payment because the debit account you have selected is not " +
                "open. Please try again later. (028)");
        brcCodes.put("023", "We are unable to make this payment because the debit account as been blocked or " +
                "transferred. Please contact the person who you are paying. (023)");
        brcCodes.put("HE2", "Sorry, we are unable to make this payment because we could not find the beneficiary " +
                "account. (HE2)");
        brcCodes.put("110", "We are unable to make this payment because the accounts you have chosen to debit and " +
                "credit are both closed. Please contact the person that you are paying. (110)");
        brcCodes.put("037", "We are unable to make payments or transfers to or from these accounts. Please contact " +
                "the person that you are paying. (037)");
        brcCodes.put("H62", "We were unable to process this payment. Please try again later. (H62)");
        brcCodes.put("H90", "We were unable to process this payment. Please try again later. (H90)");
        brcCodes.put("H65", "We were unable to process this payment. Please try again later. (H65)");
        brcCodes.put("H85", "We were unable to process this payment due to a systems error. Please try again later." +
                " (H85)");
        brcCodes.put("HE9", "The payee you have selected is a major beneficiary held on our records and can't be paid " +
                "in this way. (HE9)");
        brcCodes.put("HE3", "The beneficiary bank has advised that they are unable to accept this payment as the " +
                "beneficiary account is closed. Please contact the person you are paying. (HE3)");
        brcCodes.put("H70", "The beneficiary bank has advised that they are unable to accept this payment as the" +
                " beneficiary account is closed. Please contact the person you are paying. (H70)");
        brcCodes.put("H76", "The beneficiary bank has advised that they are unable to accept this payment as the " +
                "beneficiary account is closed. Please contact the person you are paying. (H76)");
        brcCodes.put("H75", "The beneficiary bank has informed us that they are unable to accept this payment" +
                " into the account number quoted as it is in a different currency. Please contact the " +
                "person you are paying for alternative account details. (H75)");
        brcCodes.put("HF2", "The beneficiary bank has advised that they are unable to accept this payment. Please" +
                " contact the person you are paying. (HF2)");
        brcCodes.put("H94", "Sorry - it is not possible for us to make a bill payment to the given beneficiary. (H94)");
        brcCodes.put("H68", "The beneficiary bank has advised that they are unable to accept this payment. " +
                "Please contact the person you are paying. (H68)");
        brcCodes.put("H71", "The beneficiary bank has advised that they are unable to accept this payment. " +
                "Please contact the person you are paying. (H71)");
        brcCodes.put("H77", "The beneficiary bank has advised that they are unable to accept this payment. " +
                "Please contact the person you are paying. (H77)");
        brcCodes.put("H78", "The beneficiary bank has advised that they are unable to accept this payment. " +
                "Please contact the person you are paying. (H78)");
        brcCodes.put("H79", "The beneficiary bank has advised that they are unable to accept this payment. " +
                "Please contact the person you are paying. (H79)");
        brcCodes.put("H80", "The beneficiary bank has advised that they are unable to accept this payment. " +
                "Please contact the person you are paying. (H80)");
        brcCodes.put("H84", "The beneficiary bank has advised that they are unable to accept this payment. " +
                "Please contact the person you are paying. (H84)");

        //Retry code
        brcCodes.put("HE7", "This payment is identical to a payment you have already sent. Would you like " +
                "this payment to be made as well?");
        // Bacs

        brcCodes.put("H59", "We are unable to process as a faster payment. Would you like to use the 3 day payment cycle?");
        brcCodes.put("H66", "We are unable to process as a faster payment. Would you like to use the 3 day payment cycle?");
        brcCodes.put("H67", "We are unable to process as a faster payment. Would you like to use the 3 day payment cycle?");
        brcCodes.put("002", "We are unable to process as a faster payment. Would you like to use the 3 day payment cycle?");

        //Chaps
        brcCodes.put("H58", "We are unable to process as a faster payment. Would you like us to use the 2 day payment cycle? (H58)");
        brcCodes.put("009", "We are unable to process as a faster payment. Would you like us to use the 2 day payment cycle? (009)");

        // Fraud

        brcCodes.put("H55", "We are unable to make this payment today. Do you want us to send the payment tomorrow?");
        brcCodes.put("H56", "We are unable to make this payment today. Do you want us to send the payment tomorrow?");

        //Agency

        brcCodes.put("003", "This payment should be credited to the beneficiary's account today. Payments made after " +
                "8pm or on non-working days may not be credited until the next working day. Do you wish to continue?");
        brcCodes.put("004", "This payment should be credited to the beneficiary's account today. Payments made after " +
                "8pm or on non-working days may not be credited until the next working day. Do you wish to continue?");
        brcCodes.put("005", "This payment should be credited to the beneficiary's account today. Payments made after " +
                "8pm or on non-working days may not be credited until the next working day. Do you wish to continue?");
        brcCodes.put("006", "This payment should be credited to the beneficiary's account today. Payments made after " +
                "8pm or on non-working days may not be credited until the next working day. Do you wish to continue?");
        brcCodes.put("008", "This payment will be credited to the beneficiary's account within 2 working days. " +
                "Payments made after 3.30pm or on non-working days may not be sent until the next working day.");

    }

    //Click Methods

    public void clickNext() {
        click(nextButton);
    }

    public void clickContinue() {
        click(continueButton);
    }

    public void clickPaymentTab() {
        click(paymentsTab);
    }

    public void clickNewPayee() {
        click(newPaymentButton);
    }

    public void clickExistingCustomer() {
        click(existCustomer);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void clickDone() {
        click(doneButton);
    }


    //Custom Methods

    public boolean isSpinnerShowing(){
        return spinner.isDisplayed();
    }
    public void populatePayeeDetails() {

        writeText(payeeName, "Jane doe");
        writeNumber(payeeSortCode, 123456);
        writeNumber(payeeAccNumber, 12345678);
    }

    public void populateRefPage() {

        writeNumber(payAmount, 666);
        writeText(reference, "The end is near");
    }

    public void passThroughPayeeDetails() {

        writeText(payeeName, "John doe");
        writeNumber(payeeSortCode, 123456);
        writeNumber(payeeAccNumber, 12345678);
        clickContinue();
    }

    public void passThroughRefPage() {

        writeNumber(payAmount, 1000);
        writeText(reference, "The Reference");
        clickContinue();
    }

    public void navigateToPaymentpage() {

        login.navigateToLogin();
        currentAvailBal = hsAvailableBalance.getText();
        clickPaymentTab();
        clickNewPayee();
    }

    public void navigateToPaymentpageAsUser(String user, String pass) {

        login.loginAsUser(user,pass);
        clickPaymentTab();
        clickNewPayee();
    }

    public void populateValidUser() {
        writeText(payeeName, "Valid User");
        writeNumber(payeeSortCode, 123456);
        writeNumber(payeeAccNumber, 44449999);
        clickContinue();
    }

    public void populateInvalidUser() {
        writeText(payeeName, "Invalid User");
        writeNumber(payeeSortCode, 123456);
        writeNumber(payeeAccNumber, 44449995);
        clickContinue();
    }
    public void populatePaymentWarningUser() {
        writeText(payeeName, "Payment Warning");
        writeNumber(payeeSortCode, 123456);
        writeNumber(payeeAccNumber, 44449995);
        clickContinue();
    }
    public void populateChapsWarningUser() {
        writeText(payeeName, "CHAPS Warning");
        writeNumber(payeeSortCode, 128956);
        writeNumber(payeeAccNumber, 44449777);
        clickContinue();
    }
    public void populateDuplicateWarningUser() {
        writeText(payeeName, "Duplicate Warning");
        writeNumber(payeeSortCode, 177456);
        writeNumber(payeeAccNumber, 44444377);
        clickContinue();
    }
    public void populateFraudWarningUser() {
        writeText(payeeName, "Fraud Warning");
        writeNumber(payeeSortCode, 177456);
        writeNumber(payeeAccNumber, 44444377);
        clickContinue();
    }
    public void populateBacsWarningUser() {
        writeText(payeeName, "BACS Warning");
        writeNumber(payeeSortCode, 177456);
        writeNumber(payeeAccNumber, 44444377);
        clickContinue();
    }

    public void populateHRCodeRef(String code) {
        writeNumber(payAmount, 100);
        writeText(reference, code);
        clickContinue();
    }

    public void navigateToSuccessScreen() {
        navigateToPaymentpage();
        populateValidUser();
        populateHRCodeRef("H47");
        click(makePaymentButton);
    }


    public void pressDelete(int count) {

        while (count > 0) {
            click(deleteKey);
            count--;
        }
    }

    //Test Methods
    public boolean isAvailBalanceEqual() {
        login.navigateToLogin();
        String check1 = hsAvailableBalance.getText();
        clickPaymentTab();
        clickNewPayee();
        passThroughPayeeDetails();

        return driver.findElementByAccessibilityId("Available balance: "+check1).isEnabled();
    }
    public boolean cancelButtonVerification() {
        navigateToPaymentpage();
        passThroughPayeeDetails();
        click(cancelButton);
        boolean one = paymentsTitle.isDisplayed();
        clickNewPayee();
        boolean two = payeeName.getText().isEmpty();
        passThroughPayeeDetails();
        passThroughRefPage();
        click(cancelButton);
        boolean three = paymentsTitle.isDisplayed();
        clickNewPayee();
        boolean four = payeeName.getText().isEmpty();

        return one && two && three && four;
    }
    public boolean goBackFromSummaryPage() {
        navigateToPaymentpage();
        passThroughPayeeDetails();
        passThroughRefPage();
        click(summaryBB);
        boolean one = payRefTitle.isDisplayed();
        boolean two = payAmount.getText().equals("1,000.00");
        boolean three = reference.getText().equals("The Reference");

        return one && two && three;
    }
    public boolean goBackFromPayeeDetails() {
        navigateToPaymentpage();
        writeText(payeeName, "Jane doe");
        writeNumber(payeeSortCode, 123456);
        click(payDeteailsBB);
        boolean one = paymentsTitle.isDisplayed();
        clickNewPayee();
        boolean two = payeeName.getText().isEmpty();

        return one && two;
    }
    public boolean goBackFromPayeeDetailsPopUp() {
        navigateToPaymentpage();
        populatePayeeDetails();
        click(payDeteailsBB);
        boolean one = confimCancelationBox.isDisplayed();
        click(selectNo);
        boolean two = payeeName.getText().equals("Jane doe");
        click(payDeteailsBB);
        click(selectYes);
        clickNewPayee();
        boolean three = payeeName.getText().isEmpty();

        return one && two && three;
    }
    public boolean goBackFromPaymentsDetailsPage() {
        navigateToPaymentpage();
        passThroughPayeeDetails();
        click(paymentDetailsBB);
        boolean one = payeeName.getText().equals("John doe");
        boolean two = (payeeSortCode.getText().equals("12-34-56")) && payeeAccNumber.getText().equals("12345678");

        return one && two;
    }
    public boolean isPaymentInfoKept() {
        navigateToPaymentpage();
        passThroughPayeeDetails();
        populateRefPage();
        click(paymentDetailsBB);
        clickContinue();
        boolean one = payAmount.getText().replaceAll("[^0-9]", "").equals("66600");
        boolean two = reference.getText().equals("The end is near");

        return one && two;
    }
    public boolean isAllSummaryDisplayed() {
        navigateToPaymentpage();
        passThroughPayeeDetails();
        passThroughRefPage();
        boolean one = driver.findElementById("to John doe").isDisplayed();
        boolean two = summaryAccNumber.isDisplayed();
        boolean three = summarySortCode.isDisplayed();
        boolean four = summaryAmount.isDisplayed();
        boolean five = summaryReference.isDisplayed();
        boolean six = disclaimerMessage.isDisplayed();
        boolean seven = makePaymentButton.isDisplayed();

        return one && two && three && four && five && six && seven;
    }
    public boolean sortCodeValidator() {
        navigateToPaymentpage();
        writeNumber(payeeSortCode, 1);
        boolean one = numPadDel.isDisplayed();
        writeNumber(payeeSortCode, 234567);
        click(payeeName);
        boolean two = payeeSortCode.getText().matches("^\\d{2}-\\d{2}-\\d{2}");

        return one && two;
    }
    public boolean accountNumberValidator() {
        navigateToPaymentpage();
        writeText(payeeName, "Robo Cop");
        writeNumber(payeeSortCode, 234567);
        boolean one = false;
        for (int i = 1; i < 10; i++) {
            if (continueButton.isEnabled()) {
                writeNumber(payeeAccNumber, i);
                one = payeeAccNumber.getText().equals("12345678");
                break;
            } else {
                writeNumber(payeeAccNumber, i);
            }
        }
        return one;
    }
    public boolean isContinueButtonWorking() {
        navigateToPaymentpage();
        writeText(payeeName, "Monkey D Luffy");
        boolean one = !continueButton.isEnabled();
        writeNumber(payeeSortCode, 777777);
        boolean two = !continueButton.isEnabled();
        writeNumber(payeeAccNumber, 12345678);
        clickContinue();
        boolean three = reference.isDisplayed();

        return one && two && three;
    }
    public boolean isCurrencyDisplayed() {
        navigateToPaymentpage();
        passThroughPayeeDetails();
        writeNumber(payAmount, 1500);
        boolean one = poundSign.isDisplayed();
        writeText(poundSign, "USD");
        boolean two = poundSign.getText().equals("GBP");

        return one && two;
    }
    public boolean isContinuebtnEnabled() {
        navigateToPaymentpage();
        passThroughPayeeDetails();
        writeNumber(payAmount, 123);
        boolean two = !continueButton.isEnabled();
        writeText(reference, "You can do it");
        clickContinue();
        boolean three = summarySortCode.isDisplayed();

        return two && three;
    }
    public boolean startPaymentJourneyAndEnterPayeeDetails() {
        navigateToPaymentpage();
        boolean one = payeeName.isDisplayed();
        boolean two = payeeSortCode.isDisplayed();
        boolean three = payeeAccNumber.isDisplayed();
        boolean four = continueButton.isDisplayed();

        return one && two && three && four;
    }
    public boolean payeeDetailsNameField() {
        navigateToPaymentpage();
        writeNumber(payeeSortCode, 123456);
        writeNumber(payeeAccNumber, 12345678);
        boolean one = !continueButton.isEnabled();
        writeText(payeeName, "John doe 123456789");
        boolean two = continueButton.isEnabled();
        clearText(payeeName);
        writeText(payeeName, "John does 123456789");
        boolean three = payeeName.getText().equals("John does 12345678");

        return one && two && three;
    }
    public boolean paymentAmountValidator() {
        boolean one;
        boolean two = false;
        boolean three;
        int count = 0;
        String[] correctValues = {"0.01", "5000"};
        String[] incorrectValues = {"-0.1", "-5500", "5.234"};

        navigateToPaymentpage();
        passThroughPayeeDetails();
        click(payAmount);
        boolean five = decimalDot.isDisplayed();
        writeText(reference, "Mike check one two");
        for (String val : correctValues) {
            writeText(payAmount, val);
            if (continueButton.isEnabled()) count++;
            clearText(payAmount);
        }
        if (count == 2) {
            one = true;
            count = 0;
        } else {
            one = false;
            count = 0;
        }
        for (String val : incorrectValues) {
            writeText(payAmount, val);
            if (!payAmount.getText().equals(val) || !continueButton.isEnabled()) count++;
            clearText(payAmount);
        }
        if (count == 3) {
            two = true;
        }
        writeText(payAmount, "3500.1");
        boolean four = payAmount.getText().equals("3500.1");
        click(reference);
        three = payAmount.getText().equals("3,500.10");
        return one && two && three && four && five;
    }
    public boolean isGpbDisplayedInactive() {
        navigateToPaymentpage();
        passThroughPayeeDetails();
        click(reference);
        boolean one;
        try {
            one = !poundSign.isDisplayed();
        } catch (NoSuchElementException e) {
            one = true;
        }
        return one;
    }
    public boolean referenceFieldValidator() {
        navigateToPaymentpage();
        passThroughPayeeDetails();
        writeNumber(payAmount, 1222);
        writeText(reference, "Abc345 / ., -/..ps");
        boolean one = continueButton.isEnabled();
        clearText(reference);
        boolean two = !continueButton.isEnabled();
        writeText(reference, "This is kinda longer");
        boolean three = !reference.getText().equals("This is kinda longer");
        clearText(reference);
        writeText(reference, " ");
        boolean four = !continueButton.isEnabled();
        writeText(reference, " Hiya!");
        boolean five = !continueButton.isEnabled();

        return one && two && three && four && five;
    }
    public boolean insuficientFundsError() {
        navigateToPaymentpage();
        passThroughPayeeDetails();
        writeNumber(payAmount, Integer.parseInt(currentAvailBal.replaceAll("[^0-9]", "")) + 100);
        writeText(reference, "Testing");
        boolean one = errorMessageFunds.isDisplayed();
        boolean two = !continueButton.isEnabled();

        return one && two;
    }
    public boolean insuficientFundsCorrection() {
        navigateToPaymentpage();
        passThroughPayeeDetails();
        writeNumber(payAmount,Integer.parseInt(currentAvailBal.replaceAll("[^0-9]", "")) + 100);
        writeText(reference, "Testing");
        boolean one = errorMessageFunds.isDisplayed();
        boolean two = !continueButton.isEnabled();
        click(payAmount);
        pressDelete((payAmount.getText().length())-1);
        boolean three = continueButton.isEnabled();
        boolean four;
        try {
            four = !errorMessageFunds.isDisplayed();
        } catch (NoSuchElementException e) {
            four = true;
        }
        return one && two && three && four;
    }
    public boolean successPageDisplayed() {
        navigateToSuccessScreen();
        return doneButton.isDisplayed() && paymentConfrimedTitle.isDisplayed();
    }
    public boolean disclaimerShown() {
        addBrcCodes();
        navigateToSuccessScreen();
        return paymentConfrimedTitle.isDisplayed() && driver.findElementByAccessibilityId(brcCodes.get("H47")).isDisplayed();
    }
    public boolean doneButtonValidation() {
        navigateToSuccessScreen();
        click(doneButton);
        return availableBalance.isDisplayed();
    }
    public boolean sentStatusMessageCheck() {
        addBrcCodes();
        String[] sentBrcCodes = {"H47", "H48", "H50", "H51", "H54", "H89", "H41", "H42", "H43", "H44", "H45"};
        int count = 0;
        navigateToPaymentpage();
        for (String code : sentBrcCodes) {
            populateValidUser();
            populateHRCodeRef(code);
            click(makePaymentButton);
            String message = driver.findElementByAccessibilityId(brcCodes.get(code)).getText();
            if (message.equals(brcCodes.get(code))) {
                count++;
            }
            click(doneButton);
            click(paymentsTab);
            clickNewPayee();
        }
        return count == 11;
    }
    public boolean editStatusMessageCheck() {
        addBrcCodes();
        String[] editBrcCodes = {"H87", "H88", "H63", "H64", "HI7", "456", "074", "H82", "HG8", "HE5", "H95", "H69", "H72"};
        int count = 0;
        int count2 = 0;
        navigateToPaymentpage();
        for (String code : editBrcCodes) {
            populateInvalidUser();
            populateHRCodeRef(code);
            click(makePaymentButton);
            String message = driver.findElementByAccessibilityId(brcCodes.get(code)).getText();
            if (message.equals(brcCodes.get(code))) {
                count++;
            }
            click(closeButton);
            if (paymentsTitle.isDisplayed()) count2++;
            clickNewPayee();
        }
        return count == 13 && count2 == 13;
    }
    public boolean editPayeeDetailsCode() {
        addBrcCodes();
        String[] payeeDetailsBrcCodes = {"HG8", "HE5", "H95", "H69", "H72"};
        int count = 0;
        int count2 = 0;
        navigateToPaymentpage();
        for (String code : payeeDetailsBrcCodes) {
            populateInvalidUser();
            populateHRCodeRef(code);
            click(makePaymentButton);
            click(editButton);
            if (payeeName.getText().equals("Invalid User") && payeeAccNumber.getText().equals("44449995")
                    && payeeSortCode.getText().equals("12-34-56") && continueButton.isEnabled()) count++;
            click(payDeteailsBB);
            if (selectNo.isEnabled()) count2++;
            click(selectYes);
            clickNewPayee();
        }
        return count == 5 && count2 == 5;
    }
    public boolean editPaymentDetailsCode() {
        addBrcCodes();
        String[] paymentDetailsBrcCodes = {"H87", "H88", "H63", "H64", "HI7", "456", "074", "H82"};
        int count = 0;
        int count2 = 0;
        navigateToPaymentpage();
        for (String code : paymentDetailsBrcCodes) {
            populateInvalidUser();
            populateHRCodeRef(code);
            click(makePaymentButton);
            click(editButton);
            if (payAmount.getText().equals("")) count++;
            click(paymentDetailsBB);
            click(payDeteailsBB);
            if (selectNo.isEnabled()) count2++;
            click(selectYes);
            clickNewPayee();
        }
        return count == 8 && count2 == 8;
    }
    public boolean failureStatusMessageCheck() {
        addBrcCodes();
        String[] failureBrcCodes = { "H91", "085", "H61", "051", "024", "H86", "141", "028", "023", "HE2",
                "110", "037", "H62", "H90", "H65", "H85", "HE9", "HE3", "H70", "H76", "H75", "HF2", "H94", "H68",
                "H71", "H77", "H78", "H79", "H80", "H84"};
        int count = 0;
        int count2 = 0;
        navigateToPaymentpage();
        for (String code : failureBrcCodes) {
            populateInvalidUser();
            populateHRCodeRef(code);
            click(makePaymentButton);
            String message = driver.findElementByAccessibilityId(brcCodes.get(code)).getText();
            if (message.equals(brcCodes.get(code))) {
                count++;
            }
            click(doneButton);
            if (paymentsTitle.isDisplayed()) count2++;
            clickNewPayee();
            System.out.println(count);
            System.out.println(count2);
            System.out.println(code);
        }
        return count == 30 && count2 == 30;
    }
    public boolean duplicatePopUpDisplay(){
        addBrcCodes();
         navigateToPaymentpage();
         populateDuplicateWarningUser();
         populateHRCodeRef("HE7");
         click(makePaymentButton);
         String message = duplicatePayMessage.getText();
         boolean one = message.equals(brcCodes.get("HE7"));
         boolean two = selectYes.isDisplayed() && selectNo.isDisplayed();
         return one &&two;
    }
    public boolean clickNoPopUp(){
        duplicatePopUpDisplay();
        click(selectNo);
        boolean one = driver.findElementByAccessibilityId("Your payment will not be sent").isDisplayed();
        click(doneButton);
        boolean two = paymentsTitle.isDisplayed();

        return one && two;
    }
    public boolean clickYesPopUp(){
        addBrcCodes();
        navigateToPaymentpage();
        populateDuplicateWarningUser();
        populateHRCodeRef("HE7");
        click(makePaymentButton);
        boolean one = driver.findElementByAccessibilityId(brcCodes.get("HE7")).isDisplayed();
        click(selectYes);
        boolean two = driver.findElementByAccessibilityId(brcCodes.get("H47")).isDisplayed();
        click(doneButton);
        boolean three = availableBalance.isDisplayed();

        return one && two && three;
    }
    public boolean bacsPopUpDisplay(){
        addBrcCodes();
        String[] bacsBrcCodes = {"H59","H66","H67","002"};
        int count = 0;
        int count2 = 0;
        navigateToPaymentpage();
        for (String code : bacsBrcCodes){
            populateBacsWarningUser();
            populateHRCodeRef(code);
            click(makePaymentButton);
            String message = bacsPayMessage.getText();
            if ( message.equals(brcCodes.get(code))) count ++;
            if(selectYes.isDisplayed() && selectNo.isDisplayed()) count2++;
            click(selectNo);
            click(doneButton);
            clickNewPayee();
        }
        return count == 4 && count2 == 4;
    }
    public boolean bacsSelectNo(){
        addBrcCodes();
        String[] bacsBrcCodes = {"H59","H66","H67","002"};
        int count = 0;
        int count2 = 0;
        navigateToPaymentpage();
        for (String code : bacsBrcCodes){
            populateBacsWarningUser();
            populateHRCodeRef(code);
            click(makePaymentButton);
            click(selectNo);
            if (bacsFailMessage.getText().equals("Your payment will not be sent"))count ++;
            click(doneButton);
            if(paymentsTitle.isDisplayed())count2++;
            clickNewPayee();
        }
        return count == 4 && count2 == 4;
    }
    public boolean bacsSelectYes(){
        addBrcCodes();
        String[] bacsBrcCodes = {"H59","H66","H67","002"};
        int count = 0;
        int count2 = 0;
        navigateToPaymentpage();
        for (String code : bacsBrcCodes){
            populateBacsWarningUser();
            populateHRCodeRef(code);
            click(makePaymentButton);
            click(selectYes);
            if (bacsSuccessMessage.getText().equals("Your payment has been sent and will be credited to the beneficiary's" +
                    " account within 3 working days."))count ++;
            click(doneButton);
            if(availableBalance.isDisplayed())count2++;
            clickPaymentTab();
            clickNewPayee();
        }
        return count == 4 && count2 == 4;
    }
    public boolean chapsPopUpDisplay(){
        addBrcCodes();
        String[] chapsBrcCodes = {"H58","009"};
        int count = 0;
        int count2 = 0;
        navigateToPaymentpage();
        for (String code : chapsBrcCodes){
            populateChapsWarningUser();
            populateHRCodeRef(code);
            click(makePaymentButton);
            try {
                if (chapsMessageh58.isDisplayed()) count ++;

            }catch (Exception e){
               if (chapsMessageh009.isDisplayed())count ++;
            }
            if(selectYes.isDisplayed() && selectNo.isDisplayed()) count2++;
            click(selectNo);
            clickDone();
            clickNewPayee();
        }
        return count == 2 && count2 == 2;
    }
    public boolean chapsSelectYes() {
        addBrcCodes();
        String[] chapsBrcCodes = {"H58","009"};
        int count = 0;
        int count2 = 0;
        navigateToPaymentpage();
        for (String code : chapsBrcCodes){
            populateChapsWarningUser();
            populateHRCodeRef(code);
            click(makePaymentButton);
            click(selectYes);
            try {
                if (succeessChapsH97.isDisplayed()) count ++;

            }catch (Exception e){
                if (succeessChapsH98.isDisplayed())count ++;
            }
            click(doneButton);
            if(availableBalance.isDisplayed())count2++;
            clickPaymentTab();
            clickNewPayee();
        }
        return count == 2 && count2 == 2;
    }
    public boolean chapsSelectNo(){
        addBrcCodes();
        String[] chapsBrcCodes = {"H58","009"};
        int count = 0;
        int count2 = 0;
        navigateToPaymentpage();
        for (String code : chapsBrcCodes){
            populateBacsWarningUser();
            populateHRCodeRef(code);
            click(makePaymentButton);
            click(selectNo);
            if (bacsFailMessage.getText().equals("Your payment will not be sent"))count ++;
            click(doneButton);
            if(paymentsTitle.isDisplayed())count2++;
            clickNewPayee();
        }
        return count == 2 && count2 == 2;
    }
    public boolean fruadSelectNo(){
        addBrcCodes();
        String[] chapsBrcCodes = {"H55","H55","003","004","005","006","008"};
        int count = 0;
        int count2 = 0;
        navigateToPaymentpage();
        for (String code : chapsBrcCodes){
            populateBacsWarningUser();
            populateHRCodeRef(code);
            click(makePaymentButton);
            click(selectNo);
            if (bacsFailMessage.getText().equals("Your payment will not be sent"))count ++;
            click(doneButton);
            if(paymentsTitle.isDisplayed())count2++;
            clickNewPayee();
        }
        return count == 7 && count2 == 7;
    }
    public boolean fruadPopUpDisplay(){
        addBrcCodes();
        String[] fraudBrcCodes = {"H55","H56"};
        String[] agencyBrcCodes = {"003","004","005","006","008"};

        int count = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        navigateToPaymentpageAsUser("ONETRANUSER","TESTPASSWORD");
        for (String code : fraudBrcCodes){
            populateFraudWarningUser();
            populateHRCodeRef(code);
            click(makePaymentButton);
            String message = fraudMessage.getText();
            if ( message.equals(brcCodes.get(code))) count ++;
            if(selectYes.isDisplayed() && selectNo.isDisplayed()) count2++;
            click(selectNo);
            click(doneButton);
            clickNewPayee();
        }
        for (String code : agencyBrcCodes){
            populateFraudWarningUser();
            populateHRCodeRef(code);
            click(makePaymentButton);
            try {
                if (agencyMainMessage.isDisplayed()) count3 ++;

            }catch (Exception e){
                if (agencySideMessage.isDisplayed())count3 ++;
            }
            if(selectYes.isDisplayed() && selectNo.isDisplayed()) count4++;
            click(selectNo);
            click(doneButton);
            clickNewPayee();
        }
        boolean two = count3 == 5 && count4 == 5;
        boolean one = count == 2 && count2 == 2;

        return one && two;
    }
    public boolean fraudSelectYes() {
        addBrcCodes();
        String[] chapsBrcCodes = {"H55", "H56"};
        int count = 0;
        int count2 = 0;
        navigateToPaymentpage();
        for (String code : chapsBrcCodes) {
            populateFraudWarningUser();
            populateHRCodeRef(code);
            click(makePaymentButton);
            click(selectYes);
            if (fraudYesMessage.isDisplayed())count ++;
            click(doneButton);
            if(availableBalance.isDisplayed())count2++;
            clickPaymentTab();
            clickNewPayee();
        }
        return count == 2 && count2 == 2;
    }
    public boolean agencyMainSelectYes() {
        addBrcCodes();
        String[] agencyBrcCodes = {"003","004","005","006"};
        int count = 0;
        int count2 = 0;
        navigateToPaymentpage();
        for (String code : agencyBrcCodes) {
            populateFraudWarningUser();
            populateHRCodeRef(code);
            click(makePaymentButton);
            click(selectYes);
            if (agencySuccessMainMsg.isDisplayed())count ++;
            click(doneButton);
            if(availableBalance.isDisplayed())count2++;
            clickPaymentTab();
            clickNewPayee();
        }
        return count == 4 && count2 == 4;
    }
    public boolean agencySideSelectYes(){
        addBrcCodes();
        navigateToPaymentpage();
        populateFraudWarningUser();
        populateHRCodeRef("008");
        click(makePaymentButton);
        click(selectYes);
        boolean one = agencySuccessSideMsg.isDisplayed();
        click(doneButton);
        boolean two = availableBalance.isDisplayed();

        return one && two;
    }

    public boolean agencyOtheSelectYes() {
        addBrcCodes();
        String[] agencyBrcCodes = {"000","001","007"};
        int count = 0;
        int count2 = 0;
        navigateToPaymentpageAsUser("ONETRANUSER","TESTPASSWORD");
        for (String code : agencyBrcCodes) {
            writeText(payeeName, "Fraud Success");
            writeNumber(payeeSortCode, 177456);
            writeNumber(payeeAccNumber, 44444377);
            clickContinue();
            populateHRCodeRef(code);
            click(makePaymentButton);
            if (supressSuccessMessage.isDisplayed())count ++;
            click(doneButton);
            if(availableBalance.isDisplayed())count2++;
            clickPaymentTab();
            clickNewPayee();
        }
        return count == 3 && count2 == 3;
    }
    public boolean payNewSpinner(){
        navigateToSuccessScreen();
        return isSpinnerShowing();
    }
    public boolean payChapsSpinner(){
        navigateToPaymentpage();
        populateChapsWarningUser();
        populateHRCodeRef("H58");
        click(makePaymentButton);
        click(selectYes);
        boolean one = isSpinnerShowing();
        clickDone();
        click(paymentsTab);
        clickNewPayee();
        return one;
    }
    public boolean payBacsSpinner(){
        populateBacsWarningUser();
        populateHRCodeRef("H59");
        click(makePaymentButton);
        click(selectYes);
        boolean one = isSpinnerShowing();
        clickDone();
        click(paymentsTab);
        clickNewPayee();
        return one;
    }
    public boolean payDuplicateSpinner(){
        populateDuplicateWarningUser();
        populateHRCodeRef("HE7");
        click(makePaymentButton);
        click(selectYes);
        boolean one = isSpinnerShowing();
        clickDone();
        click(paymentsTab);
        clickNewPayee();
        return one;
    }
    public boolean payFraudSpinner(){
        populateFraudWarningUser();
        populateHRCodeRef("003");
        click(makePaymentButton);
        click(selectYes);
        boolean one = isSpinnerShowing();
        clickDone();
        click(paymentsTab);
        clickNewPayee();
        return one;
    }
    public boolean payFailureSpinner(){
        populateInvalidUser();
        populateHRCodeRef("H91");
        click(makePaymentButton);
        return isSpinnerShowing();
    }


}
