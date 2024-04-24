package Createcustomerpagefile;

import CommonMethods.Actions;
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

       //commonMethods.click(page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Create Customer$"))).locator("path"));
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Customers")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Ford")).click();
        page.getByText("Edit").click();
        page.getByPlaceholder("Lead Number").click();
        commonMethods.fill(page.getByPlaceholder("Lead Number"),editcode);//fill("77877");
       // page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("SAVE")).click();
       // page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("SAVE")).click();
        page.locator("text=SAVE").click();
        page.waitForTimeout(50000);

    }
}
