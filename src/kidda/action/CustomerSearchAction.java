package kidda.action;

import java.util.ArrayList;

import kidda.dao.CustomerSearchDBAccess;
import kidda.model.Customer;
import kidda.model.OrderControlUtility;

public class CustomerSearchAction {
	String[] data;
	static String[][] tableData  = new String[4][4];;


public static String[][] execute(String[] data) {
	CustomerSearchDBAccess  DAO = new CustomerSearchDBAccess();

	if(data[1] != "") {
		ArrayList<Customer> list = DAO.searchCustomerByKana(data[1]);
//		ArrayList<Customer> list = DAO.searchCustomerByTel(data[0]);
		tableData = OrderControlUtility.customerToArray(list);
	}else {
		ArrayList<Customer> list = DAO.searchCustomerByTel(data[0]);
//		ArrayList<Customer> list = DAO.searchCustomerByKana(data[1]);

		tableData = OrderControlUtility.customerToArray(list);
	}
	return tableData;
}


}