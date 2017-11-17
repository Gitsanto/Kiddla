/**
 * �N���X���F	OrderControlUtility
 * �T�v�@�@�F	�����Ǘ��p���[�e�B���e�B
 * �쐬�Җ��F
 * �쐬���@�F
 * �C���Җ��F
 * �C�����@�F
 */

package kidda.model;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class OrderControlUtility {

	public static String[][] customerToArray(ArrayList<Customer> list) {

		int listSize = list.size();
		String[][] tableData = new String[listSize][5];

		for(int i = 0; i < listSize; i++) {

			Customer customer = list.get(i);
			tableData[i][0] = Integer.toString(customer.getCustId());
			tableData[i][1] = customer.getCustName();
			tableData[i][2] = customer.getKana();
			tableData[i][3] = customer.getAddress();
			tableData[i][4] = customer.getTel();
		}

		return tableData;
	}

	public static void systemErrorMessage(JFrame frame, Exception e) {

		JOptionPane.showMessageDialog(frame, e + "：管理者に連絡してください。", "【システムエラー】", JOptionPane.ERROR_MESSAGE);
	}

	public static void setIconImage(JFrame frame) {

		ImageIcon icon = new ImageIcon("KIDDA-LA.jpg");
	    frame.setIconImage(icon.getImage());
	}


}
