package paymentsPageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import pageObjects.Login.Login;
import utils.GuiCommands;

import java.lang.management.MonitorInfo;
import java.util.NoSuchElementException;

public class RecentPayees extends GuiCommands {

    Login login = new Login(driver);
    public RecentPayees(IOSDriver driver) {
        super(driver);
    }

    @iOSFindBy(xpath = "(//XCUIElementTypeOther[@name=\"RECENT PAYEES\"])[2]") // FIXME
    private MobileElement recentPayeeTitle;

    @iOSFindBy(accessibility = "John Smith")
    private MobileElement firstPayeeName;

    @iOSFindBy(accessibility = "11-22-33")
    private MobileElement firstPayeeSortCode;

    @iOSFindBy(accessibility = "99887799")
    private MobileElement firstPayeeAccNum;

    @iOSFindBy(xpath = "//XCUIElementTypeTextField[@name=\"payment_details.amount_textfield_header\"]")
    private MobileElement amountField;

    @iOSFindBy(xpath = "//XCUIElementTypeTextField[@name=\"payment_details.reference_textfield_header\"]")
    private MobileElement referenceField;

    @iOSFindBy(accessibility = "payments.continue_button_title")
    private MobileElement continueButton;

    @iOSFindBy(accessibility = "Available balance: 1,055.02 GBP")
    private MobileElement availableBalance;

    @iOSFindBy(accessibility = "GBP")
    private MobileElement poundSign;

    @iOSFindBy(accessibility = "payment_confirmation.about_to_pay_label_value")
    private MobileElement paymentAmount;

    @iOSFindBy(accessibility = "to John Smith")
    private MobileElement payeeName;

    @iOSFindBy(accessibility = "payment_confirmation.sort_code_label_value")
    private MobileElement summarySortCode;

    @iOSFindBy(accessibility = "payment_confirmation.account_number_label_value")
    private MobileElement summaryAccNum;

    @iOSFindBy(accessibility = "payment_confirmation.reference_label_value")
    private MobileElement summaryReference;

    @iOSFindBy(accessibility = "payment_confirmation.confirm_payment_message")
    private MobileElement confirmationMessage;

    @iOSFindBy(accessibility = "payment_confirmation.make_payment_button_title")
    private MobileElement confirmButton;

    @iOSFindBy(accessibility = "Cancel")
    private MobileElement cancelButton;

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"John Smith\"]")
    private MobileElement summaryBB;

    @iOSFindBy(accessibility = "Payments")
    private MobileElement paymentBB;

    @iOSFindBy(xpath = "xpath\t//XCUIElementTypeStaticText[@name=\"John Smith\"]")
    private MobileElement headerTitle;

    @iOSFindBy (accessibility = "Payments")
    private MobileElement paymentsTab;


    //Custom Methods

    public void navigateToPaymentTab(){
        login.navigateToLogin();
        click(paymentsTab);
    }

    //Test Methods

    public boolean recentSectionVerification(){
        navigateToPaymentTab();

        boolean one = driver.findElementByName("RECENT PAYEES").isDisplayed() && headerTitle.isDisplayed();
        boolean two = firstPayeeSortCode.getText().equals("11-22-33") && firstPayeeAccNum.getText().equals("99887799");

        return one && two;
    }

    public boolean noRecentPayee(){
        login.differentUserLogin("NOTRANSACTIONUSER","NOTRANSACTIONPASSWORD");
        click(paymentsTab);
        boolean one;
        try {
            one = !recentPayeeTitle.isDisplayed();

        }catch (NoSuchElementException e){
            one = true;
        }

        return one;
    }
    public boolean referenceFieldCheck(){
        navigateToPaymentTab();
        click(firstPayeeName);
        boolean one = referenceField.getText().equalsIgnoreCase("office rent");

        return one;
    }
    public boolean summaryPageVerification(){
        navigateToPaymentTab();
        click(firstPayeeName);
        writeNumber(amountField,22);
        click(confirmButton);
        boolean one = summaryAccNum.isDisplayed() && summarySortCode.isDisplayed() && summaryReference.isDisplayed();///come back

        return one;
    }

    public boolean selectPayee(){
        navigateToPaymentTab();
        click(firstPayeeName);

        boolean one = headerTitle.getText().equals("John Smith");
        boolean two;
        try {
            two = !cancelButton.isDisplayed();
        }catch (NoSuchElementException e){
        two = true;}
         boolean three = availableBalance.isDisplayed();
        writeNumber(amountField,22);
        click(paymentBB);
        click(firstPayeeName);
        boolean four = !amountField.getText().equals("22");

        return one && two && three && four;
        }


    }

