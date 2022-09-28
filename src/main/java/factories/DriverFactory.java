// package factories;

// import java.net.MalformedURLException;
// import java.net.URL;

// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.remote.BrowserType;
// import org.openqa.selenium.remote.DesiredCapabilities;
// import org.openqa.selenium.remote.RemoteWebDriver;

// import enums.ConfigProperties;
// import io.github.bonigarcia.wdm.WebDriverManager;
// import utilities.PropertyUtils;

// public class DriverFactory {


//     private DriverFactory(){}

//     public static WebDriver getDriver(String browser,String version) throws Exception {

// 		WebDriver driver=null;

// 		String runmode = PropertyUtils.get(ConfigProperties.RUNMODE);
// 		if(browser.equalsIgnoreCase("chrome")) {
// 			if(runmode.equalsIgnoreCase("remote")) {
// 				DesiredCapabilities cap = new DesiredCapabilities();
// 				cap.setBrowserName(BrowserType.CHROME);
// 				cap.setVersion(version);
// 				driver =new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)), cap);
// 			}
// 			else {
// 				WebDriverManager.chromedriver().setup();
// 				driver = new ChromeDriver();
// 			}
// 		}
// 		else if(browser.equalsIgnoreCase("firefox")) {

// 			if(runmode.equalsIgnoreCase("remote")) {
// 				DesiredCapabilities cap = new DesiredCapabilities();
// 				cap.setBrowserName(BrowserType.FIREFOX);
// 				cap.setVersion(version);
// 				driver =new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)), cap);
// 			} else {
// 				WebDriverManager.firefoxdriver().setup();
// 				driver = new FirefoxDriver();
// 			}
// 		}
// 		return driver;
// 	}

// }
