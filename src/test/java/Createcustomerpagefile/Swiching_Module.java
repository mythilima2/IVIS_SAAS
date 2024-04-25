package Createcustomerpagefile;

import CommonMethods.Actions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;

public class Swiching_Module {
    private final Page page;
    private final Actions commonMethods;

    public Swiching_Module(Page page) {
        this.page = page;
        this.commonMethods = new Actions(page);
    }

    public void navigateToCustomers() {
        page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Field Maintenance$"))).locator("svg").click();
        page.locator("'Customer-Site Mgmt'").click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Customers")).click();
    }
}
