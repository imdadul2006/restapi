package GUI;

import PageObject.MainLogin;
import PageObject.Manage;
import PageObject.ManageCreateDevice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class ManageTest extends Base {

    WebDriver driver;

    @BeforeClass
    public void setUP() throws IOException {
        driver = getLocalDriver("Windows", "chrome");
        setUp("http://10.6.11.161");
    }

    @Test
    public void Login() {
        MainLogin hp = new MainLogin(driver);
        hp.getUserName().sendKeys("superadmin");
        hp.getPassword().sendKeys("freestor");
        hp.getLoginButton().click();
        waitUntilClickAble(hp.getTopMenu());
        hp.navigateElement("Manage").click();

        Manage man = new Manage(driver);
        waitUntilClickAble(man.getMiddleBar());
        man.serverSeletion("FSS-116").click();
        man.navigateElement("Settings").click();

        man.navigateSetup("FC/iSCSI Target Mode").click();

    }

    @Test
    public void Login2() {
        MainLogin hp = new MainLogin(driver);
        hp.getUserName().sendKeys("superadmin");
        hp.getPassword().sendKeys("freestor");
        hp.getLoginButton().click();
        waitUntilClickAble(hp.getTopMenu());
        hp.navigateElement("Manage").click();

        Manage man = new Manage(driver);
        waitUntilClickAble(man.getMiddleBar());
        man.serverSeletion("FSS-119").click();
        man.navigateElement("Settings").click();

        man.navigateSetup("FC/iSCSI Target Mode").click();
    }
}