package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Onboarding_Your_Business_Details extends Page {

    //FIX ME GET PROPER MOBILE ACCESSIBILITY NAME
    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"Your Business Details\"]")
    private MobileElement navigationBarTitle;

    @FindBy(name = "Continue")
    private MobileElement continueButton;

    public Onboarding_Your_Business_Details(AppiumDriver driver) {
        super(driver);
    }

    public String setNavigationBarTitle() {
        String title = navigationBarTitle.getText();
        return title;
    }

    public void setContinueButton() {
        click(continueButton);
    }
}
