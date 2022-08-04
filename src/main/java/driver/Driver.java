package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import constants.FrameworkConstants;

public final class Driver {

    protected Driver() {

    }

    private static WebDriver driver; 

    public static void initDriver() {

        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedriverpath());
            driver = new ChromeDriver();

            DriverManager.setDriver(driver);
            DriverManager.getDriver().get("https://google.com");
        }

    }

    public static final void quitDriver() {

        if (driver != null) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }

}
