package Cards_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Login.Login;
import pageObjects.More.ActivateCard;
import pageObjects.More.CardsManagement;
import pageObjects.Overview.Overview;
import testData.getUserData.GetUserData;
import testUtils.Base_test;

public class CUICE460_ActivateACard extends Base_test {

    private Login login;
    private ActivateCard card;
    private CardsManagement management;
    private Overview overview;

    @BeforeMethod
    public void beforeMethod() {
        card = new ActivateCard(driver);
        management = new CardsManagement(driver);
        overview = new Overview(driver);

        login = new Login(driver);
        login.loginAsUser(GetUserData.getFirstTimeUser().get("Username").toString(), GetUserData.getFirstTimeUser().get("Password").toString());
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

    @Test(priority = 8, description = "Card Activation Success")
    public void CUICE6602(){
        Assert.assertTrue(card.successfulCardActivation());
    }

    @Test(priority = 9, description = "Incorrect Card Details")
    public void CUICE6604(){
        Assert.assertTrue(card.incorrectCardDetails());
    }

    @Test(priority = 10, description = "Card Already Activated")
    public void CUICE6605(){
        Assert.assertTrue(card.cardAlreadyActivated());
    }

    @Test(priority = 11, description = "Non Live Card Activation Attempt")
    public void CUICE6606(){
        Assert.assertTrue(card.cardNotLive());
    }

    @Test(priority = 12, description = "Card Activation Fail (Timeout)")
    public void CUICE6607(){
        Assert.assertTrue(card.cardActivationTimeout());
    }

    @Test(priority = 13, description = "Card Activation Prompt")
    public void CUICE6512(){
        Assert.assertTrue(overview.isActivateCardBannerDisplayed());
        Assert.assertTrue(card.activateCardTitleDisplayed());
    }

    @Test(priority = 14, description = "Remove Card Activation Prompt - activate from banner")
    public void CUICE6562(){
        Assert.assertTrue(overview.activateCardBannerRemovedAfterActivation());
    }

    @Test(priority = 15, description = "Card Activation Menu Option")
    public void CUICE6564() {
        Assert.assertTrue(management.cardManagmentScreenHasActivateCard());
        Assert.assertTrue(card.activateCardTitleDisplayed());
    }

    @Test(priority = 16, description = "Remove Card Activation Prompt - activate from card management")
    public void CUICE6936(){

    }
}
