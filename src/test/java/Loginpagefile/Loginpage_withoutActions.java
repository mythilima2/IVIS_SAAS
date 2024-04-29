package Loginpagefile;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;


public class Loginpage_withoutActions
{
     Page page;
    public Loginpage_withoutActions(Page page)
    {
        this.page = page;
    }

        public void login(String username, String password) {
            page.getByPlaceholder("Email or Username").fill(username);
            page.locator("#password").fill(password);
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        }
    }
