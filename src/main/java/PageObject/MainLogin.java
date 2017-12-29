package PageObject;

import GUI.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
public class MainLogin extends Base{


    public MainLogin(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//input[@name='username']")  WebElement userName;
    @FindBy(xpath="//input[@name='domain']")    WebElement domain;
    @FindBy(xpath="//input[@name='password']")  WebElement password;
    @FindBy(xpath = "//button[@name='login']")  WebElement loginButton;
    @FindBy(xpath="//ul[@class='nav navbar-nav']") WebElement topMenu;
    @FindAll(@FindBy(xpath="//div[@class='navbar-left ng-scope']/ul/li/a/span[1]"))List<WebElement> navLeftBar;

    public WebElement getTopMenu() { return topMenu; }
    public List<WebElement> getNavLeftBar() {return navLeftBar;}
    public WebElement getUserName() { return userName;  }
    public WebElement getDomain()   { return domain; }
    public WebElement getPassword() {return password;}
    public WebElement getLoginButton() { return loginButton; }
    public WebElement navigateElement(String navigate){ return ListOfString(navLeftBar,navigate);  }

}
