package agents;

import org.json.JSONObject;
import utils.AICustomerDataGenerator;

public class AIClient {
        /**
         * Generates AI Customer Data.
         * Currently uses random data and local generators.
         */
        public JSONObject generateCustomerData() {

            JSONObject customer = new JSONObject();

            customer.put("customerName",
                    AICustomerDataGenerator.customerName());

            customer.put("legalName",
                    AICustomerDataGenerator.legalName());

            customer.put("country",
                    "United States of America");

            customer.put("industry",
                    "ATM");

            customer.put("email",
                    AICustomerDataGenerator.email());

            customer.put("phone",
                    AICustomerDataGenerator.phoneNumber());

            customer.put("leadNumber",
                    AICustomerDataGenerator.leadNumber());

            return customer;
        }

        /**
         * Generates customer data from a local AI-style prompt.
         */
        public JSONObject generateCustomerDataFromGPT(String prompt) {

            System.out.println("========================================");
            System.out.println("AI CUSTOMER DATA REQUEST");
            System.out.println("========================================");
            System.out.println(prompt);
            System.out.println("========================================");

            // Currently returns locally generated customer data
            return generateCustomerData();
        }

        /**
         * Generic AI Prompt
         * Every AI Agent should use this method.
         */
        public String generateResponse(String prompt) {

            System.out.println("========================================");
            System.out.println("AI PROMPT");
            System.out.println("========================================");
            System.out.println(prompt);
            System.out.println("========================================");

            String normalized = prompt == null ? "" : prompt.toLowerCase();

            if (normalized.contains("root cause") || normalized.contains("failure reason") || normalized.contains("suggested fix")) {
                return "Free AI Analysis:\n"
                        + "- Failure Reason: The issue looks like a data or environment mismatch.\n"
                        + "- Root Cause: The current test input or expected response does not align with the API behavior.\n"
                        + "- Impact: The automation execution may fail consistently until the request data is corrected.\n"
                        + "- Suggested Fix: Verify the payload, test data, and environment configuration, then rerun.\n";
            }

            if (normalized.contains("generate") && normalized.contains("test cases")) {
                return "Free AI Test Case Suggestions:\n"
                        + "1. Validate the happy path with valid input.\n"
                        + "2. Validate required field validation and error responses.\n"
                        + "3. Validate boundary values and negative inputs.\n";
            }

            return "Free AI Response:\n\n" + prompt;
        }

        /**
         * Print Generated Customer
         */
        public void printCustomer(JSONObject customer) {

            System.out.println("========== AI GENERATED CUSTOMER ==========");
            System.out.println(customer.toString(4));
            System.out.println("===========================================");
        }



}