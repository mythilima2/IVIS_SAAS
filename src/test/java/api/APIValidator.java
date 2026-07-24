package api;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Response;
import com.microsoft.playwright.Page;
import org.testng.Assert;

public class APIValidator {



        public static void validate(APIResponse response) {

            System.out.println("=================================");
            System.out.println("URL    : " + response.url());
            System.out.println("STATUS : " + response.status());

            try {

                System.out.println("BODY : " + response.text());

            } catch (Exception e) {

                System.out.println("No Response Body");

            }

            Assert.assertTrue(

                    response.status() == 200
                            || response.status() == 201,

                    "API Failed"

            );

        }



}
