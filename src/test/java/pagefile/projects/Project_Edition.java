package pagefile.projects;

import commonactions.Actions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;

public class Project_Edition {
    private final Page page;
    private final Actions commonMethods;


    public Project_Edition(Page page) {
        this.page = page;
        this.commonMethods = new Actions(page);
    }

    public void editproject() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Test project")).first().click();
        page.getByText("Edit").click();
        page.locator("#projectName").click();
        page.locator("#projectName").fill("");

        String projectnamevalidation = page.locator("'Please enter valid  Project Name'").textContent();
        Assert.assertEquals("Please enter valid  Project Name", projectnamevalidation);
        System.out.println(projectnamevalidation);
        page.locator("#projectName").fill("Test automation");
//        String projectnameUNIQUEvalidation = page.locator("'This project name is already taken'").textContent();
//        Assert.assertEquals("This project name is already taken", projectnameUNIQUEvalidation);
//        System.out.println(projectnameUNIQUEvalidation);
        page.locator("#projectName").fill("Testautomate");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("SAVE")).click();

    }
}
