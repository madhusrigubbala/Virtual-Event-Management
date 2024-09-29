package EventManagement;

import java.util.Scanner;

public class SupportModule {
    public static void runSupportModule(Scanner scanner) {
        boolean exitSupportModule = false;

        while (!exitSupportModule) {
            System.out.println("\nTechnical Support and Assistance:");
            System.out.println("1. Request Technical Support");
            System.out.println("2. Access Help Desk Resources");
            System.out.println("3. View FAQs");
            System.out.println("4. Read User Guides");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    requestTechnicalSupport(scanner);
                    break;
                case 2:
                    accessHelpDeskResources();
                    break;
                case 3:
                    viewFAQs();
                    break;
                case 4:
                    readUserGuides();
                    break;
                case 5:
                    exitSupportModule = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void requestTechnicalSupport(Scanner scanner) {
        System.out.println("Request Technical Support:");
        System.out.println("Enter your technical issue: ");
        String issue = scanner.nextLine();
        System.out.println("Your technical support request has been submitted.");
       
    }

    private static void accessHelpDeskResources() {
        System.out.println("Access Help Desk Resources:");
        System.out.println("Here are the available resources:");
        System.out.println("- Help desk contact information");
        System.out.println("- Troubleshooting guides");
        System.out.println("- Knowledge base articles");
    }

    private static void viewFAQs() {
        System.out.println("View FAQs:");
        System.out.println("Frequently Asked Questions:");
        System.out.println("- How do I log in to the platform?");
        System.out.println("- What should I do if I encounter technical issues?");
        System.out.println("- How can I contact support?");
     
    }

    private static void readUserGuides() {
        System.out.println("Read User Guides:");
        System.out.println("User Guides:");
        System.out.println("- Platform navigation guide");
        System.out.println("- Attendee experience overview");
        System.out.println("- Speaker instructions");
     
    }
}
