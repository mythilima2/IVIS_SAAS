package commonactions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitForSelectorState;
import locators.CommonLocators;

import java.nio.file.Paths;

public class Actions {


    private final Page page;
    private final CommonLocators common;

    private static final int TIMEOUT = 60000;

    public Actions(Page page) {
        this.page = page;
        this.common = new CommonLocators(page);
    }

    /**
     * Wait until element is visible.
     */
    private void waitForVisible(Locator locator) {
        locator.waitFor(
                new Locator.WaitForOptions()
                        .setState(WaitForSelectorState.VISIBLE)
                        .setTimeout(TIMEOUT)
        );
    }

    /**
     * Wait until loader disappears.
     */
    public void waitForLoader() {

        try {

            if (common.loader.count() > 0) {

                common.loader.first().waitFor(
                        new Locator.WaitForOptions()
                                .setState(WaitForSelectorState.HIDDEN)
                                .setTimeout(TIMEOUT)
                );
            }

        } catch (Exception ignored) {
            // Loader already disappeared or not present.
        }
    }

    /**
     * Click an element.
     */
    public void click(Locator locator) {

        waitForVisible(locator);

        locator.scrollIntoViewIfNeeded();

        locator.click(
                new Locator.ClickOptions()
                        .setTimeout(TIMEOUT)
        );

        waitForLoader();
    }

    /**
     * Double Click.
     */
    public void doubleClick(Locator locator) {

        waitForVisible(locator);

        locator.dblclick();

        waitForLoader();
    }

    /**
     * Fill textbox.
     */
    public void fill(Locator locator, String text) {

        waitForVisible(locator);

        locator.clear();

        locator.fill(text);
    }

    /**
     * Hover.
     */
    public void hover(Locator locator) {

        waitForVisible(locator);

        locator.hover();
    }

    /**
     * Checkbox.
     */
    public void check(Locator locator) {

        waitForVisible(locator);

        if (!locator.isChecked()) {
            locator.check();
        }
    }

    /**
     * Uncheck Checkbox.
     */
    public void uncheck(Locator locator) {

        waitForVisible(locator);

        if (locator.isChecked()) {
            locator.uncheck();
        }
    }

    /**
     * Select Dropdown by Visible Text.
     */
    public void selectByText(Locator locator, String text) {

        waitForVisible(locator);

        locator.selectOption(
                new SelectOption().setLabel(text)
        );

        waitForLoader();
    }

    /**
     * Press Keyboard Key.
     */
    public void pressKey(Locator locator, String key) {

        waitForVisible(locator);

        locator.press(key);
    }

    /**
     * Upload File.
     */
    public void uploadFile(Locator locator, String filePath) {

        locator.setInputFiles(Paths.get(filePath));
    }

    /**
     * Get Text.
     */
    public String getText(Locator locator) {

        waitForVisible(locator);

        return locator.textContent().trim();
    }

    /**
     * Get Attribute.
     */
    public String getAttribute(Locator locator, String attribute) {

        waitForVisible(locator);

        return locator.getAttribute(attribute);
    }

    /**
     * Check Visibility.
     */
    public boolean isVisible(Locator locator) {

        try {
            return locator.isVisible();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Check Enabled.
     */
    public boolean isEnabled(Locator locator) {

        try {
            return locator.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Wait Until Element Disappears.
     */
    public void waitForDisappear(Locator locator) {

        locator.waitFor(
                new Locator.WaitForOptions()
                        .setState(WaitForSelectorState.HIDDEN)
                        .setTimeout(TIMEOUT)
        );
    }

    /**
     * Wait for URL.
     */
    public void waitForURL(String url) {

        page.waitForURL(url);
    }

    /**
     * Scroll to Element.
     */
    public void scrollIntoView(Locator locator) {

        waitForVisible(locator);

        locator.scrollIntoViewIfNeeded();
    }

    /**
     * Take Screenshot.
     */
    public void takeScreenshot(String fileName) {

        page.screenshot(
                new Page.ScreenshotOptions()
                        .setPath(Paths.get("screenshots/" + fileName + ".png"))
        );}
        public void scrollToTop() {

            page.evaluate("window.scrollTo(0, 0)");



    }

}
