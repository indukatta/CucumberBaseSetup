package stepDefinitions.Lending;

import static com.factory.mobile.driver.MobileDriverManager.*;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import pageObjects.Login.Login;
import pageObjects.More.More;

public class CommonLibrary {
	public static boolean alreadyLoggedIn = false;
	public static boolean onScreen = false;
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
		if (!alreadyLoggedIn) {
			Login login = new Login(driver);
			login.loginAsUser("TESTUSER", "TESTPASSWORD");
			alreadyLoggedIn = true;
		}else {
			reportPass("User is already logged in to Iceberg application.");
		}
		More more = new More(driver);
		more.navigateToCreditAndLending();
		sleep(3000);
		captureScreenshot("ProductSelection");
	}
	public static void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
