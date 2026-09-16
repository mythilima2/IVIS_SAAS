package pagefile.switchmodules;

import commonactions.Actions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.regex.Pattern;

public class Swiching_Module {
    private final Page page;
    private final Actions commonMethods;

    public Swiching_Module(Page page) {
        this.page = page;
        this.commonMethods = new Actions(page);
    }

    public void navigateToCustomers() {
        page.getByText("Management", new Page.GetByTextOptions().setExact(true)).click();
        page.waitForTimeout(1000);
        page.getByText("Config Mgmt").click();
    }

    public void navigateToMonitoring() {
        page.getByText("Management", new Page.GetByTextOptions().setExact(true)).click();
        page.waitForTimeout(1000);
        page.getByText("Monitoring", new Page.GetByTextOptions().setExact(true)).first().click();
    }
}
