package api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;

import java.util.HashMap;
import java.util.Map;

import static api.BaseAPI.request;

public class LoginAPI {


        public APIResponse login(String username, String password) {

            Map<String, Object> body = new HashMap<>();

            body.put("loginId", username);
            body.put("password", password);

            APIResponse response = request.post(

                    "/api/login",

                    RequestOptions.create()
                            .setHeader("Content-Type", "application/json")
                            .setData(body)

            );

            if (response.status() == 200) {

                try {

                    ObjectMapper mapper = new ObjectMapper();

                    JsonNode json = mapper.readTree(response.text());

                    String token = json
                            .path("results")
                            .path("accessToken")
                            .asText();

                    TokenManager.setToken(token);

                    System.out.println("Login Successful");
                    System.out.println("Access Token : " + token);

                } catch (Exception e) {

                    e.printStackTrace();
                }
            }

            return response;
        }



}