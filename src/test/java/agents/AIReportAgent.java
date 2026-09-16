package agents;

import model.AICustomerData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AIReportAgent {
        /**
         * Generates execution report after successful execution.
         */
        public void generateSuccessReport(AICustomerData customer) {

            System.out.println("\n==============================================");
            System.out.println("        AI AUTOMATION EXECUTION REPORT");
            System.out.println("==============================================");

            System.out.println("Execution Time : "
                    + LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));

            System.out.println("----------------------------------------------");

            System.out.println("Customer Name : " + customer.getCustomerName());
            System.out.println("Customer Code : " + customer.getLegalName());
            System.out.println("Country       : " + customer.getCountry());
            System.out.println("Industry      : " + customer.getIndustry());
            System.out.println("Email         : " + customer.getEmail());
            System.out.println("Phone         : " + customer.getPhone());
            System.out.println("Lead Number   : " + customer.getLeadNumber());

            System.out.println("----------------------------------------------");
            System.out.println("Execution Status : PASSED");
            System.out.println("----------------------------------------------");
        }

        /**
         * Generates failure report.
         */
        public void generateFailureReport(Exception exception) {

            System.out.println("\n==============================================");
            System.out.println("        AI AUTOMATION EXECUTION REPORT");
            System.out.println("==============================================");

            System.out.println("Execution Time : "
                    + LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));

            System.out.println("----------------------------------------------");

            System.out.println("Execution Status : FAILED");

            System.out.println("Failure Reason   : "
                    + exception.getMessage());

            System.out.println("----------------------------------------------");
        }

        /**
         * Generates API Report.
         */
        public void generateAPIReport(int statusCode) {

            System.out.println("\n========== API REPORT ==========");

            System.out.println("API Status Code : " + statusCode);

            if (statusCode == 200 || statusCode == 201) {

                System.out.println("API Result      : SUCCESS");

            } else {

                System.out.println("API Result      : FAILED");

            }

            System.out.println("================================");
        }

        /**
         * Generates UI Report.
         */
        public void generateUIReport(boolean status) {

            System.out.println("\n========== UI REPORT ==========");

            if (status) {

                System.out.println("UI Validation : PASSED");

            } else {

                System.out.println("UI Validation : FAILED");

            }

            System.out.println("===============================");
        }

        /**
         * Final Summary
         */
        public void generateSummary(boolean status) {

            System.out.println("\n==============================================");

            if (status) {

                System.out.println("OVERALL RESULT : PASS");

            } else {

                System.out.println("OVERALL RESULT : FAIL");

            }

            System.out.println("==============================================");
        }
    }

