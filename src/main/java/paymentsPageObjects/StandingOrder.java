package paymentsPageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.openqa.selenium.NoSuchElementException;
import utils.GuiCommands;

import javax.swing.plaf.synth.SynthToggleButtonUI;
import java.util.concurrent.TimeUnit;

public class StandingOrder extends GuiCommands {

    DirectDebit directDebit = new DirectDebit(driver);

    public StandingOrder(IOSDriver driver) {
        super(driver);
    }

    @iOSFindBy(accessibility = "payments.view_scheduled_payments")
    private MobileElement viewSPayments;

    @iOSFindBy(accessibility = "direct_debits.tab_bar_title")
    private MobileElement dDTab;

    @iOSFindBy(accessibility = "standing_orders.tab_bar_title")
    private MobileElement sOTab;

    @iOSFindBy(accessibility = "Scheduled payments")
    private MobileElement scheduledPayTitle;

    @iOSFindBy(accessibility = "activity_indicator")
    private MobileElement spinner;

    @iOSFindBy(accessibility = "standing_orders.table.header")
    private MobileElement upcomingTitle;

    // CustomMethods

    public void navigateToStandingOrder(){
        directDebit.navigateToDDScreen();
        clickSOTab();
    }
    public void navigateToSOAsUser(String user,String pass){
        directDebit.navigateToDDScreenAsUser(user,pass);
        clickSOTab();
    }
    public boolean isSpinnerDisplayed(){
        try {
            return spinner.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }
    //Click Methods

    public void clickSOTab(){click(sOTab);}

    // Test Methods

    public boolean manageScheduleIsDisplayed(){
        directDebit.navigateToDDScreen();
        boolean one = directDebit.isRecentDisplayed();
        boolean two = dDTab.isDisplayed() && sOTab.isDisplayed();
        boolean three = sOTab.getLocation().toString().equals("(197, 74)");

        return one && two && three;

    }
    public boolean switchTabVerification(){
        directDebit.navigateToDDScreen();
        boolean one = directDebit.isRecentDisplayed();
        clickSOTab();
        boolean two = !directDebit.isRecentDisplayed();
        click(dDTab);
        boolean three = directDebit.isRecentDisplayed();

        return one && two && three;
    }
    public boolean scheduleHeaderIsDisplayed(){
        navigateToStandingOrder();
        return scheduledPayTitle.isDisplayed();
    }
    public boolean refreshCheck(){
        directDebit.navigateToDDScreen();
        boolean one = isSpinnerDisplayed();
        directDebit.isRecentDisplayed();
        clickSOTab();
        boolean two = isSpinnerDisplayed();
        upcomingTitle.isDisplayed();
        click(dDTab);
        boolean three = !isSpinnerDisplayed();
        directDebit.clickFRecentDD();
        directDebit.clickDetailsBB();
        boolean four = !isSpinnerDisplayed();
        directDebit.clickDirectDebitsBB();
        directDebit.clickViewSPayements();
        boolean five = isSpinnerDisplayed();

        return one && two && three && four && five;
    }

}
