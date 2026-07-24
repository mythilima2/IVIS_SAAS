package testfile;

import api.APIValidator;
import api.CustomerAPI;
import api.LoginAPI;
import com.microsoft.playwright.APIResponse;
import model.CustomerData;
import org.testng.annotations.Test;
import testdata.CustomerDataFactory;

public class APICustomerTest {


        LoginAPI loginAPI = new LoginAPI();
        CustomerAPI customerAPI = new CustomerAPI();

        @Test
        public void createCustomerUsingAPI() {

            // Login API
            APIResponse loginResponse =
                    loginAPI.login("sudhir.i", "password");

            APIValidator.validate(loginResponse);

            // Generate Random Customer Data
            CustomerData customer =
                    CustomerDataFactory.getValidCustomer();

            // Create Customer API
            APIResponse customerResponse =
                    customerAPI.createCustomer(

                            customer.getCustomerName(),
                            customer.getLegalName(),
                            customer.getCountry(),
                            customer.getIndustry(),
                            customer.getEmail()
                    );

            APIValidator.validate(customerResponse);
        }

    }

