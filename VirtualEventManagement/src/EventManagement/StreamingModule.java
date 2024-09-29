package EventManagement;

import java.util.Scanner;

public class StreamingModule {
    public static void runStreamingModule(Scanner scanner) {
        boolean exitStreamingModule = false;

        while (!exitStreamingModule) {
            System.out.println("\nContent Delivery and Streaming:");
            System.out.println("1. Stream Live Presentations");
            System.out.println("2. Support Multimedia Content");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    streamLivePresentations(scanner);
                    break;
                case 2:
                    supportMultimediaContent(scanner);
                    break;
                case 3:
                    exitStreamingModule = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void streamLivePresentations(Scanner scanner) {
        System.out.println("Streaming Live Presentations:");
        System.out.println("1. Start Live Stream");
        System.out.println("2. Stop Live Stream");
        System.out.println("3. Back to Streaming Menu");
        System.out.print("Enter your choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        switch (choice) {
            case 1:
                startLiveStream();
                break;
            case 2:
                stopLiveStream();
                break;
            case 3:
                System.out.println("Returning to Streaming Menu.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
    
    public static void startLiveStream() {
        System.out.println("Live presentations are now streaming.");
        System.out.println("Attendees can now watch the live presentations.");
    }

    public static void stopLiveStream() {
        System.out.println("Live stream stopped.");
    }

    public static void supportMultimediaContent(Scanner scanner) {
        System.out.println("Support Multimedia Content:");
        System.out.println("1. Upload Multimedia Content");
        System.out.println("2. View Multimedia Content");
        System.out.println("3. Interact with Multimedia Content");
        System.out.println("4. Back to Streaming Menu");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
                uploadMultimediaContent(scanner);
                break;
            case 2:
                viewMultimediaContent(scanner);
                break;
            case 3:
                interactWithMultimediaContent(scanner);
                break;
            case 4:
                System.out.println("Returning to Streaming Menu.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    public static void uploadMultimediaContent(Scanner scanner) {
        System.out.println("Upload Multimedia Content:");
       
    }

    public static void viewMultimediaContent(Scanner scanner) {
        System.out.println("View Multimedia Content:");
      
    }

    public static void interactWithMultimediaContent(Scanner scanner) {
        System.out.println("Interact with Multimedia Content:");
    }
}
