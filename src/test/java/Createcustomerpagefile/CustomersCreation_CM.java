package Createcustomerpagefile;

import CommonMethods.Actions;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;

import java.util.regex.Pattern;

public class CustomersCreation_CM {
            private final Page page;
            private final Actions commonMethods;

            public CustomersCreation_CM(Page page) {
                this.page = page;
                this.commonMethods = new Actions(page);
            }

            public void navigateToCustomers() {
                page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Field Maintenance$"))).locator("svg").click();
                commonMethods.click(page.getByText("Customer-Site Mgmt"));
                commonMethods.click(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Customers")));
            }

            public void createCustomer(String customerName, String customerCode, String country, String industry, String email) {
                page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Customers$"))).locator("svg").nth(2).click();
                commonMethods.click(page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")));
                String actualValue = page.locator("'Please enter the Customer Name'").textContent();
                Assert.assertEquals("Please enter the Customer Name", actualValue);
                System.out.println(actualValue);
                commonMethods.fill(page.getByPlaceholder("Customer Name"), customerName);
                commonMethods.click(page.getByPlaceholder("Country"));
                commonMethods.click(page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName(country)));
                commonMethods.fill(page.getByPlaceholder("Customer Code"), customerCode);
                commonMethods.click(page.getByPlaceholder("Industry"));
                commonMethods.click(page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName(industry)));
                commonMethods.fill(page.getByPlaceholder("Email"), email);
                commonMethods.click(page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")));
                commonMethods.click(page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")));
                commonMethods.click(page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Open")).first());
                page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("United States of America")).click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Open")).nth(1).click();
                page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Califonria (CA)")).click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Open")).nth(2).click();
                page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("ATM")).click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Select Type")).click();
                page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("B2B")).click();
                page.locator("'Next'").click();
                page.locator("'Next'").click();
                page.locator("'Next'").click();
                page.getByLabel("Same as customer Address").check();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create")).click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("close")).click();
            }

            public  void  running(){
                Playwright playwright = Playwright.create();
                    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    Page page = browser.newPage();
                    CustomersCreation_CM customerCreator = new CustomersCreation_CM(page);
                    customerCreator.navigateToCustomers();

                    // Data-driven approach to create customers
                    String[][] customerData = {
                            {"Customer1", "Code1", "United States of America", "Industry1", "customer1@example.com"},
                            {"Customer2", "Code2", "United Kingdom", "Industry2", "customer2@example.com"},
                            {"Customer3", "Code3", "Canada", "Industry3", "customer3@example.com"},
                            {"Customer4", "Code4", "Australia", "Industry4", "customer4@example.com"},
                            {"Customer5", "Code5", "Germany", "Industry5", "customer5@example.com"}
                    };

                    for (String[] data : customerData) {
                        customerCreator.createCustomer(data[0], data[1], data[2], data[3], data[4]);
                    }

                    browser.close();
                }
            }


