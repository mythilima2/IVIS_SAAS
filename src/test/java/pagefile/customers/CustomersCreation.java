package pagefile.customers;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import commonactions.Actions;
import locators.CustomersLocators;
import org.testng.Assert;

import java.util.UUID;

public class CustomersCreation {




        private final Page page;
        private final Actions actions;
        private final CustomersLocators customer;

        public CustomersCreation(Page page) {

            this.page = page;
            this.actions = new Actions(page);
            this.customer = new CustomersLocators(page);
        }

        //==========================================
        // Open Customer Page
        //==========================================

        public void openCustomerPage() {

            actions.click(customer.lnkCustomers);

            actions.click(customer.btnAddCustomer);
            actions.waitForLoader();


        }

        //==========================================
        // Mandatory Validation
        //==========================================

        public void validateMandatoryFields() {

            actions.click(customer.btnNext);

            Assert.assertEquals(
                    customer.txtCustomerNameValidation.textContent(),
                    "Please enter the Customer Name");

            Assert.assertEquals(
                    customer.txtCountryValidation.textContent(),
                    "Please select the Country");

            Assert.assertEquals(
                    customer.txtCustomerCodeValidation.textContent(),
                    "Please enter the Customer Code");

            Assert.assertEquals(
                    customer.txtEmailValidation.textContent(),
                    "Please enter the Email");

            Assert.assertEquals(
                    customer.txtTypeValidation.textContent(),
                    "Select Type");

            Assert.assertEquals(
                    customer.txtIndustryValidation.textContent(),
                    "Please select the Industry");

        }

        //==========================================
        // Customer Details
        //==========================================

        public void enterCustomerDetails(String customerName,
                                         String customerCode,
                                         String country,
                                         String industry,
                                         String email) {

            actions.fill(customer.txtCustomerName, customerName);

            actions.click(customer.txtCountry);
            actions.click(page.getByText(country));

            actions.fill(customer.txtCustomerCode, customerCode);

            actions.click(customer.txtIndustry);
            actions.click(page.getByText(industry));

            actions.click(customer.btnCustomerType);
          //  page.waitForTimeout(5000); // Temporary for debugging


            actions.click(customer.optionB2B);


            actions.fill(customer.txtEmail, email);
            actions.fill(customer.txtLeadNumber,
                    String.valueOf(9000000000L + (System.currentTimeMillis() % 999999999L)));

            actions.click(customer.btnCountry);
            actions.click(customer.optionUSA);

            actions.click(customer.btnState);
            actions.click(customer.optionCalifornia);

            actions.click(customer.btnCity);
            actions.click(customer.optionATM);

            actions.click(customer.btnNext);


        }

        //==========================================
        // Features
        //==========================================

        public void selectCustomerFeatures() {
            actions.click(customer.pnlCustomerFeature);
            actions.check(customer.chkSmartSearch);
            actions.click(customer.btnNext);
        }

        //==========================================
        // Customer Contact Information
        //==========================================

        public void enterCustomerContact() {
            String uniqueId = String.valueOf(System.currentTimeMillis());
            String nameSuffix = UUID.randomUUID()
                    .toString()
                    .replaceAll("[^a-zA-Z]", "")
                    .substring(0, 8);

            actions.fill(customer.txtFirstName, "First" + nameSuffix);
            actions.fill(customer.txtLastName, "Last" + nameSuffix);
            actions.fill(customer.txtUserName, "user" + uniqueId);
            actions.fill(customer.txtContactEmail, "user" + uniqueId + "@example.com");
            actions.fill(customer.txtPhoneNumber,
                    String.valueOf(9000000000L + (System.currentTimeMillis() % 999999999L)));
            actions.click(customer.btnNext);
        }

        //==========================================
        // Billing Information
        //==========================================

        public void enterBillingInformation() {
            actions.check(customer.chkSameAddress);
            actions.check(customer.chkGeneralSubscription);
            actions.click(customer.btnNext);
        }

        public void skipProjects() {
            actions.click(customer.btnNext);
        }

        //==========================================
        // Submit
        //==========================================

        public void submitCustomer() {

            actions.scrollIntoView(customer.btnCreate);
            actions.click(customer.btnCreate);
            actions.scrollToTop();
          //  actions.clickIfPresent(customer.btnClose);

            customer.btnCancel.scrollIntoViewIfNeeded();
            actions.click(customer.btnCancel);

        }


}
