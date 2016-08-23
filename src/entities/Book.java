package entities;

/**
 * 
 * @author Kritik Garg
 *
 */
public class Book {

	int accessionNo;
	String purchaseDt;
	int price;
	String status;
	String title;

	// setter accession_no
	public void setAccession_no(int accessionNo) {
		this.accessionNo = accessionNo;
	}

	// getter accession_no
	public int getAccession_no() {
		return accessionNo;
	}

	// setter purchaseDt
	public void setPurchase_dt(String purchase_dt) {
		this.purchaseDt = purchase_dt;
	}

	// getter purchaseDt
	public String getPurchase_dt() {
		return purchaseDt;
	}

	// setter price
	public void setPrice(int price) {
		this.price = price;
	}

	// getter price
	public int getPrice() {
		return price;
	}

	// setter status
	public void setStatus(String status) {
		this.status = status;
	}

	// getter status
	public String getStatus() {
		return status;
	}

	// setter title
	public void setTitle(String title) {
		this.title = title;
	}

	// getter title
	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		String data = "\nAccession No = " + getAccession_no() + " Title = "
				+ getTitle() + " Price" + getPrice() + " Purchase Date = "
				+ getPurchase_dt();
		return data;
	}

}
