package Createcustomerpagefile;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;

public class CustomerCreation_withoutCommonmethods {
    Page page;
    public CustomerCreation_withoutCommonmethods(Page page)
    {
        this.page=page;
    }
        public void navigateToCustomers() {
            page.getByText("Management", new Page.GetByTextOptions().setExact(true)).click();
            page.getByText("Customer-Site Mgmt").click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Customers")).click();
        }

        public void createCustomer(String customerName, String customerCode, String country, String industry, String email) {
            // Logic to handle click on specific customer based on name or other criteria
            // page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Customers$"))).locator("svg").nth(3).click();
            page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Field Maintenance$"))).locator("svg").click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
            page.getByPlaceholder("Customer Name").fill(customerName);
            page.getByPlaceholder("Country").click();
            page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName(country)).click();
            page.getByPlaceholder("Customer Code").fill(customerCode);
            page.getByPlaceholder("Industry").click();
            page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName(industry)).click();
            page.getByPlaceholder("Email").fill(email);

            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
            page.waitForTimeout(50000);

            // Implement navigation and handling for subsequent steps (omitted for brevity)
        }
    }

