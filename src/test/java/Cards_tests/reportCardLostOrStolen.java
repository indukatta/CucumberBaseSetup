package Cards_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Cards.Cards;
import testUtils.Base_test;

public class reportCardLostOrStolen extends Base_test {

    private Cards Cards;

    @BeforeMethod
    public void beforeMethod() throws Exception {
        Cards = new Cards(driver);
    }

    @Test(priority = 1, description = "Report card lost or stolen")
    public void CUICE2065() {
        Assert.assertTrue(Cards.cardReportLost());
    }

}