package driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;

import constants.FrameworkConstants;
import enums.ConfigProperties;
import utilities.PropertyUtils;

public final class Driver {

    protected Driver() {

    }

    public static void initDriver() throws Exception {

        if (DriverManager.getDriver() == null) {

            // System.setProperty("webdriver.gecko.driver",
            // FrameworkConstants.getFirefoxdriverpath());
            // /*
            // * Using WebDriverManager
            // */

            // // WebDriverManager.chromedriver().setup();
            // // WebDriver driver = new ChromeDriver();

            // DriverManager.setDriver(new FirefoxDriver());
            // DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
            // //
            // DriverManager.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            if (Objects.isNull(DriverManager.getDriver())) {

                System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
                DriverManager.setDriver(new ChromeDriver());

                DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
            }
        }

    }

    public static final void quitDriver() {

        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }

}
