package lending.overdrafts.pre_TnC;

import static com.factory.mobile.driver.MobileDriverManager.*;
import static com.factory.services.wrapper.RestAssuredManager.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import pageObjects.Login.Login;
import pageObjects.More.More;

public class CommonLibrary {
	public static IOSDriver<MobileElement> driver;
	public static boolean alreadyLoggedIn = false;
	public static boolean onScreen = false;
	public static String loginErrorCancel;
	public static More more = null;

	public void functionNotImplemented() {
		System.out.println(Thread.currentThread().getStackTrace()[2].getMethodName() + " is not implemented yet.");
		reportInfo(Thread.currentThread().getStackTrace()[2].getMethodName() + " is not implemented yet.");
	}

	public void loginAndOpenCreditAndSelectScreen() {
		if (!alreadyLoggedIn) {
			driver = (IOSDriver<MobileElement>) getAppiumDriverInstance();
			Login login = new Login(driver);
			login.loginAsUser("TESTUSER", "TESTPASSWORD");
			alreadyLoggedIn = true;
		} else {
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

	public static void deleteAllLendingApplications() throws Throwable {
		httpGet("productCategories", false);
		List<Object> appIds = getValueFromJSON("data/applications/id");
		System.out.println("Current Application ID: " + appIds);
		for (Object appId : appIds) {
			Map<String, Object> reqParam = new HashMap<String, Object>();
			reqParam.put("applicationId", appId);
			httpPost("consents", "consents", reqParam, false);
		}
	}
}
