/**
 * �N���X���F	OrderDetail
 * �T�v�@�@�F	�������׏��
 * �쐬�Җ��F
 * �쐬���@�F
 * �C���Җ��F
 * �C�����@�F
 */

package kidda.model;


public class OrderDetail {
	long No;
	Customer customer;
	Item item;
	String orderDate;
	int quantity;
	Tax tax;
	int status;

	public OrderDetail(long no, Customer customer, Item item, String orderDate,
			int quantity, Tax tax, int status) {
	}

	public Customer getCustomer() {
		return null;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getOrderDate() {
		return null;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}


	public long getNo() {
		return No;
	}

	public void setNo(long no) {
		No = no;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Tax getTax() {
		return tax;
	}

	public void setTax(Tax tax) {
		this.tax = tax;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}





}
