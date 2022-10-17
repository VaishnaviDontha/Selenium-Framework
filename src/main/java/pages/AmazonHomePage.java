package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.DriverManager;

public final class AmazonHomePage extends BasePage {

    @FindBy(xpath = "//i[@class='hm-icon nav-sprite']/parent::a")
    private WebElement linkHamburger;

    public AmazonHomePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public AmazonHamburgerMenuPage clickHamburger() {
        linkHamburger.click();
        return new AmazonHamburgerMenuPage();
    }

    // private String linkHamburger = "//a[@id='nav-hamburger-menu']";
    // public AmazonHamburgerMenuPage clickHamburgerIcon() throws Exception{
    //     click(By.xpath(linkHamburger), WaitStrategy.CLICKABLE, "Hamburger icon");
    //     return new AmazonHamburgerMenuPage();
    // }
}
