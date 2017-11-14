package kidda.action;

import java.util.ArrayList;

import kidda.dao.CustomerSearchDBAccess;
import kidda.model.Customer;
import kidda.model.OrderControlUtility;

public class CustomerSearchAction {
	String[] data;
	static String[][] tableData  = new String[4][4];
	static ArrayList<Customer> list;


public static String[][] execute(String[] data) {
	CustomerSearchDBAccess  DAO = new CustomerSearchDBAccess();

	if(!data[0].equals("")) {

	     list = DAO.searchCustomerByTel(data[0]);


	}else{
		data[1]=data[1].replaceAll(" ", "");
		data[1]=data[1].replaceAll("  ", "");

		if(!data[1].equals("")) {

	     list = DAO.searchCustomerByKana(data[1]);
		}

	}

	return tableData = OrderControlUtility.customerToArray(list);


}


}