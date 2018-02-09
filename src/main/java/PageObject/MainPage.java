package PageObject;

import GUI.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends Base{


    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//ul[@class='nav navbar-nav']") WebElement topMenu;
    @FindAll(@FindBy(xpath="//div[@class='navbar-left ng-scope']/ul/li/a/span[1]"))List<WebElement> navLeftBar;

    public WebElement getTopMenu() { return topMenu; }
    public List<WebElement> getNavLeftBar() {return navLeftBar;}
    public WebElement navigateElement(String navigate){ return ListOfString(navLeftBar,navigate);  }

}

