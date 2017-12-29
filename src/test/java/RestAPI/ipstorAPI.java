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
        //Response getPhyResource =
        JsonPath jPhysicalResource = CommonAPI.commonGet(ApiResource.getenumAdapters());//DataParser.rawToJSON(getPhyResource);
        adapterList = jPhysicalResource.get("data.physicaladapters.id");
        System.out.println("Respond : rc = "+jPhysicalResource.get("rc"));
        Assert.assertEquals(jPhysicalResource.get("rc"),0);

    }

    @Test (priority = 1)
    public void getAllPhysicalDevice() throws IOException {
        //Response getAllPhysicalDevices =
        JsonPath jPhysicalDevices= CommonAPI.commonGet(ApiResource.getEnumPhysicalDevices());//DataParser.rawToJSON(getAllPhysicalDevices );
        physicalDeviceList = jPhysicalDevices.get("data.physicaldevices.id");
        System.out.println("Respond : rc = "+jPhysicalDevices.get("rc"));
        Assert.assertEquals(jPhysicalDevices.get("rc"),0);

    }

    @Test(priority = 1)
    public void getClientInitiator() throws IOException {
       // CommonAPI.setBaseURI();
       // Response res =  //given().cookie("session_id", CommonAPI.getSessionID()).log().uri().get(ApiResource.getClientInitiator()).then().log().all().extract().response();
        JsonPath json= CommonAPI.commonGet(ApiResource.getClientInitiator());//DataParser.rawToJSON(res);
        Assert.assertEquals(json.get("rc"),0);
    }

    @Test(priority = 1)
    public void getFCbasePort() throws IOException {
        JsonPath getFCbase = CommonAPI.commonGet(ApiResource.getFCbasePort());
        getFCbase.prettyPrint();
    }

    @Test(priority = 1)
    public void getFCTargetPort() throws IOException {
       // Response res =  //given().cookie("session_id", CommonAPI.getSessionID()).log().uri().get(ApiResource.getClientInitiator()).then().log().all().extract().response();
        JsonPath json=CommonAPI.commonGet(ApiResource.getFCbasePort()) ;// DataParser.rawToJSON(res);
        Assert.assertEquals(json.get("rc"),0);
    }

    @Test(priority = 1)
    public void getEnumUnassignedPhysicalDevices() throws IOException {
        //Response res =  //given().cookie("session_id", CommonAPI.getSessionID()).log().uri().get(ApiResource.getClientInitiator()).then().log().all().extract().response();
        JsonPath json= CommonAPI.commonGet(ApiResource.getEnumPhysicalDevices());//DataParser.rawToJSON(res);
        Assert.assertEquals(json.get("rc"),0);
    }

    @Test(priority = 1)
    public void getEnumeleligibleTarget() throws IOException {
      //  Response res =  //given().cookie("session_id", CommonAPI.getSessionID()).log().uri().get(ApiResource.getClientInitiator()).then().log().all().extract().response();
        JsonPath json= CommonAPI.commonGet(ApiResource.getEnumeleligibleTarget());//DataParser.rawToJSON(res);
        Assert.assertEquals(json.get("rc"),0);;
    }

    @Test(priority = 1)
    public void getEnumStoragePool() throws IOException {
        JsonPath json= CommonAPI.commonGet(ApiResource.getEnumStoragePool());
        Assert.assertEquals(json.get("rc"),0);;
    }

    @Test(priority = 2)
    public void getPhysicalResource() throws IOException {
        for(int i : adapterList) {
            System.out.println("=======Adapter Number "+i+" ==============");
            System.out.println();
           // Response getPhyResource =
            JsonPath jPhysicalResource = CommonAPI.commonGet(ApiResource.getaAdapter(i));//DataParser.rawToJSON(getPhyResource);
            System.out.println("Respond : rc = "+jPhysicalResource.get("rc"));
            Assert.assertEquals(jPhysicalResource.get("rc"), 0);
            if(i>=100)
                Assert.assertEquals(jPhysicalResource.get("data.type"), "fc");
            System.out.println();
        }
    }

    @Test(priority = 2)
    public void getPhysicalDevicePath() throws IOException {
        for(String i : physicalDeviceList) {
            System.out.println("=======Physical Disk ID "+i+" ==============");
            System.out.println();
           // Response getPhyResource =
            JsonPath jPhysicalResource = CommonAPI.commonGet(ApiResource.getPhyiscalDevicePath(i));//DataParser.rawToJSON(getPhyResource);
            System.out.println("Respond : rc = "+jPhysicalResource.get("rc"));
            Assert.assertEquals(jPhysicalResource.get("rc"), 0);
        }
    }

    @Test(priority = 2)
    public void getPhysicalDevices() throws IOException {
        for(String i : physicalDeviceList) {
            System.out.println("=======Physical Disk ID "+i+" ==============");
            System.out.println();
           // Response getPhyResource = ;
            JsonPath jPhysicalResource = CommonAPI.commonGet(ApiResource.getPhysicalDevices(i));//DataParser.rawToJSON(getPhyResource);
            System.out.println("Respond : rc = "+jPhysicalResource.get("rc"));
            Assert.assertEquals(jPhysicalResource.get("rc"), 0);
        }
    }

}

