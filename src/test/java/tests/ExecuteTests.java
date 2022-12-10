package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class ExecuteTests {


    @Test
    public void localTest1(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        System.out.println("Title is : " + driver.getTitle());    
    }


    // @Test
    // public void localTest2() throws MalformedURLException {
    //     DesiredCapabilities cap = new DesiredCapabilities();
    //     cap.setCapability(CapabilityType.BROWSER_NAME, "chrome");
    //     WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
    //     driver.get("https://google.com");
    //     System.out.println("Title is : " + driver.getTitle());
    //     Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
    //     driver.quit();
    // }
    
}
