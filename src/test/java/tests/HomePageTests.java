package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import driver.Driver;

public final class HomePageTests extends BaseTest {

    protected HomePageTests() {
    }

    @Test
    public void Test() {

        // Driver.initDriver();
        Driver.driver.findElement(By.name("q")).sendKeys("Rest Assured Automation", Keys.ENTER);

    }

}
