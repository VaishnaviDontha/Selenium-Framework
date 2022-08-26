package pages;

import org.openqa.selenium.By;

import enums.WaitStrategy;

public final class OrangeHRMLoginPage extends BasePage{

    private final By textboxUsername = By.name("username");
    private final By textboxPassword = By.xpath("//input[@name = 'password' and @type='password']");
    private final By buttonLogin = By.xpath("//button[@type='submit']");

    public OrangeHRMLoginPage enterUserName(String username) {

        sendKeys(textboxUsername, username, WaitStrategy.PRESENCE);
        return this;

    }

    public OrangeHRMLoginPage enterPassword(String password) {
        sendKeys(textboxPassword, password, WaitStrategy.PRESENCE);
        return this;
    }

    public OrangeHRMHomePage clickLogin() {
        click(buttonLogin, WaitStrategy.CLICKABLE);
        return new OrangeHRMHomePage();

    }

    public String getTitle() {

        return getPageTitle();
        
    }


}
