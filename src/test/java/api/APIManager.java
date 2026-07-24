package api;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;

public class APIManager {

        private static APIRequestContext request;

        public static APIRequestContext getRequest() {

            if(request == null){

                Playwright playwright = Playwright.create();

                request = playwright.request().newContext(
                        new APIRequest.NewContextOptions()
                                .setBaseURL("https://uat1.iviscloud.net"));
            }

            return request;
        }

    }
