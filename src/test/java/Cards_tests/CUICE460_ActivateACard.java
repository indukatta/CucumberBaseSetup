package Cards_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.More.ActivateCard;
import testUtils.Base_test;

public class CUICE460_ActivateACard extends Base_test {

    private ActivateCard card;

    @BeforeMethod
    public void beforeMethod() {
        card = new ActivateCard(driver);
    }

    @Test(priority = 1, description = "Activate a card screen")
    public void CUICE6628(){
        Assert.assertTrue(card.activateACardScreen());
    }

    @Test(priority = 2, description = "Card Number screen, positive")
    public void CUICE6629(){
        Assert.assertTrue(card.positiveEntryIntoCardNumberField());
    }

    @Test(priority = 3, description = "Card Number screen, negative")
    public void CUICE6678(){
        Assert.assertTrue(card.negativeEntryIntoCardTextField());
    }

    @Test(priority = 4, description = "Expiry Date Field, positive")
    public void CUICE6630(){
        Assert.assertTrue(card.expiryDatePositive());
    }

    @Test(priority = 5, description = "Expiry Date Field, negative")
    public void CUICE6679(){
        Assert.assertTrue(card.expiryDateNegative());
    }

    @Test(priority = 6, description = "Continue Button")
    public void CUICE6631(){
        Assert.assertTrue(card.continueButton());
    }

    @Test(priority = 7, description = "Cancel Button")
    public void CUICE6632(){
        Assert.assertTrue(card.cancelButton());
    }
}
