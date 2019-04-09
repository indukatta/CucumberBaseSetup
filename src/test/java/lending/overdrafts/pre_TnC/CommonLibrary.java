package lending.overdrafts.pre_TnC;

import static com.factory.data.manager.Database.fetchSingleValue;
import static com.factory.data.manager.Database.updateTable;
import static com.factory.mobile.driver.AppiumDriverManager.*;
import static com.factory.services.wrapper.RestAssuredManager.*;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import pageObjects.More.More;

public class CommonLibrary {
	public static Map<String, String> persistentValue = new HashMap<String, String>();
	public static IOSDriver<MobileElement> driver;
	public static boolean alreadyLoggedIn = false;
	public static boolean deleteApplication = true;
	public static String applicationID = "";
	public static String categoryName = "";
	public static More more = null;

	public CommonLibrary() {

	}

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

	public static String modifiedDate(int days) {
		LocalDateTime newDate = LocalDateTime.now().plusDays(days);
		String dateStr = newDate.getDayOfMonth() + " " + newDate.getMonth() + " " + newDate.getYear();
		Date date = new Date(dateStr);
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
		return sdf.format(date);
	}

	protected static String commaSeparatedNumber(String number) {
		DecimalFormat myFormatter = new DecimalFormat("#,###");
		if (!number.contains(",")) {
			number = myFormatter.format(Integer.parseInt(number));
		}
		return number;
	}

	protected static int convertToInteger(String number) {
		number = number.replace(",", "").replace(".00", "");
		return Integer.parseInt(number);
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

	public static void updateApplicationDate() {
		String pseDecision = fetchSingleValue(
				"select psedecision from application where id=(SELECT max(id) from application);");
		if (pseDecision != null && !pseDecision.equals("null")) {
			JSONObject pseDecisionObj = new JSONObject(pseDecision);
			String dateTime = pseDecisionObj.getString("datetime");
			String message = "update application set psedecision=replace(psedecision::TEXT,'\"" + dateTime
					+ "\"','\"2018-01-01T00:00:00.000Z\"')::json;";
			updateTable(message);
			reportPass(message);
		} else {
			String message = "update application set datemodified='2018-01-01 11:42:20.712+00';";
			updateTable(message);
			reportPass(message);
		}
	}
}
