package locators;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;

public class CustomersLocators {

        //==========================
        // Navigation
        //==========================

        public final Locator lnkCustomers;
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
       // public final Locator customerphonenumber;
     public final Locator btnEdit;
    public final Locator btnUpdate;
    public final Locator edittabclose;
    public final Locator customerDescription;
    public final Locator btnDelete;

        public CustomersLocators(Page page) {
            this.page = page;

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
            //=====================================
            // Customer Table - Grid Columns & Cells
            //=====================================

            // Table header columns (sortable)
            customerGridHeader = page.locator("thead");
            customerGridRows = page.locator("tbody tr");

            // Column headers with sort indicators
            // Customer Name column (first column with sort arrow)
            // Tenant Name column
            // Customer Code column (with "LEGAL_*" format)
            // Status column (shows "Active" in green)

            //=====================================
            // Search & Filter
            //=====================================

            // Main search bar at top right
            searchInputField =             page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Contains")).first();



            // Column filter inputs - "Contains" filters under each column
            // These filter dropdowns appear below column headers

            // No data message when results are empty
            noDataMsg = page.getByText("No data");


            //=====================================
            // Edit & Status Actions (Row Actions)
            //=====================================

            // Edit button - appears as icon at end of row

            btnEdit =       page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("controlled"));

            customerDescription =            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Description"));
            btnUpdate =       page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("SAVE"));




            // Delete button - appears as icon at end of row
            btnDelete =       page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("close"));
            edittabclose =      page.locator(".svg-inline--fa.fa-xmark > path");


            // Status badge showing "Active" in green
          //  btnStatusActive = page.locator("text=Active").first();

            // Status indicator for inactive
           // btnStatusInactive = page.locator("text=Inactive").first();
        }

        //==========================
        // Edit & Status Actions
        //==========================

//        public Locator btnEdit;
//        public Locator btnDelete;
        public Locator btnStatusActive;
        public Locator btnStatusInactive;

        //==========================
        // Search & Filter
        //==========================

        public Locator searchInputField;
        public Locator noDataMsg;

        //==========================
        // Grid Elements
        //==========================

        public Locator customerGridRows;
        public Locator customerGridHeader;
        private Page page;

        //==========================
        // Table Cell Locators
        //==========================

        // Method to get customer name cell from a specific row
        public Locator getCustomerNameCell(int rowIndex) {
            return customerGridRows.nth(rowIndex).locator("td:nth-child(2) a");
        }

        // Method to get customer code cell from a specific row
        public Locator getCustomerCodeCell(int rowIndex) {
            return customerGridRows.nth(rowIndex).locator("td:nth-child(3)");
        }

        // Method to get status cell from a specific row
        public Locator getStatusCell(int rowIndex) {
            return customerGridRows.nth(rowIndex).locator("td:nth-child(6)");
        }

        // Method to get edit button for a specific row
        public Locator getEditButton(int rowIndex) {
            return customerGridRows.nth(rowIndex).locator("svg[aria-label='Edit']");
        }

        // Method to get delete button for a specific row
        public Locator getDeleteButton(int rowIndex) {
            return customerGridRows.nth(rowIndex).locator("svg[aria-label='Delete']");

        }

        // Method to find a row by customer name
        public Locator getRowByCustomerName(String customerName) {
            return page.locator("tbody tr:has-text('" + customerName + "')");
        }

        // Method to find a row by customer code
        public Locator getRowByCustomerCode(String customerCode) {
            return page.locator("tbody tr:has-text('" + customerCode + "')");
        }

    public Locator getCustomerRow(String customerName) {

        return page.locator(
                "div[data-field='customerName'] span:text-is('" + customerName + "')"
        );
    }
}





