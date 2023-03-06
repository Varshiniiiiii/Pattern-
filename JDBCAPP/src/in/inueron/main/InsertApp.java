package in.inueron.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class InsertApp {

	public static void main(String[] args) throws SQLException {
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
						
							int noOfRows=statement.executeUpdate("insert into student( sid,sname,sage,saddar) values (5,'abc',40,'ban')");
							System.out.println("No of rows affected is :: "+noOfRows);
							
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
