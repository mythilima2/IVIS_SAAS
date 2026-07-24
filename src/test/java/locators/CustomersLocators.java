package locators;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;

public class CustomersLocators {

        //==========================
        // Navigation
        //==========================

        public final
        Locator lnkCustomers;
        public final Locator btnAddCustomer;

        //==========================
        // Customer Details
        //==========================

        public final Locator txtCustomerName;
        public final Locator txtCustomerCode;
        public final Locator txtCountry;
        public final Locator txtIndustry;
        public final Locator txtEmail;
        public final Locator txtLeadNumber;
        public final Locator txtFirstName;
        public final Locator txtLastName;
        public final Locator txtUserName;
        public final Locator txtContactEmail;
        public final Locator txtPhoneNumber;

        //==========================
        // Buttons
        //==========================

        public final Locator btnNext;
        public final Locator btnCreate;
        public final Locator btnClose;
        public final Locator btnCancel;

        //==========================
        // Address Dropdowns
        //==========================

        public final Locator btnCountry;
        public final Locator btnState;
        public final Locator btnCity;

        //==========================
        // Customer Type
        //==========================

        public final Locator btnCustomerType;

        //==========================
        // Checkbox
        //==========================

        public final Locator chkSameAddress;
        public final Locator chkSmartSearch;
        public final Locator chkGeneralSubscription;
        public final Locator pnlCustomerFeature;

        //==========================
        // Validation Messages
        //==========================

        public final Locator txtCustomerNameValidation;
        public final Locator txtCountryValidation;
        public final Locator txtCustomerCodeValidation;
        public final Locator txtEmailValidation;
    public Locator txtRequiredFieldValidation;
    public final Locator txtTypeValidation;
        public final Locator txtIndustryValidation;
        public final Locator txtBillingCountryValidation;

        //==========================
        // Duplicate Validation
        //==========================

        public final Locator txtCustomerNameAlreadyExists;
        public final Locator txtCustomerCodeAlreadyExists;

        //==========================
        // Dropdown Options
        //==========================

        public final Locator optionUSA;
        public final Locator optionCalifornia;
        public final Locator optionATM;
        public final Locator optionB2B;

        public CustomersLocators(Page page) {

            //=====================================
            // Navigation
            //=====================================

            lnkCustomers =
                    page.getByRole(
                            AriaRole.LINK,
                            new Page.GetByRoleOptions().setName("Customers"));

            btnAddCustomer =
                    page.getByLabel("Add Customer");            //=====================================
            // Customer Details
            //=====================================

            txtCustomerName =
                    page.getByPlaceholder("Customer Name");

            txtCustomerCode =
                    page.getByPlaceholder("Customer Code");

            txtCountry =
                    page.getByPlaceholder("Country");

            txtIndustry =
                    page.getByPlaceholder("Industry");

            txtEmail =
                    page.getByPlaceholder("Email");

            txtLeadNumber =
                    page.getByPlaceholder("Lead Number");

            txtFirstName = page.getByPlaceholder("First Name");
            txtLastName = page.getByPlaceholder("Last Name");
            txtUserName = page.getByPlaceholder("User Name");
            txtContactEmail = page.getByPlaceholder("Email");
            txtPhoneNumber = page.getByPlaceholder("Phone Number");

            //=====================================
            // Buttons
            //=====================================

            btnNext =
                    page.getByRole(
                            AriaRole.BUTTON,
                            new Page.GetByRoleOptions().setName("Next"));

            btnCreate =
                    page.getByRole(
                            AriaRole.BUTTON,
                            new Page.GetByRoleOptions().setName("Create"));

            btnClose =
                    page.getByRole(
                            AriaRole.BUTTON,
                            new Page.GetByRoleOptions().setName("close"));

            btnCancel =
                    page.locator(".svg-inline--fa.fa-xmark");

            //=====================================
            // Address Dropdowns
            //=====================================

            btnCountry =
                    page.getByRole(
                                    AriaRole.BUTTON,
                                    new Page.GetByRoleOptions().setName("Open"))
                            .first();

            btnState =
                    page.getByRole(
                                    AriaRole.BUTTON,
                                    new Page.GetByRoleOptions().setName("Open"))
                            .nth(1);

            btnCity =
                    page.getByRole(
                                    AriaRole.BUTTON,
                                    new Page.GetByRoleOptions().setName("Open"))
                            .nth(2);

            //=====================================
            // Customer Type
            //=====================================

            btnCustomerType =
                    page.getByText(
                            "Select Type",
                            new Page.GetByTextOptions().setExact(true));

            //=====================================
            // Checkbox
            //=====================================

            chkSameAddress =
                    page.getByLabel("Same as customer Address");

            chkSmartSearch = page.getByLabel("General Dashboard Atmscount Read");
            chkGeneralSubscription = page.getByLabel("General Subscription");
            pnlCustomerFeature = page.getByText(
                    "Customer Feature", new Page.GetByTextOptions().setExact(true));

            //=====================================
            // Validation Messages
            //=====================================

            txtCustomerNameValidation =
                    page.getByText("Please enter the Customer Name");

            txtCountryValidation =
                    page.getByText("Please select the Country");

            txtCustomerCodeValidation =
                    page.getByText("Please enter the Customer Code");

            txtEmailValidation =
                    page.getByText("Please enter the Email");
            txtRequiredFieldValidation =
                    page.getByText("This field is required");

            txtTypeValidation =
                   // page.getByText("Please select the Type");
            page.getByText("Select Type");


            txtIndustryValidation =
                    page.getByText("Please select the Industry");

            txtBillingCountryValidation =
                    page.getByText("Please select the Billing Country");

            //=====================================
            // Duplicate Validation
            //=====================================

            txtCustomerNameAlreadyExists =
                    page.getByText("This Customer name is already taken");

            txtCustomerCodeAlreadyExists =
                    page.getByText("This Customer code is already taken");

            //=====================================
            // Dropdown Options
            //=====================================

            optionUSA =
                    page.getByRole(
                            AriaRole.OPTION,
                            new Page.GetByRoleOptions()
                                    .setName("United States of America"));

            optionCalifornia =
                    page.getByRole(
                            AriaRole.OPTION,
                            new Page.GetByRoleOptions()
                                    .setName("Califonria (CA)"));

            optionATM =
                    page.getByRole(
                            AriaRole.OPTION,
                            new Page.GetByRoleOptions()
                                    .setName("ATM"));

            optionB2B =
                    page.getByRole(
                            AriaRole.OPTION,
                            new Page.GetByRoleOptions()
                                    .setName("B2B"));


    }
}
