package pagefile.customers;

import commonactions.Actions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;


import java.util.regex.Pattern;

public class Customer_Creation_using_Commonactions {
    private final Page page;
    private final Actions commonMethods;

    public Customer_Creation_using_Commonactions(Page page) {
        this.page = page;
        this.commonMethods = new Actions(page);
    }

    public void createCustomer(String customerName, String customerCode, String country, String industry, String email) {
       page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Customers")).click();
        page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Customers$"))).locator("svg").nth(2).click();
        commonMethods.click(page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")));
        String customernamevalidation = page.locator("'Please enter the Customer Name'").textContent();
        // Assert the value using equals
        Assert.assertEquals("Please enter the Customer Name", customernamevalidation);
        System.out.println(customernamevalidation);
        String countrynamevalidation = page.locator("'Please select the Country'").textContent();
        Assert.assertEquals("Please select the Country", countrynamevalidation);
        System.out.println(countrynamevalidation);
        String customercodenamevalidation = page.locator("'Please enter the Customer Code'").textContent();

        Assert.assertEquals("Please enter the Customer Code", customercodenamevalidation);
        System.out.println(customercodenamevalidation);
        String EmailMandatoryvalidation = page.locator("'Please enter the Email'").textContent();

        Assert.assertEquals("Please enter the Email", EmailMandatoryvalidation);
        System.out.println(EmailMandatoryvalidation);
        String typeMandatoryvalidation = page.locator("'Please select the Type'").textContent();
        Assert.assertEquals("Please select the Type", typeMandatoryvalidation);
        System.out.println(typeMandatoryvalidation);
        String IndustryMandatoryvalidation = page.locator("'Please select the Industry'").textContent();
        Assert.assertEquals("Please select the Industry", IndustryMandatoryvalidation);
        System.out.println(IndustryMandatoryvalidation);
        commonMethods.fill(page.getByPlaceholder("Customer Name"), customerName);
        commonMethods.click(page.getByPlaceholder("Country"));
        commonMethods.click(page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName(country)));
        commonMethods.fill(page.getByPlaceholder("Customer Code"), customerCode);
        commonMethods.click(page.getByPlaceholder("Industry"));
        commonMethods.click(page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName(industry)));
        commonMethods.fill(page.getByPlaceholder("Email"), email);
//        String customernameuniqueevalidation = page.locator("'This Customer name is already taken'").textContent();
//        Assert.assertEquals("This Customer name is already taken", customernameuniqueevalidation);
//        System.out.println(customernameuniqueevalidation);
//        String customercodeuniqueevalidation = page.locator("'This Customer code is already taken'").textContent();
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
        String BillingCountryMandatoryvalidation = page.locator("'Please select the Billing Country'").textContent();
        Assert.assertEquals("Please select the Billing Country", BillingCountryMandatoryvalidation);
        System.out.println(BillingCountryMandatoryvalidation);
        page.getByLabel("Same as customer Address").check();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("close")).click();
    }
}


