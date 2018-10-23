package pageObjects.Overview;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import pageObjects.More.ActivateCard;
import testData.cardsTestData.GetCardsTestData;
import utils.GuiCommands;

public class Overview extends GuiCommands {

    //private ActivateCard card = new ActivateCard(driver);

    public Overview(IOSDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSFindBy(accessibility = "tab_bar.overview_title")
    private MobileElement overviewButton;

    @iOSFindBy(accessibility = "overview.activateCard.banner.leftTitle")
    private MobileElement activateCardBanner;

    @iOSFindBy(accessibility = "ACTIVATE")
    private MobileElement activateButton;

    @iOSFindBy(accessibility = "activate_card.textfield.card_number")
    private MobileElement cardNumberTextbox;

    @iOSFindBy(accessibility = "activate_card.textfield.expiry_date")
    private MobileElement expiryDateTextbox;

    @iOSFindBy(accessibility = "activate_card.button.primary_cta")
    private MobileElement activateCardButton;

    @iOSFindBy(accessibility = "activate_card_progress_status.button.done")
    private MobileElement activatedDoneButton;

    public void navigateToOverviewPage(){
        click(overviewButton);
    }

    public void clickBanner(){
        click(activateCardBanner);
    }

    public boolean isActivateCardBannerDisplayed(){
        navigateToOverviewPage();
        boolean one = activateCardBanner.isDisplayed();
        return one;
    }

    public boolean activateCardBannerRemovedAfterActivation(){
        navigateToOverviewPage();
        click(activateCardBanner);
        writeText(cardNumberTextbox, GetCardsTestData.getSuccssfullCardNumber());
        writeText(expiryDateTextbox, "1225");
        click(activateCardButton);
        click(activatedDoneButton);
        click(overviewButton);
        boolean one = false;
        try {
            activateCardBanner.isDisplayed();
        } catch (NoSuchElementException e){
            one = true;
        }
        return one;
    }
}
