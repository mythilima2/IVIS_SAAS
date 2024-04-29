package Ivistestfile;

import customerspagefile.*;
import Ivisbasefile.Createcustomer.basepage;
import Loginpagefile.Loginpage_usingCommonmethods;
import Projectspagefile.CreateProject_usingcommonmethods;
import Projectspagefile.Editproject;
import SwitchModules.Swiching_Module;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.testng.reporters.TestHTMLReporter.class)

public class CreateCustomerWithCommonMethods extends basepage {
    Loginpage_usingCommonmethods login;
    Createcustomer_withcommonmethods customerMgmtPage;
    EditCustomer_commonmethods editCustomer;
    CreateProject_usingcommonmethods createProjectCrm;
    Editproject editProject;
    Swiching_Module Switchmodule;
    FilteringCustomername filteringCustomername;

    @Test(priority = 1)
    public void testCreateCustomer() {
        login=new Loginpage_usingCommonmethods(page);
        login.login("veera.rangina@motivitylabs.com", "Ivis@1234");
    }
   // @Test(priority = 3)
    public void create() {
        customerMgmtPage = new Createcustomer_withcommonmethods(page);

        //customerMgmtPage.createCustomer("abdefg", "454564", "United States of America", "Automotive Industry", "bekkkkkkkk@gmail.com");
        String[][] customerData = {
                {"Automn0avatwo", "4506i5", "United States of America", "Automotive Industry", "customer1@example.com"},
//               {"Customer2two", "785758", "United Kingdom", "Automotive Industry", "customer2@example.com"},
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
        editCustomer=new EditCustomer_commonmethods(page);
        editCustomer.edit("894055445565744");

        }
        @Test(priority = 2)
    public void setSwitchmodule()
        {
            Switchmodule=new Swiching_Module(page);
            Switchmodule.navigateToCustomers();

        }



       // @Test(priority = 6)
    public  void createproject() throws InterruptedException {
        editProject=new Editproject(page);
        editProject.editproject();

        }
      //  @Test(priority = 5)
        public  void setCreateProject(){
        createProjectCrm=new CreateProject_usingcommonmethods(page);
        createProjectCrm.create();
        }
     // @Test(priority = 7)
    public void filtering(){
        filteringCustomername=new FilteringCustomername(page);
        filteringCustomername.status();

      }
}
