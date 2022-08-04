package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import constants.FrameworkConstants;

public class Driver {

    public Driver() {
    }

    public static WebDriver driver;

    public static void initDriver() {

        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedriverpath());
            driver = new ChromeDriver();
            driver.get("https://google.com");
        }

    }

    public final static void quitDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
