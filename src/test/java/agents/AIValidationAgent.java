package agents;

import model.AICustomerData;

public class AIValidationAgent {


        /**
         * Validate complete customer object.
         */
        public boolean validateCustomer(AICustomerData customer) {

            validateCustomerName(customer.getCustomerName());
            validateLegalName(customer.getLegalName());
            validateEmail(customer.getEmail());
            validatePhone(customer.getPhone());
            validateCountry(customer.getCountry());
            validateIndustry(customer.getIndustry());
            validateLeadNumber(customer.getLeadNumber());

            System.out.println("AI Validation Successful.");

            return true;
        }

        /**
         * Customer Name Validation
         */
        private void validateCustomerName(String customerName) {

            if (customerName == null || customerName.trim().isEmpty()) {

                throw new RuntimeException(
                        "Customer Name cannot be empty."
                );
            }

            if (customerName.length() < 3) {

                throw new RuntimeException(
                        "Customer Name should contain at least 3 characters."
                );
            }
        }

        /**
         * Customer Code (Legal Name) Validation
         */
        private void validateLegalName(String legalName) {

            if (legalName == null || legalName.trim().isEmpty()) {

                throw new RuntimeException(
                        "Customer Code cannot be empty."
                );
            }

            if (legalName.length() < 3) {

                throw new RuntimeException(
                        "Customer Code should contain at least 3 characters."
                );
            }
        }

        /**
         * Email Validation
         */
        private void validateEmail(String email) {

            if (email == null || email.trim().isEmpty()) {

                throw new RuntimeException(
                        "Email cannot be empty."
                );
            }

            if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {

                throw new RuntimeException(
                        "Invalid Email Address."
                );
            }
        }

        /**
         * Phone Number Validation
         */
        private void validatePhone(String phone) {

            if (phone == null || phone.trim().isEmpty()) {

                throw new RuntimeException(
                        "Phone Number cannot be empty."
                );
            }

            if (!phone.matches("\\d{10}")) {

                throw new RuntimeException(
                        "Phone Number must contain exactly 10 digits."
                );
            }
        }

        /**
         * Country Validation
         */
        private void validateCountry(String country) {

            if (country == null || country.trim().isEmpty()) {

                throw new RuntimeException(
                        "Country cannot be empty."
                );
            }
        }

        /**
         * Industry Validation
         */
        private void validateIndustry(String industry) {

            if (industry == null || industry.trim().isEmpty()) {

                throw new RuntimeException(
                        "Industry cannot be empty."
                );
            }
        }

        /**
         * Lead Number Validation
         */
        private void validateLeadNumber(String leadNumber) {

            if (leadNumber == null || leadNumber.trim().isEmpty()) {

                throw new RuntimeException(
                        "Lead Number cannot be empty."
                );
            }

            if (!leadNumber.matches("^\\d+$")) {
                throw new RuntimeException(
                        "Invalid Lead Number format."
                );
            }
        }
}
