package pageObjects.Cards;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import pageObjects.Login.Login;
import utils.GuiCommands;

public class Cards extends GuiCommands {
    public Cards(IOSDriver driver) {
        super(driver);
    }
        Login login = new Login(driver);

    @iOSFindBy(accessibility = "tab_bar.more_title")
    private MobileElement MoreButton;

    @iOSFindBy(accessibility = "Card management")
    private MobileElement cardManagementButton;

    @iOSFindBy(accessibility = "Report lost or stolen")
    private MobileElement reportLostAndStolenButton;

    @iOSFindBy(accessibility = "cards.button.continue")
    private MobileElement reportCardContinueButton;

// Custom Methods
   public boolean cardReportLost() {
       login.passThroughLogin();
       click(MoreButton);
       click(cardManagementButton);
       click(reportLostAndStolenButton);
       click(reportCardContinueButton);
       return reportCardContinueButton.isDisplayed();
   }
}

