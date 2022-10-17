package driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import constants.FrameworkConstants;
import enums.ConfigProperties;
import utilities.PropertyUtils;

public final class Driver {

    protected Driver() {

    }

    public static void initDriver(String browser) throws Exception {

        if (Objects.isNull(DriverManager.getDriver())) {

            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
                DriverManager.setDriver(new ChromeDriver());
            }

            else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", FrameworkConstants.getFirefoxdriverpath());
                DriverManager.setDriver(new FirefoxDriver());
            }

            DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
        }

    }

    public static final void quitDriver() {

        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }

}
