package agents;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import org.json.JSONObject;
import utils.AICustomerDataGenerator;

public class AIClient {


        /**
         * Generates AI customer data.
         * Currently uses mock/random data.
         * Later this method can call GPT/OpenAI.
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
         * Future GPT/OpenAI Integration
         */
        public JSONObject generateCustomerDataFromGPT(String prompt) {

            System.out.println("========================================");
            System.out.println("Calling GPT...");
            System.out.println("Prompt : " + prompt);
            System.out.println("========================================");

            // TODO:
            // Replace with OpenAI API call

            return generateCustomerData();
        }

        /**
         * Print Generated Customer JSON
         */
        public void printCustomer(JSONObject customer) {

            System.out.println("========== AI GENERATED CUSTOMER ==========");
            System.out.println(customer.toString(4));
            System.out.println("===========================================");
        }
    }


