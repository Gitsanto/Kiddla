package kidda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kidda.model.Item;

public class ItemMenuDisplayAccess extends ControlDBAccess {

	public ArrayList<Item> searchAllItem() throws Exception{
		Connection con = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Item> allItemReturn = new ArrayList<Item>();

		try {
			if(con != null) {
				String querry = "select * from item";
				pstmt = con.prepareStatement(querry);
				rs = pstmt.executeQuery();

				while(rs.next()== true) {
					String itemId = rs.getString("itemid");
					String itemName = rs.getString("itemname");
					String size = rs.getString("size");
					int price = rs.getInt("price");
					System.out.println(itemId);
			Item allItem = 	new Item(itemId,itemName, size, price);
				allItemReturn.add(allItem);
				}

			}

		}catch(SQLException e) {
	        System.out.println("DB切断時にエラーが発生しました");
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

		return allItemReturn;

}
}
