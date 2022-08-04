package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest{

    @Test
    public void Test() {

        driver.findElement(By.name("q")).sendKeys("Rest Assured Automation", Keys.ENTER);
        
    }
    
}
