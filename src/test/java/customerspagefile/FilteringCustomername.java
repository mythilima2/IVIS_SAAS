package customerspagefile;

import CommonMethods.Actions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;

import java.util.regex.Pattern;

public class FilteringCustomername {
    private final Page page;
    private final Actions commonMethods;

    public FilteringCustomername(Page page) {
        this.page = page;
        this.commonMethods = new Actions(page);
    }
    public void status() {
        page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName("Checkbox selection Customer Name Tenant Name Customer Code Website Phone Number Status Projects | Sites | Units | Devices")).getByRole(AriaRole.COLUMNHEADER, new Locator.GetByRoleOptions().setName("Customer Name")).getByLabel("Contains").fill("Cs80m");
        page.waitForTimeout(10000);
        page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Select row")).check();
        page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Customers$"))).locator("svg").nth(1).click();
        page.getByLabel("Accept and continue").check();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes")).click();
        String Status=page.locator("'Inactive'").textContent();
        System.out.println(Status);
        page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Select row")).check();
        page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Customers$"))).locator("svg").first().click();
        page.getByLabel("Accept and continue").check();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes")).click();
        String Statuschecking=page.getByText("Active", new Page.GetByTextOptions().setExact(true)).textContent();
        System.out.println(Statuschecking);
        page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Select row")).check();
        page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Customers$"))).locator("svg").first().click();
        String Alreadyactive = page.locator("'You cannot activate customers who are already active.'").textContent();
               Assert.assertEquals("You cannot activate customers who are already active.", Alreadyactive);
               System.out.println(Alreadyactive);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("ok")).click();
        page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Select row")).check();
        page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Customers$"))).locator("svg").nth(1).click();
        page.getByLabel("Accept and continue").check();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes")).click();
        page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Select row")).check();
        page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Customers$"))).locator("svg").nth(1).click();
        String Alreadyinactive = page.locator("'You cannot deactivate customers who are already inactive.'").textContent();
        Assert.assertEquals("You cannot deactivate customers who are already inactive." , Alreadyinactive);
        System.out.println(Alreadyinactive);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("ok")).click();
    }
}
