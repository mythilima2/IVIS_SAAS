package pagefile.customers;

import commonactions.Actions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;

public class Customer_Edition {
    private final  Page page;
     private final Actions commonMethods;

    public Customer_Edition(Page page) {
        this.page = page;
        this.commonMethods = new Actions(page);
    }

    public void edit(String editcode) {
        page.waitForTimeout(5000);
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Customers")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cs80m")).click();

       // page.locator("'EditCustomer'").click();
        page.locator("'Edit'").click();
        page.getByPlaceholder("Customer Name").fill("");
        page.getByPlaceholder("Customer Code").fill("");
        page.getByPlaceholder("Email").fill("");
        page.locator("text=SAVE").click();
        String customernameeditvalidation = page.locator("'Please enter valid  Customer Name'").textContent();
       Assert.assertEquals("Please enter valid  Customer Name", customernameeditvalidation);
       System.out.println(customernameeditvalidation);
        String customercodenamevalidation = page.locator("'Atleast 3 characters  required'").textContent();
        Assert.assertEquals("Atleast 3 characters  required", customercodenamevalidation);
        System.out.println(customercodenamevalidation);
        String EmailMandatoryvalidation = page.locator("'Please enter the Email'").textContent();
        Assert.assertEquals("Please enter the Email", EmailMandatoryvalidation);
        System.out.println(EmailMandatoryvalidation);
        page.getByPlaceholder("Customer Name").fill("Edit Customer");
        //page.getByPlaceholder("Customer Code").fill("6456465");
        page.getByPlaceholder("Customer Code").fill("Testing Example");
        page.getByPlaceholder("Customer Code").fill("Test Example");
        page.waitForTimeout(5000);
        page.getByPlaceholder("Email").fill("bekkam@gmail.com");
        page.getByPlaceholder("Phone Number").fill("8712269937");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Active")).click();
        page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("Country Open")).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Open")).click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("India")).click();
        page.getByPlaceholder("State").click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Andhra Pradesh (AP)")).click();
        page.getByPlaceholder("Lead Number").click();
        commonMethods.fill(page.getByPlaceholder("Lead Number"),editcode);
//        String customernameuniquevalidation = page.locator("'This Customer name is already taken'").textContent();
//        Assert.assertEquals("This Customer name is already taken", customernameuniquevalidation);
//        System.out.println(customernameuniquevalidation);
        //page.locator("'SAVE'").click();
//        String customercodeuniquevalidation = page.locator("'This Customer code is already taken'").textContent();
//        Assert.assertEquals("This Customer code is already taken", customercodeuniquevalidation);
//        System.out.println(customercodeuniquevalidation);
        page.getByPlaceholder("Customer Name").fill("Automationedittest");
        page.getByPlaceholder("Customer Code").fill("67677767");
        page.locator("'SAVE'").click();
        page.locator("//div[@class='d-flex px-3 pt-3']//*[name()='svg']//*[name()='path' and contains(@fill,'currentCol')]").click();
        page.waitForTimeout(1000);


    }
}
