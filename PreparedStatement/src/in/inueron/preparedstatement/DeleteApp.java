package in.inueron.preparedstatement;
import java.sql.*;
import java.util.Scanner;

import in.inueron.jdbc.util.*;
public class DeleteApp {

	public static void main(String[] args) throws SQLException {
		Connection connection=null;
		PreparedStatement pstm=null;
		ResultSet resultset=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id of the student: ");
		int id=sc.nextInt();
		String updateQuery="delete from  student  where sid=?";
		
		try {
			connection=JdbcConnection.getJdbcConnection();
			if(connection!=null)
			{
				pstm=connection.prepareStatement(updateQuery);
				if(pstm!=null) {
					pstm.setInt(1,id);
					
					int noOfRows=pstm.executeUpdate();
					if(noOfRows==1)
					{
						System.out.println("Number of rows affected : "+noOfRows);
						
					}else {
						System.out.println("Record not found for "+id);
					}
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
			JdbcConnection.closeConnection(resultset, connection, pstm);
		}

	}

}
