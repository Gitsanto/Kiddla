/**
 * �N���X���F	Item
 * �T�v�@�@�F	���i���
 * �쐬�Җ��F
 * �쐬���@�F
 * �C���Җ��F
 * �C�����@�F
 */

package kidda.model;


public class Item {
	String itemId;
	String itemName;
	String size;
	int price;

	public Item(){

	}

	public Item(String itemId, String itemName, String size, int price) {
		this.getItemId();
		this.getItemName();
		this.getSize();
		this.getPrice();
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


}
