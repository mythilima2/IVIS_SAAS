package workflow;

//import api.CustomerAPI;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Page;
import pagefile.customers.CustomersCreation;

public class CustomersWorkflow {


        private final CustomersCreation customer;
//        private final CustomerAPI customerAPI;

        public CustomersWorkflow(Page page,
                                APIRequestContext requestContext) {

            customer = new CustomersCreation(page);

//            customerAPI = new CustomerAPI(requestContext);

        }

        public void createCustomer(String customerName,
                                   String customerCode,
                                   String country,
                                   String industry,
                                   String email)
                throws Exception {

            customer.openCustomerPage();

            customer.validateMandatoryFields();

            customer.enterCustomerDetails(
                    customerName,
                    customerCode,
                    country,
                    industry,
                    email);

            customer.selectCustomerFeatures();

            customer.enterCustomerContact();

            customer.enterBillingInformation();

            customer.skipProjects();

            customer.submitCustomer();


            // API Validation
            // customerAPI.validateCustomer(customerCode);

        }

}
