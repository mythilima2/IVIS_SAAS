package testfile;

import basefile.URL.launching.Dev2v2_URLlaunching_ParallelExecution;
import pagefile.login.Loginpage_usingCommonmethods;
import pagefile.projects.Project_Creation_using_Commonactions;
import pagefile.projects.Project_Edition;
import pagefile.switchmodules.Swiching_Module;
import org.testng.annotations.Test;

public class Projectstestfile_TestNG  extends Dev2v2_URLlaunching_ParallelExecution {
    Loginpage_usingCommonmethods login;
    Project_Creation_using_Commonactions createProjectCrm;
    Project_Edition editProject;
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
        editProject=new Project_Edition(page);
        editProject.editproject();

    }
    @Test(priority = 3)
    public  void setCreateProject() throws InterruptedException {
        createProjectCrm=new Project_Creation_using_Commonactions(page);
        createProjectCrm.create();
    }


}
