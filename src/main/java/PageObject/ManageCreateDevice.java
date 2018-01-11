package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ManageCreateDevice extends Manage {

    public ManageCreateDevice(WebDriver driver){
        super(driver);
    }



    @FindBy(xpath="//ng-form[@name='forms.general']/div[1]/div[1]/div[1]") WebElement enableMultiple;
    @FindBy(xpath = "//ng-form[@name='forms.general']/div[1]/div[2]/div[1]") WebElement sanDiskName;
    @FindAll(@FindBy(xpath = "//ng-form[@name='forms.general']/div[1]/div[5]/div[1]/label")) List<WebElement> lunTypes;

    public WebElement getEnableMultiple() {
        return enableMultiple;
    }
    public WebElement getSanDiskName() {
        return sanDiskName;
    }
    public List<WebElement> getLunTypes() {
        return lunTypes;
    }
}

