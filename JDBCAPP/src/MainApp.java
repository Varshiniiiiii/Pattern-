import java.sql.SQLException;
import java.util.Scanner;

import in.inueron.dynamicinput.InsertApp;
import in.inueron.main.DeleteApp;
import in.inueron.main.SelectApp;
import in.inueron.main.UpdateApp;

public class MainApp {
	public static void main(String args[]) throws SQLException
	
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the operation u want to perform");
		System.out.println("1)Insert\n2)Read\n3)Update\n4)Delete");
		int i=sc.nextInt();
		switch(i) {
		case 1:InsertApp in=new InsertApp();
				in.insert();	
				break;
		case 2: SelectApp read=new SelectApp();
			read.select();
				break;
		case 3:UpdateApp update=new UpdateApp();
				update.update();
				break;
		case 4:DeleteApp delete=new DeleteApp();
				delete.delete();
					break;
		}
		
			System.out.println("Thankyou for using the Application");
		
	}
}
