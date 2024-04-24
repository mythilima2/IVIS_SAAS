package Ivistestfile;

import Createcustomerpagefile.Loginpage_withoutActions;
import Createcustomerpagefile.CustomerCreation_withoutCommonmethods;
import Ivisbasefile.Createcustomer.basepage;
import org.testng.annotations.Test;

public class CreateCustomer_withoutCommonmethods extends basepage {
Loginpage_withoutActions login;
CustomerCreation_withoutCommonmethods customerMgmtPage;

        @Test(priority = 1)
            public void testCreateCustomer() {
            login=new Loginpage_withoutActions(page);
            login.login("veera.rangina@motivitylabs.com", "Ivis@1234");
        }
          @Test(priority = 2)
                  public void create(){
            customerMgmtPage=new CustomerCreation_withoutCommonmethods(page);
            customerMgmtPage.navigateToCustomers();
            customerMgmtPage.createCustomer("abc", "45454", "United States of America", "Automotive Industry", "bekkkkkkkk@gmail.com");

            // Add assertions to verify successful customer creation (omitted for brevity)

            //teardown();
        }
    }
