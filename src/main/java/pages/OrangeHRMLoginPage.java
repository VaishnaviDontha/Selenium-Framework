package pages;

import org.openqa.selenium.By;

import enums.WaitStrategy;

public final class OrangeHRMLoginPage extends BasePage{

    private final By textboxUsername = By.name("username");
    private final By textboxPassword = By.xpath("//input[@name = 'password' and @type='password']");
    private final By buttonLogin = By.xpath("//button[@type='submit']");

    public OrangeHRMLoginPage enterUserName(String username) throws Exception {

        sendKeys(textboxUsername, username, WaitStrategy.PRESENCE, "Username");
        return this;

    }

    public OrangeHRMLoginPage enterPassword(String password) throws Exception {
        sendKeys(textboxPassword, password, WaitStrategy.PRESENCE, "Password");
        return this;
    }

    public OrangeHRMHomePage clickLogin() throws Exception {
        click(buttonLogin, WaitStrategy.CLICKABLE, "Login Button");
        return new OrangeHRMHomePage();

    }

    public String getTitle() {

        return getPageTitle();
        
    }


}
