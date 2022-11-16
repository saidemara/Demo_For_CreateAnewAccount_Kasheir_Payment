package Tests.Source;

import Source.Employees;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Rest_Assured {

    String URl = "https://api.getpostman.com";
    String API_Key = "PMAK-63696b1306a0f73f0e1e7325-e8dffe9bb022eb47877609b93ca1c166d2";

    @Test
    public void GetToken() {
        JsonPath Res = given().baseUri(URl).
                header("x-api-key", API_Key).
                when().get("/workspaces").
                then().statusCode(200).time(lessThan(5000l)).assertThat().extract().body().jsonPath();
        Assert.assertEquals(Res.get("workspaces[3].name"), "Newman ", "The values ara not matched");
//        System.out.println("Response is" + Res.get("workspaces.name"));
        System.out.println("Response is : " + Res.get("workspaces"));
    }

    @Test
    public void SetAnewResource() {
        String EndPoint = "http://localhost:3000/Users";
        String body =
                """
                         {
                        "F_Name":"SaidEmaraaa",
                        "Age":"33",
                        "Status":"Married"
                         }""";
        var Response = given().header("Content-Type", "application/json").
                body(body).when().post(EndPoint).then();
        Response.log().body().extract().jsonPath();
    }


    @Test
    public void CreateAnewEmployee()

    {
        String EndPoint = "http://localhost:3000/Users";

        Employees Emp = new Employees(
                "SAId", "Emara", 22, "Mansoura", "QA", "SoftwareQA");
        var Response = given().body(Emp).header("Content-Type", "application/json").when().post(EndPoint).then();
        Response.log().body();
    }
}
