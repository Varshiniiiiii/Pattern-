package in.inueron.preparedstatement;
import java.sql.*;
import java.util.Scanner;

import in.inueron.jdbc.util.*;
public class SelectApp {

	public static void main(String[] args) throws SQLException {
		Connection connection=null;
		PreparedStatement pstm=null;
		ResultSet resultset=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id of the student: ");
		int sid=sc.nextInt();
		String selectQuery="select * from student where sid=?";
		
		try {
			connection=JdbcConnection.getJdbcConnection();
			if(connection!=null)
			{
				pstm=connection.prepareStatement(selectQuery);
				if(pstm!=null) {
					pstm.setInt(1,sid);
					
					resultset=pstm.executeQuery();
					if(resultset.next())
					{
						System.out.println("id\tname\tage\taddress");
						System.out.println(resultset.getInt(1)+"\t"+resultset.getString(2)+"\t"+resultset.getInt(3)+"\t"+resultset.getString(4));
					}else {
						System.out.println("Record not found for "+sid);
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
