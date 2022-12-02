package Tests.Source;

import Source.Employees;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredtwo {
    Rest_Assured rest = new Rest_Assured();

    RequestSpecification RequestSpecificationOBJ;
    ResponseSpecification ResponseSpecificationOBj;
    Employees Emp;
    String EndPoint = "http://localhost:3000/Users";

    String URl = "https://api.getpostman.com";
    String API_Key = "PMAK-63696b1306a0f73f0e1e7325-e8dffe9bb022eb47877609b93ca1c166d2";

    @BeforeClass
    public void CheckRequestandResponseSpecification() {
        RequestSpecificationOBJ = with().baseUri(URl).header("x-api-key", API_Key).contentType("application/json; charset=utf-8");
        ResponseSpecificationOBj = RestAssured.expect().contentType("application/json; charset=utf-8").and().statusCode(200).log().ifError();

    }

    @Test
    public void ReadDatafromExternalFileasOutSource() {


        HashMap<String, String> PairValues = new HashMap<String, String>();
        PairValues.put("name", "HashMap");
        PairValues.put("description", "workspaceDescriptions");
        PairValues.put("type", "team");
        PairValues.put("visibility", "Personal");
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("workspace", PairValues);


//        File FIleStream = new File("src/main/resources/SourceDatabaseof.json");
        var ResponeValues = given().spec(RequestSpecificationOBJ).body(values).post("/workspaces").then()
                .assertThat().spec(ResponseSpecificationOBj).
                body("workspace.name", equalTo("HashMap")).
                extract().response();
        System.out.println(ResponeValues.prettyPeek());
    }

    @Test
    public void GetSpecificWorkspaceBYParamtrization() {
        String value="Test";
        given().spec(RequestSpecificationOBJ).
                queryParams("name",value)
                .log().all().when().get("/workspaces").then().extract().response().body();
    }
@Test
    public void uploadfileattached()
    {
        String BaseUrl="https://the-internet.herokuapp.com";
        given().baseUri(BaseUrl).multiPart("file",new File("C:/Users/Said Emara/Downloads/TestData.csv")).
                when().get("/upload").then().assertThat().statusCode(200).
                extract().response().body().prettyPeek();
    }
}
