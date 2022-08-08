package driver;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import constants.FrameworkConstants;
import utilities.ReadingPropertyFile;

public final class Driver {

    protected Driver() {

    }

    public static void initDriver() throws Exception {

        if ( DriverManager.getDriver() == null) {
            System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
            WebDriver driver = new ChromeDriver();

            DriverManager.setDriver(driver);
            DriverManager.getDriver().get(ReadingPropertyFile.getValue("url"));
        }

    }

    public static final void quitDriver() {

        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }

}
