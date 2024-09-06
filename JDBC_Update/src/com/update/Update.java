//Values Updated in BLT_2 Table using PreparedStatement


package com.update;
import java.sql.*;
import java.io.*;

public class Update {

	public static void main(String[] args) {
		
		Connection con = null;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "ACS_DAC";
			String pwd = "ACS_DAC";
			con = DriverManager.getConnection(url, username, pwd);
			
			
			String query="update BLT_2 set STA =? where TASK_ID =?";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			
			System.out.println("Enter the STA : ");
			String STA = br.readLine();
			System.out.println("Enter TASK_ID : ");
			int TASK_ID = Integer.parseInt(br.readLine());
			
			pst.setString(1, STA);
			pst.setInt(2, TASK_ID);
			
			
			pst.executeUpdate();
			
			System.out.println("Values Updated in table..");
			pst.close();

			
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		finally {
			if(con!=null) {
				try {
					con.close();
					System.out.println("Connection closed..");
				}
				catch(SQLException e){
					e.printStackTrace();
					
				}
			}
		}
	}

}
