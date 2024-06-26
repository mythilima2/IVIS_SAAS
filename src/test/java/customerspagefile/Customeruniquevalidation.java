package customerspagefile;

import CommonMethods.Actions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;

import java.util.regex.Pattern;

public class Customeruniquevalidation {
    private final Page page;
    private final Actions commonMethods;

    public Customeruniquevalidation(Page page) {
        this.page = page;
        this.commonMethods = new Actions(page);
    }
    public void uniquevalidation(){
        page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Customers$"))).locator("svg").nth(2).click();
        page.fill("'Customer Name'","Testing Example");
        page.fill("'Customer Code'","Test Example");
        commonMethods.click(page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")));
        String customernameuniqueevalidation = page.locator("'This Customer name is already taken'").textContent();
        Assert.assertEquals("This Customer name is already taken", customernameuniqueevalidation);
        System.out.println(customernameuniqueevalidation);
        String customercodeuniqueevalidation = page.locator("'This Customer code is already taken'").textContent();
        Assert.assertEquals("This Customer code is already taken", customercodeuniqueevalidation);
        System.out.println(customercodeuniqueevalidation);
        page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Create Customer$"))).locator("path").click();
    }
}
