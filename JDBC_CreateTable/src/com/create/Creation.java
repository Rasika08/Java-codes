//Created a Table(BLT_2) in the database named ACS_DAC

package com.create;
import java.sql.*;

public class Creation {

	public static void main(String[] args) {
		Connection con = null;
		try {
//			Step 1
			Class.forName("oracle.jdbc.driver.OracleDriver");

//			Step 2
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String username ="ACS_DAC";
			String pwd="ACS_DAC";
			con = DriverManager.getConnection(url,username,pwd);
			
//			Step 3
			String query = "create table BLT_2(Task_ID int primary key, TASK varchar(20) not null, STA varchar(20), COMPL_TME varchar(20))";
			
			
//			Step 4
			Statement st = con.createStatement();
			st.executeUpdate(query);
			
			System.out.println("table is created in database..");
		
//			Step 5
			st.close();
	
		}
		catch(Exception e){
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
