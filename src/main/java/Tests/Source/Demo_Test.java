package Tests.Source;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.Matchers;
import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import javax.swing.*;

public class Demo_Test {

    String URl = "https://api.getpostman.com";
    String API_Key = "PMAK-63696b1306a0f73f0e1e7325-629a1a0b63e66006b5a7b4c531b654776a";

    @Test
    public void GetToken() {
       ResponseBody Res= given().baseUri(URl).
                header("x-api-key", API_Key).
                when().get("/workspaces").
                then().statusCode(200).time(lessThan(5000l)).assertThat().extract().response().body();
       System.out.println("Response is"+Res.asString());

    }
}
