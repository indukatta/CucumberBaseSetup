package lending.overdrafts.saveAndReturn;

import static com.factory.mobile.driver.MobileDriverManager.*;
import static com.factory.services.wrapper.RestAssuredManager.httpGet;
import static com.factory.services.wrapper.RestAssuredManager.httpPost;

import static com.factory.services.wrapper.RestAssuredManager.verifyResponseFileEqualsTo;
import static com.factory.services.wrapper.RestAssuredManager.getLastValueFromJSON;

import cucumber.api.java.en.Then;

public class SaveAndReturnPreTnC {
	String applicationID = "";

	@Then("^user call rest end point \"([^\"]*)\" to get and verify response$")
	public void user_call_rest_end_point_to_see_and_verify_response(String endPoint) {
		setStepName("Then");
		httpGet(endPoint);
//		httpPost("/1003056660/lending/consents", "consents");
	}

	@Then("^verify that expected json file \"([^\"]*)\" is equal to end point response$")
	public void verify_that_expected_json_file_is_equal_to_end_point_response(String jsonFile) throws Throwable {
		setStepName("Then");
//		verifyResponseFileEqualsTo("jsonArrayTest", "data/application/answers", "dateModified1");
		applicationID = getLastValueFromJSON("data/applications/id");
		System.out.println("Application ID: "+applicationID);
	}
}
