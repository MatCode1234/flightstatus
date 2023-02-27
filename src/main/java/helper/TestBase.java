package helper;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static helper.Constants.MAC_CHROME_DRIVER;

public class TestBase {

    public static WebDriver driver;

    public void setDriver(){
        System.setProperty("webdriver.chrome.driver", MAC_CHROME_DRIVER);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }
}
