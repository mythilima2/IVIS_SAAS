package model;

public class AICustomerData {
        private String customerName;
        private String legalName;
        private String country;
        private String industry;
        private String email;
        private String phone;

        // Parameterized Constructor
        public AICustomerData(String customerName,
                              String legalName,
                              String country,
                              String industry,
                              String email,
                              String phone) {

            this.customerName = customerName;
            this.legalName = legalName;
            this.country = country;
            this.industry = industry;
            this.email = email;
            this.phone = phone;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getLegalName() {
            return legalName;
        }

        public void setLegalName(String legalName) {
            this.legalName = legalName;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getIndustry() {
            return industry;
        }

        public void setIndustry(String industry) {
            this.industry = industry;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }


}