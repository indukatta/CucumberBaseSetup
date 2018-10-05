package pageObjects.More;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import testData.RandomDataGenerator;
import utils.GuiCommands;

public class ActivateCard extends GuiCommands {

    private CardsManagement cardsManagement = new CardsManagement(driver);
    private RandomDataGenerator generator = new RandomDataGenerator();

    public ActivateCard(IOSDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSFindBy(accessibility = "activate_card.textfield.card_number")
    private MobileElement cardNumberTextbox;

    @iOSFindBy(accessibility = "activate_card.textfield.expiry_date")
    private MobileElement expiryDateTextbox;

    @iOSFindBy(accessibility = "activate_card.button.primary_cta")
    private MobileElement activateCardButton;

    @iOSFindBy(accessibility = "activate_card.button.secondary_cta")
    private MobileElement contactSupportButton;

    @iOSFindBy(accessibility = "Cancel")
    private MobileElement cancelButton;

    @iOSFindBy(accessibility = "activate_card.label.footer")
    private MobileElement contactlessMessage;

    @iOSFindBy(accessibility = "Incorrect details entered")
    private MobileElement errorMessage;

    @iOSFindBy(accessibility = "Select All")
    private MobileElement selectAll;

    @iOSFindBy(accessibility = "Cut")
    private MobileElement cut;

    public boolean activateACardScreen(){
        cardsManagement.navigateToActivateCard();
        boolean one  = cardNumberTextbox.isDisplayed();
        boolean two = expiryDateTextbox.isDisplayed();
        boolean three  = contactSupportButton.isDisplayed();
        boolean four = contactlessMessage.isDisplayed();
        boolean five = cancelButton.isDisplayed();
        boolean six = activateCardButton.isDisplayed();
        return one && two && three && four && five && six;
    }

    public boolean positiveEntryIntoCardNumberField(){
        cardsManagement.navigateToActivateCard();
        click(cardNumberTextbox);
        boolean one = doesKeyboardExist();
        boolean two;
        writeText(cardNumberTextbox, "4532507073978721");
        try {
            two = !errorMessage.isDisplayed();
        } catch (NoSuchElementException e){
            two = true;
        }
        return one && two;
    }

    public boolean negativeEntryIntoCardTextField(){
        cardsManagement.navigateToActivateCard();
        writeText(cardNumberTextbox, generator.setRandomValue(15, "NUMERIC"));
        click(expiryDateTextbox);
        boolean one = errorMessage.isDisplayed();
        click(cardNumberTextbox);
        click(cardNumberTextbox);
        click(selectAll);
        click(cut);

        writeText(cardNumberTextbox, "1111111111111111");
        click(expiryDateTextbox);
        click(cardNumberTextbox);
        System.out.println(cardNumberTextbox.getAttribute("value"));
        click(expiryDateTextbox);
        boolean two = errorMessage.isDisplayed();

        click(cardNumberTextbox);
        click(cardNumberTextbox);
        click(selectAll);
        click(cut);
        String num = generator.setRandomValue(15, "NUMERIC");
        writeText(cardNumberTextbox,  num + "01");
        System.out.println(readAttribute(cardNumberTextbox, "value"));
        boolean three = readAttribute(cardNumberTextbox, "value").equalsIgnoreCase(num + "0");

        return one && two && three;
    }

    public boolean expiryDatePositive(){
        cardsManagement.navigateToActivateCard();
        writeText(expiryDateTextbox, "1225");
        click(cardNumberTextbox);
        try {
            return !errorMessage.isDisplayed();
        } catch (NoSuchElementException e){
            return true;
        }
    }

    public boolean expiryDateNegative(){
        cardsManagement.navigateToActivateCard();
        writeText(expiryDateTextbox, "1525");
        click(cardNumberTextbox);
        //check month cannot be greater than 12
        boolean monthLong;
        try {
            monthLong = errorMessage.isDisplayed();
        } catch (NoSuchElementException e){
            monthLong = false;
        }

        cardsManagement.navigateToActivateCard();
        writeText(expiryDateTextbox, "0025");
        click(cardNumberTextbox);
        // check month cannot be zero
        boolean monthShort;
        try {
            monthShort = errorMessage.isDisplayed();
        } catch (NoSuchElementException e){
            monthShort = false;
        }

        clearText(expiryDateTextbox);
        writeText(expiryDateTextbox, "1215");
        click(cardNumberTextbox);
        //check year cannot be past
        boolean year;
        try {
            year = errorMessage.isDisplayed();
        } catch (NoSuchElementException e){
            year = false;
        }

        return monthShort && monthLong && year;
    }

    public boolean continueButton(){
        cardsManagement.navigateToActivateCard();
        boolean one = !activateCardButton.isEnabled();

        writeText(cardNumberTextbox, "4532507073978721");
        boolean two = !activateCardButton.isEnabled();
        clearText(cardNumberTextbox);

        writeText(expiryDateTextbox, "1225");
        boolean three = !activateCardButton.isEnabled();
        clearText(cardNumberTextbox);

        writeText(cardNumberTextbox, "4532507073978721");
        writeText(expiryDateTextbox, "1225");
        boolean four = activateCardButton.isEnabled();

        return one && two && three && four;
    }

    public boolean cancelButton(){
        cardsManagement.navigateToActivateCard();
        click(cancelButton);
        return cardsManagement.isTitleDisplayed();
    }
}
