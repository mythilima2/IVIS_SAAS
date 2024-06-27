package testfile;

import basefile.URL.launching.Dev1v2_URLlaunching;
import pagefile.login.Loginpage_usingCommonmethods;
import pagefile.switchmodules.Swiching_Module;
import org.testng.annotations.Test;
import pagefile.sitegroups.Sitegroup_Creation;

public class Sitegrouptestfile extends Dev1v2_URLlaunching {
    Loginpage_usingCommonmethods login;
    Swiching_Module Switchmodule;
    Sitegroup_Creation sitegroupCreation;
    @Test(priority = 1)
    public void testCreateCustomer() {
        login=new Loginpage_usingCommonmethods(page);
        login.login("veera.rangina@motivitylabs.com", "Ivis@1234");
    }
    @Test(priority = 2)
    public void setSwitchmodule()
    {
        Switchmodule=new Swiching_Module(page);
        Switchmodule.navigateToCustomers();

    }
    @Test(priority = 3)
    public void runcreatesitegroup(){
        sitegroupCreation=new Sitegroup_Creation(page);
        sitegroupCreation.sitegroupCreate();
    }
}
