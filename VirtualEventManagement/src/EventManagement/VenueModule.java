package EventManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class VenueModule {
    public static void runVenueModule(Scanner scanner) {
        boolean exitVenueModule = false;

        while (!exitVenueModule) {
            System.out.println("\nVirtual Venue Setup:");
            System.out.println("1. Create Venue Spaces");
            System.out.println("2. Customize Venue");
            System.out.println("3. View Venue Layout");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    createVenueSpaces(scanner);
                    break;
                case 2:
                    customizeVenue(scanner);
                    break;
                case 3:
                    viewVenueLayout(scanner);
                    break;
                case 4:
                    exitVenueModule = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createVenueSpaces(Scanner scanner) {
        System.out.println("Create Venue Spaces:");
        System.out.print("Enter Space Name: ");
        String spaceName = scanner.nextLine();
        System.out.print("Enter Capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); 

        insertVenueSpace(spaceName, capacity);
    }

    public static void customizeVenue(Scanner scanner) {
        System.out.println("Customize Venue:");
        System.out.println("What would you like to customize?");
        System.out.println("1. Add branding");
        System.out.println("2. Add banners");
        System.out.println("3. Add logos");
        System.out.println("4. Add interactive features");
        System.out.println("5. Back to Venue Menu");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                addBranding(scanner);
                break;
            case 2:
                addBanners(scanner);
                break;
            case 3:
                addLogos(scanner);
                break;
            case 4:
                addInteractiveFeatures(scanner);
                break;
            case 5:
                System.out.println("Returning to Venue Menu.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    private static void addBranding(Scanner scanner) {
        System.out.println("Adding branding:");
 
        System.out.println("Upload branding images:");
        System.out.print("Enter file path or URL: ");
        String imagePath = scanner.nextLine();
        System.out.println("Set color themes:");
        System.out.print("Enter primary color: ");
        String primaryColor = scanner.nextLine();
        System.out.print("Enter secondary color: ");
        String secondaryColor = scanner.nextLine();
        saveBrandingDetailsToDatabase(imagePath, primaryColor, secondaryColor);
        
        System.out.println("Branding added successfully.");
    }

    private static void saveBrandingDetailsToDatabase(String imagePath, String primaryColor, String secondaryColor) {
        System.out.println("Saving branding details to the database...");
        System.out.println("Image path: " + imagePath);
        System.out.println("Primary color: " + primaryColor);
        System.out.println("Secondary color: " + secondaryColor);
       
    }
    private static void addBanners(Scanner scanner) {
        System.out.println("Adding banners:");
       
    }

    private static void addLogos(Scanner scanner) {
        System.out.println("Adding logos:");
        
    }

    private static void addInteractiveFeatures(Scanner scanner) {
        System.out.println("Adding interactive features:");
        
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        customizeVenue(scanner);
        scanner.close();
    }


    private static void viewVenueLayout(Scanner scanner) {
        System.out.println("View Venue Layout:");
        viewVenueSpaces();
    }

   

    public static void createVenueTable() {
        String sql = "CREATE TABLE IF NOT EXISTS venue ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "space_name VARCHAR(255) NOT NULL,"
                + "capacity INT)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.executeUpdate();
            System.out.println("Venue table created successfully.");
        } catch (SQLException e) {
            System.out.println("Error creating venue table: " + e.getMessage());
        }
    }

    public static void insertVenueSpace(String spaceName, int capacity) {
        String sql = "INSERT INTO venue (space_name, capacity) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, spaceName);
            statement.setInt(2, capacity);
            statement.executeUpdate();
            System.out.println("Venue space inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting venue space: " + e.getMessage());
        }
    }

    public static void viewVenueSpaces() {
        String sql = "SELECT * FROM venue";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                System.out.println("Space ID: " + resultSet.getInt("id"));
                System.out.println("Space Name: " + resultSet.getString("space_name"));
                System.out.println("Capacity: " + resultSet.getInt("capacity"));
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Error viewing venue spaces: " + e.getMessage());
        }
    }
}
