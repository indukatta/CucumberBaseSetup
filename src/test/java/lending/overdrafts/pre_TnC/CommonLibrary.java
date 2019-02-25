package lending.overdrafts.pre_TnC;

import static com.factory.data.manager.Database.fetchSingleValue;
import static com.factory.data.manager.Database.updateTable;
import static com.factory.data.manager.Database.closeDatabseConnection;
import static com.factory.mobile.driver.AppiumDriverManager.*;
import static com.factory.services.wrapper.RestAssuredManager.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import pageObjects.More.More;

public class CommonLibrary {
	public static Map<String, String> persistentValue = new HashMap<String, String>();
	public static IOSDriver<MobileElement> driver;
	public static boolean alreadyLoggedIn = false;
	public static boolean deleteApplication = true;
	public static String applicationStatus = "";
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
		for (Object appId : appIds) {
			Map<String, Object> reqParam = new HashMap<String, Object>();
			reqParam.put("applicationId", appId);
			httpPost("consents", "consents", reqParam, false);
		}
	}

	public static void setApplicationStatusTo(String status) {
		applicationStatus = fetchSingleValue(
				"select status from application where id=(SELECT max(id) from application);");
		if (applicationStatus.equals("open") && status.equalsIgnoreCase("open")) {
			updateTable(
					"UPDATE application set decision=null, answers=null, status='open' where id=(SELECT max(id) from application);");
		} else if (applicationStatus.equals("open")) {
			updateTable(
					"UPDATE application set decision=null, answers=null, status='closed' where id=(SELECT max(id) from application);");
		}
		closeDatabseConnection();
	}
}
