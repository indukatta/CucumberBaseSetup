package cucumberRunner;

import static com.factory.mobile.driver.AppiumDriverManager.closeApplication;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "feature-files/"
		, glue = "lending/"
//		, tags = {"@FinalOffer"}
//		, tags = {"@BusinessPremisesOptions"}
		, dryRun=true, tags = {"@UserDecline"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	@BeforeSuite
	public void setup() throws Exception {
//		launchMobileApplication(AppType.IOSAPP, "0.0.0.0:4723");
	}
	@AfterSuite
	public void teardown() {
		closeApplication();
	}
	
	public static void main1(String[] args) {
		String s = Thread.currentThread().getStackTrace()[1].getClassName();
		String[] r = StringUtils.capitalize(s).split("(?=\\p{Upper})");
		System.out.println(r.length);
		String cp = String.join("", r).toString();
		System.out.println(cp);
		System.out.println(cp.lastIndexOf("."));
		System.out.println(String.join("", r));
	}
}
