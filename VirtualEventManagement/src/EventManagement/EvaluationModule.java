package EventManagement;

import java.util.Scanner;

public class EvaluationModule {
    public static void runEvaluationModule(Scanner scanner) {
        boolean exitEvaluationModule = false;

        while (!exitEvaluationModule) {
            System.out.println("\nPost-Event Evaluation and Follow-up:");
            System.out.println("1. Collect Feedback");
            System.out.println("2. Analyze Feedback");
            System.out.println("3. Generate Post-Event Reports");
            System.out.println("4. Follow-up with Attendees");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    collectFeedback(scanner);
                    break;
                case 2:
                    analyzeFeedback(scanner);
                    break;
                case 3:
                    generatePostEventReports(scanner);
                    break;
                case 4:
                    followUpWithAttendees(scanner);
                    break;
                case 5:
                    exitEvaluationModule = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void collectFeedback(Scanner scanner) {
        System.out.println("Collect Feedback:");
        System.out.println("Provide options for attendees to submit feedback through surveys, polls, evaluations, etc.");
        System.out.print("Rate the event (1 - Very Poor,2 - Poor,3 - Good,4 - VeryGood,5 - Excellent): ");
        int rating = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Thank you for your feedback!");
    }
    private static void analyzeFeedback(Scanner scanner) {
        System.out.println("Analyze Feedback:");
        System.out.println("Process and analyze feedback data to derive insights and trends.");
        System.out.println("Analysis:");
        System.out.println("- 80% of attendees rated the event as 'Excellent'.");
        System.out.println("- 15% of attendees rated the event as 'Good'.");
        System.out.println("- 5% of attendees rated the event as 'Average'.");
        System.out.println("- No attendees rated the event as 'Poor' or 'Very Poor'.");
    }

    private static void generatePostEventReports(Scanner scanner) {
        System.out.println("Generate Post-Event Reports:");
        System.out.println("Create reports summarizing attendee feedback, engagement metrics, etc.");
        System.out.println("Post-event reports:");
        System.out.println("- Summary report of attendee feedback.");
        System.out.println("- Engagement metrics report.");
        System.out.println("- Comparison report with previous events.");
    }

    private static void followUpWithAttendees(Scanner scanner) {
        System.out.println("Follow-up with Attendees:");
        System.out.println("Send follow-up emails, surveys, or communications to attendees based on their feedback and participation.");
        System.out.println("Example follow-up actions:");
        System.out.println("- Send thank-you emails to attendees.");
        System.out.println("- Distribute post-event surveys to gather additional feedback.");
        System.out.println("- Provide information about upcoming events or related resources.");
    }

}
