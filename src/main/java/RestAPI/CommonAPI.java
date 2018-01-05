package RestAPI;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.baseURI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static RestAPI.DataParser.rawToJSON;
import static io.restassured.RestAssured.given;

public class CommonAPI {

    static String baseURI;
    static String currentSessionID = null;

    public static String getSessionID() throws IOException {
        Properties prop = property();
        String nameOfLoginFile = prop.getProperty("loginJson");
        File loginFile = new File("src/test/Resource/"+nameOfLoginFile+".json");
        if(currentSessionID==null) {
            Response loginResponse = given().header(CommonAPI.header()).body(loginFile).post(ApiResource.postLogin()).then().extract().response();
            JsonPath auth = rawToJSON(loginResponse);
            currentSessionID = auth.get("id");
        }
        return currentSessionID;

    }

    public static Header header(){
        return new Header("Content-Type","application/json");
    }

    public static void setBaseURI() throws IOException {
        Properties properties = property();
        RestAssured.baseURI = properties.getProperty("url");
        baseURI = RestAssured.baseURI;

    }
    public static Properties property() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/Resource/env.properties");
        prop.load( fis);
        return prop;
    }

    public static JsonPath commonGet(String getApi) throws IOException {
        setBaseURI();
        Response res = given().cookie("session_id", getSessionID()).log().uri().get(getApi).then().log().all().extract().response();
        return DataParser.rawToJSON(res);
    }

   /* public static JsonPath commonPost(String postApi, String body) throws IOException {
        setBaseURI();
        Response res = given().cookie("session_id", getSessionID()).log().uri().get(getApi).then().log().all().extract().response();
        return DataParser.rawToJSON(res);
    }

    public static JsonPath commonPost(String postApi, String param, String body) throws IOException {
        setBaseURI();
        Response res = given().cookie("session_id", getSessionID()).log().uri().get(getApi).then().log().all().extract().response();
        return DataParser.rawToJSON(res);
    }*/
}
