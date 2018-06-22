package pageObjects;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Onboarding_Welcome_screen extends Page {

    @FindBy(name = "Yes, I am a new customer")
    private MobileElement newCustomer;

    @FindBy(name = "I am an existing customer")
    private MobileElement existingCustomer;

    public Onboarding_Welcome_screen(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void newCustomer(){
        click(newCustomer);
    }

    public void existingCustomer(){
        click(existingCustomer);
    }
}
