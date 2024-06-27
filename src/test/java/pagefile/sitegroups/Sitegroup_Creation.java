package pagefile.sitegroups;

import commonactions.Actions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;

public class Sitegroup_Creation {
    private final Page page;
    private final Actions commonMethods;

    public Sitegroup_Creation(Page page) {
        this.page = page;
        this.commonMethods = new Actions(page);
    }
    public void sitegroupCreate(){
    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Site Groups")).click();
      page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Site Groups$"))).locator("svg").nth(2).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("NEXT")).click();
      page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("APCOB")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Select Project")).click();
      page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("APCOB").setExact(true)).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Select Parent Site Group")).click();
      page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Project - Project-APCOB")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Select Site Group Type")).click();
      page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("CSO")).click();
      page.getByPlaceholder("SG_TYPE_CUSTOMER_NAME").fill("Sample_Sitegroup");
      page.getByPlaceholder("Description").fill("Sample");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("NEXT")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("close")).click();
}
}
