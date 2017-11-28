/**
 * �N���X���F	ItemMenuDisplayAction
 * �T�v�@�@�F	���i���\���A�N�V����
 * �쐬�Җ��F
 * �쐬���@�F
 * �C���Җ��F
 * �C�����@�F
 */

package kidda.action;

import java.util.ArrayList;

import kidda.dao.ItemMenuDisplayAccess;
import kidda.model.Item;
import kidda.model.OrderControlUtility2;

public class ItemMenuDisplayAction {
	String[][] itemMenuData  = null;
	ArrayList<Item> list = null;

	public String[][] execute()  throws Exception {
		ItemMenuDisplayAccess menuDisplay = new ItemMenuDisplayAccess();
		list = menuDisplay.searchAllItem();
		itemMenuData = OrderControlUtility2.itemToArray(list);
		return itemMenuData;
	}
}
