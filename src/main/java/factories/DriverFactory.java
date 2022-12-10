package factories;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import enums.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.PropertyUtils;

public class DriverFactory {


    private DriverFactory(){}

    public static WebDriver getDriver(String browser) throws Exception {

		WebDriver driver=null;

		String runmode = PropertyUtils.get(ConfigProperties.RUNMODE);
		if(browser.equalsIgnoreCase("chrome")) {
			if(runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
				driver =new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			}
			else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
		}
		else if(browser.equalsIgnoreCase("firefox")) {

			if(runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(browser);
				driver =new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			} else {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		}
		return driver;
	}

}
