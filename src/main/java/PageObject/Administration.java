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


}
