package pageObjects.Overview;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import pageObjects.More.ActivateCard;
import utils.GuiCommands;

public class Overview extends GuiCommands {

    private ActivateCard card = new ActivateCard(driver);

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
        card.passThroughSuccessfulCardActivation();
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
