package agents;

import model.AICustomerData;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class AIValidationAgent {

        private final List<String> validationErrors = new ArrayList<>();

        // Email Regex
        private static final Pattern EMAIL_PATTERN =
                Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

        // 10 Digit Phone
        private static final Pattern PHONE_PATTERN =
                Pattern.compile("^[0-9]{10}$");

        /**
         * Validate Customer Data
         *
         * @param customer CustomerData object
         * @return true if validation passed
         */
        public boolean validate(AICustomerData customer) {

            validationErrors.clear();

            validateCustomerName(customer.getCustomerName());
            validateCustomerCode(customer.getLegalName());
            validateCountry(customer.getCountry());
            validateIndustry(customer.getIndustry());
            validateEmail(customer.getEmail());
            validatePhone(customer.getPhone());
            validateLeadNumber(customer.getLeadnumber());

            if (validationErrors.isEmpty()) {

                System.out.println("=================================");
                System.out.println("AI Validation Successful");
                System.out.println("=================================");

                return true;
            }

            System.out.println("=================================");
            System.out.println("AI Validation Failed");
            System.out.println("=================================");

            validationErrors.forEach(System.out::println);

            return false;
        }

        //-------------------------------------
        // Customer Name
        //-------------------------------------

        private void validateCustomerName(String value) {

            if (value == null || value.trim().isEmpty()) {

                validationErrors.add("Customer Name is empty.");

            } else if (value.length() < 3) {

                validationErrors.add("Customer Name must be at least 3 characters.");
            }
        }

        //-------------------------------------
        // Customer Code
        //-------------------------------------

        private void validateCustomerCode(String value) {

            if (value == null || value.trim().isEmpty()) {

                validationErrors.add("Customer Code is empty.");
            }
        }

        //-------------------------------------
        // Country
        //-------------------------------------

        private void validateCountry(String value) {

            if (value == null || value.trim().isEmpty()) {

                validationErrors.add("Country is missing.");
            }
        }

        //-------------------------------------
        // Industry
        //-------------------------------------

        private void validateIndustry(String value) {

            if (value == null || value.trim().isEmpty()) {

                validationErrors.add("Industry is missing.");
            }
        }

        //-------------------------------------
        // Email
        //-------------------------------------

        private void validateEmail(String value) {

            if (value == null || value.trim().isEmpty()) {

                validationErrors.add("Email is empty.");

            } else if (!EMAIL_PATTERN.matcher(value).matches()) {

                validationErrors.add("Invalid Email Format.");
            }
        }

        //-------------------------------------
        // Phone
        //-------------------------------------

        private void validatePhone(String value) {

            if (value == null || value.trim().isEmpty()) {

                validationErrors.add("Phone Number is empty.");

            } else if (!PHONE_PATTERN.matcher(value).matches()) {

                validationErrors.add("Phone Number should contain exactly 10 digits.");
            }
        }

        //-------------------------------------
        // Lead Number
        //-------------------------------------

        private void validateLeadNumber(String value) {

            if (value == null || value.trim().isEmpty()) {

                validationErrors.add("Lead Number is empty.");
            }
        }

        //-------------------------------------
        // Get Errors
        //-------------------------------------

        public List<String> getValidationErrors() {

            return validationErrors;
        }

        //-------------------------------------
        // Print Errors
        //-------------------------------------

        public void printValidationErrors() {

            if (validationErrors.isEmpty()) {

                System.out.println("No Validation Errors.");

            } else {

                validationErrors.forEach(System.out::println);
            }

    }
}
