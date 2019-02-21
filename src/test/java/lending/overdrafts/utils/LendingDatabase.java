package lending.overdrafts.utils;

import static com.factory.mobile.driver.AppiumDriverManager.setStepName;
import static com.factory.data.manager.Database.*;
import cucumber.api.java.en.Then;
import lending.overdrafts.pre_TnC.CommonLibrary;

public class LendingDatabase extends CommonLibrary {

	@Then("^execute database query to get reset lending application$")
	public void execute_database_query_to_get_reset_lending_application() {
		setStepName("Then");
		applicationStatus = fetchSingleValue("select status from application where id=(SELECT max(id) from application);");
		System.out.println("application status: " + applicationStatus);
		if (applicationStatus.equals("open")) {
			updateTable(
					"UPDATE application set decision=null, answers=null, status='open' where id=(SELECT max(id) from application);");
		}
	}

}
