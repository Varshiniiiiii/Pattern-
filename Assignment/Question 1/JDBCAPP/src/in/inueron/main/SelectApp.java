package in.inueron.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class SelectApp {

	public void select() throws SQLException {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		
		
		
		String url="jdbc:mysql://localhost:3306/nithin";
		String user="root";
		String password="root";
		Connection connection=DriverManager.getConnection(url,user,password);
		
		
		Statement statement=connection.createStatement();
		
		ResultSet resultset=statement.executeQuery("select sid,sname,sage,saddar from student");
		while(resultset.next())
		{
			int sid=resultset.getInt("sid");
			String sname=resultset.getString("sname");
			int sage=resultset.getInt("sage");
			String saddar=resultset.getString("saddar");
			System.out.println(sid+"\t"+sname+"\t\t"+sage+"\t"+saddar);
			
		}
		resultset.close();
		statement.close();
		connection.close();
	}

}
