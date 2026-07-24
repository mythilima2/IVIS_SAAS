package model;

public class CustomerData {

        private String customerName;
        private String legalName;
        private String country;
        private String industry;
        private String email;

        public CustomerData(String customerName,
                            String legalName,
                            String country,
                            String industry,
                            String email) {

            this.customerName = customerName;
            this.legalName = legalName;
            this.country = country;
            this.industry = industry;
            this.email = email;
        }

        public String getCustomerName() {
            return customerName;
        }

        public String getLegalName() {
            return legalName;
        }

        public String getCountry() {
            return country;
        }

        public String getIndustry() {
            return industry;
        }

        public String getEmail() {
            return email;
        }
}
