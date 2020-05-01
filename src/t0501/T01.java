package t0501;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class T01 {

	public static void main(String[] args) throws 
		ClassNotFoundException, SQLException{
		
		String url = "jdbc:oracle:thin://@localhost:1521:orcl";
		String userid = "kosmo";
		String userpw = "1234";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url,
				userid,userpw);
		if(con!=null) {
			System.out.println("DB연결성공");
		}
		else {
			System.out.println("DB연결실패");
		}
	}

}
