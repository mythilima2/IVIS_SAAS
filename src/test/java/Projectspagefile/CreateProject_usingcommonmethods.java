package Projectspagefile;

import CommonMethods.Actions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;

import java.util.regex.Pattern;


public class CreateProject_usingcommonmethods {
    private final Page page;
    private final Actions commonMethods;


      public CreateProject_usingcommonmethods(Page page) {
        this.page = page;
        this.commonMethods = new Actions(page);
    }


    public void create() throws InterruptedException {
                page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Projects")).click();
        page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Projects$"))).locator("svg").nth(2).click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
        String customernamevalidation = page.locator("'Please select the Customer Name'").textContent();
        // Assert the value using equals
        Assert.assertEquals("Please select the Customer Name", customernamevalidation);
        System.out.println(customernamevalidation);
        String projectnamevalidation = page.locator("'Please enter the Project Name'").textContent();
        Assert.assertEquals("Please enter the Project Name", projectnamevalidation);
        System.out.println(projectnamevalidation);
        String projecttypenamevalidation = page.locator("'Please select the Project Type'").textContent();

        Assert.assertEquals("Please select the Project Type", projecttypenamevalidation);
        System.out.println(projecttypenamevalidation);
        String hierarchyMandatoryvalidation = page.locator("'Please select the Hierarchy'").textContent();

        Assert.assertEquals("Please select the Hierarchy", hierarchyMandatoryvalidation);
        System.out.println(hierarchyMandatoryvalidation);
                page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Please select the Customer Name$"))).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Open")).click();
                page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("ABC Electronics")).click();
                page.getByPlaceholder("Project Name").click();
                page.getByPlaceholder("Project Name").fill("fhdyuyygf");
                page.waitForTimeout(1000);
        String projectnameUNIQUEvalidation = page.locator("'This project name is already taken'").textContent();
        Assert.assertEquals("This project name is already taken", projectnameUNIQUEvalidation);
        System.out.println(projectnameUNIQUEvalidation);
        page.getByPlaceholder("Project Name").fill("TestingQAone project");
        Thread.sleep(2000);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Select Project Type")).click();
                page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Money Chest")).click();
                page.getByPlaceholder("Hierarchy").click();
                page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Area").setExact(true)).click();
        page.locator("//button[normalize-space()='Next']").click();
        page.locator("'Next'").click();
        String billingCountrynamevalidation = page.locator("'Please select the Billing Country'").textContent();
        Assert.assertEquals("Please select the Billing Country", billingCountrynamevalidation);
        System.out.println(billingCountrynamevalidation);
//        String billingStatevalidation = page.locator("'Please select the Billing State'").textContent();
//
//        Assert.assertEquals("Please select the Billing State", billingStatevalidation);
//        System.out.println(billingStatevalidation);
//        String billingCityMandatoryvalidation = page.locator("'Please enter the Billing City'").textContent();
//
//        Assert.assertEquals("Please enter the Billing City", billingCityMandatoryvalidation);
//        System.out.println(billingCityMandatoryvalidation);
//        String BillingZIPCodeMandatoryvalidation = page.locator("'Please enter the Billing ZIP Code'").textContent();
//        Assert.assertEquals("Please enter the Billing ZIP Code", BillingZIPCodeMandatoryvalidation);
//        System.out.println(BillingZIPCodeMandatoryvalidation);
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

