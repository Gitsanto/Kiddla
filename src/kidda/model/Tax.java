/**
 * �N���X���F	Tax
 * �T�v�@�@�F	����ŏ��
 * �쐬�Җ��F
 * �쐬���@�F
 * �C���Җ��F
 * �C�����@�F
 */

package kidda.model;


public class Tax {
	int taxId;
	double rate;
	String endDate;

	public Tax() {

	}

	public Tax(int taxId, double rate, String endDate) {

	}

	public int getTaxId() {
		return taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}




}
