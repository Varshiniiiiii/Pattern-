package in.inueron.jdbc.util;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcConnection {
	public static Connection getJdbcConnection() throws SQLException{
	Connection connection=null;
	String url="jdbc:mysql://localhost:3306/nithin";
	String user="root";
	String password="root";
	connection=DriverManager.getConnection(url,user,password);
		if(connection!=null) {
			return connection;
		}
		return connection;
}
	public static void closeConnection(ResultSet resultset,Connection connection,Statement statement) throws SQLException
	{
		if(resultset!=null)resultset.close();
		if(statement!=null)statement.close();
		if(connection!=null)connection.close();
		
	}
}
