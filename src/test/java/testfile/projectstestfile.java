package testfile;

import basefile.URL.launching.Dev1v2_URLlaunching;
import CSVdatareader.Login_Credentials_CSV_Reader;
import basefile.URL.launching.ScanalitixBaseFile_ParallelExecution;
import pagefile.login.Loginpage_usingCommonmethods;
import pagefile.projects.Project_Creation_using_Commonactions;
import pagefile.projects.Project_Edition;
import pagefile.switchmodules.Swiching_Module;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;


public class projectstestfile  extends ScanalitixBaseFile_ParallelExecution {
    Loginpage_usingCommonmethods login;
    Project_Creation_using_Commonactions createProjectCrm;
    Project_Edition editProject;
    Swiching_Module Switchmodule;



    @DataProvider(name = "loginCredentials")
    public Object[][] getLoginCredentials() throws IOException {
        String filePath = "C:\\Users\\Mythili Bekkam\\IdeaProjects\\Ivisseleniumpractice\\src\\test\\java\\testfile\\Credentials.csv"; // Replace with your CSV file path
        List<String[]> credentialsList = Login_Credentials_CSV_Reader.readCredentialsFromCSV(filePath);
        Object[][] credentials = new Object[credentialsList.size()][2];

        for (int i = 0; i < credentialsList.size(); i++) {
            credentials[i][0] = credentialsList.get(i)[0]; // username
            credentials[i][1] = credentialsList.get(i)[1]; // password
        }

        return credentials;
    }
    @Test(priority = 1, dataProvider = "loginCredentials")
    public void testCreateCustomer(String username, String password) {
        login = new Loginpage_usingCommonmethods(getPage());
        login.login(username, password);
    }

    @Test(priority = 2)
    public void setSwitchmodule()
    {
        Switchmodule=new Swiching_Module(getPage());
        Switchmodule.navigateToCustomers();

    }

//      @Test(priority = 4)
//    public  void setEditproject() throws InterruptedException {
//        editProject=new Project_Edition(getPage());
//        editProject.editproject();
//
//    }
    @Test(priority = 3)
    public  void setCreateProject() throws InterruptedException {
        createProjectCrm=new Project_Creation_using_Commonactions(getPage());
        createProjectCrm.create();
    }
}
