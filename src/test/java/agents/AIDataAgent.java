package agents;

import model.AICustomerData;
import model.CustomerData;
import utils.AICustomerDataGenerator;
import utils.RandomDataGenerator;

public class AIDataAgent {




        public AICustomerData generateCustomer() {

                AICustomerData customer = new AICustomerData();

            customer.setCustomerName(
                    AICustomerDataGenerator.customerName());

            customer.setLegalName(
                    AICustomerDataGenerator.legalName());

            customer.setCountry(
                    "United States of America");

            customer.setIndustry(
                    "ATM");

            customer.setEmail(
                    AICustomerDataGenerator.email());

            customer.setPhone(
                    AICustomerDataGenerator.phoneNumber());

            customer.setLeadNumber(
                    AICustomerDataGenerator.leadNumber());

            return customer;
        }
    }


