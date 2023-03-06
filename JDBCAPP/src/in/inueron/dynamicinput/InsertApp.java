package in.inueron.dynamicinput;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;


public class InsertApp {

	public void insert() throws SQLException{
		Connection connection=null;

		Statement statement=null;
		
		
		
		
		String url="jdbc:mysql://localhost:3306/nithin";
		String user="root";
		String password="root";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id : ");
		int sid=sc.nextInt();
		System.out.println("Enter the age : ");
		int sage=sc.nextInt();
		System.out.println("Enter the name : ");
		String sname=sc.next();
		System.out.println("Enter the address : ");
		String saddar=sc.next();
		
		try {
			connection=DriverManager.getConnection(url,user,password);
			if (connection!=null)
			{
					statement=connection.createStatement();
					
					if (statement!=null)
					{
						String sqlinsert=String.format("insert into student( `sid`,`sname`,`sage`,`saddar`) values ('%d','%s','%d','%s')",sid,sname,sage,saddar);
							int noOfRows=statement.executeUpdate(sqlinsert);
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
			if(sc!=null)sc.close();
		}
		
	}

}