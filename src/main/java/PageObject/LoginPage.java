package PageObject;

import GUI.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
public class LoginPage extends Base{


    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//input[@name='username']")  WebElement userName;
    @FindBy(xpath="//input[@name='domain']")    WebElement domain;
    @FindBy(xpath="//input[@name='password']")  WebElement password;
    @FindBy(xpath = "//button[@name='login']")  WebElement loginButton;

    public WebElement getUserName() { return userName;  }
    public WebElement getDomain()   { return domain; }
    public WebElement getPassword() {return password;}
    public WebElement getLoginButton() { return loginButton; }
}
