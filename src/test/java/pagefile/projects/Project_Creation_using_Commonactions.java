package pagefile.projects;

import commonactions.Actions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import locators.ProjectsLocators;
import org.testng.Assert;
import utils.CustomerStore;

import java.util.regex.Pattern;


public class Project_Creation_using_Commonactions {

        private final Page page;
        private final Actions actions;
        private final ProjectsLocators project;

        public Project_Creation_using_Commonactions(Page page) {

            this.page = page;
            this.actions = new Actions(page);
            this.project = new ProjectsLocators(page);
        }

        public void create() {

            // Navigate
            actions.click(project.lnkProjects);
            actions.waitForLoader();

            actions.click(project.btnAddProject);
            actions.waitForLoader();

            // Mandatory validations
            actions.click(project.btnNext);

            Assert.assertEquals(project.txtCustomerValidation.textContent(),
                    "Please select the Customer Name");

            Assert.assertEquals(project.txtProjectNameValidation.textContent(),
                    "Please enter the Project Name");

            Assert.assertEquals(project.txtProjectTypeValidation.textContent(),
                    "Please select the Project Type");

            Assert.assertEquals(project.txtHierarchyValidation.textContent(),
                    "Please select the Hierarchy");

            // Customer
            actions.click(project.ddlCustomer);
            String storedCustomerName = CustomerStore.getCustomerName();
            if (storedCustomerName == null || storedCustomerName.isBlank()) {
                throw new RuntimeException("Stored customer name is not available.");
            }
            actions.click(page.getByText(storedCustomerName).first());

            // Project Name
            actions.fill(project.txtProjectName, "Auto purpose project");

            // Project Type
            actions.click(project.ddlProjectType);
            actions.click(project.optionProjectType);

            // Hierarchy
            actions.click(project.txtHierarchy);
            actions.click(project.optionHierarchy);

            actions.click(project.btnNext);

            // Billing Validation
            Assert.assertEquals(project.txtBillingCountryValidation.textContent(),
                    "Please select the Billing Country");

            // Billing Details
            actions.click(project.ddlBillingCountry);
            actions.click(project.optionUSA);

            actions.click(project.ddlBillingState);
            actions.click(project.optionState);

            actions.click(project.ddlBillingCity);
            actions.click(project.optionCity);

            actions.fill(project.txtBillingZipCode, "454545");

            actions.click(project.btnNext);

            // Create Project
            actions.click(project.btnCreate);

            actions.waitForLoader();

            actions.click(project.btnClose);
        }
    }


