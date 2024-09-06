//Values Inserted in BLT_2 Table using PreparedStatement


package com.insert;
import java.sql.*;
import java.io.*;

public class Insertion {

	public static void main(String[] args) {
		
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String username ="ACS_DAC";
			String pwd="ACS_DAC";
			con = DriverManager.getConnection(url,username,pwd);
			
			
			String query = "insert into BLT_2 values(?,?,?,?)";
			
			PreparedStatement pst = con.prepareStatement(query);
		
//			 Manual data insertion
/* 
          	pst.setInt(1, 11);
			pst.setString(2, "proj_11");
			pst.setString(3, "In Progress");
			pst.setString(4, "5 Days");
 */
			
//			Dynamic data insertion
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter the TASK_ID: ");
	        int TASK_ID = Integer.parseInt(br.readLine());
			
			System.out.println("Enter the TASK : ");
			String TASK = br.readLine();
			
			System.out.println("Enter the STA : ");
			String STA = br.readLine();
			
			System.out.println("Enter the COMPL_TIME : ");
			String COMPL_TME = br.readLine();
			
			
			pst.setInt(1, TASK_ID);
			pst.setString(2, TASK);
			pst.setString(3, STA);
			pst.setString(4, COMPL_TME);
			
			
			pst.executeUpdate();
			
			System.out.println("Values Inserted in table..");
			
			pst.close();
			
			
			
			
			
		}
		
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
        	if (con != null) {
        		try {
        			con.close();
        			System.out.println("Connection closed.");
        		} 	
        		catch (SQLException e) {
                e.printStackTrace();
        		}
        	}
		}
		
	}

}
