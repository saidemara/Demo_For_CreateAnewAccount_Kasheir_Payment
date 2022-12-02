package Tests.Source;

import Source.Employees;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.poi.sl.draw.geom.Path;
import org.checkerframework.checker.units.qual.C;
import org.hamcrest.beans.SamePropertyValuesAs;
import org.hamcrest.core.StringContains;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Rest_Assured {
    RequestSpecification RequestSpecificationOBJ;
    ResponseSpecification ResponseSpecificationOBj;
    Employees Emp;
    String EndPoint = "http://localhost:3000/Users";

    String URl = "https://api.getpostman.com";
    String API_Key = "PMAK-63696b1306a0f73f0e1e7325-e8dffe9bb022eb47877609b93ca1c166d2";
    private ExtractableResponse<Response> extract;

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
        String EndPoint = "http://localhost:3000";
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
    public void CreateAnewEmployee() {

        Emp = new Employees(
                "SAId", "Emara", 22, "Mansoura", "QA", "SoftwareQA");
        var Response = given().body(Emp).
                header("Content-Type", "application/json").when().
                post(EndPoint).then().extract().response().asString();
        System.out.println(Response);
    }

    @Test
    public void GetALLUsers() {
        Employees ExpectedEmp = new Employees(2737,
                "SAId",
                "Emara",
                22,
                "Mansoura",
                "QA",
                "SoftwareQA"
        );

        var ActualResult = given().when().
                get(EndPoint).then().extract().body().path("Employees");
//        System.out.println(equals(Arrays.stream(ActualEmployees).toList()));
        System.out.println(ExpectedEmp.getF_Name());

//                then().extract().body().jsonPath().getList(R);


    }

    @Test
    public void GetRequiredWorkspaces() {
        var response = given().baseUri(URl).
                header("x-api-key", API_Key).when().get("/workspaces").

                then().log().headers().headers("Content-Type", "application/json; charset=utf-8")
                .statusCode(200).assertThat().body("workspaces.name", hasItems("Newman ")
                        , "workspaces", is(not(empty()))
//                        , "workspaces",hasProperty("name")
                        // Map collection that specefied by endex as shown below
                        , "workspaces[0]", hasKey("name")
                        , "workspaces[0]", hasValue("team")
                        , "workspaces[0]", hasEntry("type", "team")
                        , "workspaces[0]", not(equalTo(Collections.emptyList())));


    }

    @Test
    public void GetDetailsofHeader() {
        Headers HeaderResponse = given().baseUri(URl).
                header("x-api-key", API_Key).when().get("/workspaces").
                then().headers("Content-Type", "application/json; charset=utf-8")
                .statusCode(200).extract().headers();
        for (Header header : HeaderResponse) {
            System.out.println("The name of property is " + header.getName());
            System.out.println("The Value of property is " + header.getValue() +
                    "*****************"
            );

        }


    }

    @Test
    public void GetHeaderofMochServer() {
        String EndPoint = "https://8817c324-5154-4f64-82f1-265d46b2adb0.mock.pstmn.io";
        var HeadersVlaue = given().baseUri(EndPoint)
                .get("/get").then().statusCode(200).extract().headers();
        List<String> ListofValues = HeadersVlaue.getValues("x-mock-response-name");
        for (String Value : ListofValues) {
            System.out.println(Value);
        }
    }

    @BeforeClass
    public void CheckRequestandResponseSpecification() {
        RequestSpecificationOBJ = with().baseUri(URl)
                .header("x-api-key", API_Key).contentType("application/json; charset=utf-8");
        ResponseSpecificationOBj = RestAssured.expect().contentType("application/json; charset=utf-8")
                .log().ifError();

    }

    @Test
    public void ReUseRequestspecification() {
        given().spec(RequestSpecificationOBJ).get("/workspaces").then().assertThat().spec(ResponseSpecificationOBj);
    }

    @Test
    public void CheckRequestspecification() {
        List<String> ArrayValuees;
        ArrayValuees = given().spec(RequestSpecificationOBJ).get("/workspaces").then().assertThat().statusCode(200)
                .extract().body().path("workspaces.name");
        System.out.println(ArrayValuees);
        for (String Value : ArrayValuees) {
            System.out.println("The value is :" + Value);
        }
    }

    public String ID = "e5f55d0a-d2a4-469e-834c-aa8c6cadeaf1";

    @Test
    public void SetanewRecorde() {
        String ID = "e5f55d0a-d2a4-469e-834c-aa8c6cadeaf1";
        String payload = "{\n" +
                "    \"workspace\": {\n" +
                "        \"name\": \"QualityAssurance\",\n" +
                "        \"description\": \"workspaceDescriptions\",\n" +
                "        \"type\": \"team\",\n" +
                "        \"visibility\":\"Personal\"\n" +
                "    }\n" +
                "}";
        given().spec(RequestSpecificationOBJ).
                // path paramter   body(payload).pathParam("id", ID).log().all()
                        body(payload).log().all()
                .when().put("/workspaces/{id}", ID)
                .then().spec(ResponseSpecificationOBj).assertThat().log().all().statusCode(200).
                body("workspace.name", equalTo("QualityAssurance"),
                        "workspace.id", matchesPattern("^[a-z-0-9-]{36}$")
                ).and().time(lessThan(4000l), TimeUnit.MILLISECONDS);
    }

    @Test
    public void UsingFilterOption() throws FileNotFoundException {
        PrintStream outputStream = new PrintStream(new File("restassurredlogged.log"));
        given().spec(RequestSpecificationOBJ).filter(new RequestLoggingFilter(LogDetail.BODY, outputStream)).
                and().filter(new ResponseLoggingFilter(LogDetail.STATUS, outputStream)).when().get("/workspaces").then();
    }


}

