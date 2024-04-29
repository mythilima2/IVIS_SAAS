package Loginpagefile;

import CommonMethods.Actions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class Loginpage_usingCommonmethods {
     Page page;
     Actions commonMethods;

    public Loginpage_usingCommonmethods(Page page) {
        this.page = page;
        this.commonMethods = new Actions(page);
    }


    public void login(String username, String password) {
        commonMethods.fill(page.getByPlaceholder("Email or Username"), username);
        commonMethods.fill(page.locator("#password"), password);
        commonMethods.click(page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")));
    }
}
