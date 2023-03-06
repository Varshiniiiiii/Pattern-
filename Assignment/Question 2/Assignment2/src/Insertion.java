import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import in.inueron.jdbc.util.JdbcConnection;

public class Insertion {

	public static void main(String[] args) throws ParseException {
		Connection connection=null;
		PreparedStatement pstm=null;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the name: ");
		String name=sc.next();
		
		System.out.println("Enter the address: ");
		String address=sc.next();
		
		System.out.println("Enter the gender: " );
		String gender=sc.next();
		
		System.out.println("Enter the DOB(dd-MM-yyyy): ");
		String sdob=sc.next();
		
		System.out.println("Enter the DOJ(MM-dd-yyyy): ");
		String sdoj=sc.next();
		
		
		System.out.println("Enter the DOM(yyyy-MM-dd): ");
		String sdom=sc.next();
		
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date udate=sdf.parse(sdob);
		
		long time=udate.getTime();
		java.sql.Date sqldate=new java.sql.Date(time);
		
		SimpleDateFormat sdj=new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date udatej=sdf.parse(sdoj);
		
		long timel=udatej.getTime();
		java.sql.Date sqldatej=new java.sql.Date(timel);
		
		java.sql.Date sqldom=java.sql.Date.valueOf(sdom);
		
		String sqlInsertQuery="insert into assignment2(`name`,`address`,`gender`,`dob`,`doj`,`dom`) values (?,?,?,?,?,?)";
		try {
			connection=JdbcConnection.getJdbcConnection();
			if(connection!=null)
			{
				pstm=connection.prepareStatement(sqlInsertQuery);
				if(pstm!=null)
				{
					pstm.setString(1, name);
					pstm.setString(2, address);
					pstm.setString(3, gender);
					pstm.setDate(4, sqldate);
					pstm.setDate(5, sqldatej);
					pstm.setDate(6, sqldom);
					int row=pstm.executeUpdate();
					System.out.println("Number of rows affected: "+row);
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
			try {
				JdbcConnection.closeConnection(null, pstm, connection);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			if(sc!=null) {
				sc.close();
			}
		}

	

	

	}

}
