package kidda.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ControlDBAccess {

	protected Connection createConnection() {
		Connection con = null;

	try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:65534/kidda_la",
				"root",
				"pass");


	}catch(ClassNotFoundException e){
		System.out.println("JDBC ドライバ見つかりません");
		e.printStackTrace();


	}
	catch(SQLException e) {
		System.out.println("DB 接続時にエラーが発生しました");
		e.printStackTrace();
	}

	return con;
	}
	//Db close

	protected void closeConnection(Connection con) {
		try {
			if(con != null) {
				con.close();
			}
		}catch(SQLException e) {
			System.out.println("DB切断時にエラーが発生しました");
			e.printStackTrace();
		}
	}



}
