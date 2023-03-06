package in.inueron.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class UpdateApp {

	public void update() throws SQLException {
		Connection connection=null;

		Statement statement=null;
		
		
		
		
		String url="jdbc:mysql://localhost:3306/nithin";
		String user="root";
		String password="root";
		try {
			connection=DriverManager.getConnection(url,user,password);
			if (connection!=null)
			{
					statement=connection.createStatement();
					
					if (statement!=null)
					{
						
							int noOfRows=statement.executeUpdate("update student set sage=34 where sid=4");
							System.out.println("No of rows updated is :: "+noOfRows);
							
					}
			}
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			if(statement!=null)statement.close();
			if(connection!=null)connection.close();
		}
		
	}

}