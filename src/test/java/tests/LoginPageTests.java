package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest{

    @Test
    public void Test() {

        driver.findElement(By.name("q")).sendKeys("Selenium Automation", Keys.ENTER);
        
    }
    
}
