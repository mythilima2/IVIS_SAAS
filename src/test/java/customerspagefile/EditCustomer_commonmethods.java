package customerspagefile;

import CommonMethods.Actions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class EditCustomer_commonmethods {
    private final  Page page;
     private final Actions commonMethods;

    public EditCustomer_commonmethods(Page page) {
        this.page = page;
        this.commonMethods = new Actions(page);
    }

    public void edit(String editcode) {
        page.waitForTimeout(10000);
       // page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Customers")).click();
        page.locator("//span[text()='Automationjavatwo']").click();
        page.getByText("Edit").click();
        page.getByPlaceholder("Phone Number").fill("8712269937");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Active")).click();
        page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("Country Open")).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Open")).click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("India")).click();
        page.getByPlaceholder("State").click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Andhra Pradesh (AP)")).click();
        page.getByPlaceholder("Lead Number").click();
        commonMethods.fill(page.getByPlaceholder("Lead Number"),editcode);
        page.locator("text=SAVE").click();
        page.waitForTimeout(10000);


    }
}
