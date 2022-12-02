package Tests.Source;

import Source.Employees;
import Source.workspace;
import Source.RootEmployees;
import Source.workspace;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.commons.logging.Log;
import org.hamcrest.beans.SamePropertyValuesAs;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.equalTo;

public class EmployeesTest {
    workspace TestWorkSpaces =
            new workspace("SAIdEmara", "Testing", "team", "Personal");

    RootEmployees MainWorkspaces =
            new RootEmployees(TestWorkSpaces);
    RequestSpecification RequestSpecificationOBJ;
    ResponseSpecification ResponseSpecificationOBj;
    String URlOFFIlePath = "http://localhost:3000/Users";
    String BaseURl = "https://0614cd82-783e-4bd8-aa45-a70e9a50ad4d.mock.pstmn.io";
    String WorkSpacesEndPoint = "https://api.getpostman.com";

    //    String URl = "https://api.getpostman.com";
    String API_Key = "PMAK-63696b1306a0f73f0e1e7325-e8dffe9bb022eb47877609b93ca1c166d2";

    public EmployeesTest(InputStream in) {

    }

    @BeforeClass
    public void CheckRequestandResponseSpecification() {
        RequestSpecificationOBJ = with().baseUri(WorkSpacesEndPoint).header("x-api-key", API_Key).contentType("application/json;charset=utf-8");
//        RequestSpecificationOBJ = with().baseUri(WorkSpacesEndPoint).contentType("application/json; charset=utf-8");
        ResponseSpecificationOBj = RestAssured.expect().contentType("application/json; charset=utf-8").log().ifError();

    }


    @Test
    public void GetListOFEmployees() {


        given().spec(RequestSpecificationOBJ).pathParam("ID", 2853).
                filter(new RequestLoggingFilter(LogDetail.URI)).when().
                get("/{ID}").
                then().statusCode(200).assertThat();
//                .body("company", equalTo(SeralizeEmployees.getFullName()));
        System.out.println("");
    }

    @Test
    public void SetEmployee() {
        RootEmployees Desaralize = given().spec(RequestSpecificationOBJ).body(MainWorkspaces).filter(new RequestLoggingFilter(LogDetail.BODY)).
                when().
                post("/workspaces")
                .then().spec(ResponseSpecificationOBj).extract().response().as(RootEmployees.class);
        Assert.assertEquals(Desaralize, MainWorkspaces);


    }
}