package in.inueron.preparedstatement;


import in.inueron.jdbc.util.*;
import java.sql.*;
import java.util.Scanner;

import in.inueron.jdbc.util.JdbcConnection;
public class InsertApp {

	public static void main(String[] args)throws SQLException {
		Connection connection=null;
		PreparedStatement pstm=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the sid: ");
		int id=sc.nextInt();
		System.out.println("Enter the sname: ");
		String name=sc.next();
		System.out.println("Enter the age: ");
		int age=sc.nextInt();
		System.out.println("Enter the address: ");
		String address=sc.next();
		String sqlIntsertQuery="insert into student(`sid`,`sname`,`sage`,`saddar`) values(?,?,?,?)";
		try
		{
			connection=JdbcConnection.getJdbcConnection();
			if(connection!=null) {
				pstm=connection.prepareStatement(sqlIntsertQuery);
				if(pstm!=null) {
					pstm.setInt(1, id);
					pstm.setString(2, name);
					pstm.setInt(3, age);
					pstm.setString(4, address);
					int rowAffected=pstm.executeUpdate();
					System.out.println("Number of rows affected "+rowAffected);
					
				}
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JdbcConnection.closeConnection(null, connection, pstm);
			if(sc!=null)sc.close();
		}

	}

}
