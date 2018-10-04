package Cards_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.More.CardLostOrStolen;
import pageObjects.More.CardsManagement;
import testUtils.Base_test;

public class CUICE452_ReportACardLostOrStolen extends Base_test {

    private CardsManagement Cards;
    private CardLostOrStolen cardLostOrStolen;

    @BeforeMethod
    public void beforeMethod() throws Exception {
        Cards = new CardsManagement(driver);
        cardLostOrStolen = new CardLostOrStolen(driver);
    }

    @Test(priority = 1, description = "Card Activation menu Option")
    public void CUICE6455() {
        Assert.assertTrue(Cards.cardManagmentScreenHasReportLostStolen());
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

}