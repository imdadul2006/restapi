package GUI;

import PageObject.LoginPage;
import PageObject.MainPage;
import PageObject.Manage;
import Utility.FileRead;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

import static Utility.FileRead.*;

public class ManageTest extends Base {

    WebDriver driver;

    @BeforeClass
    public void setUP() throws IOException {
        driver = getLocalDriver("Windows", "chrome");
        setUp(getfmsServer());
    }

   // @Test
    public void Login() throws InterruptedException {
        loginToFreestor();
        MainPage hp = new MainPage(driver);
        waitUntilClickAble(hp.getTopMenu());
        hp.navigateElement("Manage").click();

        Manage man = new Manage(driver);
        waitUntilClickAble(man.getMiddleBar());
        man.serverSeletion("FSS-116").click();
        man.navigateElement("Settings").click();
        man.navigateSetup("Reboot").click();
        waitUntilVisible(man.getModalTitle());
        Actions action = new Actions(driver);

        if(man.getModalTitle().getText().contains("Reboot")){
            System.out.println(man.getModalTitle().getText());
            Thread.sleep(2000);
            action.moveToElement(man.getCancel()).contextClick().build().perform();
            action.moveToElement( man.getCancel()).click().build().perform();
        }

    }

    public void loginToFreestor(){
        LoginPage hp = new LoginPage(driver);
        hp.getUserName().sendKeys();
        hp.getPassword().sendKeys("freestor");
        hp.getLoginButton().click();
    }

 //   @AfterClass
    public void clean(){
        //driver.close();
    }
}