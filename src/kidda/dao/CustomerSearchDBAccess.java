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
		Connection conByTel = createConnection();
		PreparedStatement pstmtByTel = null;
		ResultSet rsByTel = null;
		ArrayList<Customer> listByTel = new ArrayList<Customer>();

		try {
			if(conByTel != null) {

				String sqlByTel ="select  custid,custname,kana,tel,address  from customer where tel = "+Tel+";";
				pstmtByTel = conByTel.prepareStatement(sqlByTel);

				rsByTel= pstmtByTel.executeQuery();


			while(rsByTel.next()== true) {

					int  id= rsByTel.getInt("custid");
					String name= rsByTel.getString("custname");
					String kana= rsByTel.getString("kana");
					String tel= rsByTel.getString("tel");
					String address= rsByTel.getString("address");

			Customer cusData = new Customer(id,name, kana, tel, address);
				listByTel.add(cusData);
				}
			}



	        }catch(SQLException e) {
		        System.out.println("DB切断時にエラーが発生しました（顧客検索 by tel）");
		       e.printStackTrace();

	         }finally {
		       try{
			    if(rsByTel !=null) {
				   rsByTel.close();
			    }
		      }catch(SQLException e) {
			     System.out.println("DB切断時にエラーが発生しました");
			     e.printStackTrace();
		        }try {
			    if(pstmtByTel != null) {
			    	pstmtByTel.close();
			    }
		       }catch(SQLException e) {
			     System.out.println("DB切断時にエラーが発生しました");
			    e.printStackTrace();
		      }
	         }
		closeConnection(conByTel);
		return listByTel;
		}


	//list by kana
		public ArrayList<Customer> searchCustomerByKana(String Kana){
			Connection con = createConnection();
			PreparedStatement pstmtByKana = null;
			ResultSet rsByKana = null;
			ArrayList<Customer> listByKana = new ArrayList<Customer>();

			try {
			   if(con != null) {
			   if(Kana != "") {
					String sqlByKana = "select custid,custname,kana,tel,address from customer where kana like ?";
					pstmtByKana = con.prepareStatement(sqlByKana);
					pstmtByKana.setString(1, "%"+Kana+"%");
					}else {
						String sqlByKana = "select custid,custname,kana,tel,address from customer";
						pstmtByKana = con.prepareStatement(sqlByKana);
					}

					rsByKana= pstmtByKana.executeQuery();

				while(rsByKana.next()== true) {

						int  id= rsByKana.getInt("custid");
						String name= rsByKana.getString("custname");
						String kana= rsByKana.getString("kana");
						String tel= rsByKana.getString("tel");
						String address= rsByKana.getString("address");

				Customer cusData = new Customer(id,name, kana, tel, address);
					listByKana.add(cusData);
					}
				}


		        }catch(SQLException e) {
			        System.out.println("DB切断時にエラーが発生しました（顧客検索 by kana）");
			       e.printStackTrace();

		         }finally {
			       try{
				    if(rsByKana !=null) {
					   rsByKana.close();
				    }
			      }catch(SQLException e) {
				     System.out.println("DB切断時にエラーが発生しました");
				     e.printStackTrace();
			        }try {
				    if(pstmtByKana != null) {
					pstmtByKana.close();
				    }
			       }catch(SQLException e) {
				     System.out.println("DB切断時にエラーが発生しました");
				    e.printStackTrace();
			      }
		     }

    closeConnection(con);
    return listByKana;
	}

}
