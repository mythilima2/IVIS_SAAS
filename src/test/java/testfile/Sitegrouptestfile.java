package testfile;

import CSVdatareader.Login_Credentials_CSV_Reader;
import basefile.URL.launching.Dev1v2_URLlaunching;
import basefile.URL.launching.ScanalitixBaseFile_ParallelExecution;
import com.microsoft.playwright.Response;
import model.CustomerData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import pagefile.customers.CustomerSearch;
import pagefile.login.Loginpage_usingCommonmethods;
import pagefile.switchmodules.Swiching_Module;
import org.testng.annotations.Test;
import pagefile.sitegroups.Sitegroup_Creation;
import workflow.CustomersWorkflow;

import java.io.IOException;
import java.util.List;

public class Sitegrouptestfile extends ScanalitixBaseFile_ParallelExecution {

    private Loginpage_usingCommonmethods login;
    private CustomersWorkflow customerWorkflow;
    private Swiching_Module switchModule;
    private CustomerData customer;
    private CustomerSearch customerSearch;
    private Sitegroup_Creation  sitegroupCreation;

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
    @Test(priority = 3)
    public void runcreatesitegroup(){
        sitegroupCreation=new Sitegroup_Creation(getPage());
        sitegroupCreation.sitegroupCreate();
    }
}
