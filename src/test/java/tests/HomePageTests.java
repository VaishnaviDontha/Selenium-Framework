package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import driver.Driver;
import driver.DriverManager;

public final class HomePageTests extends BaseTest {

    private HomePageTests() {
    }

    @Test
    public void Test() throws Exception {

        Driver.initDriver();
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Rest Assured Automation", Keys.ENTER);

    }

}
