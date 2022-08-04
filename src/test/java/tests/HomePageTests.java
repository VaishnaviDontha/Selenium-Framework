package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import driver.Driver;
import driver.DriverManager;

public final class HomePageTests extends BaseTest {

    protected HomePageTests() {
    }

    @Test
    public void Test() {

        Driver.initDriver();
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Rest Assured Automation", Keys.ENTER);

    }

}
