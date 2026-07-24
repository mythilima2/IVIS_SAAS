package api;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseAPI {

    private static final String BASE_URL = "https://uat1.iviscloud.net";

    protected static Playwright playwright;
    protected static APIRequestContext request;

    static {

        playwright = Playwright.create();

        request = playwright.request().newContext(
                new APIRequest.NewContextOptions()
                        .setBaseURL(BASE_URL)
                        .setIgnoreHTTPSErrors(true)
        );
    }

    public static APIRequestContext getRequest() {
        return request;

}}


