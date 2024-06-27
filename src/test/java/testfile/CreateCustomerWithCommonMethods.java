package testfile;

import CSVdatareader.Login_Credentials_CSV_Reader;
import org.testng.annotations.DataProvider;
import pagefile.customers.*;
import basefile.URL.launching.Dev1v2_URLlaunching;
import pagefile.login.Loginpage_usingCommonmethods;
import pagefile.projects.Project_Creation_using_Commonactions;
import pagefile.projects.Project_Edition;
import pagefile.switchmodules.Swiching_Module;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pagefile.customers.Customer_Creation_using_Commonactions;
import pagefile.customers.Customer_Name_Unique_Validation;
import pagefile.customers.Customer_Edition;
import pagefile.customers.Filtering_Customer_and_Status_Changing;

import java.io.IOException;
import java.util.List;

@Listeners(org.testng.reporters.TestHTMLReporter.class)

public class CreateCustomerWithCommonMethods extends Dev1v2_URLlaunching {
    Loginpage_usingCommonmethods login;
    Customer_Creation_using_Commonactions customerMgmtPage;
    Customer_Edition editCustomer;
    Project_Creation_using_Commonactions createProjectCrm;
    Project_Edition editProject;
    Swiching_Module Switchmodule;
    Filtering_Customer_and_Status_Changing filteringCustomername;
    Customer_Name_Unique_Validation customeruniquevalidation;
    private List<String[]> customerData;
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
        login = new Loginpage_usingCommonmethods(page);
        login.login(username, password);
    }

   @Test(priority = 3)
    public void create() {
        customerMgmtPage = new Customer_Creation_using_Commonactions(page);

        //customerMgmtPage.createCustomer("abdefg", "454564", "United States of America", "Automotive Industry", "bekkkkkkkk@gmail.com");
        String[][] customerData = {
                {"TestQA21 Sample12", "TestingQA21 Sample12", "United States of America", "Automotive Industry", "customer1@example.com"},
//               {"Cs80m", "AB89780766", "United Kingdom", "Automotive Industry", "customer2@example.com"},
//                {"Custome3three", "dhfh76", "Canada", "Automotive Industry", "customer3@example.com"},
//                {"Customer4four", "fghdhf67", "Australia", "Automotive Industry", "customer4@example.com"},
//                {"Customer5five", "hhfg767", "Germany", "Automotive Industry", "customer5@example.com"}
        };
        for (String[] data : customerData) {
           customerMgmtPage.createCustomer(data[0], data[1], data[2], data[3], data[4]);
        }

    }

     @Test(priority = 4)
              public void editcustomer(){
        editCustomer=new Customer_Edition(page);
        editCustomer.edit("884455744");

        }
        @Test(priority = 2)
    public void setSwitchmodule()
        {
            Switchmodule=new Swiching_Module(page);
            Switchmodule.navigateToCustomers();

        }



     //  @Test(priority = 8)
    public  void setEditproject() throws InterruptedException {
        editProject=new Project_Edition(page);
        editProject.editproject();

        }
    // @Test(priority = 7)
        public  void setCreateProject() throws InterruptedException {
        createProjectCrm=new Project_Creation_using_Commonactions(page);
        createProjectCrm.create();
        }
      @Test(priority = 6)
    public void filtering(){
        filteringCustomername=new Filtering_Customer_and_Status_Changing(page);
        filteringCustomername.status();

      }
      @Test(priority = 5)
    public  void setCustomeruniquevalidation(){
        customeruniquevalidation=new Customer_Name_Unique_Validation(page);
       customeruniquevalidation.uniquevalidation();
      }
}
