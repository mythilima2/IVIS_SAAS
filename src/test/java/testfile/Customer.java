package testfile;

import CSVdatareader.Login_Credentials_CSV_Reader;
import basefile.URL.launching.ScanalitixBaseFile_ParallelExecution;
import com.microsoft.playwright.Response;
import model.CustomerData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pagefile.login.Loginpage_usingCommonmethods;
import pagefile.switchmodules.Swiching_Module;
import testdata.CustomerDataFactory;
import workflow.CustomersWorkflow;

import java.io.IOException;
import java.util.List;

public class Customer  extends ScanalitixBaseFile_ParallelExecution {

        private Loginpage_usingCommonmethods login;
        private CustomersWorkflow customerWorkflow;
        private Swiching_Module switchModule;
        private CustomerData customer;

        @DataProvider(name = "loginCredentials")
        public Object[][] getLoginCredentials() throws IOException {

            String filePath = System.getProperty("user.dir")
                    + "/src/test/java/testfile/Credentials.csv";

            List<String[]> credentialsList =
                    Login_Credentials_CSV_Reader.readCredentialsFromCSV(filePath);

            Object[][] credentials = new Object[credentialsList.size()][2];

            for (int i = 0; i < credentialsList.size(); i++) {
                credentials[i][0] = credentialsList.get(i)[0];
                credentials[i][1] = credentialsList.get(i)[1];
            }

            return credentials;
        }

        @Test(priority = 1, dataProvider = "loginCredentials")
        public void login(String username, String password) {

            login = new Loginpage_usingCommonmethods(getPage());

            getPage().onResponse(response -> {

                System.out.println("======================================");
                System.out.println("METHOD : " + response.request().method());
                System.out.println("STATUS : " + response.status());
                System.out.println("URL    : " + response.url());

            });

            Response loginResponse = getPage().waitForResponse(

                    response ->
                            response.url().contains("/api/login")
                                    && response.request().method().equalsIgnoreCase("POST"),

                    () -> login.login(username, password)
            );

            Assert.assertEquals(loginResponse.status(), 200,
                    "Login API Failed");

            customerWorkflow =
                    new CustomersWorkflow(getPage(), getRequestContext());
        }

        @Test(priority = 2, dependsOnMethods = "login")
        public void switchModule() {

            switchModule = new Swiching_Module(getPage());

            Response switchResponse = getPage().waitForResponse(

                    response ->
                            response.url().contains("/api/users/mappedscopes")
                                    && response.url().contains("segmentName=Config%20Mgmt")
                                    && response.request().method().equalsIgnoreCase("GET"),

                    () -> switchModule.navigateToCustomers()
            );

            Assert.assertEquals(switchResponse.status(), 200);

            System.out.println("======= SWITCH MODULE API =======");
            System.out.println("URL    : " + switchResponse.url());
            System.out.println("METHOD : " + switchResponse.request().method());
            System.out.println("STATUS : " + switchResponse.status());

            try {
                System.out.println("BODY : " + switchResponse.text());
            } catch (Exception e) {
                System.out.println("Response body not available.");
            }
        }

        @Test(priority = 3, dependsOnMethods = "switchModule")
        public void createCustomer() throws Exception {

            Response customerResponse = getPage().waitForResponse(

                    response ->
                            response.url().contains("/api/customers")
                                    && response.request().method().equalsIgnoreCase("POST"),

                    () -> {
                        try {
                            customer = customerWorkflow.createCustomer();

                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });

            System.out.println("========== CUSTOMER API ==========");
            System.out.println("URL    : " + customerResponse.url());
            System.out.println("METHOD : " + customerResponse.request().method());
            System.out.println("STATUS : " + customerResponse.status());

            try {
                System.out.println("BODY : " + customerResponse.text());
            } catch (Exception e) {
                System.out.println("Response body not available.");
            }

            System.out.println("=================================");
            System.out.println("Customer Created Successfully");
            System.out.println("Customer Name : " + customer.getCustomerName());
            System.out.println("Customer Code : " + customer.getLegalName());
            System.out.println("=================================");

            Assert.assertTrue(
                    customerResponse.status() == 200
                            || customerResponse.status() == 201,
                    "Customer Creation API Failed. Status = "
                            + customerResponse.status()
            );
        }

}