package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import driver.DriverManager;

public final class LoginPageTests extends BaseTest {

    private LoginPageTests() {

    }

    @Test
    public void Test() {

        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Selenium Automation", Keys.ENTER);

    }

    @Test
    public void Test2() {

        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Selenium Automation", Keys.ENTER);

    }


}
