package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GuiCommands;

public class SourceOfFunds extends GuiCommands {

    private PersonalDetailsForm personalDetailsForm = new PersonalDetailsForm(driver);

    public SourceOfFunds(IOSDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy (xpath = "//XCUIElementTypeTextField[@name=\"depositors.last_twelve_months_amount\"]")
    private MobileElement valueOfCashDepositorBox;

    @FindBy (xpath = "//XCUIElementTypeTextField[@name=\"depositors.depositors_total_amount.header\"]")
    private MobileElement totalDepositMoneyBox;

    @FindBy (name = "depositors.depositors_count_textfield.header")
    private MobileElement numberOfDepositors;

    @FindBy (name = "depositors.add_depositor_details.buttonTitle")
    private MobileElement depositorDetailButton;

    @FindBy (name = "Ff Gg")
    private MobileElement depositorDetail;

    @FindBy (name = "next_button_default_title")
    private  MobileElement nextButton;


    public void navigateToSourceOfFunds(){

        personalDetailsForm.passThroughPersonalDetailsForm();
    }

}



