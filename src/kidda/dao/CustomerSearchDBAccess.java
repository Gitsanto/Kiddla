package kidda.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kidda.model.Customer;

public class CustomerSearchDBAccess {


	private Connection createConnection() {
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

	private void closeConnection(Connection con) {
		try {
			if(con != null) {
				con.close();
			}
		}catch(SQLException e) {
			System.out.println("DB切断時にエラーが発生しました");
			e.printStackTrace();
		}
	}

//	//list by tel
	public ArrayList<Customer> searchCustomerByTel(String Tel){
		Connection con = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Customer> list = new ArrayList<Customer>();

		try {
			if(con != null) {

				String sql ="select * from customer where tel = "+Tel+";";
				pstmt = con.prepareStatement(sql);
				rs= pstmt.executeQuery();


			while(rs.next()== true) {

					int  id= rs.getInt("custid");
					String name= rs.getString("custname");
					String kana= rs.getString("kana");
					String tel= rs.getString("tel");
					String address= rs.getString("address");

			Customer cusData = new Customer(id,name, kana, tel, address);
				list.add(cusData);
				}
			}



	        }catch(SQLException e) {
		        System.out.println("DB切断時にエラーが発生しました（顧客検索 by tel）");
		       e.printStackTrace();

	         }finally {
		       try{
			    if(rs !=null) {
				   rs.close();
			    }
		      }catch(SQLException e) {
			     System.out.println("DB切断時にエラーが発生しました");
			     e.printStackTrace();
		        }try {
			    if(pstmt != null) {
				pstmt.close();
			    }
		       }catch(SQLException e) {
			     System.out.println("DB切断時にエラーが発生しました");
			    e.printStackTrace();
		      }
	         }
		closeConnection(con);
		return list;
		}


	//list by kana
		public ArrayList<Customer> searchCustomerByKana(String Kana){
			Connection con = createConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArrayList<Customer> list = new ArrayList<Customer>();

			try {
				if(con != null) {

					String sql ="select * from customer where kana = "+Kana+";";
					pstmt = con.prepareStatement(sql);
					rs= pstmt.executeQuery();

				while(rs.next()== true) {
					System.out.println(Kana);
						int  id= rs.getInt("custid");
						String name= rs.getString("custname");
						String kana= rs.getString("kana");
						String tel= rs.getString("tel");
						String address= rs.getString("address");
						System.out.println(kana);
				Customer cusData = new Customer(id,name, kana, tel, address);
					list.add(cusData);
					}
				}


		        }catch(SQLException e) {
			        System.out.println("DB切断時にエラーが発生しました（顧客検索 by kana）");
			       e.printStackTrace();

		         }finally {
			       try{
				    if(rs !=null) {
					   rs.close();
				    }
			      }catch(SQLException e) {
				     System.out.println("DB切断時にエラーが発生しました");
				     e.printStackTrace();
			        }try {
				    if(pstmt != null) {
					pstmt.close();
				    }
			       }catch(SQLException e) {
				     System.out.println("DB切断時にエラーが発生しました");
				    e.printStackTrace();
			      }
		     }

    closeConnection(con);
    return list;
	}

}
