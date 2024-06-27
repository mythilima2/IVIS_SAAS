package commonactions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Actions {
    private final Page page;

    public Actions(Page page) {
        this.page = page;
    }

     public void click(Locator locator) {
        locator.click();
    }

    public void fill(Locator locator, String text) {
        locator.fill(text);
    }
}
