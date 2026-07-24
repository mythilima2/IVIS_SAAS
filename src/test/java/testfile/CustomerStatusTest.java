package testfile;

import CSVdatareader.Login_Credentials_CSV_Reader;
import basefile.URL.launching.ScanalitixBaseFile_ParallelExecution;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pagefile.customers.Filtering_Customer_and_Status_Changing;
import pagefile.login.Loginpage_usingCommonmethods;
import pagefile.switchmodules.Swiching_Module;

import java.io.IOException;
import java.util.List;

public class CustomerStatusTest extends ScanalitixBaseFile_ParallelExecution {


        private Loginpage_usingCommonmethods login;
        private Swiching_Module switchModule;
        private Filtering_Customer_and_Status_Changing customerStatus;

        @DataProvider(name = "loginCredentials")
        public Object[][] getLoginCredentials() throws IOException {

            String filePath = System.getProperty("user.dir")
                    + "/src/test/java/testfile/Credentials.csv";

            List<String[]> credentialsList =
                    Login_Credentials_CSV_Reader.readCredentialsFromCSV(filePath);

            Object[][] credentials =
                    new Object[credentialsList.size()][2];

            for (int i = 0; i < credentialsList.size(); i++) {

                credentials[i][0] = credentialsList.get(i)[0];
                credentials[i][1] = credentialsList.get(i)[1];
            }

            return credentials;
        }

        @Test(priority = 1, dataProvider = "loginCredentials")
        public void login(String username, String password) {

            login = new Loginpage_usingCommonmethods(getPage());

            login.login(username, password);
        }

        @Test(priority = 2, dependsOnMethods = "login")
        public void navigateToCustomers() {

            switchModule = new Swiching_Module(getPage());

            switchModule.navigateToCustomers();
        }

        @Test(priority = 3, dependsOnMethods = "navigateToCustomers")
        public void activateDeactivateCustomer() {

            customerStatus =
                    new Filtering_Customer_and_Status_Changing(getPage());

            customerStatus.status();
        }


}
