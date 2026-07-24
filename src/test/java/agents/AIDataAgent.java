package agents;

import model.CustomerData;
import utils.RandomDataGenerator;

public class AIDataAgent {



        public CustomerData generateCustomer() {

            return new CustomerData(

                    RandomDataGenerator.customerName(),

                    RandomDataGenerator.legalName(),

                    "United States of America",

                    "ATM",

                    RandomDataGenerator.email()

            );
        }

}
