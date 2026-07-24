package locators;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CommonLocators {

        public final Locator loader;

        public CommonLocators(Page page) {

            // Material UI Progress Loader
            loader = page.locator("[role='progressbar']");
        }
}
