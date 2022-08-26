package pages;

import org.openqa.selenium.By;

import enums.WaitStrategy;

public final class OrangeHRMHomePage extends BasePage {

    private final By linkWelcome = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
    private final By linkLogout = By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]/a");

    public OrangeHRMHomePage clickWelcome() {

        click(linkWelcome, WaitStrategy.CLICKABLE);
        return this;

    }

    public OrangeHRMLoginPage clickLogout() {

        click(linkLogout, WaitStrategy.CLICKABLE);
        return new OrangeHRMLoginPage();

    }

}
