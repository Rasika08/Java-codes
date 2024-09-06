//First program of the JDBC connection and Retrieving some values



/*
 * Requirements.......
 * ojdbc8.jar
 * Driver-oracle.jdbc.driver.OracleDriver
 * URL-jdbc:oracle:thin:@localhost:1521:xe
 */



package jdbc_connectivity;
import java.sql.*;

public class Conn {
	public static void main(String arg[]) {
		Connection con = null;
		try {

//Step 1 {Load the driver}
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
// Step 2 {Create a Connection}
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "ACS_DAC";
			String password = "ACS_DAC";
			con = DriverManager.getConnection(url, username, password);
			
			if(con.isClosed()) {
				System.out.println("Connection is closed");
			}else {
				System.out.println("Connection created.....");

			}

// Step 3 {Create a query, Statement(Simple), PreparedStatement(Complex), CallableStatement(Stored Procedural)}
			String query = "select * from BLT";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
// Step 4 {Process the data}
			while(rs.next()) {
				 System.out.println("Column1: " + rs.getInt("TASK_ID"));
				 System.out.println("Column2: " + rs.getString("TASK"));
				 System.out.println(" ");
	             
				
			}
//Step 5 {Connection Close}			
			 rs.close();
	         st.close();
		}
			catch(Exception e){
			e.printStackTrace();
		} finally {
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
