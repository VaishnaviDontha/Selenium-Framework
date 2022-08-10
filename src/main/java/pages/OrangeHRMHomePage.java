package pages;

import org.openqa.selenium.By;

import enums.WaitStrategy;

public final class OrangeHRMHomePage extends BasePage {

    private final By linkWelcome = By.xpath("//a[@id='welcome']");
    private final By linkLogout = By.xpath("//div[@id = 'welcome-menu']/ul/li[3]/a");

    public OrangeHRMHomePage clickWelcome() {

        click(linkWelcome, WaitStrategy.CLICKABLE);
        return this;

    }

    public OrangeHRMLoginPage clickLogout() {

        click(linkLogout, WaitStrategy.CLICKABLE);
        return new OrangeHRMLoginPage();

    }

}
