package com.select;
import java.sql.*;
public class Select {

	public static void main(String[] args) {
		
		Connection con = null;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "ACS_DAC";
			String pwd = "ACS_DAC";
			con = DriverManager.getConnection(url, username, pwd);
			
			
			String query = "select * from BLT";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				 System.out.println("Column1: " + rs.getInt("TASK_ID"));
				 System.out.println("Column2: " + rs.getString("TASK"));
				 System.out.println(" ");
	             
				
			}
			st.close();

			
			
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
