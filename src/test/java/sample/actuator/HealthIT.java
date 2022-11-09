package sample.actuator;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class HealthIT {

    @BeforeClass
    public static void setup() {
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(8080);
        } else {
            RestAssured.port = Integer.valueOf(port);
        }

        String baseHost = System.getProperty("server.host");
        if (baseHost == null) {
            baseHost = "http://localhost";
        }
        RestAssured.baseURI = baseHost;

    }

    @Test
    public void running() {
        given().when().get("/")
                .then().statusCode(200);
    }

    @Test
    public void message() {
        given().when().get("/")
                .then().body(containsString("Hello Hello"));
    }

    @Test
    public void fullMessage() {
        given().when().get("/")
                .then().body("message", equalTo("Hello Hello"));
    }

    @Test
    public void health() {
        given().when().get("/actuator/health")
                .then().body("status", equalTo("UP"));
    }


}
