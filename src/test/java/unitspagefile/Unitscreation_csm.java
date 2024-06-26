package unitspagefile;

import CommonMethods.Actions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;

public class Unitscreation_csm {
    private final Page page;
    private final Actions commonMethods;


    public Unitscreation_csm(Page page) {
        this.page = page;
        this.commonMethods = new Actions(page);
    }
    public void createUnit(){page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Units")).click();
        page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Units$"))).locator("svg").nth(2).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("NEXT")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Select Customer Name")).click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Amol")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Select Site Name")).click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Pune-Demo")).click();
        page.getByPlaceholder("Unit Name").click();
        page.getByPlaceholder("Unit Name").fill("Sample ");
        page.getByPlaceholder("Unit Name").press("CapsLock");
        page.getByPlaceholder("Unit Name").fill("Sample QA ");
        page.getByPlaceholder("Unit Name").press("CapsLock");
        page.getByPlaceholder("Unit Name").fill("Sample QA automation");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("NEXT")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
        page.getByPlaceholder("Monitoring SOP").click();
        page.getByPlaceholder("Monitoring SOP").fill("Sample ");
        page.getByPlaceholder("Monitoring SOP").press("CapsLock");
        page.getByPlaceholder("Monitoring SOP").fill("Sample SOP");
        page.getByPlaceholder("Monitoring SOP").press("CapsLock");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Choose date")).first().click();
        page.getByRole(AriaRole.GRIDCELL, new Page.GetByRoleOptions().setName("8").setExact(true)).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Choose date").setExact(true)).click();
        page.getByRole(AriaRole.GRIDCELL, new Page.GetByRoleOptions().setName("9").setExact(true)).click();
        page.getByPlaceholder("Monitoring Title").click();
        page.getByPlaceholder("Monitoring Title").fill("Sample title");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
        page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Please select the Installation Date$"))).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Choose date")).click();
        page.getByRole(AriaRole.GRIDCELL, new Page.GetByRoleOptions().setName("8").setExact(true)).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
        page.getByPlaceholder("iVIS Unit Id").click();
        page.getByPlaceholder("iVIS Unit Id").fill("");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Back")).click();
        page.getByPlaceholder("iVIS Unit Id").click();
        page.getByPlaceholder("iVIS Unit Id").fill("testunitid");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("close")).click();

    }

}
