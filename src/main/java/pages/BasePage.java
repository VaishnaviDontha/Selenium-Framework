package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import driver.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;

public class BasePage {

    protected void click(By by, WaitStrategy waitStrategy) {

        WebElement element = ExplicitWaitFactory.performingExplicitWait(waitStrategy, by);
        element.click();

    }

    protected void sendKeys(By by, String value, WaitStrategy waitStrategy) {

        WebElement element = ExplicitWaitFactory.performingExplicitWait(waitStrategy, by);
        element.sendKeys(value);

    }

    protected String getPageTitle() {

        return DriverManager.getDriver().getTitle();

    }

}
