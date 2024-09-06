package com.delete;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
public class Deletion {

	public static void main(String[] args) {
		
		Connection con = null;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "ACS_DAC";
			String pwd = "ACS_DAC";
			con = DriverManager.getConnection(url, username, pwd);
			
			
			String query="delete from BLT_2 where Task_ID = ?";
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter the TASK_ID : ");
			int taskID = Integer.parseInt(br.readLine());
			
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1, taskID);

			pst.executeUpdate();
			System.out.println("Record Deleted..");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
