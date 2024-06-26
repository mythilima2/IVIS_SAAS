package Ivistestfile;

import Ivisbasefile.Createcustomer.URLaunching_SeleniumGrid;
import Loginpagefile.Loginpage_usingCommonmethods;
import Projectspagefile.CreateProject_usingcommonmethods;
import Projectspagefile.Editproject;
import SwitchModules.Swiching_Module;
import org.testng.annotations.Test;

public class Projectstestfile_TestNG  extends URLaunching_SeleniumGrid {
    Loginpage_usingCommonmethods login;
    CreateProject_usingcommonmethods createProjectCrm;
    Editproject editProject;
    Swiching_Module Switchmodule;
    @Test(priority = 1)
    public void testCreateCustomer() {
        login=new Loginpage_usingCommonmethods(page);
        login.login("veera.rangina@motivitylabs.com", "Ivis@123");
    }

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
