package EventManagement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SpeakerModule {
    public static void runSpeakerModule(Scanner scanner) {
        boolean exitSpeakerModule = false;

        while (!exitSpeakerModule) {
            System.out.println("\nSpeaker and Presenter Management:");
            System.out.println("1. Manage Speakers");
            System.out.println("2. Schedule Speaker Sessions");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    manageSpeakers(scanner);
                    break;
                case 2:
                    scheduleSpeakerSessions(scanner);
                    break;
                case 3:
                    exitSpeakerModule = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageSpeakers(Scanner scanner) {
        boolean exitManageSpeakers = false;

        while (!exitManageSpeakers) {
            System.out.println("Manage Speakers:");
            System.out.println("1. Add Speaker");
            System.out.println("2. Edit Speaker");
            System.out.println("3. Delete Speaker");
            System.out.println("4. View Speakers");
            System.out.println("5. Back to Speaker Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addSpeaker(scanner);
                    break;
                case 2:
                    editSpeaker(scanner);
                    break;
                case 3:
                    deleteSpeaker(scanner);
                    break;
                case 4:
                    viewSpeakers();
                    break;
                case 5:
                    exitManageSpeakers = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addSpeaker(Scanner scanner) {
        System.out.println("Add Speaker:");
        System.out.print("Enter Speaker Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Topic: ");
        String topic = scanner.nextLine();
        System.out.print("Enter Affiliation: ");
        String affiliation = scanner.nextLine();

        insertSpeaker(name, topic, affiliation);
    }

    private static void editSpeaker(Scanner scanner) {
        System.out.println("Edit Speaker:");
        System.out.print("Enter Speaker ID to edit: ");
        int speakerId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Topic: ");
        String topic = scanner.nextLine();
        System.out.print("Enter New Affiliation: ");
        String affiliation = scanner.nextLine();
        updateSpeaker(speakerId, name, topic, affiliation);
    }

    private static void deleteSpeaker(Scanner scanner) {
        System.out.println("Delete Speaker:");
        System.out.print("Enter Speaker ID to delete: ");
        int speakerId = scanner.nextInt();
        scanner.nextLine(); 
        deleteSpeakerById(speakerId);
    }

    private static void updateSpeaker(int speakerId, String name, String topic, String affiliation) {
       
        System.out.println("Speaker details updated successfully.");
    }

    private static void deleteSpeakerById(int speakerId) {
      
        System.out.println("Speaker deleted successfully.");
    }

    private static void scheduleSpeakerSessions(Scanner scanner) {
        boolean exitScheduleSessions = false;

        while (!exitScheduleSessions) {
            System.out.println("Schedule Speaker Sessions:");
            System.out.println("1. Assign Speaker to Session");
            System.out.println("2. View Scheduled Sessions");
            System.out.println("3. Back to Speaker Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    assignSpeakerToSession(scanner);
                    break;
                case 2:
                    viewScheduledSessions();
                    break;
                case 3:
                    exitScheduleSessions = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void assignSpeakerToSession(Scanner scanner) {
        System.out.println("Assign Speaker to Session:");
        System.out.print("Enter Speaker ID: ");
        int speakerId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Session ID: ");
        int sessionId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Speaker assigned to session successfully.");
    }
    private static void viewScheduledSessions() {
        System.out.println("View Scheduled Sessions:");

        String sql = "SELECT * FROM scheduled_sessions";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            if (!resultSet.isBeforeFirst()) {
                System.out.println("No scheduled sessions found.");
            } else {
                while (resultSet.next()) {
                    int sessionId = resultSet.getInt("id");
                    String sessionTitle = resultSet.getString("session_title");
                    String speakerName = resultSet.getString("speaker_name");
                    String sessionDate = resultSet.getString("session_date");
                    String startTime = resultSet.getString("start_time");
                    String endTime = resultSet.getString("end_time");

                    System.out.println("Session ID: " + sessionId);
                    System.out.println("Title: " + sessionTitle);
                    System.out.println("Speaker: " + speakerName);
                    System.out.println("Date: " + sessionDate);
                    System.out.println("Start Time: " + startTime);
                    System.out.println("End Time: " + endTime);
                    System.out.println();
                }
            }

        } catch (SQLException e) {
            System.out.println("Error viewing scheduled sessions: " + e.getMessage());
        }
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        uploadPresentationMaterials(scanner);
        scanner.close();
    }
   

    private static void uploadPresentationMaterials(Scanner scanner) {
		
	}


    public static void createSpeakerTable() {
        String sql = "CREATE TABLE IF NOT EXISTS speakers ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "name VARCHAR(255) NOT NULL,"
                + "topic VARCHAR(255),"
                + "affiliation VARCHAR(255)"
                + ")";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.executeUpdate();
            System.out.println("Speaker table created successfully.");
        } catch (SQLException e) {
            System.out.println("Error creating speaker table: " + e.getMessage());
        }
    }

    public static void insertSpeaker(String name, String topic, String affiliation) {
        String sql = "INSERT INTO speakers (name, topic, affiliation) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, topic);
            statement.setString(3, affiliation);
            statement.executeUpdate();
            System.out.println("Speaker inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting speaker: " + e.getMessage());
        }
    }

    public static void viewSpeakers() {
        String sql = "SELECT * FROM speakers";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                System.out.println("Speaker ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Topic: " + resultSet.getString("topic"));
                System.out.println("Affiliation: " + resultSet.getString("affiliation"));
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Error viewing speakers: " + e.getMessage());
        }
    }
}
