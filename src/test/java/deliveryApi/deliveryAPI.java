package deliveryApi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class deliveryAPI {

    public static void main(String[] args) {
        String baseUrl = "http://dev2-v2.iviscloud.net:8000/api/sitegroups/unmappedsitegrouplist"; // Replace with your API URL
        String bearerToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCIsImd0eSI6WyJhdXRob3JpemF0aW9u" +
                                "X2NvZGUiXSwia2lkIjoiMzE2YzBmZTU3In0.eyJhdWQiOiI5NGRlMTBlZC01NGZjLTQ2MjEtY" +
                                "jBmNi0yZTJjOGRjOTBiNTUiLCJleHAiOjE3MjY3MTQ4NDMsImlhdCI6MTcyNjY3MTY0MywiaXNzI" +
                                "joiYWNtZS5jb20iLCJzdWIiOiI3YmZmNmE1Yi1kNTAyLTRiYjUtYjQ2Ny01ZmJiMjc0ODJiZDUiLCJ" +
                "qdGkiOiJjOWM4NzhiMy0zYTljLTQ4Y2YtYjA4Ny1hZDgxZDcyYmU5NWMiLCJhdXRoZW50aWNhdGlvblR5cGUiOiJQQVNTV09SRCIsImV" +
                "tYWlsIjoidmVlcmEucmFuZ2luYUBtb3Rpdml0eWxhYnMuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsInByZWZlcnJlZF91c2Vy" +
                "bmFtZSI6InZlZXJhLnJhbmdpbmFAbW90aXZpdHlsYWJzLmNvbSIsImFwcGxpY2F0aW9uSWQiOiI5NGRlMTBlZC01NGZjLTQ2MjEtYjB" +
                "mNi0yZTJjOGRjOTBiNTUiLCJyb2xlcyI6W10sImF1dGhfdGltZSI6MTcyNjY3MTY0MywidGlkIjoiMjUwNjM5MzItNjQwOC00ZGU3LWIwY" +
                "jgtZWYwMjQzNmQzNDMyIn0.VsnKc5Ewy5j1xj-bjBtjIM1zh9H1qQQbnAPBCpxq9Ro"; // Replace with your Bearer token
        // Additional headers you want to pass
        Map<String, String> headers = new HashMap<>();
        headers.put("Tenant-Id", "1"); // Example header
        //headers.put("Custom-Header", "value"); // Replace with your custom headers if any

        // Parameters to be passed in the URL
        Map<String, String> params = new HashMap<>();
        params.put("projectId", "452"); // Replace with your actual parameters
        //params.put("param2", "value2");

        try {

            // Construct the full URL with parameters
            String fullUrl = baseUrl + "?" + getParamsString(params);
            System.out.println("Full URL: " + fullUrl);


            // Create a URL object
            URL obj = new URL(fullUrl);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            // Set the request method to GET
            connection.setRequestMethod("GET");

            // Set the Authorization header with the Bearer token
            connection.setRequestProperty("Authorization", "Bearer " + bearerToken);

            // Add any additional headers from the map
            for (Map.Entry<String, String> header : headers.entrySet()) {
                connection.setRequestProperty(header.getKey(), header.getValue());
            }


            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response message
            String responseMessage = connection.getResponseMessage();
            System.out.println("Response Message: " + responseMessage);

            // If the response code is 200, read the response
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Print the response body
                System.out.println("Response Body: " + response.toString());
            } else {
                System.out.println("Failed to get successful response. Server responded with: " + responseCode + " - " + responseMessage);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Utility method to encode parameters into a URL query string
    public static String getParamsString(Map<String, String> params) throws Exception {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            result.append("&");
        }
        String resultString = result.toString();
        return resultString.length() > 0 ? resultString.substring(0, resultString.length() - 1) : resultString;
    }
}
