package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import constants.FrameworkConstants;

public class BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedriverpath());
        driver = new ChromeDriver();
        driver.get("https://google.com");

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();

    }

    
}
