package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import driver.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import reports.ExtentLogger;

public class BasePage {

    protected void click(By by, WaitStrategy waitStrategy, String elementname) throws Exception {

        WebElement element = ExplicitWaitFactory.performingExplicitWait(waitStrategy, by);
        element.click();
        ExtentLogger.pass(elementname+ " is clicked", true);

    }

    protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementname) throws Exception {

        WebElement element = ExplicitWaitFactory.performingExplicitWait(waitStrategy, by);
        element.sendKeys(value);
        ExtentLogger.pass(value+ " is entered sucessfully in "+ elementname, true);

    }

    protected String getPageTitle() {

        return DriverManager.getDriver().getTitle();

    }

}
