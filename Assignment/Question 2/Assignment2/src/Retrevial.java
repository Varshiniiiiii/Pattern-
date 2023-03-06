
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import in.inueron.jdbc.util.JdbcConnection;

public class Retrevial {

	public static void main(String[] args) throws ParseException {

		// resource used
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the name:: ");
		String name = scanner.next();

		String sqlSelectQuery = "select name,address,gender,dob,doj,dom from assignment2 where name = ?";

		try {

			connection = JdbcConnection.getJdbcConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlSelectQuery);

			if (pstmt != null) {
				pstmt.setString(1, name);
				resultSet = pstmt.executeQuery();
			}
			if (resultSet != null) {

				if (resultSet.next()) {
					
					String userName = resultSet.getString(1);
					String address=resultSet.getString(2);
					String gender=resultSet.getString(3);
					java.sql.Date userDob = resultSet.getDate(4);
					System.out.println("SQLDate present in database is :: "+userDob);
					// formatting the output as the user choice(based on locale)
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					String date = sdf.format(userDob);
					
					
					java.sql.Date userDoj = resultSet.getDate(5);
					System.out.println("SQLDate present in database is :: "+userDoj);
					// formatting the output as the user choice(based on locale)
					SimpleDateFormat sdfj = new SimpleDateFormat("dd-MM-yyyy");
					String datej = sdfj.format(userDoj);
					
					java.sql.Date userDom = resultSet.getDate(6);
					System.out.println("SQLDate present in database is :: "+userDom);
					// formatting the output as the user choice(based on locale)
					SimpleDateFormat sdfm = new SimpleDateFormat("dd-MM-yyyy");
					String datem = sdfm.format(userDom);
					
					
					
					System.out.println("NAME IS :: " + userName);
					System.out.println("ADDRESS IS :: " + address);
					System.out.println("GENDER IS :: " + gender);
					System.out.println("DOB  IS :: " + date);
					System.out.println("DOJ IS :: " + datej);
					System.out.println("DOM IS :: " + datem);
				
				} else {
					System.out.println("Record not available for the given name: " + name);
				}

			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				JdbcConnection.closeConnection(resultSet, pstmt, connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (scanner != null) {
				scanner.close();
			}
		}

	}
}