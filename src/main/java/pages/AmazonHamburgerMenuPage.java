package pages;

import org.openqa.selenium.By;

import enums.WaitStrategy;
import utilities.DynamicXpathUtils;

public final class AmazonHamburgerMenuPage extends BasePage{

    /*@FindBy(xpath = "//div[text()='Electronics']/parent :: a")
    private WebElement linkMobileAndComputers;

     @FindBy(xpath = "//ul[@class='hmenu hmenu-visible hmenu-translateX']//a[@class='hmenu-item'][normalize-space()='Headphones']")
    private WebElement linkHeadphones;

    @FindBy(xpath = "//ul[@class='hmenu hmenu-visible hmenu-translateX']//a[@class='hmenu-item'][normalize-space()='Video Games']")
    private WebElement linkVideoGames;

    @FindBy(xpath = "//ul[@class='hmenu hmenu-visible hmenu-translateX']//a[@class='hmenu-item'][normalize-space()='Bluetooth & Wireless Speakers']")
    private WebElement linkBluetoothWirelessSpeakers;*/

    private String linkElectronics = "//div[text()='Electronics']/parent :: a";
    private String linkSubMenu = "//ul[@class='hmenu hmenu-visible hmenu-translateX']//a[@class='hmenu-item'][normalize-space()='%s']";

    public AmazonHamburgerMenuPage clickElectonics()  {
        click(By.xpath(linkElectronics), WaitStrategy.CLICKABLE, "Electonics");
        return this;
    }
    public AmazonHeadphonesPage clickOnSubMenuItem(String menutext)  {

        String newXpath = DynamicXpathUtils.getXpath(linkSubMenu, menutext);
        click(By.xpath(newXpath),WaitStrategy.CLICKABLE,menutext);

        if (menutext.contains("Headphones")) {
                 return new AmazonHeadphonesPage();           
        }
        return null;
    }

    /*public AmazonHamburgerMenuPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    

    public AmazonHamburgerMenuPage clickHeadphones() {
        linkHeadphones.click();
        return this;      
    

    public AmazonHamburgerMenuPage clickVideoGames() {
        linkVideoGames.click();
        return this;      
    } 

    public AmazonHamburgerMenuPage clickBluetoothWirelessSpeakers() {
        linkBluetoothWirelessSpeakers.click();
        return this;      
    }*/

}
