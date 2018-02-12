package GUI;

import PageObject.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static Utility.FileRead.*;

public class LogFreestor extends Base{

    static WebDriver driver;

    @BeforeClass
    public void setUP() throws IOException {
        driver = getLocalDriver("Windows", "chrome");
        setUp(getfmsServer());
    }


    @Test
    public void loginToFreestor(){
        LoginPage hp = new LoginPage(driver);
        waitUntilVisible(hp.getUserName());
        hp.getUserName().sendKeys(getfmsUserName());
        hp.getPassword().sendKeys(getfmsPassword());
        if(getfmsDomain()!=null){
            System.out.println(getfmsDomain());
            hp.getDomain().sendKeys(getfmsDomain());
        }
        hp.getLoginButton().click();
    }

}
