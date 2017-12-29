package RestAPI;

import RestAPI.*;
import io.restassured.RestAssured;


import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.activation.CommandObject;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ipstorAPI {


    static List<Integer> adapterList;
    static List<String> physicalDeviceList;

   /*@Test
    public void login() throws IOException {
          System.out.println(abc);
          String abc = CommonAPI.getSessionID();
          File loginFile = new File("src/test/Resource/loginServer.json");
          RestAssured.baseURI = "http://10.8.25.32/";
        Response login= given().header(new Header("Content-Type","application/json")).body(loginFile).log().all().post("ipstor/auth/login").then().log().all().extract().response();
    }
   */
    @Test (priority = 1)
    public void getAllPhysicalResource() throws IOException {
        JsonPath jPhysicalResource = CommonAPI.commonGet(ApiResource.getenumAdapters());
        adapterList = jPhysicalResource.get("data.physicaladapters.id");
        System.out.println("Respond : rc = "+jPhysicalResource.get("rc"));
        Assert.assertEquals(jPhysicalResource.get("rc"),0);

    }

    @Test (priority = 1)
    public void getAllPhysicalDevice() throws IOException {
        JsonPath jPhysicalDevices= CommonAPI.commonGet(ApiResource.getEnumPhysicalDevices());
        physicalDeviceList = jPhysicalDevices.get("data.physicaldevices.id");

        System.out.println("=====================================");
        for (String x:physicalDeviceList) {
            System.out.println(x);
        }
        System.out.println("=====================================");
        System.out.println("Respond : rc = "+jPhysicalDevices.get("rc"));
        Assert.assertEquals(jPhysicalDevices.get("rc"),0);

    }

    @Test(priority = 1)
    public void getClientInitiator() throws IOException {
        JsonPath json= CommonAPI.commonGet(ApiResource.getClientInitiator());
        Assert.assertEquals(json.get("rc"),0);
    }

    @Test(priority = 1)
    public void getFCbasePort() throws IOException {
        JsonPath getFCbase = CommonAPI.commonGet(ApiResource.getFCbasePort());
        getFCbase.prettyPrint();
    }

    @Test(priority = 1)
    public void getFCTargetPort() throws IOException {
      JsonPath json=CommonAPI.commonGet(ApiResource.getFCbasePort()) ;
        Assert.assertEquals(json.get("rc"),0);
    }

    @Test(priority = 1)
    public void getEnumUnassignedPhysicalDevices() throws IOException {
        JsonPath json= CommonAPI.commonGet(ApiResource.getEnumPhysicalDevices());
        Assert.assertEquals(json.get("rc"),0);
    }

    @Test(priority = 1)
    public void getEnumeleligibleTarget() throws IOException {
        JsonPath json= CommonAPI.commonGet(ApiResource.getEnumeleligibleTarget());
        Assert.assertEquals(json.get("rc"),0);
    }

    @Test(priority = 1)
    public void getEnumStoragePool() throws IOException {
        JsonPath json= CommonAPI.commonGet(ApiResource.getEnumStoragePool());
        Assert.assertEquals(json.get("rc"),0);
    }

    @Test(priority = 2)
    public void getPhysicalResource() throws IOException {
        for(int i : adapterList) {
            System.out.println("=======Adapter Number "+i+" ==============");
            System.out.println();
            JsonPath jPhysicalResource = CommonAPI.commonGet(ApiResource.getaAdapter(i));
            System.out.println("Respond : rc = "+jPhysicalResource.get("rc"));
            Assert.assertEquals(jPhysicalResource.get("rc"), 0);
            if(i>=100)
                Assert.assertEquals(jPhysicalResource.get("data.type"), "fc");
            System.out.println();
        }
    }

    @Test(priority = 2,dependsOnMethods = {"getAllPhysicalDevice"})
    public void getPhysicalDevicePath() throws IOException {
        for(String i : physicalDeviceList) {
            System.out.println("=======Physical Disk ID "+i+" ==============");
            System.out.println();
            JsonPath jPhysicalResource = CommonAPI.commonGet(ApiResource.getPhyiscalDevicePath(i));
            System.out.println("Respond : rc = "+jPhysicalResource.get("rc"));
            Assert.assertEquals(jPhysicalResource.get("rc"), 0);
        }
    }

    @Test(priority = 2)
    public void getPhysicalDevices() throws IOException {
        for(String i : physicalDeviceList) {
            System.out.println("=======Physical Disk ID "+i+" ==============");
            System.out.println();
            JsonPath jPhysicalResource = CommonAPI.commonGet(ApiResource.getPhysicalDevices(i));
            System.out.println("Respond : rc = "+jPhysicalResource.get("rc"));
            Assert.assertEquals(jPhysicalResource.get("rc"), 0);
        }
    }

}

