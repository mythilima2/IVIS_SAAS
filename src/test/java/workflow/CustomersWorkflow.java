package workflow;

//import api.CustomerAPI;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Page;
import model.CustomerData;
import pagefile.customers.CustomersCreation;
import testdata.CustomerDataFactory;
import utils.CustomerStore;

public class CustomersWorkflow {


        private final CustomersCreation customer;

        public CustomersWorkflow(Page page,
                                 APIRequestContext requestContext) {

            customer = new CustomersCreation(page);
        }

        public CustomerData createCustomer() throws Exception {

            CustomerData customerData = CustomerDataFactory.getValidCustomer();

            customer.openCustomerPage();

            customer.validateMandatoryFields();

            customer.enterCustomerDetails(
                    customerData.getCustomerName(),
                    customerData.getLegalName(),
                    customerData.getCountry(),
                    customerData.getIndustry(),
                    customerData.getEmail());

            customer.selectCustomerFeatures();

            customer.enterCustomerContact();

            customer.enterBillingInformation();

            customer.skipProjects();

            customer.submitCustomer();

            System.out.println("=================================");
            System.out.println("Customer Created Successfully");
            System.out.println("Customer Name : " + customerData.getCustomerName());
            System.out.println("Customer Code : " + customerData.getLegalName());
            System.out.println("=================================");

            return customerData;

    }
}