package apiautomation;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class Base_api {
        @BeforeClass
        public void setup() {
            RestAssured.baseURI = "https://api.example.com"; // Replace with your base URI
        }
}
