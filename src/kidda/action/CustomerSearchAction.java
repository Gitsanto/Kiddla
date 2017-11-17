package kidda.action;

import java.util.ArrayList;

import kidda.dao.CustomerSearchDBAccess;
import kidda.model.Customer;
import kidda.model.OrderControlUtility;

public class CustomerSearchAction {

	String[][] tableData  = null;
	ArrayList<Customer> list = null;


public  String[][] execute(String[] data)throws Exception {
	CustomerSearchDBAccess  DAO = new CustomerSearchDBAccess();

	if(!data[0].equals("")) {

	     list = DAO.searchCustomerByTel(data[0]);


	}else{
		data[1]=data[1].replaceAll(" ", "");
		data[1]=data[1].replaceAll("  ", "");

		if(!data[1].equals("")) {

	     list = DAO.searchCustomerByKana(data[1]);
		}
		 list = DAO.searchCustomerByKana(data[1]);

	}
	if(list != null && list.size() !=0) {
	 tableData = OrderControlUtility.customerToArray(list);
	}
	return tableData;

}


}