package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import static helpers.Constants.CUCUMBER_FEATURE;

@CucumberOptions(
        features = CUCUMBER_FEATURE,
        plugin = { "pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        glue = {"helpers", "stepdefinitions", "runner", "pageobjects"}
)
public class RunCucumberTests extends AbstractTestNGCucumberTests {

}