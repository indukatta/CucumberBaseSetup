package pageObjects.More;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GuiCommands;

public class CardLostOrStolen extends GuiCommands {

    public CardLostOrStolen(IOSDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private CardsManagement cardsManagement = new CardsManagement(driver);

    @iOSFindBy(accessibility = "CardPlaceholder")
    private MobileElement cardImage;

    @iOSFindBy(accessibility = "You're about to report the following card as lost or stolen")
    private MobileElement reportLostStolenTitle;

    @iOSFindBy(accessibility = "Once confirmed your old card will be cancelled and a new card will be sent to your correspondence address.")
    private MobileElement reportLostStolenInstruction;

    @iOSFindBy(accessibility = "cards.button.continue")
    private MobileElement cardsContinueButton;

    @iOSFindBy(accessibility = "cards.button.something_wrong_contact_support")
    private MobileElement contactSupportButton;

    @iOSFindBy(accessibility = "Card management")
    private MobileElement cancelReoprtLostStolen;

    public boolean isCardImageDisplayed(){
        return cardImage.isDisplayed();
    }

    public boolean navigateToReportLostOrStolenScreen(){
        cardsManagement.navigateToCardLostOrStolen();
        return reportLostStolenTitle.isDisplayed();
    }

    public boolean reportLostStolenScreen(){
        cardsManagement.navigateToCardLostOrStolen();
        boolean one = isCardImageDisplayed();
        boolean two = reportLostStolenTitle.isDisplayed();
        boolean three = reportLostStolenInstruction.isDisplayed();
        boolean four = cardsContinueButton.isDisplayed();
        boolean five = contactSupportButton.isDisplayed();
        boolean six = cancelReoprtLostStolen.isDisplayed();
        click(cancelReoprtLostStolen);
        boolean seven = cardsManagement.isTitleDisplayed();

        return one && two && three && four && five && six && seven;
    }

    public boolean continueButton(){
        cardsManagement.navigateToCardLostOrStolen();
        boolean one = cardsContinueButton.isDisplayed();
        boolean two = cardsContinueButton.isEnabled();

        return one && two;
    }

    public void navigateToCardLostStolenFurtherInfo(){
        cardsManagement.navigateToCardLostOrStolen();
        click(cardsContinueButton);
    }
}
