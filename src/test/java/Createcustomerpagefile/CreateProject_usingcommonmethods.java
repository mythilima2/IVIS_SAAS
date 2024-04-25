package Createcustomerpagefile;

import CommonMethods.Actions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import java.util.regex.Pattern;


public class CreateProject_usingcommonmethods {
    private final Page page;
    private final Actions commonMethods;


      public CreateProject_usingcommonmethods(Page page) {
        this.page = page;
        this.commonMethods = new Actions(page);
    }


    public void create(){
                page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Ford$"))).locator("path").click();
                page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Projects")).click();
                page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Projects$"))).locator("svg").nth(3).click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
                page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Please select the Customer Name$"))).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Open")).click();
                page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("ABC Electronics")).click();
                page.getByPlaceholder("Project Name").click();
                page.getByPlaceholder("Project Name").fill("fhdyuyygf");
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Select Project Type")).click();
                page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Money Chest")).click();
                page.getByPlaceholder("Hierarchy").click();
                page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Area").setExact(true)).click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Select Country")).click();
                page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("United States of America")).click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Select State")).click();
                page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Delaware (DE)")).click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Select City")).click();
                page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Lewes")).click();
                page.getByPlaceholder("Billing ZIP Code").click();
                page.getByPlaceholder("Billing ZIP Code").fill("454545");
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create")).click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("close")).click();
            }
        }

