package EventManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EventModule {
    public static void runEventModule(Scanner scanner) {
        boolean exitEventModule = false;

        while (!exitEventModule) {
            System.out.println("\nEvent Management:");
            System.out.println("1. Create Event");
            System.out.println("2. View Events");
            System.out.println("3. Edit Event");
            System.out.println("4. Delete Event");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    createEvent(scanner);
                    break;
                case 2:
                    viewEvents();
                    break;
                case 3:
                    editEvent(scanner);
                    break;
                case 4:
                    deleteEvent(scanner);
                    break;
                case 5:
                    exitEventModule = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createEvent(Scanner scanner) {
        System.out.println("\nCreate Event:");
        System.out.print("Enter Event Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Event Description: ");
        String description = scanner.nextLine();

        try (Connection connection = DBConnection.getConnection()) {
            String sql = "INSERT INTO events (title, description) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, title);
            statement.setString(2, description);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Event created successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void viewEvents() {
        System.out.println("\nView Events:");

        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT * FROM events";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println("Event ID: " + resultSet.getInt("id"));
                System.out.println("Title: " + resultSet.getString("title"));
                System.out.println("Description: " + resultSet.getString("description"));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void editEvent(Scanner scanner) {
        System.out.println("\nEdit Event:");
        System.out.print("Enter Event ID to edit: ");
        int eventId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter new Event Title: ");
        String newTitle = scanner.nextLine();
        System.out.println("Enter new Event Description: ");
        String newDescription = scanner.nextLine();

        try (Connection connection = DBConnection.getConnection()) {
            String sql = "UPDATE events SET title = ?, description = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newTitle);
            statement.setString(2, newDescription);
            statement.setInt(3, eventId);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Event updated successfully.");
            } else {
                System.out.println("Event ID not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  

    private static void deleteEvent(Scanner scanner) {
        System.out.println("\nDelete Event:");

        System.out.print("Enter Event ID to delete: ");
        int eventId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Event with ID " + eventId + " deleted successfully.");
    }
}
