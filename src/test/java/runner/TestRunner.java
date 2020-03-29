package runner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import manager.FileReaderManager;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
        "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
        "html:target/cucumber-reports"},features = { "src\\test\\resources\\featureFiles\\Heathrow.feature" },glue = {
        "stepdefinition"},monochrome = true,tags = {"@test","~@bar"}
        )
public class TestRunner  {
        @AfterClass
        public static void writeExtentReport() {
                Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
        }
}
