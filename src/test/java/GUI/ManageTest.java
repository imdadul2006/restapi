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
        driver = getLocalDriver("Windows","chrome");
        setUp("http://10.6.11.161");
    }

    @Test
    public void Login(){
        MainLogin hp = new MainLogin(driver);
        hp.getUserName().sendKeys("superadmin");
        hp.getPassword().sendKeys("freestor");
        hp.getLoginButton().click();
        waitUntilClickAble(hp.getTopMenu());
        hp.navigateElement("Manage").click();


        driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div[2]/ul/li[3]/div[1]")).click();

        Manage man = new Manage(driver);
        waitUntilClickAble(man.getMiddleBar());
        man.navigateElement("Virtual Devices").click();
        man.getCreate().click();

        ManageCreateDevice manDevic = new ManageCreateDevice(driver);
        waitUntilClickAble(manDevic.getCreate());
        manDevic.getSanDiskName().sendKeys("MyTestDisk");

    }
}
