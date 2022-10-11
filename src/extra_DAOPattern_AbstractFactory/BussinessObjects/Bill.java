package extra_DAOPattern_AbstractFactory.BussinessObjects;

public class Bill {

	private int staffId;
	private int productId;
	private int quantitySold;

	public Bill(int staffId, int productId, int quantitySold) {
		this.staffId = staffId;
		this.productId = productId;
		this.quantitySold = quantitySold;
	}

	public int getStaffId() {
		return staffId;
	}

	public int getProductId() {
		return productId;
	}

	public int getQuantitySold() {
		return quantitySold;
	}

	@Override
	public String toString() {
		return "\t\tStaff's id: " + staffId + "\n" + "\t\tProduct's id: " + productId + "\n"
								+ "\t\tQuantity sold: " + quantitySold;
	}

}
