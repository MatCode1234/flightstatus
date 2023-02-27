package helpers;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

import static helpers.TestBase.driver;

public class Hooks {

    @BeforeAll
    public static void before_all() {
        TestBase tb = new TestBase();
        tb.setDriver();
    }

    @AfterAll
    public static void after_all(){
        driver.quit();
    }
}