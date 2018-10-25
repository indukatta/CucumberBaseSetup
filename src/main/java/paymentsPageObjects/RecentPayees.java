package paymentsPageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import pageObjects.Login.Login;
import utils.GuiCommands;

public class RecentPayees extends GuiCommands {

    Login login = new Login(driver);
    AvailableBalance availableBalance = new AvailableBalance(driver);
    public RecentPayees(IOSDriver driver) {
        super(driver);
    }

    @iOSFindBy(accessibility = "payments.recent_payees_section_header_title")
    private MobileElement recentPayeeTitle;

    @iOSFindBy(accessibility = "John Smith")
    private MobileElement firstPayeeName;

    @iOSFindBy(accessibility = "11-22-33")
    private MobileElement firstPayeeSortCode;

    @iOSFindBy(accessibility = "99887799")
    private MobileElement firstPayeeAccNum;

    @iOSFindBy(accessibility = "payment_details.amount_textfield_header")
    private MobileElement amountField;

    @iOSFindBy(accessibility = "payment_details.reference_textfield_header")
    private MobileElement referenceField;

    @iOSFindBy(accessibility = "payments.continue_button_title")
    private MobileElement continueButton;

    @iOSFindBy(accessibility = "balanceViewTitle")
    private MobileElement availableBalanceLabel;


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

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"John Smith\"]")
    private MobileElement headerTitle;

    @iOSFindBy (accessibility = "tab_bar.payments_title")
    private MobileElement paymentsTab;

    @iOSFindBy(accessibility = "payment_confirmation.make_payment_button_title")
    private MobileElement makePaymentButton;

    String currentAvailBal;


    //Custom Methods

    public void navigateToPaymentTab(){
        login.navigateToLogin();
        currentAvailBal = availableBalanceLabel.getText();
        click(paymentsTab);
    }

    public void  getPayeeInfo(){
       // String name = driver.findElementByClassName("XCUIElementTypeCell");
    }
    //Test Methods

    public boolean recentSectionVerification(){
        navigateToPaymentTab();
        boolean one = recentPayeeTitle.isDisplayed() ;
        boolean two = driver.findElementByAccessibilityId("11-22-33").isDisplayed()
                && driver.findElementByAccessibilityId("99887799").isDisplayed();

        return one && two;
    }
    public boolean noRecentPayee(){
        login.loginAsUser("NOTRANSACTIONUSER","NOTRANSACTIONPASSWORD");
        click(paymentsTab);
        boolean one;
        try {
            one = !recentPayeeTitle.isDisplayed();

        }catch (Exception e){
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
        click(continueButton);
        boolean one = summaryAccNum.isDisplayed() && summarySortCode.isDisplayed() && summaryReference.isDisplayed();
        click(summaryBB);
        boolean two = referenceField.getText().equalsIgnoreCase("office rent");
        click(continueButton);
        click(cancelButton);
        boolean three = recentPayeeTitle.isDisplayed() ;
        click(firstPayeeName);
        boolean four = amountField.getText().isEmpty();

        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
        System.out.println(four);


        return one && two && three && four;
    }
    public boolean payRecentSpinner(){
        navigateToPaymentTab();
        driver.findElementByAccessibilityId("Valid User").click();
        writeNumber(amountField,100);
        click(continueButton);
        click(makePaymentButton);

        return availableBalance.isSpinnerShowing();
    }
    public boolean selectPayee(){
        navigateToPaymentTab();
        click(firstPayeeName);
        boolean one = headerTitle.isDisplayed();
        boolean two;
        try {
            two = !cancelButton.isDisplayed();
        }catch (Exception e){
        two = true;}
         boolean three = driver.findElementByName("Available balance: "+currentAvailBal).isEnabled();
        writeNumber(amountField,22);
        click(paymentBB);
        click(firstPayeeName);
        boolean four = !amountField.getText().equals("22");

        return one && two && three && four;
        }
    }

