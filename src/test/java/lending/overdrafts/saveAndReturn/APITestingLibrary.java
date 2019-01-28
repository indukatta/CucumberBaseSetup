package lending.overdrafts.saveAndReturn;

import static com.factory.mobile.driver.AppiumDriverManager.setStepName;
import static com.factory.services.wrapper.RestAssuredManager.*;
import static com.factory.services.wrapper.RestAssuredManager.httpGet;
import static com.factory.services.wrapper.RestAssuredManager.verifyResponseFileEqualsTo;

import static com.factory.services.wrapper.RestAssuredManager.getLastValueFromJSON;
import cucumber.api.java.en.Then;

public class APITestingLibrary {
	
	Object applicationID = "";
	
	@Then("^call rest end point \"([^\"]*)\" to get application id from \"([^\"]*)\" and save$")
	public void call_rest_end_point_to_get_application_id_from_and_store(String endPoint, String jPath) {
		setStepName("Then");
		httpGet(endPoint, true);
		applicationID = getLastValueFromJSON(jPath);
		System.out.println("applicationID: "+applicationID);
	}
	
	@Then("^user call rest end point \"([^\"]*)\" to get and save the response$")
	public void user_call_rest_end_point_to_toget_and_store_the_response(String endPoint) {
		setStepName("Then");
		httpGet("product-categories", false);
		applicationID = getLastValueFromJSON("data/applications/id");
		System.out.println("applicationID: "+applicationID);
		httpGet(endPoint, "applicationID", applicationID.toString(), true);
	}
	
	@Then("^verify that expected json \"([^\"]*)\" is equals to \"([^\"]*)\" except \"([^\"]*)\" key$")
	public void verify_that_expected_json_file_is_equal_to_end_point_response(String jsonFile, String jsonPath, String except) throws Throwable {
		setStepName("Then");
//		verifyResponseFileEqualsTo("jsonArrayTest", "data/application/answers", "dateModified");
		verifyResponseFileEqualsTo(jsonFile, jsonPath, except);
	}

}
