package pageObjects.More;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Login.Login;
import utils.GuiCommands;

public class CardsManagement extends GuiCommands {
    public CardsManagement(IOSDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private More more = new More(driver);

    @FindBy(name = "Card management")
    private MobileElement cardManagementTitle;

    @iOSFindBy(accessibility = "card_management.rows.report_lost_or_stolen")
    private MobileElement reportLostAndStolenButton;

    @iOSFindBy(accessibility = "CardPlaceholder")
    private MobileElement cardImage;

    @iOSFindBy(accessibility = "card_management.rows.replace_damage_or_broken")
    private MobileElement replaceDamagedOrStolenButton;

    @iOSFindBy(accessibility = "card_management.rows.activate_card")
    private MobileElement activateCardButton;

    public boolean isTitleDisplayed(){
        return cardManagementTitle.isDisplayed();
    }

   public boolean cardManagementScreenHasReportLostStolen() {
       more.navigateToCardManagement();
       boolean one = isTitleDisplayed();
       boolean two = reportLostAndStolenButton.isEnabled();
       return one && two;
   }

   public void navigateToCardLostOrStolen(){
       more.navigateToCardManagement();
       click(reportLostAndStolenButton);
   }

   public void navigateToActivateCard(){
        more.navigateToCardManagement();
        click(activateCardButton);
   }
}

