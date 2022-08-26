package driver;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import constants.FrameworkConstants;
import enums.ConfigProperties;
import utilities.ReadingPropertyFile;

public final class Driver {

    protected Driver() {

    }

    public static void initDriver() throws Exception {

        if ( DriverManager.getDriver() == null) {
            System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
            WebDriver driver = new ChromeDriver();

            DriverManager.setDriver(driver);
            // DriverManager.getDriver().get(ReadingPropertyFile.getValue(ConfigProperties.URL));
            DriverManager.getDriver().get("https://opensource-demo.orangehrmlive.com/");
        }

    }

    public static final void quitDriver() {

        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }

}
