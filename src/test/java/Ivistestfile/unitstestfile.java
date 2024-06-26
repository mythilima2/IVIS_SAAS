package Ivistestfile;

import Ivisbasefile.Createcustomer.basepage;
import Loginpagefile.Loginpage_usingCommonmethods;
import SwitchModules.Swiching_Module;
import org.testng.annotations.Test;
import sitegroupspagefile.Sitegroup_Creation;
import unitspagefile.Unitscreation_csm;

public class unitstestfile extends basepage {
    Loginpage_usingCommonmethods login;
    Swiching_Module Switchmodule;

    Unitscreation_csm unitscreationCsm;
    @Test(priority = 1)
    public void testCreateCustomer() {
        login=new Loginpage_usingCommonmethods(page);
        login.login("tenantadmin@motivitylabs.com", "Ivis@1234");
    }
    @Test(priority = 2)
    public void setSwitchmodule()
    {
        Switchmodule=new Swiching_Module(page);
        Switchmodule.navigateToCustomers();

    }
    @Test(priority = 3)
    public void runcreatesitegroup(){
        unitscreationCsm=new Unitscreation_csm(page);
        unitscreationCsm.createUnit();
    }
}


