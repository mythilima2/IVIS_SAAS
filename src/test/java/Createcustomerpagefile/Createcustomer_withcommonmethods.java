package Createcustomerpagefile;

import CommonMethods.Actions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;

import java.util.regex.Pattern;

public class Createcustomer_withcommonmethods {
    private final Page page;
    private final Actions commonMethods;

    public Createcustomer_withcommonmethods(Page page) {
        this.page = page;
        this.commonMethods = new Actions(page);
    }

    public void navigateToCustomers() {
        //commonMethods.click(page.getByText("Management", new Page.GetByTextOptions().setExact(true)));
        page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Field Maintenance$"))).locator("svg").click();
        commonMethods.click(page.getByText("Customer-Site Mgmt"));
        commonMethods.click(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Customers")));
    }

    public void createCustomer(String customerName, String customerCode, String country, String industry, String email) {
        // Logic to handle click on specific customer based on name or other criteria
        page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Customers$"))).locator("svg").nth(2).click();

        //commonMethods.click(page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Customers$"))).locator("svg").nth(3));
        commonMethods.click(page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")));
        //String actualValue = page.locator("locator for the element").textContent();
        String customernamevalidation = page.locator("'Please enter the Customer Name'").textContent();
        // Assert the value using equals
       Assert.assertEquals("Please enter the Customer Name", customernamevalidation);
        System.out.println(customernamevalidation);
        String countrynamevalidation = page.locator("'Please select the Country'").textContent();
        Assert.assertEquals("Please select the Country", countrynamevalidation);
       // Assert.assertTrue(countrynamevalidation.contains("Please enter the Customer Code"));

        System.out.println(countrynamevalidation);


// Assert that customernamevalidation contains "Please enter the Customer Name"
      //  System.out.println(customercodenamevalidation);
        String customercodenamevalidation = page.locator("'Please enter the Customer Code'").textContent();

        Assert.assertEquals("Please enter the Customer Code", customercodenamevalidation);
        System.out.println(customercodenamevalidation);


// Assert that customernamevalidation contains "Please enter the Customer Name"
       // Assert.assertTrue(countrynamevalidation.contains("Please select the Country"));


        commonMethods.fill(page.getByPlaceholder("Customer Name"), customerName);

        commonMethods.click(page.getByPlaceholder("Country"));
       // commonMethods.click(page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName(country)));
        commonMethods.fill(page.getByPlaceholder("Customer Code"), customerCode);
        commonMethods.click(page.getByPlaceholder("Industry"));
        commonMethods.click(page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName(industry)));
        commonMethods.fill(page.getByPlaceholder("Email"), email);
        String customernameuniqueevalidation = page.locator("'This Customer name is already taken'").textContent();

        Assert.assertEquals("This Customer name is already taken", customernameuniqueevalidation);
        System.out.println(customernameuniqueevalidation);
//        String customercodeuniqueevalidation = page.locator("'This Customer code is already taken'").textContent();
//
//        Assert.assertEquals("This Customer code is already taken", customercodeuniqueevalidation);
//        System.out.println(customercodeuniqueevalidation);
        commonMethods.click(page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")));
        commonMethods.click(page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")));
       commonMethods.click(page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Open")).first());
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("United States of America")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Open")).nth(1).click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Califonria (CA)")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Open")).nth(2).click();
        //page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Anaheim")).click();

        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("ATM")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Select Type")).click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("B2B")).click();
        page.locator("'Next'").click();
        page.locator("'Next'").click();
        page.locator("'Next'").click();
        page.getByLabel("Same as customer Address").check();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("close")).click();
        page.locator("(//input[@aria-label='Select row'])[2]").click();
      //  page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName("Select row Custome3three Ivis_India_A DHFH76 Active 0 0 0 cctv 0")).getByRole(AriaRole.CHECKBOX, new Locator.GetByRoleOptions().setName("Select row")).check();
    }
            }


