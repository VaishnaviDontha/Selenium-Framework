package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import driver.Driver;

public final class LoginPageTests extends BaseTest {

    protected LoginPageTests() {

    }

    @Test
    public void Test() {

        // Driver.initDriver();
        Driver.driver.findElement(By.name("q")).sendKeys("Selenium Automation", Keys.ENTER);

    }

}
