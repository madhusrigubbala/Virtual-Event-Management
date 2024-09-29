package EventManagement;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EngagementModule {
    public static void runEngagementModule(Scanner scanner) {
        boolean exitEngagementModule = false;

        while (!exitEngagementModule) {
            System.out.println("\nAttendee Engagement Tools:");
            System.out.println("1. Q&A Sessions");
            System.out.println("2. Polls");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    conductQASessions(scanner);
                    break;
                case 2:
                    conductPolls(scanner);
                    break;
                case 3:
                    exitEngagementModule = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
	private static void conductQASessions(Scanner scanner) {
            System.out.println("Q&A Sessions:");
        
            System.out.println("Attendees can now ask questions. Type 'end' to finish the session.");
            boolean sessionActive = true;
            while (sessionActive) {
                System.out.print("Attendee: ");
                String question = scanner.nextLine();
                if (question.equalsIgnoreCase("end")) {
                    sessionActive = false;
                    System.out.println("Q&A session ended.");
                } else {
                    System.out.println("Speaker: Thank you for your question.");
           
                }
            }
        }

        public static void main1(String[] args) {
            Scanner scanner = new Scanner(System.in);
            conductQASessions(scanner);
            scanner.close();
        }
    
            private static void conductPolls(Scanner scanner) {
                System.out.println("Polls:");
                Map<String, Integer> pollResults = new HashMap<>();

                // Input poll question
                System.out.print("Enter poll question: ");
                String question = scanner.nextLine();

                // Input poll options
                System.out.println("Enter poll options separated by commas:");
                String[] options = scanner.nextLine().split(",");

                // Initialize the poll results
                for (String option : options) {
                    pollResults.put(option.trim(), 0);
                }

                // Simulate voting
                simulateVoting(scanner, pollResults);

                // Display poll results
                System.out.println("Poll Results:");
                for (Map.Entry<String, Integer> entry : pollResults.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
                }
            }

            private static void simulateVoting(Scanner scanner, Map<String, Integer> pollResults) {
                System.out.println("Simulating voting (enter 'vote <option>' to cast a vote or 'end' to finish):");
                String input;
                while (true) {
                    input = scanner.nextLine().trim();
                    if ("end".equalsIgnoreCase(input)) {
                        break;
                    } else if (input.startsWith("vote")) {
                        String[] parts = input.split("\\s+");
                        if (parts.length == 2 && pollResults.containsKey(parts[1])) {
                            pollResults.put(parts[1], pollResults.get(parts[1]) + 1);
                            System.out.println("Vote cast for option: " + parts[1]);
                        } else {
                            System.out.println("Invalid vote option.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter 'vote <option>' or 'end'.");
                    }
                }
            }

            public static void main11(String[] args) {
                Scanner scanner = new Scanner(System.in);
                conductPolls(scanner);
                scanner.close();
            }

 
}
