package agents;
import com.microsoft.playwright.Locator;

import com.microsoft.playwright.Page;

public class AISelfHealingAgent {

        private final Page page;

        public AISelfHealingAgent(Page page) {
            this.page = page;
        }

        /**
         * Enterprise Self-Healing Click
         */
        public void click(String primaryLocator,
                          String backupText,
                          String ariaLabel) {

            try {

                page.locator(primaryLocator).click();

                System.out.println("Primary locator successful.");

            } catch (Exception e1) {

                System.out.println("Primary locator failed.");

                try {

                    page.getByText(backupText).click();

                    System.out.println("Recovered using Text locator.");

                } catch (Exception e2) {

                    try {

                        page.getByLabel(ariaLabel).click();

                        System.out.println("Recovered using Label locator.");

                    } catch (Exception e3) {

                        throw new RuntimeException(
                                "AI Self Healing Failed."
                        );

                    }

                }

            }

        }

        /**
         * Enterprise Self-Healing Fill
         */
        public void fill(String primaryLocator,
                         String backupPlaceholder,
                         String value) {

            try {

                page.locator(primaryLocator).fill(value);

                System.out.println("Filled using Primary Locator.");

            } catch (Exception e) {

                try {

                    page.getByPlaceholder(backupPlaceholder).fill(value);

                    System.out.println("Recovered using Placeholder.");

                } catch (Exception ex) {

                    throw new RuntimeException(
                            "Unable to locate textbox."
                    );

                }

            }

        }

        /**
         * Self-Healing Visibility Check
         */
        public boolean isVisible(String locator) {

            try {

                return page.locator(locator).isVisible();

            } catch (Exception e) {

                return false;

            }

        }

        /**
         * Self-Healing Locator Finder
         */
        public Locator locate(String css,
                              String text,
                              String placeholder) {

            if (page.locator(css).count() > 0)
                return page.locator(css);

            if (page.getByText(text).count() > 0)
                return page.getByText(text);

            if (page.getByPlaceholder(placeholder).count() > 0)
                return page.getByPlaceholder(placeholder);

            throw new RuntimeException(
                    "AI could not recover locator."
            );
        }

        /**
         * Future GPT Integration
         */
        public String askGPTForLocator(String failedLocator) {

        /*
         Future Version

         Prompt:

         My Playwright locator failed.

         Locator:

         page.locator("xxxx")

         Suggest a better locator.

         GPT returns:

         page.getByRole(...)
         page.getByLabel(...)
         page.getByPlaceholder(...)

        */

            return "GPT Suggested Locator";
        }

}
