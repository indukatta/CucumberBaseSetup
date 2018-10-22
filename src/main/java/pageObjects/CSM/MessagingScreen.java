package pageObjects.CSM;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Login.Login;
import pageObjects.More.ActivateCard;
import pageObjects.Onboarding.SetUp;
import testData.RandomDataGenerator;
import utils.GuiCommands;

public class MessagingScreen extends GuiCommands {

    SupportScreen supportScreen = new SupportScreen(driver);
    ActivateCard activateCard = new ActivateCard(driver);


    public MessagingScreen(IOSDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSFindBy(accessibility = "cards.button.contact_support")
    private MobileElement contactSupportButton;

    @iOSFindBy(accessibility = "Close")
    private MobileElement closeScreenButton;

    @iOSFindBy(accessibility = "Menu")
    private MobileElement menu;

    @iOSFindBy(accessibility = "Now")
    private MobileElement timeOfFirstMessage;

    @iOSFindBy(accessibility = "Send")
    private MobileElement sendButton;

    @iOSFindBy(xpath = "//XCUIElementTypeTextView[@name=\"Write a message\"]]")//FIXME get unique accessibility id
    private MobileElement messagingText;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Write a message\"]")//FIXME get unique accessibility id
    private MobileElement messagingBox;

    @iOSFindBy(accessibility = "Allow")
    private MobileElement allowNotification;

    @iOSFindBy(accessibility = "Don’t Allow")
    private MobileElement dontAllowNotification;

    @iOSFindBy(accessibility = "Support chat")
    private MobileElement supportPageTitle;


    public void clickSendButton() {
        click(sendButton);
    }

    public void writeMessage(String message) {
        writeText(messagingText, message);
    }

    public boolean navigateToMessagingScreen() {
        supportScreen.passToMessageScreen();
        return messagingBox.isDisplayed();
    }

    public boolean writeToMessagingScreen() {
        navigateToMessagingScreen();
        writeMessage("I have lost my card");
        clickSendButton();
        return messagingBox.isDisplayed();
    }

//    public boolean contactSupportFromCards() {
//        activateCard.contactSupport();
//        click(allowNotification);
//        return supportPageTitle.isDisplayed();
//
//    }


//    public boolean contactSupportFromCardsReturningCustomer() {
//        contactSupportFromCards();
//        click(closeScreenButton);
//        click(contactSupportButton);
//        boolean one = false;//copy from here
//        try {
//            allowNotification.isDisplayed();//if change this to allow button .isDisplayed()
//        } catch (
//                NoSuchElementException e) {//this is the exception catch that passes the test
//            one = true;
//        }
//        return one;//till here, delete these comments after you have copied the code
//    }
//}
//






