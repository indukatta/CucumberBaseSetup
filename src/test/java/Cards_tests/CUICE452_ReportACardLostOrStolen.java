package Cards_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.More.CardLostOrStolen;
import pageObjects.More.CardLostOrStolenFurtherInfo;
import pageObjects.More.CardsManagement;
import testUtils.Base_test;

public class CUICE452_ReportACardLostOrStolen extends Base_test {

    private CardsManagement Cards;
    private CardLostOrStolen cardLostOrStolen;
    private CardLostOrStolenFurtherInfo info;

    @BeforeMethod
    public void beforeMethod() throws Exception {
        Cards = new CardsManagement(driver);
        cardLostOrStolen = new CardLostOrStolen(driver);
        info = new CardLostOrStolenFurtherInfo(driver);
    }

    @Test(priority = 1, description = "Card Activation menu Option")
    public void CUICE6455() {
        Assert.assertTrue(Cards.cardManagementScreenHasReportLostStolen());
        Assert.assertTrue(cardLostOrStolen.navigateToReportLostOrStolenScreen());
    }

    @Test(priority = 2, description = "Report Lost or Stolen screen")
    public void CUICE6460() {
        Assert.assertTrue(cardLostOrStolen.reportLostStolenScreen());
    }

    @Test(priority = 3, description = "Card Image Display")
    public void CUICE6461(){
        Assert.assertTrue(cardLostOrStolen.isCardImageDisplayed());
        //take card image screenshot
    }

    @Test(priority = 4, description = "Debit Card Lost or Stolen - Continue Button")
    public void CUICE6462(){
        Assert.assertTrue(cardLostOrStolen.continueButton());
    }

    @Test(priority = 5, description = "Report Lost Stolen Screen (Further Info)")
    public void CUICE6736(){
        Assert.assertTrue(info.verifyFurtherInformationScreen());
    }

    @Test(priority = 6, description = "What Happened to your card. Field")
    public void CUICE6737(){
        Assert.assertTrue(info.verifyWhatHappenedYourCardScreen());
    }

    @Test(priority = 7, description = "When did you last see your card")
    public void CUICE6738(){
        Assert.assertTrue(info.verifyWhenYouLastSawCard());
    }

    @Test(priority = 8, description = "Has your pin been compromised? Field")
    public void CUICE6739(){
        Assert.assertTrue(info.verifyHasPinBeenCompromisedSelection());
    }

    @Test(priority = 9, description = "Report and Cancel Button")
    public void CUICE6740(){
        Assert.assertTrue(info.verifyReportAndCancelButton());
    }
}