package api;

import com.microsoft.playwright.APIResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    @Test
    public void validateLoginAPI() {

        LoginAPI loginAPI = new LoginAPI();

        APIResponse response = loginAPI.login("sudhir.i", "Iportal@3210");

        Assert.assertEquals(response.status(), 200);

        String responseBody = response.text();

        Assert.assertTrue(responseBody.contains("token"));
    }
}
