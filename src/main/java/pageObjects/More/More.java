package pageObjects.More;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Login.Login;
import utils.GuiCommands;

public class More extends GuiCommands {

    public More(IOSDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSFindBy(accessibility = "More")
    private MobileElement moreButton;

    @iOSFindBy(accessibility = "more.cell_title.details")
    private MobileElement detailsButton;

    @iOSFindBy(accessibility = "more.cell_title.accounts")
    private MobileElement accountsButton;

    @iOSFindBy(accessibility = "more.cell_title.card_management")
    private MobileElement cardManagmentButton;

    @iOSFindBy(accessibility = "Credit & Lending")
    private MobileElement creditAndLendingButton;

    public void navigateToCardManagement(){
        click(moreButton);
        click(cardManagmentButton);
    }

    public void navigateToCreditAndLending(){
        click(moreButton);
        click(creditAndLendingButton);
    }
    
}

