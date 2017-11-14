/**
 * �N���X���F	KiddaLaController
 * �T�v�@�@�F	KIDDA-LA�Ɩ��V�X�e���R���g���[��
 * �쐬�Җ��F
 * �쐬���@�F
 * �C���Җ��F
 * �C�����@�F
 */

package kidda.control;

import java.util.ArrayList;

import kidda.action.CustomerSearchAction;
import kidda.action.CustomerSearchDisplayAction;
import kidda.action.MainMenuDisplayAction;
import kidda.action.PrintOutAction;
import kidda.model.Customer;
import kidda.model.OrderDetail;
import kidda.view.DeliveryConfirmFrame;

public class KiddaLaController {

	public static void customerSearchDisplay() {
		CustomerSearchDisplayAction action = new CustomerSearchDisplayAction();
		action.execute();
	}

	public static void mainMenuDisplay() {
		MainMenuDisplayAction action = new MainMenuDisplayAction();
		action.execute();
	}

	public static Customer orderInputDisplay(String custId) throws Exception {
		Customer customer = new Customer(
				9999, "ダミー顧客", "ダミーコキャク", "99999999999", "東京都千代田区神田小川町9-9-9");
		return customer;
	}

	public static String[][] itemMenuDisplay() throws Exception {
		return null;
	}

	public static ArrayList<OrderDetail> deliveryConfirm(String custId)
			throws Exception {
		return null;
	}

	public static ArrayList<OrderDetail> orderRegister(
			ArrayList<OrderDetail> orderDetailList) throws Exception {
		return null;
	}

	public static int customerModify(Customer customer) throws Exception {
		return 0;
	}

	public static void printOut(DeliveryConfirmFrame frame) throws Exception {
		PrintOutAction action = new PrintOutAction();
		action.execute(frame);
	}

	public static int deliveryComplete(String custId) throws Exception {
		return 0;
	}

	public static String[][] customerSearch(String[] data) {
		return CustomerSearchAction.execute(data);

	}
}
