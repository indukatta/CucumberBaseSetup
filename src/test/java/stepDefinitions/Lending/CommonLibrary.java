package stepDefinitions.Lending;

import static com.factory.mobile.driver.MobileDriverManager.*;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import pageObjects.Login.Login;
import pageObjects.More.More;

public class CommonLibrary {
	public static boolean alreadyLoggedIn = false;
	public static IOSDriver<MobileElement> driver;
	
	public CommonLibrary() {
		driver = (IOSDriver<MobileElement>) getAppiumDriverInstance();
	}

	public static String loginErrorCancel;

	public void functionNotImplemented() {
		System.out.println(Thread.currentThread().getStackTrace()[2].getMethodName() + " is not implemented yet.");
		reportInfo(Thread.currentThread().getStackTrace()[2].getMethodName() + " is not implemented yet.");
	}

	public void loginAndOpenCreditAndSelectScreen() {
		Login login = new Login(driver);
		login.loginAsUser("TESTUSER", "TESTPASSWORD");
		More more = new More(driver);
		more.navigateToCreditAndLending();
	}
	public void sleep(int seconds) {
		try {
//			System.out.println("Waiting for "+seconds+" seconds ...");
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
