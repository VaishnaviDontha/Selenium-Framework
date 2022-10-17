package tests;

import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import driver.DriverManager;

import static org.assertj.core.api.Assertions.*;
import static org.testng.Assert.*; 

public final class HomePageTests extends BaseTest {

    private HomePageTests() {
    }


    /*
     * Validating Title contains Google Search or google search
     * Validating Title isn't NULL and title length < 15 & > 100
     * Validating links in the page 
     * No# of links displayed is 10 / 15
     */

    @Test
    public void Test() throws Exception {


        DriverManager.getDriver().findElement(By.name("q")).sendKeys("The Internet Herokuapp", Keys.ENTER);
        String title = DriverManager.getDriver().getTitle();
        assertTrue(Objects.nonNull(title));
        assertTrue(title.toLowerCase().contains("google search")); 
        assertTrue(title.length()>15);
        assertTrue(title.length()<100);
        
        List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//h3[text()='The Internet Herokuapp']"));
        assertEquals(elements.size(), 1);

        boolean isElementPresent = false;
        for (WebElement webElement : elements) {
            if (webElement.getText().equalsIgnoreCase("The Internet Herokuapp")) {
                 isElementPresent = true;
            }
        }

        Assert.assertTrue(isElementPresent, "Element not found");

    }

    @Test
    public void TestsUsingAssertJ() throws Exception {

        DriverManager.getDriver().findElement(By.name("q")).sendKeys("The Internet Herokuapp", Keys.ENTER);
        String title = DriverManager.getDriver().getTitle();

        assertThat(title)
                  .isNotBlank()
                  .isNotEmpty()
                  .containsIgnoringCase("Google Search");
        
        assertThat(title.length())
                  .isLessThanOrEqualTo(100)
                  .isGreaterThan(15);        

    }


}
