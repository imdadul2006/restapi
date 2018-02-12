package PageObject;

import GUI.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Administration extends Base {


    WebDriver driver;
    public Administration(WebDriver driver){this.driver = driver; PageFactory.initElements(driver,this); }

    @FindAll(@FindBy(xpath = "//div[@class='panel-heading clearfix']/div[1]/button")) List<WebElement> superadminOptions;
    @FindAll(@FindBy(xpath = "//div[@class='panel-heading clearfix']/div[1]/div[1]/button")) List<WebElement> serversSuperadminOptions;
    public WebElement serverSuperadminOp(int navigate){return ListSelectionByIndex(serversSuperadminOptions,navigate); }
    public WebElement superadminOp(int navigate){return ListSelectionByIndex(superadminOptions,navigate); }


    // This for Add Server Form

    @FindBy(xpath = "//input[@name='userName']") WebElement username;
    @FindBy(xpath = "//input[@name='ipAddress']") WebElement ipAddress;
    @FindBy(xpath = "//input[@name='passwd']") WebElement password;
    @FindBy(xpath = "//button[@type='submit']") WebElement addButton;
    @FindBy (css = ".modal-content.ui-resizable") WebElement modal;

    public WebElement getUsername() {   return username;   }
    public WebElement getIpAddress() {  return ipAddress;  }
    public WebElement getPassword() {   return password;   }

    public void addNewServer(String ipaddress, String username, String password ){
        serverSuperadminOp(0).click();   //Click the Add Icon first
        waitUntilVisible(modal);                  //Wait Until the modal Appear
        keysInput(getIpAddress(),ipaddress);      // type the ip address
        keysInput(getUsername(),username);        // type the username
        keysInput(getPassword(),password);        // type the password
        addButton.click();                        // click the submit button
        waitUntilDisappear(modal,30);    // wait until disappear
    }
}
