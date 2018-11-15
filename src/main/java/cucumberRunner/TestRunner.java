package cucumberRunner;

import static com.factory.mobile.driver.MobileDriverManager.closeApplication;
import static com.factory.mobile.driver.MobileDriverManager.launchIOSApplication;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "feature-files/"
		, glue = "stepDefinitions.Lending/"
		, tags = "@productDetails"
//		, dryRun=true
)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	@BeforeSuite
	public void setup() throws Exception {
		System.out.println("TestRunner-Setup");
		launchIOSApplication("0.0.0.0:4723");
	}

	@AfterSuite
	public void teardown() {
		closeApplication();
	}
	
	public static void main(String[] args) {
		String s = "thisIsMyString";
		String[] r = StringUtils.capitalize(s).split("(?=\\p{Upper})");
		System.out.println(r.length);
		System.out.println(String.join(" ", r));
	}
}
