package utils;

import java.util.Random;
import java.util.UUID;

public class AICustomerDataGenerator {



        private static final Random random = new Random();

        public static String customerName() {
            return "Customer_" + UUID.randomUUID().toString().substring(0, 8);
        }

        // Customer Code (Legal Name)
        public static String legalName() {
            return "Legal_" + UUID.randomUUID().toString().substring(0, 8);
        }

        public static String email() {
            return "customer" + System.currentTimeMillis() + "@gmail.com";
        }

        // Unique Phone Number
        public static String phoneNumber() {
            return "9" + (100000000 + random.nextInt(900000000));
        }

        // Unique Lead Number
        public static String leadNumber() {
            return String.valueOf(100000 + random.nextInt(900000));
        }    }

