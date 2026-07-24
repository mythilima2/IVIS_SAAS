package testdata;

import model.CustomerData;
import utils.RandomDataGenerator;

public class CustomerDataFactory {

        public static CustomerData getValidCustomer() {

            return new CustomerData(

                    RandomDataGenerator.customerName(),

                    RandomDataGenerator.legalName(),

                    "United States of America",

                    "Automotive Industry",

                    RandomDataGenerator.email()

            );

        }

        public static CustomerData getEmptyCustomerName() {

            return new CustomerData(

                    "",

                    RandomDataGenerator.legalName(),

                    "United States of America",

                    "Automotive Industry",

                    RandomDataGenerator.email()

            );

        }

        public static CustomerData getInvalidEmail() {

            return new CustomerData(

                    RandomDataGenerator.customerName(),

                    RandomDataGenerator.legalName(),

                    "United States of America",

                    "Automotive Industry",

                    "abcgmail.com"

            );

        }

        public static CustomerData getLongCustomerName() {

            return new CustomerData(

                    "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ",

                    RandomDataGenerator.legalName(),

                    "United States of America",

                    "Automotive Industry",

                    RandomDataGenerator.email()

            );

        }

}
