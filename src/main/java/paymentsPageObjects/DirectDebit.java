package paymentsPageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import pageObjects.Login.Login;
import utils.GuiCommands;

import java.security.cert.X509Certificate;

public class DirectDebit extends GuiCommands {

    Login login = new Login(driver);

    public DirectDebit(IOSDriver driver) {
        super(driver);
    }


    @iOSFindBy(accessibility = "payments.view_scheduled_payments")
    private MobileElement viewSPayments;

    @iOSFindBy(accessibility = "Payments")
    private MobileElement directDebitBB;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Direct debits\"]")
    private MobileElement directDebitTitle;

    @iOSFindBy(accessibility = "direct_debits.table.header")
    private MobileElement recentDirectDebits;

    @iOSFindBy(accessibility = "You have no direct debits.")
    private MobileElement noDDTitle;

    @iOSFindBy(accessibility = "A Direct Debit is an agreement between your bank and a third party " +
            "to take money from your account on a recurring series of dates, usually to pay for bills.")
    private MobileElement noDDMessage;

    @iOSFindBy(accessibility = "direct_debits.table.load_more")
    private MobileElement loadMoreBtn;

    @iOSFindBy(accessibility = "direct_debits.table.footer")
    private MobileElement infomativeText;

    @iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"topLeftLabel\"])[199]")
    private MobileElement lastDD;

    @iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"topLeftLabel\"])[1]")
    private MobileElement firstDD;

    @iOSFindBy (accessibility = "tab_bar.payments_title")
    private MobileElement paymentsTab;

    @iOSFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Payments\"]")
    private MobileElement paymentsTitle;

    @iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"topLeftLabel\"])[2]")
    private MobileElement merchantName;

    @iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"bottomLeftLabel\"])[1]")
    private MobileElement paymentCategrory;

    @iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"bottomRightLabel\"])[1]")
    private MobileElement lastPaymentField;

    @iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"topRightLabel\"])[1]")
    private MobileElement dDPaymentAmount;

    @iOSFindBy(accessibility = "There may be some direct debits missing. Please try again later.")
    private MobileElement networkErrMessage;

    @iOSFindBy(accessibility = "alertWarning")
    private MobileElement alertImage;

    @iOSFindBy(accessibility = "There may be some direct debits missing.")
    private MobileElement failureMessage;

    @iOSFindBy(accessibility = "Allow")
    private MobileElement allowButton;

    @iOSFindBy(accessibility = "Don’t Allow")
    private MobileElement dontAllowButton;

    @iOSFindBy(accessibility = "Support chat")
    private MobileElement supportChatTitle;

    @iOSFindBy(accessibility = "Close")
    private MobileElement closeSupportChat;

    @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Iceberg\"]/XCUIElementTypeWindow[1]/" +
            "XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther" +
            "/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther" +
            "/XCUIElementTypeOther[1]/XCUIElementTypeButton")
    private MobileElement contactSupportBtn;

    @iOSFindBy(accessibility = "direct_debit_details.cancel")
    private MobileElement cancelDDButton;

    // Custom Methods

    public void navigateToDDScreen(String user, String pass){
        login.differentUserLogin(user,pass);
        click(paymentsTab);
        click(viewSPayments);
    }

    // Test Methods

    public boolean emptyState(){
        navigateToDDScreen("NOTRANSACTIONUSER","NOTRANSACTIONPASSWORD");
        boolean one = noDDMessage.isDisplayed();

        return one;
    }
    public boolean BBValidation(){
        navigateToDDScreen("TESTUSER","TESTPASSWORD");
        click(directDebitBB);
        boolean one = paymentsTitle.isDisplayed();

        return one;
    }
    public boolean isInformativeTextShown(){
        navigateToDDScreen("TESTUSER","TESTPASSWORD");
        boolean one = infomativeText.isDisplayed();

        return one;
    }
    public boolean displayDD(){
        navigateToDDScreen("TESTUSER","TESTPASSWORD");
        boolean one = recentDirectDebits.isDisplayed();
        boolean two = dDPaymentAmount.getText().matches("^(\\d{1,3},)?\\d{1,3}.\\d{2} GBP$");
        boolean three = merchantName.getText().matches(".*");
        boolean four = lastPaymentField.getText().matches("^Last payment on\\s+[a-zA-Z]{3}\\s+\\d{2}$");
        boolean five = paymentCategrory.getText().equals("Direct Debit");
        
        return one && two && three && four && five;
    }
    public boolean isFailureErrMsgDisplayed(){
        navigateToDDScreen("THREETRANUSER","TESTPASSWORD");
        boolean one = failureMessage.isEnabled() && noDDMessage.isDisplayed();
        System.out.println(one);
        click(contactSupportBtn);
        click(allowButton);
        boolean two = supportChatTitle.isDisplayed();

        return one && two;
    }
    public boolean isNetworkErrMsgDisplayed(){
        navigateToDDScreen("TWOTRANUSER","TESTPASSWORD");
        boolean one = networkErrMessage.isDisplayed() && alertImage.isDisplayed() && noDDMessage.isDisplayed();
        boolean two = alertImage.getLocation().toString().equals("(16, 76)");

        return one && two;
    }
}
