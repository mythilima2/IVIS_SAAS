package utils;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import locators.CommonLocators;

public class WaitUtils {



        private final CommonLocators common;

        public WaitUtils(Page page) {

            common = new CommonLocators(page);

        }

        public void waitForLoaderToDisappear() {

            common.loader.waitFor(

                    new Locator.WaitForOptions()

                            .setState(WaitForSelectorState.HIDDEN)

                            .setTimeout(1200000)

            );

        }

    }

