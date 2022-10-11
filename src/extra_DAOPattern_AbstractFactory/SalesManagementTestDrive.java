package extra_DAOPattern_AbstractFactory;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import extra_DAOPattern_AbstractFactory.DAOFactory.DAOFactory;
import extra_DAOPattern_AbstractFactory.TransferObjects.BillTransfer;
import extra_DAOPattern_AbstractFactory.TransferObjects.ProductTransfer;
import extra_DAOPattern_AbstractFactory.TransferObjects.StaffTransfer;

public class SalesManagementTestDrive {

	private ProductTransfer productTransfer;
	private StaffTransfer staffTransfer;
	private BillTransfer billTransfer;
	private Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		new SalesManagementTestDrive().go();
	}

	private int chooseDatabase() {
		do {
			System.out.println("CHOOSE DATABASE:");
			System.out.println("1. SQL Server");
			System.out.println("2. My SQL");
			System.out.print("Enter your choose: ");
			try {
				int choose = scanner.nextInt();
				if (choose > 0 && choose < 3) {
					return choose;
				} else {
					pressEnterToContinue(scanner, "Invalid data input! Only integer number 1 or 2 allowed!");
				}
			} catch (InputMismatchException e) {
				pressEnterToContinue(scanner, "Invalid data input! Only integer number 1 or 2 allowed!");
			}
		} while (true);
	}

	private void go() {
		int type = chooseDatabase();
		productTransfer = new ProductTransfer(type);
		staffTransfer = new StaffTransfer(type);
		billTransfer = new BillTransfer(type);
		do {
			System.out.println("==========MENU==========");
			System.out.println("0. Delete database");
			System.out.println("1. Create database");

			System.out.println("2. Create table Product");
			System.out.println("3. Create table Staff");
			System.out.println("4. Create table Bill");

			System.out.println("5. Delete table Product");
			System.out.println("6. Delete table Staff");
			System.out.println("7. Delete table Bill");

			System.out.println("8. Add product");
			System.out.println("9. Show product list");
			System.out.println("10. Update product");
			System.out.println("11. Delete product");

			System.out.println("12. Add staff");
			System.out.println("13. Show staff list");
			System.out.println("14. Update staff");
			System.out.println("15. Delete staff");

			System.out.println("16. Add bill");
			System.out.println("17. Show bill list");
			System.out.println("18. Update bill");
			System.out.println("19. Delete bill");

			System.out.println("20. Exit program");
			System.out.print("Enter your choose: ");
			try {
				int choose = scanner.nextInt();
				if (choose >= 0 && choose < 21) {
					try {
						switch (choose) {
						case 0:
							if (type == 1) {
								DAOFactory.getDAOFactory(1).deleteDatabase();
							} else {
								DAOFactory.getDAOFactory(2).deleteDatabase();
							}
							pressEnterToContinue(scanner, "Database deleted successfully!");
							break;
						case 1:
							if (type == 1) {
								DAOFactory.getDAOFactory(1).createDatabase();
							} else {
								DAOFactory.getDAOFactory(2).createDatabase();
							}
							pressEnterToContinue(scanner, "Database created successfully!");
							break;
						case 2:
							productTransfer.createProductTable(scanner);
							break;
						case 3:
							staffTransfer.createStaffTable(scanner);
							break;
						case 4:
							billTransfer.createBillTable(scanner);
							break;
						case 5:
							productTransfer.deleteProductTable(scanner);
							break;
						case 6:
							staffTransfer.deleteStaffTable(scanner);
							break;
						case 7:
							billTransfer.deleteBillTable(scanner);
							break;
						case 8:
							productTransfer.createProduct(scanner);
							break;
						case 9:
							productTransfer.readAllProducts(scanner);
							break;
						case 10:
							productTransfer.updateProduct(scanner);
							break;
						case 11:
							productTransfer.deleteProduct(scanner);
							break;
						case 12:
							staffTransfer.createStaff(scanner);
							break;
						case 13:
							staffTransfer.readAllStaffs(scanner);
							break;
						case 14:
							staffTransfer.updateStaff(scanner);
							break;
						case 15:
							staffTransfer.deleteStaff(scanner);
							break;
						case 16:
							billTransfer.createBill(scanner);
							break;
						case 17:
							billTransfer.readAllBills(scanner);
							break;
						case 18:
							billTransfer.updateBill(scanner);
							break;
						case 19:
							billTransfer.deleteBill(scanner);
							break;
						case 20:
							scanner.close();
							System.exit(0);
						}
					} catch (SQLException e) {
//						e.printStackTrace();
						pressEnterToContinue(scanner, e.getMessage());
					}
				} else {
					pressEnterToContinue(scanner,
											"Invalid data input! Only integer number from 1 to 5 is allowed!");
				}
			} catch (InputMismatchException e) {
				pressEnterToContinue(scanner,
										"Invalid data input! Only integer number from 1 to 5 is allowed!");
			}
		} while (true);
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
