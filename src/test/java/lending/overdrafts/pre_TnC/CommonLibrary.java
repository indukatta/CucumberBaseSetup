package lending.overdrafts.pre_TnC;

import static com.factory.mobile.driver.AppiumDriverManager.*;
import static com.factory.services.wrapper.RestAssuredManager.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import pageObjects.More.More;

public class CommonLibrary {
	public static IOSDriver<MobileElement> driver;
	public static boolean alreadyLoggedIn = false;
	public static boolean deleteApplication = true;
	public static String categoryName = "";
	public static More more = null;

	public void functionNotImplemented() {
		System.out.println(Thread.currentThread().getStackTrace()[2].getMethodName() + " is not implemented yet.");
		reportInfo(Thread.currentThread().getStackTrace()[2].getMethodName() + " is not implemented yet.");
	}

	public static void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void deleteLendingApplications() throws Throwable {
		httpGet("product-categories", false);
		List<Object> appIds = getValueFromJSON("data/applications/id");
		System.out.println("Current Application ID: " + appIds);
		for (Object appId : appIds) {
			Map<String, Object> reqParam = new HashMap<String, Object>();
			reqParam.put("applicationId", appId);
			httpPost("consents", "consents", reqParam, false);
		}
	}
}
