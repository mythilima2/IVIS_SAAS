package deliveryApi;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;

public class deliveryApi {
    public static void main(String[] args) {

        // Bearer token for authorization
        String bearerToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCIsImd0eSI6WyJhdXRob3JpemF0aW9uX2NvZGUiXSwia2lkIjoiMzE2YzBmZTU3In0.eyJhdWQiOiI5NGRlMTBlZC01NGZjLTQ2MjEtYjBmNi0yZTJjOGRjOTBiNTUiLCJleHAiOjE3MjU3MTU1MjUsImlhdCI6MTcyNTY3MjMyNSwiaXNzIjoiYWNtZS5jb20iLCJzdWIiOiI3YmZmNmE1Yi1kNTAyLTRiYjUtYjQ2Ny01ZmJiMjc0ODJiZDUiLCJqdGkiOiI0NGIzOWU5MS1iYTQ3LTRiYjYtYmQzNi1iZWEyZDNjNjhlNWIiLCJhdXRoZW50aWNhdGlvblR5cGUiOiJQQVNTV09SRCIsImVtYWlsIjoidmVlcmEucmFuZ2luYUBtb3Rpdml0eWxhYnMuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsInByZWZlcnJlZF91c2VybmFtZSI6InZlZXJhLnJhbmdpbmFAbW90aXZpdHlsYWJzLmNvbSIsImFwcGxpY2F0aW9uSWQiOiI5NGRlMTBlZC01NGZjLTQ2MjEtYjBmNi0yZTJjOGRjOTBiNTUiLCJyb2xlcyI6W10sImF1dGhfdGltZSI6MTcyNTY3MjMyNSwidGlkIjoiMjUwNjM5MzItNjQwOC00ZGU3LWIwYjgtZWYwMjQzNmQzNDMyIn0.eLLvWW5_-aoe3T7qVQ4lhMC2OqKO1yUjb9fwVvGrVNE";

        // Set the base URI for RestAssured
        baseURI = "https://dev2-v2.iviscloud.net";

        try {
            // Sending the GET request with headers (Authorization, Tenant-Id, Content-Type)
            Response response = RestAssured
                    .given()
                    .header("Authorization", "Bearer " + bearerToken)
                    .header("Tenant-Id", "1")
                    //.header("Content-Type", "application/json")
                    .get(baseURI+"/api/analytical/fmapi/getsitestages");

            // Get the status code of the response
            int statusCode = response.getStatusCode();
            System.out.println("Response Status Code: " + statusCode);

            // If status code is 200, print the response body
            if (statusCode == 200) {
                System.out.println("Response Body: " + response.getBody().asString());
            } else {
                System.out.println("GET request failed with status code: " + statusCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}