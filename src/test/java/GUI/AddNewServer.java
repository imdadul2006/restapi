package GUI;

import PageObject.Administration;
import PageObject.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import GUI.LogFreestor;

import java.io.IOException;

import static Utility.FileRead.getfmsServer;


public class AddNewServer extends Base {
    public static WebDriver driver;

    @BeforeTest
    public void setUP() throws IOException {
        driver = getLocalDriver("Windows", "chrome");
        setUp(getfmsServer());
    }

    @Test
    public void addServer(){

        /* Use the login from LogFreestor class */
        LogFreestor login = new LogFreestor();
        login.driver = driver;
        login.loginToFreestor();

        /*Navigate to Administration Menu*/
        MainPage mp = new MainPage(driver);
        mp.navigateElement("ADMINISTRATION").click();

        /* Need to click on server item from menu option*/
        mouseClickByText("Servers");

        //Adding server using Administration class
        Administration admins = new Administration(driver);
        admins.addNewServer("10.8.25.32","root","IPStor101");
        admins.addNewServer("10.8.25.86","root","IPStor101");

    }

}
