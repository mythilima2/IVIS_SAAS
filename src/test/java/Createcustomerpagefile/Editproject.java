package Createcustomerpagefile;

import CommonMethods.Actions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;

public class Editproject {
    private final Page page;
    private final Actions commonMethods;


    public Editproject(Page page) {git
        this.page = page;
        this.commonMethods = new Actions(page);
    }

    public void editproject() {
        page.locator("//span[text()='fhdyuyygf']").click();
       // page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("fhdyuyygf")).click();
        page.getByText("Edit").click();
        page.locator("#projectName").click();
        page.locator("#projectName").fill("fhdyuyygfok");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("SAVE")).click();
        page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^fhdyuyygfok$"))).locator("svg").click();
    }
}
