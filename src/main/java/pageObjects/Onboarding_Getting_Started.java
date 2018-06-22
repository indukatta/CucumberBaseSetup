package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Onboarding_Getting_Started extends Page {

    //Mobile Elements
    @FindBy(name = "App credentials")
    private MobileElement appCredentials;

    @FindBy(name = "About you & your business")
    private MobileElement aboutBusiness;

    @FindBy(name = "Financial Details")
    private MobileElement financialDetails;

    @FindBy(name = "Account & Card setup")
    private MobileElement accountSetup;

    //Constructor
    public Onboarding_Getting_Started(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void enterAppCredentials(){
        click(appCredentials);
    }

    public void enterAboutBusiness(){
        click(aboutBusiness);
    }

    public void enterFinancialDetails(){
        click(financialDetails);
    }

    public void enterAccountSetup(){
        click(accountSetup);
    }
}
