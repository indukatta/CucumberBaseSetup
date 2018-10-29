package pageObjects.More;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.GuiCommands;

public class ReviewTransactions extends GuiCommands {

    CardLostOrStolenFurtherInfo info = new CardLostOrStolenFurtherInfo(driver);

    public ReviewTransactions(IOSDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public int returnElements(){
        info.passToReviewTransactionsPage();
        return driver.findElements(By.name("sectionHeaderLabel")).size();
    }
}
