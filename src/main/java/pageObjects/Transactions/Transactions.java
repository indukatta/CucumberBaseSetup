package pageObjects.Transactions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import pageObjects.Login.Login;
import utils.GuiCommands;

public class Transactions extends GuiCommands {
    public Transactions(IOSDriver driver) {
        super(driver);
    }

    Login Login = new Login(driver);

    @iOSFindBy(accessibility = "welcome.title")
    private MobileElement welcomeTitle;
}


/*
    //Elements Displayed
    public boolean isaccountTitleDisplayed() {
        return accountTitle.isDisplayed();
    }

    //Click Methods
    public void clickexistingCustomerButton() {
        click(existingCustomerButton);
    }

    // Custom Methods
    public boolean cardReportLost() {
        Login.passThroughLogin();

        return iserrorMessageDisplayed();
    }
}
*/
