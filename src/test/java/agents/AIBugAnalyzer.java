package agents;

import java.time.LocalDateTime;

public class AIBugAnalyzer {

        public void analyze(Exception e) {

            System.out.println("========== AI BUG ANALYZER ==========");

            System.out.println("Exception Type : "
                    + e.getClass().getSimpleName());

            System.out.println("Message : "
                    + e.getMessage());

            if (e.getStackTrace().length > 0) {

                System.out.println("Location : "
                        + e.getStackTrace()[0]);
            }

            System.out.println("=====================================");
        }

}