package paymentsPageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import pageObjects.Login.Login;
import utils.GuiCommands;

public class AccountsTab extends GuiCommands {

    Login login = new Login(driver);

    public AccountsTab (IOSDriver driver) {
        super(driver);
    }

    @iOSFindBy(accessibility = "Available balance")
    private MobileElement graphAvailableBalanceTitle;

    @iOSFindBy(accessibility = "tab_bar.overview_title")
    private MobileElement overviewTab;

    @iOSFindBy(accessibility = "tab_bar.transactions_title")
    private MobileElement accountsTab;

    @iOSFindBy(accessibility = "tab_bar.payments_title")
    private MobileElement paymentsTab;

    @iOSFindBy(accessibility = "tab_bar.support_title")
    private MobileElement supportTab;

    @iOSFindBy(accessibility = "tab_bar.more_title")
    private MobileElement moreTab;

    @iOSFindBy(accessibility = "transactions.no_transactions_title")
    private MobileElement noTrasactionTitle;

    @iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"transactions.no_transactions_sortcode_value\"])[1]")//FIXME
    private MobileElement noTransSortCode;

    @iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"transactions.no_transactions_sortcode_value\"])[2]") //FIXME
    private MobileElement noTransAccountNum;

    @iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"titleLabel\"])[18]")
    private MobileElement firstTransaction;

    @iOSFindBy(accessibility = "455.02 GBP")
    private MobileElement availableBalance; //FIXME

    @iOSFindBy(accessibility = "40-12-76 | 12768903") // FIXME
    private MobileElement sortCodeAndAccountNum;



    //Custom Methods

    //Test Methods

    public boolean emptyStateVerification(){
        login.differentUserLogin("NOTRANSACTIONUSER","NOTRANSACTIONPASSWORD");
       // click(accountsTab);
        boolean one = noTrasactionTitle.isDisplayed();
        boolean two = noTransSortCode.getText().equals("40-12-76");
        boolean three = noTransAccountNum.getText().equals("44444444");

        return one && two && three;
    }

    public boolean titleDisplayVerification(){
        login.navigateToLogin();
        boolean one = graphAvailableBalanceTitle.isDisplayed();
        boolean three = availableBalance.getText().equals("455.02 GBP");
       // boolean two = sortCodeAndAccountNum.equals("40-12-76 | 12768903"); // waiting for fix


        return one && three;
    }



}
