package pagefile.login;

import commonactions.Actions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import locators.LoginLocators;

public class Loginpage_usingCommonmethods {


        private final Page page;
        private final Actions commonMethods;
        private final LoginLocators loginLocators;

        public Loginpage_usingCommonmethods(Page page) {
            this.page = page;
            this.commonMethods = new Actions(page);
            this.loginLocators = new LoginLocators(page);
        }

        public void login(String username, String password) {

            commonMethods.fill(loginLocators.txtUsername, username);
            commonMethods.fill(loginLocators.txtPassword, password);
            commonMethods.click(loginLocators.btnLogin);

    }

}
