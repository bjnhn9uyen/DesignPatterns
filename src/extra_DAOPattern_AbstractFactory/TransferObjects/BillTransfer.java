package extra_DAOPattern_AbstractFactory.TransferObjects;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import extra_DAOPattern_AbstractFactory.BussinessObjects.Bill;
import extra_DAOPattern_AbstractFactory.DAOFactory.DAOFactory;
import extra_DAOPattern_AbstractFactory.DAOs.BillDAO;
import extra_DAOPattern_AbstractFactory.DAOs.ProductDAO;
import extra_DAOPattern_AbstractFactory.DAOs.StaffDAO;

public class BillTransfer {

	private BillDAO billDAO;
	private StaffDAO staffDAO;
	private ProductDAO productDAO;

	public BillTransfer(int factoryType) {
		this.billDAO = DAOFactory.getDAOFactory(factoryType).getBillDAO();
		this.staffDAO = DAOFactory.getDAOFactory(factoryType).getStaffDAO();
		this.productDAO = DAOFactory.getDAOFactory(factoryType).getProductDAO();
	}

	public void createBillTable(Scanner scanner) throws SQLException {
		billDAO.createTable();
		pressEnterToContinue(scanner, "Bill table created successfully!");
	}

	public void deleteBillTable(Scanner scanner) throws SQLException {
		billDAO.deleteTable();
		pressEnterToContinue(scanner, "Bill table deleted successfully!");
	}

	public void createBill(Scanner scanner) throws SQLException {
		System.out.println("Input information for Bill:");
		try {
			System.out.print("Staff's id: ");
			int staffId = scanner.nextInt();
			if (staffDAO.getStaff(staffId) == null) {
				pressEnterToContinue(scanner, "Staff's id '" + staffId + "' does not exist!");
				return;
			}
			System.out.print("Product's id: ");
			int productId = scanner.nextInt();
			if (productDAO.getProduct(productId) == null) {
				pressEnterToContinue(scanner, "Product's id '" + productId + "' does not exist!");
				return;
			}
			System.out.print("Quantity sold: ");
			int quantitySold = scanner.nextInt();
			billDAO.addBill(new Bill(staffId, productId, quantitySold));
			pressEnterToContinue(scanner, "New bill added successfully!");
		} catch (InputMismatchException e) {
			pressEnterToContinue(scanner, "Invalid data input!");
		}
	}

	public void readAllBills(Scanner scanner) throws SQLException {
		List<Bill> list = billDAO.getAllBills();
		if (list.isEmpty()) {
			pressEnterToContinue(scanner, "Bill list is empty!");
		} else {
			System.out.println("Bill list:");
			for (int i = 0; i < list.size(); i++) {
				System.out.println("\tBill " + (i + 1) + ": ");
				System.out.println(list.get(i));
			}
			pressEnterToContinue(scanner, "");
		}
	}

	public void updateBill(Scanner scanner) throws SQLException {
		System.out.println("Enter staff's id and product's id to update bill");
		try {
			System.out.print("Staff's id: ");
			int staffId = scanner.nextInt();
			if (staffDAO.getStaff(staffId) == null) {
				pressEnterToContinue(scanner, "Staff's id '" + staffId + "' does not exist!");
				return;
			}
			System.out.print("Product's id: ");
			int productId = scanner.nextInt();
			if (productDAO.getProduct(productId) == null) {
				pressEnterToContinue(scanner, "Product's id '" + productId + "' does not exist!");
				return;
			}
			if (billDAO.getBill(staffId, productId) == null) {
				pressEnterToContinue(scanner, "Bill does not exist!");
			} else {
				System.out.print("Set quantity sold: ");
				int quantitySold = scanner.nextInt();
				billDAO.updateBill(new Bill(staffId, productId, quantitySold));
				pressEnterToContinue(scanner, "Bill updated successfully!");
			}
		} catch (InputMismatchException ex) {
			pressEnterToContinue(scanner, "Invalid data input!");
		}
	}

	public void deleteBill(Scanner scanner) throws SQLException {
		System.out.println("Enter staff's id and product's id to delete bill");
		try {
			System.out.print("Staff's id: ");
			int staffId = scanner.nextInt();
			if (staffDAO.getStaff(staffId) == null) {
				pressEnterToContinue(scanner, "Staff's id '" + staffId + "' does not exist!");
				return;
			}
			System.out.print("Product's id: ");
			int productId = scanner.nextInt();
			if (productDAO.getProduct(productId) == null) {
				pressEnterToContinue(scanner, "Product's id '" + productId + "' does not exist!");
				return;
			}
			if (billDAO.getBill(staffId, productId) == null) {
				pressEnterToContinue(scanner, "Bill does not exist!");
			} else {
				billDAO.deleteBill(staffId, productId);
				pressEnterToContinue(scanner, "Bill deleted successfully!");
			}
		} catch (InputMismatchException ex) {
			pressEnterToContinue(scanner, "Invalid data input!");
		}
	}

	private void pressEnterToContinue(Scanner scanner, String str) {
		System.out.println(str);
		System.out.println("Press ENTER to continue...");
		scanner.nextLine();
		// when we continue reading with nextLine() after using nextInt() (or nextFloat(), etc...),
		// we receive the "\n" key, it automatically presses Enter key for us
		scanner.nextLine();
	}

}
