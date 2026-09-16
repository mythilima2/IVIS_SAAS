package locators;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginLocators {


        public final Locator txtUsername;
        public final Locator txtPassword;
        public final Locator btnLogin;

    public Locator profileIcon;
    public Locator logoutButton;
    public Locator confirmLogoutButton;
        public LoginLocators(Page page) {
            txtUsername = page.getByPlaceholder("Email or Username");
            txtPassword = page.locator("#password");
            btnLogin = page.getByRole(
                    AriaRole.BUTTON,
                    new Page.GetByRoleOptions().setName("Login")
            );


                profileIcon = page.locator(
                        ".admin-container.ms-4 > div > .navbar > .dropdown > div:nth-child(2) > .dropbtn > .svg-inline--fa"
                );

                logoutButton = page.getByText("Logout");

                confirmLogoutButton = page.getByRole(
                        com.microsoft.playwright.options.AriaRole.BUTTON,
                        new Page.GetByRoleOptions().setName("Yes")
                );
            }

    }

