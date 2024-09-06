package com.CRUD;

import java.sql.*;
import java.util.Scanner;

public class MenudrivenProgram {
	
    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    static final String USER = "ACS_DAC";
    static final String PASS = "ACS_DAC";
    
    public static void main(String[] args) {
        try {
            
            Class.forName(JDBC_DRIVER);
            
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n=== Menu ===");
                System.out.println("1. Create");
                System.out.println("2. Read");
                System.out.println("3. Update");
                System.out.println("4. Delete");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        createRecord(conn, scanner);
                        break;
                    case 2:
                        readRecords(conn);
                        break;
                    case 3:
                        updateRecord(conn, scanner);
                        break;
                    case 4:
                        deleteRecord(conn, scanner);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } while (choice != 5);

            conn.close();
            scanner.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createRecord(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter TASK_ID: ");
        int taskId= scanner.nextInt();
        
        scanner.nextLine(); 
        
        System.out.print("Enter TASK: ");
        String task = scanner.nextLine();
        System.out.print("Enter STA: ");
        String sta = scanner.nextLine();
        System.out.print("Enter COMPL_TME: ");
        String time = scanner.nextLine();
        

        String query = "insert into BLT_2 values (?, ?, ?, ?)";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, taskId);
        pst.setString(2, task);
        pst.setString(3, sta);
        pst.setString(4, time);
        
        pst.executeUpdate();
        System.out.println("Record created successfully.");
    }

    public static void readRecords(Connection conn) throws SQLException {
        String query = "select * from BLT_2";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            
            System.out.println("TASK_ID   : "+ rs.getInt(1));
            System.out.println("TASK      : " + rs.getString(2));
            System.out.println("STA       : " + rs.getString(3));
            System.out.println("COMPL_TME : " + rs.getString(4));
            System.out.println(" ");
        }
    }

    public static void updateRecord(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter TASK_ID of the record to update: ");
        int taskId = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter STA: ");
        String sta = scanner.nextLine();
        
        String query = "update BLT_2 set STA = ? where TASK_ID = ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, sta );
        pst.setInt(2, taskId);
      
        int rows = pst.executeUpdate();
        
        if (rows > 0) {
            System.out.println("Record updated successfully.");
        } else {
            System.out.println("Record not found.");
        }
    }

    public static void deleteRecord(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter TASK_ID of the record to delete: ");
        int taskId = scanner.nextInt();

        String query = "delete from BLT_2 where TASK_ID = ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, taskId);
        
        int rows = pst.executeUpdate();
        
        if (rows > 0) {
            System.out.println("Record deleted successfully.");
        } else {
            System.out.println("Record not found.");
        }
    }
}
