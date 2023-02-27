package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static helper.Constant.HEADLESS_WINDOWS_SIZE;
import static helper.Constant.MAC_CHROME_DRIVER;

public class TestBase {

    public static WebDriver driver;

    public void setDriver(){
        System.setProperty("webdriver.chrome.driver", MAC_CHROME_DRIVER);
        ChromeOptions options=new ChromeOptions();
        options.setHeadless(true);
        options.addArguments(HEADLESS_WINDOWS_SIZE);
        options.addArguments("--user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36");
        driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }
}
