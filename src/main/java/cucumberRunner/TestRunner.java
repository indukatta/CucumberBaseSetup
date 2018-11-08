package cucumberRunner;

import static com.factory.mobile.driver.MobileDriverManager.*;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "feature-files/"
		, glue = "pageObjects.Lending"
//		, tags = "@dryRun"
		, dryRun=true
		)
public class TestRunner extends AbstractTestNGCucumberTests {
	@BeforeSuite
	public void runSniff() {
		setupAutoExSel();
		startReports("sniffSuite");
	}
	@AfterSuite
	public void test() {
//		Object[] [] darr = features();
//		System.out.println(darr.length);
//		System.out.println(darr[0].length);
		endReports();
	}
}
