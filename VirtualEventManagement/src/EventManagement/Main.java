package EventManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("**********Welcome to Virtual Event Management System**********");
            System.out.println("1. Events");
            System.out.println("2. Registration and Ticketing");
            System.out.println("3. Virtual Venue Setup");
            System.out.println("4. Speaker and Presenter Management");
            System.out.println("5. Attendee Engagement Tools");
            System.out.println("6. Content Delivery and Streaming");
            System.out.println("7. Technical Support and Assistance");
            System.out.println("8. Post-Event Evaluation and Follow-up");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                	EventModule.runEventModule(scanner); 
                    break;
                case 2:
                	RegistrationModule.runRegistrationModule(scanner);
                    break;
                case 3:
                	VenueModule.runVenueModule(scanner);
                    break;
                case 4:
                	SpeakerModule.runSpeakerModule(scanner);
                    break;		
                case 5:
                    EngagementModule.runEngagementModule(scanner);
                    break;
                case 6:
                    StreamingModule.runStreamingModule(scanner);
                    break;
                case 7:
                    SupportModule.runSupportModule(scanner);
                    break;
                case 8:
                    EvaluationModule.runEvaluationModule(scanner);
                    break;
                case 9:
                    exit = true;
                    System.out.println("--------Exiting Virtual Event Management System---------");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
