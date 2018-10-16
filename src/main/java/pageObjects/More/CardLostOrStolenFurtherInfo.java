package pageObjects.More;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GuiCommands;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class CardLostOrStolenFurtherInfo extends GuiCommands {

    private CardLostOrStolen cardLostOrStolen = new CardLostOrStolen(driver);
    private CardsManagement cardsManagement = new CardsManagement(driver);

    public CardLostOrStolenFurtherInfo(IOSDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSFindBy(accessibility = "Tell us what happened, we are here to help.")
    private MobileElement titleMessage;

    @iOSFindBy(accessibility = "report_lost_card.what_happened_to_your_card")
    private MobileElement whatHappenedYourCardMessage;

    @iOSFindBy(accessibility = "Lost")
    private MobileElement lostButton;

    @iOSFindBy(accessibility = "Stolen")
    private MobileElement stolenButton;

    @iOSFindBy(accessibility = "report_lost_card.when_did_you_last_see_your_card")
    private MobileElement cardLastSeenTextfield;

    @iOSFindBy(accessibility = "report_lost_card.has_your_pin_been_compromised")
    private MobileElement hasPinBeenCompromisedField;

    @iOSFindBy(accessibility = "Yes")
    private MobileElement pinCompromisedYes;

    @iOSFindBy(accessibility = "No")
    private MobileElement pinCompromisedNo;

    @iOSFindBy(accessibility = "cards.button.report_and_cancel")
    private MobileElement reportAndCancelButton;

    @iOSFindBy(accessibility = "cards.button.contact_support")
    private MobileElement contactSupportButton;

    @iOSFindBy(accessibility = "Cancel")
    private MobileElement cancelButton;

    @iOSFindBy(accessibility = "toolbar_done")
    private MobileElement dateDone;

    public boolean verifyFurtherInformationScreen(){
        cardLostOrStolen.navigateToCardLostStolenFurtherInfo();
        boolean one = titleMessage.isDisplayed();
        boolean two = whatHappenedYourCardMessage.isDisplayed();
        boolean three = cardLastSeenTextfield.isDisplayed();
        boolean four = hasPinBeenCompromisedField.isDisplayed();
        boolean five = reportAndCancelButton.isDisplayed();
        boolean six  = contactSupportButton.isDisplayed();

        click(cancelButton);
        boolean seven = cardsManagement.isTitleDisplayed();
        return one && two && three && four && five && six && seven;
    }

    public boolean verifyWhatHappenedYourCardScreen(){
        cardLostOrStolen.navigateToCardLostStolenFurtherInfo();
        boolean one = lostButton.isDisplayed();
        boolean two = stolenButton.isDisplayed();

        click(lostButton);
        boolean three = readAttribute(lostButton, "value").equals("1");
        boolean four  = readAttribute(stolenButton, "value") == null;

        click(stolenButton);
        boolean five = readAttribute(lostButton, "value") == null;
        boolean six  = readAttribute(stolenButton, "value").equals("1");

        return one && two && three && four && five && six;
    }

    public boolean verifyWhenYouLastSawCard(){
        cardLostOrStolen.navigateToCardLostStolenFurtherInfo();
        String pastDate = "12/June/1989";
        String[] pastDateArray = pastDate.split("/");

        HashMap<String, String> pastDateMap = new HashMap<>();
        pastDateMap.put("day", pastDateArray[0]);
        pastDateMap.put("month", pastDateArray[1]);
        pastDateMap.put("year", pastDateArray[2]);
        IosDatePickerWheel(pastDateMap, cardLastSeenTextfield);

        boolean one = readText(cardLastSeenTextfield).equalsIgnoreCase("12/06/1989");//FIXME: Shouldn't be hard coded

        click(dateDone);

        String futureDate = "12/June/2025";
        String[] futureDateArray = futureDate.split("/");

        HashMap<String, String> futureDateMap = new HashMap<>();
        futureDateMap.put("day", futureDateArray[0]);
        futureDateMap.put("month", futureDateArray[1]);
        futureDateMap.put("year", futureDateArray[2]);
        IosDatePickerWheel(futureDateMap, cardLastSeenTextfield);

        click(dateDone);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();

        boolean two = readText(cardLastSeenTextfield).equalsIgnoreCase(dtf.format(localDate));

        return one && two;
    }

    public boolean verifyHasPinBeenCompromisedSelection(){
        cardLostOrStolen.navigateToCardLostStolenFurtherInfo();
        boolean one = pinCompromisedYes.isDisplayed();
        boolean two = pinCompromisedNo.isDisplayed();

        click(pinCompromisedYes);
        boolean three = readAttribute(pinCompromisedYes, "value").equals("1");
        boolean four  = readAttribute(pinCompromisedNo, "value") == null;

        click(pinCompromisedNo);
        boolean five = readAttribute(pinCompromisedYes, "value") == null;
        boolean six  = readAttribute(pinCompromisedNo, "value").equals("1");

        return one && two && three && four && five && six;
    }

    public boolean verifyReportAndCancelButton(){
        cardLostOrStolen.navigateToCardLostStolenFurtherInfo();
        boolean one = !reportAndCancelButton.isEnabled();
        click(lostButton);
        click(cardLastSeenTextfield);
        click(dateDone);
        click(pinCompromisedNo);
        boolean two = reportAndCancelButton.isEnabled();

        return one && two;
    }
}
