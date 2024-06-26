package Ivistestfile;

import Ivisbasefile.Createcustomer.basepage;
import Loginpagefile.CSVreader;
import Loginpagefile.Login_UsingSeleniumJava;
import Loginpagefile.Loginpage_usingCommonmethods;
import Projectspagefile.CreateProject_usingcommonmethods;
import Projectspagefile.Editproject;
import SwitchModules.Swiching_Module;
import customerspagefile.Createcustomer_withcommonmethods;
import customerspagefile.Customeruniquevalidation;
import customerspagefile.EditCustomer_commonmethods;
import customerspagefile.FilteringCustomername;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class projectstestfile  extends basepage {
    Loginpage_usingCommonmethods login;
    CreateProject_usingcommonmethods createProjectCrm;
    Editproject editProject;
    Swiching_Module Switchmodule;



    @DataProvider(name = "loginCredentials")
    public Object[][] getLoginCredentials() throws IOException {
        String filePath = "C:\\Users\\Mythili Bekkam\\IdeaProjects\\Ivisseleniumpractice\\src\\test\\java\\Ivistestfile\\Credentials.csv"; // Replace with your CSV file path
        List<String[]> credentialsList = CSVreader.readCredentialsFromCSV(filePath);
        Object[][] credentials = new Object[credentialsList.size()][2];

        for (int i = 0; i < credentialsList.size(); i++) {
            credentials[i][0] = credentialsList.get(i)[0]; // username
            credentials[i][1] = credentialsList.get(i)[1]; // password
        }

        return credentials;
    }
    @Test(priority = 1, dataProvider = "loginCredentials")
    public void testCreateCustomer(String username, String password) {
        login = new Loginpage_usingCommonmethods(page);
        login.login(username, password);
    }
//    @Test(priority = 1)
//    public void testCreateCustomer() {
//        login=new Loginpage_usingCommonmethods(page);
//        login.login("veera.rangina@motivitylabs.com", "Ivis@123");
//    }

    @Test(priority = 2)
    public void setSwitchmodule()
    {
        Switchmodule=new Swiching_Module(page);
        Switchmodule.navigateToCustomers();

    }



      @Test(priority = 4)
    public  void setEditproject() throws InterruptedException {
        editProject=new Editproject(page);
        editProject.editproject();

    }
    @Test(priority = 3)
    public  void setCreateProject() throws InterruptedException {
        createProjectCrm=new CreateProject_usingcommonmethods(page);
        createProjectCrm.create();
    }
}
