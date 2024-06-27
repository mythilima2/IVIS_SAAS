package testfile;

import pagefile.login.Loginpage_withoutActions;
import pagefile.customers.Customer_Creation_without_Commonactions;
import basefile.URL.launching.Dev1v2_URLlaunching;
import org.testng.annotations.Test;

public class CreateCustomer_withoutCommonmethods extends Dev1v2_URLlaunching {
Loginpage_withoutActions login;
Customer_Creation_without_Commonactions customerMgmtPage;

        @Test(priority = 1)
            public void testCreateCustomer() {
            login=new Loginpage_withoutActions(page);
            login.login("veera.rangina@motivitylabs.com", "Ivis@1234");
        }
          @Test(priority = 2)
                  public void create(){
            customerMgmtPage=new Customer_Creation_without_Commonactions(page);
            customerMgmtPage.navigateToCustomers();
            customerMgmtPage.createCustomer("automation", "45454", "United States of America", "Automotive Industry", "bekkkkkkkk@gmail.com");
        }
    }
