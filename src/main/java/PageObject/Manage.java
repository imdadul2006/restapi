package PageObject;

import GUI.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Manage extends Base {


    WebDriver driver;
    public Manage(WebDriver driver){this.driver = driver; PageFactory.initElements(driver,this); }

    @FindBy(xpath = "//ul[@class='nav nav-tabs']") WebElement middleBar;
    @FindBy(xpath = "//div[@class='panel-heading clearfix']/div[1]/div[1]/button[1]") WebElement create;

    //Find all item on second navigation tab
    @FindAll({@FindBy(xpath = "//ul[@class='nav nav-tabs']/li")})  public List<WebElement> navigationList;
    // Find all them on settings page
    @FindAll({@FindBy(xpath = "//div[@class='widget-item thumb']/following-sibling::div")})public List<WebElement> settingPageOptions;

    public WebElement getMiddleBar() { return middleBar;}
    public WebElement navigateElement(String navigate){return ListOfString(navigationList,navigate); }
    public WebElement navigateSetup(String navigate){ return ListOfString(settingPageOptions,navigate); }
    public WebElement getCreate() { return create; }
}
