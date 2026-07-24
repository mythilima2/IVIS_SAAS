package locators;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginLocators {


        public final Locator txtUsername;
        public final Locator txtPassword;
        public final Locator btnLogin;

        public LoginLocators(Page page) {
            txtUsername = page.getByPlaceholder("Email or Username");
            txtPassword = page.locator("#password");
            btnLogin = page.getByRole(
                    AriaRole.BUTTON,
                    new Page.GetByRoleOptions().setName("Login")
            );

    }
}
