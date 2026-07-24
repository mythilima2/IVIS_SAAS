package api;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;

import java.util.HashMap;
import java.util.Map;

public class CustomerAPI extends BaseAPI {

    public APIResponse createCustomer(

            String customerName,
            String legalName,
            String country,
            String industry,
            String email
          //  String projectType

    ) {

        Map<String, Object> body = new HashMap<>();

        body.put("customerName", customerName);
        body.put("legalName", legalName);
        body.put("country", country);
        body.put("industry", industry);
        body.put("email", email);
        //body.put("projectType", projectType);

        return request.post(

                "/api/customers?tenantId=1",

                RequestOptions.create()
                        .setHeader("Authorization",
                                "Bearer " + TokenManager.getToken())
                        .setHeader("Content-Type", "application/json")
                        .setData(body)

        );

    }

}