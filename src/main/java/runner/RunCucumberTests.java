package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import static helper.Constants.CUCUMBER_FEATURE;

@CucumberOptions(
        features = CUCUMBER_FEATURE,
        plugin = { "pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        glue = { "helper", "stepdefinitions", "runner", "pagaobjects"}
)
public class RunCucumberTests extends AbstractTestNGCucumberTests {

}