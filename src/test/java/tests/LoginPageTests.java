package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import driver.Driver;
import driver.DriverManager;

public final class LoginPageTests extends BaseTest {

    private LoginPageTests() {

    }

    @Test
    public void Test() throws Exception {

        Driver.initDriver();
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Selenium Automation", Keys.ENTER);

    }

    @Test
    public void Test2() throws Exception {

        Driver.initDriver();
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Selenium Automation", Keys.ENTER);

    }


}
