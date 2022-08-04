package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import driver.Driver;
import driver.DriverManager;

public final class LoginPageTests extends BaseTest {

    protected LoginPageTests() {

    }

    @Test
    public void Test() {

        Driver.initDriver();
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Selenium Automation", Keys.ENTER);

    }

}
