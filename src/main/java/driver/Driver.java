package driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.Browser;
import constants.FrameworkConstants;
import enums.ConfigProperties;
import exceptions.BrowserInvocationFailedException;
import factories.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.PropertyUtils;

/**
 * 
 * Driver class - Initiating/Closing Browser
 * 
 * @author Vaishnavi
 * @version 1.0
 */

public final class Driver {

    protected Driver() {

    }

    /**
     * The initDriver function is used to initialize the driver.
     * 
     *
     * @param browser Determine which browser to use
     *
     * @return The driver object
     *
     * @docauthor Trelent
     */
    public static void initDriver(String browser) {

        String runmode = PropertyUtils.get(ConfigProperties.RUNMODE);

        if (Objects.isNull(DriverManager.getDriver())) {
            try {
                DriverManager.setDriver(DriverFactory.getDriver(browser));
            } catch (Exception e) {
                throw new BrowserInvocationFailedException("Please check the capabilities");
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
