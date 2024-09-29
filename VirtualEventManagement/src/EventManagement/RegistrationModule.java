package EventManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistrationModule {
    
    private static final String TABLE_NAME = "registrations";

    private static final String INSERT_QUERY = "INSERT INTO " + TABLE_NAME + " (name, email) VALUES (?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM " + TABLE_NAME;

    public static void runRegistrationModule(Scanner scanner) {
        boolean exitRegistrationModule = false;

        while (!exitRegistrationModule) {
            System.out.println("\nRegistration and Ticketing:");
            System.out.println("1. Register for Event");
            System.out.println("2. View Registration Details");
            System.out.println("3. Pay for Event (Ticketing)");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    registerForEvent(scanner);
                    break;
                case 2:
                    viewRegistrationDetails();
                    break;
                case 3:
                    payForEvent(scanner);
                    break;
                case 4:
                    exitRegistrationModule = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerForEvent(Scanner scanner) {
        System.out.println("\nRegister for Event:");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
            System.out.println("Registration successful.");
        } catch (SQLException e) {
            System.out.println("Failed to register: " + e.getMessage());
        }
    }

    private static void viewRegistrationDetails() {
        System.out.println("\nView Registration Details:");
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (!resultSet.isBeforeFirst()) {
                System.out.println("No registrations found.");
            } else {
                System.out.println("Registration Details:");
                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("Name: " + resultSet.getString("name"));
                    System.out.println("Email: " + resultSet.getString("email"));
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve registration details: " + e.getMessage());
        }
    }

    private static void payForEvent(Scanner scanner) {
        System.out.println("\nPay for Event (Ticketing):");

        
        System.out.println("Enter payment details:");
        System.out.print("Credit Card Number: ");
        @SuppressWarnings("unused")
		String creditCardNumber = scanner.nextLine();
        System.out.print("Expiration Date (MM/YY): ");
        @SuppressWarnings("unused")
		String expirationDate = scanner.nextLine();
        System.out.print("CVV: ");
        @SuppressWarnings("unused")
		String cvv = scanner.nextLine();

        System.out.println("Processing payment...");
        System.out.println("Payment processed successfully.");

        System.out.println("Ticket issued.");
        System.out.println("Registration status updated.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        runRegistrationModule(scanner);
        scanner.close();
    }
    @SuppressWarnings("unused")
	private static class Registration {
        private String name;
        private String email;

        public Registration(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }
}
