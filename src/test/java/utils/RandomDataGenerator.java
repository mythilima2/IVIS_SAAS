package utils;

import java.util.Random;
import java.util.UUID;

public class RandomDataGenerator {



        private static final Random random = new Random();

        public static String customerName() {

            return "Customer_" +
                    UUID.randomUUID().toString().substring(0,8);

        }

        public static String legalName() {

            return "Legal_" +
                    UUID.randomUUID().toString().substring(0,8);

        }

        public static String email() {

            return "customer" +
                    System.currentTimeMillis() +
                    "@gmail.com";

        }

    }



