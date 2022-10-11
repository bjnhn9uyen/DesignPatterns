package extra_DAOPattern_FactoryMethod.TransferObjects;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import extra_DAOPattern_FactoryMethod.BussinessObjects.Staff;
import extra_DAOPattern_FactoryMethod.DAOFactory.DAOFactory;
import extra_DAOPattern_FactoryMethod.DAOs.StaffDAO;

public class StaffTransfer {

	private StaffDAO staffDAO = DAOFactory.getDAOFactory().getStaffDAO();

	public void createStaffTable(Scanner scanner) throws SQLException {
		staffDAO.createTable();
		pressEnterToContinue(scanner, "Staff table created successfully!");
	}

	public void deleteStaffTable(Scanner scanner) throws SQLException {
		staffDAO.deleteTable();
		pressEnterToContinue(scanner, "Staff table deleted successfully!");
	}

	public void createStaff(Scanner scanner) throws SQLException {
		System.out.println("Input information for Staff:");
		try {
			System.out.print("Name: ");
			String name = scanner.next();
			System.out.print("Gender (m: Male - f: Female): ");
			Pattern pattern = Pattern.compile("[mf]");
			String gender = scanner.next(pattern).equalsIgnoreCase("m") ? "M" : "F";
			System.out.print("Age: ");
			int age = scanner.nextInt();
			System.out.print("Address: ");
			String address = scanner.next();
			staffDAO.addStaff(new Staff(0, name, gender, age, address));
			pressEnterToContinue(scanner, "New staff added successfully!");
		} catch (InputMismatchException e) {
			pressEnterToContinue(scanner, "Invalid data input!");
		}
	}

	public void readAllStaffs(Scanner scanner) throws SQLException {
		List<Staff> list = staffDAO.getAllStaffs();
		if (list.isEmpty()) {
			pressEnterToContinue(scanner, "Staff list is empty!");
		} else {
			System.out.println("Staff list:");
			for (int i = 0; i < list.size(); i++) {
				System.out.println("\tStaff " + (i + 1) + ": ");
				System.out.println(list.get(i));
			}
			pressEnterToContinue(scanner, "");
		}
	}

	public void updateStaff(Scanner scanner) throws SQLException {
		System.out.print("Enter staff's id to update staff: ");
		try {
			int id = scanner.nextInt();
			if (staffDAO.getStaff(id) == null) {
				pressEnterToContinue(scanner, "Id '" + id + "' does not exist!");
			} else {
				System.out.print("set name: ");
				String name = scanner.next();
				System.out.print("Gender (m: Male - f: Female): ");
				Pattern pattern = Pattern.compile("[mf]");
				String gender = scanner.next(pattern).equalsIgnoreCase("m") ? "M" : "F";
				System.out.print("set age: ");
				int age = scanner.nextInt();
				System.out.print("set adress: ");
				String address = scanner.next();
				staffDAO.updateStaff(new Staff(id, name, gender, age, address));
				pressEnterToContinue(scanner, "Staff '" + id + "' updated successfully!");
			}
		} catch (InputMismatchException ex) {
			pressEnterToContinue(scanner, "Invalid data input!");
		}
	}

	public void deleteStaff(Scanner scanner) throws SQLException {
		System.out.print("Enter staff's id to delete staff: ");
		try {
			int id = scanner.nextInt();
			if (staffDAO.getStaff(id) == null) {
				pressEnterToContinue(scanner, "Id '" + id + "' does not exist!");
			} else {
				staffDAO.deleteStaff(id);
				pressEnterToContinue(scanner, "Staff '" + id + "' deleted successfully!");
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
