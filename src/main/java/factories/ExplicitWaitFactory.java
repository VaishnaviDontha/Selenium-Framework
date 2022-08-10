package factories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.FrameworkConstants;
import driver.DriverManager;
import enums.WaitStrategy;

public class ExplicitWaitFactory {

    public static WebElement performingExplicitWait(WaitStrategy waitStrategy, By by) {

        WebElement element = null;

        if (waitStrategy == WaitStrategy.CLICKABLE) {
            
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.getExplicitwait()));
            element = wait.until(ExpectedConditions.elementToBeClickable(by));
        
        } else if (waitStrategy == WaitStrategy.PRESENCE) {
            
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.getExplicitwait()));
            element = wait.until(ExpectedConditions.presenceOfElementLocated(by));

        } else if (waitStrategy == WaitStrategy.VISIBLE) {

            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.getExplicitwait()));
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            
        }else if (waitStrategy == WaitStrategy.NONE) {

            element = DriverManager.getDriver().findElement(by);
            
        }

        return element;

    }

}
