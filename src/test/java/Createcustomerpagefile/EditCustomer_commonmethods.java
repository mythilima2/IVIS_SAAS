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
        page.locator("//span[text()='Cs80m']").click();
        page.getByText("Edit").click();
        page.getByPlaceholder("Lead Number").click();
        commonMethods.fill(page.getByPlaceholder("Lead Number"),editcode);
        page.locator("text=SAVE").click();
        page.waitForTimeout(50000);

    }
}
