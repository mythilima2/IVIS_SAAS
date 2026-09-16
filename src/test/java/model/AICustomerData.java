package model;

public class AICustomerData {

        private String customerName;
        private String legalName;
        private String country;
        private String industry;
        private String email;
        private String phone;
        private String leadNumber;

        // Default Constructor
        public AICustomerData() {
        }

        // Parameterized Constructor
        public AICustomerData(String customerName,
                              String legalName,
                              String country,
                              String industry,
                              String email,
                              String phone,
                              String leadNumber) {

            this.customerName = customerName;
            this.legalName = legalName;
            this.country = country;
            this.industry = industry;
            this.email = email;
            this.phone = phone;
            this.leadNumber = leadNumber;
        }

        // Customer Name
        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        // Customer Code (Legal Name)
        public String getLegalName() {
            return legalName;
        }

        public void setLegalName(String legalName) {
            this.legalName = legalName;
        }

        // Country
        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        // Industry
        public String getIndustry() {
            return industry;
        }

        public void setIndustry(String industry) {
            this.industry = industry;
        }

        // Email
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        // Phone Number
        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        // Lead Number
        public String getLeadNumber() {
            return leadNumber;
        }

        public void setLeadNumber(String leadNumber) {
            this.leadNumber = leadNumber;
        }

        @Override
        public String toString() {
            return "AICustomerData{" +
                    "customerName='" + customerName + '\'' +
                    ", legalName='" + legalName + '\'' +
                    ", country='" + country + '\'' +
                    ", industry='" + industry + '\'' +
                    ", email='" + email + '\'' +
                    ", phone='" + phone + '\'' +
                    ", leadNumber='" + leadNumber + '\'' +
                    '}';
        }
    }